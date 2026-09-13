package com.li64.tide.registries.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

//? if >=26.2 {
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.world.level.portal.TeleportTransition;
//?} elif >= 1.21 {
/*
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;
import java.util.Optional;
*/
//?} else {
/*
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import java.util.Optional;
*/
//?}


public class VoidseekerItem extends AbstractTooltipItem {
    public VoidseekerItem(Properties properties) {
        super(properties);
    }

    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);
        if (!(entity instanceof ServerPlayer player)) return result;

        //? if >=26.2 {
        player.getCooldowns().addCooldown(stack, 20);
        //?} else {
        /*player.getCooldowns().addCooldown(stack.getItem(), 20);*/
        //?}
        player.resetFallDistance(); // secret tech?!?

        //? if >=26.2 {
        ServerPlayer.RespawnConfig respawnConfig = player.getRespawnConfig();

        if (respawnConfig != null) {
                TeleportTransition transition = 
                        player.findRespawnPositionAndUseSpawnBlock(
                                true,
                                TeleportTransition.DO_NOTHING
                        );

                player.teleport(transition);
        }
        //?} elif >= 1.21 {
        /*
        ResourceKey<Level> dimension = player.getRespawnDimension();

        if (player.getServer() != null && player.getRespawnPosition() != null) {
            ServerLevel respawnLevel = player.getServer().getLevel(dimension);
            if (respawnLevel == null) return result;

            Optional<Vec3> respawnPos = Optional.of(
                    player.findRespawnPositionAndUseSpawnBlock(
                            true, 
                            DimensionTransition.DO_NOTHING
                    ).pos()
            );
            
            respawnPos.ifPresent(pos -> player.teleportTo(
                    respawnLevel,
                    pos.x(), pos.y(), pos.z(), 
                    player.getRespawnAngle(), 
                    0f
            ));
        }
        */
        //?} else {
        /*
        Optional<Vec3> respawnPos = Player.findRespawnPositionAndUseSpawnBlock(
                respawnLevel, 
                player.getRespawnPosition(), 
                player.getRespawnAngle(),
                false, 
                true
        );
        */
        //?}
        return result;
    }

    @Override
    //? if >=26.2 {
    public void addTooltip(DataComponentGetter getter, Consumer<Component> tooltip) {
    //?} else {
    /*
    public void addTooltip(ItemStack stack, Consumer<Component> tooltip) {
    */
    //?}
        Style gray = Component.empty().getStyle().withColor(ChatFormatting.GRAY);
        tooltip.accept(Component.translatable("item.tide.voidseeker.desc").setStyle(gray));
    }
}