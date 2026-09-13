//?if >=26.2 {
package com.li64.tide.data.item;

import java.util.function.Consumer;

import com.li64.tide.registries.items.TooltipItem;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

//?if >=26.2 {
import net.minecraft.core.component.DataComponentGetter;
//?}

public record TideTooltipProvider(TooltipItem item) implements TooltipProvider {
        @Override 
        public void addToTooltip(
                Item.TooltipContext context,
                Consumer<Component> tooltip,
                TooltipFlag flag,
                //? if >=26.2 {
                DataComponentGetter getter
                //?} else {
                /*
                ItemStack getter
                */
                //?}
        ) {
                item.addTooltip(getter, tooltip);
        }
}
//?}