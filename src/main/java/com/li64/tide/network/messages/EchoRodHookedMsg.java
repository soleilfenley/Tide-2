package com.li64.tide.network.messages;

import com.li64.tide.Tide;
import com.li64.tide.client.gui.overlays.SonarOverlay;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
//? if >=26.2 {
import net.minecraft.resources.Identifier;
//?} else {
/*
import net.minecraft.resources.ResourceLocation;
*/
//?}
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public record EchoRodHookedMsg(ItemStack stack) implements TidePacketPayload {
        //? if >=26.2 {
        public static final Identifier ID = Tide.resource("echo_rod_hooked");
        @Override public Identifier id() { return ID; }
        //?} else {
        /*
        public static final ResourceLocation ID = Tide.resource("echo_rod_hooked");
        @Override public ResourceLocation id() { return ID; }
        */
        //?}

    public EchoRodHookedMsg(FriendlyByteBuf buf) {
        this(BuiltInRegistries.ITEM
                //? if >=26.2 {
                .getOptional(Identifier.tryParse(buf.readUtf()))
                //?} else {
                /*
                .getOptional(ResourceLocation.tryParse(buf.readUtf()))
                */
                //?}
                .orElseThrow().getDefaultInstance());
    }

    public static void encode(EchoRodHookedMsg message, FriendlyByteBuf buf) {
        buf.writeUtf(BuiltInRegistries.ITEM.getKey(message.stack.getItem()).toString());
    }

    public static void handle(EchoRodHookedMsg message, Player player) {
        SonarOverlay.show(message.stack);
    }
}