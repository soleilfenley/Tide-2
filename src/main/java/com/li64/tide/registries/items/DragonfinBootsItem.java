package com.li64.tide.registries.items;

import com.li64.tide.registries.TideArmorMaterials;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;

import java.util.function.Consumer;

//? if >=26.2 {
import com.li64.tide.registries.TooltipRegistry;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
//?} else {
/*
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.level.Level;

import java.util.List;
*/
//?}

//? if >=26.2 {
public class DragonfinBootsItem extends Item implements TooltipItem {
    public DragonfinBootsItem(Properties properties) {
        super(
                properties.humanoidArmor(TideArmorMaterials.DRAGONFIN.value(), 
                        ArmorType.BOOTS
        ));

        TooltipRegistry.register(this, this);
    }
//?} else {
/*
public class DragonfinBootsItem extends ArmorItem implements TooltipItem {
    public DragonfinBootsItem(Properties properties) {
        super(TideArmorMaterials.DRAGONFIN, ArmorItem.Type.BOOTS, properties);
    }
*/
//?}
    //? if >=1.21.1 && <26.2 {
    /*
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> lines, TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);
        this.addTooltip(stack, lines::add);
    }
    */
    //?} else {
    /*@Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> lines, TooltipFlag flag) {
        super.appendHoverText(stack, level, lines, flag);
        this.addTooltip(stack, lines::add);
    }
    *///?}

    @Override
    //? if >=26.2 {
    public void addTooltip(DataComponentGetter getter, Consumer<Component> tooltip) {
    //?} else {
    /*
    public void addTooltip(ItemStack stack, Consumer<Component> tooltip) {
    */
    //?}
        Style gold = Component.empty().getStyle().withColor(ChatFormatting.GOLD);
        tooltip.accept(Component.translatable("item.tide.dragonfin_boots.desc_0").setStyle(gold));
        tooltip.accept(Component.translatable("item.tide.dragonfin_boots.desc_1").setStyle(gold));
    }
}
