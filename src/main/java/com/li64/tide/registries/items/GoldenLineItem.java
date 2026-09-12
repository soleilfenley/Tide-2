package com.li64.tide.registries.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

public class GoldenLineItem extends FishingLineItem {
    public GoldenLineItem(Properties properties) {
        super(properties, "item.tide.golden_line.desc_0");
    }

    @Override
    //? if >=26.2 {
    public void addTooltip(DataComponentGetter getter, Consumer<Component> tooltip) {
    //?} else {
    /*
    public void addTooltip(ItemStack stack, Consumer<Component> tooltip) {
    */
    //?}
        super.addTooltip(stack, tooltip);
        Style blue = Component.empty().getStyle().withColor(ChatFormatting.BLUE);
        tooltip.accept(Component.translatable("item.tide.golden_line.desc_1").setStyle(blue));
    }
}
