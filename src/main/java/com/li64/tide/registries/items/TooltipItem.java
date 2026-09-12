package com.li64.tide.registries.items;

import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

//? if >=26.2 {
import net.minecraft.core.component.DataComponentGetter;
//?} else {
/*
import net.minecraft.world.item.ItemStack;
*/
//?}

public interface TooltipItem {
        //? if >=26.2 {
        void addTooltip(DataComponentGetter getter, Consumer<Component> tooltip);
        //?} else {
        /*
        void addTooltip(ItemStack stack, Consumer<Component> tooltip);
        */
        //?}
}
