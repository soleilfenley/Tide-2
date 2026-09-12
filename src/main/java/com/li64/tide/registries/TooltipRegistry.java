//?if >=26.2 {
package com.li64.tide.registries;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.li64.tide.data.item.TideTooltipProvider;
import com.li64.tide.registries.items.TooltipItem;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public final class TooltipRegistry {
        private static final Map<Item, TideTooltipProvider> PROVIDERS = new IdentityHashMap<>();

        private TooltipRegistry() {}

        public static void register(Item item, TooltipItem tooltipItem) {
                PROVIDERS.put(item, new TideTooltipProvider(tooltipItem));
        }

        public static void addTooltip(
                ItemStack stack,
                Item.TooltipContext context,
                Consumer<Component> tooltip,
                TooltipFlag flag
        ) {
                TideTooltipProvider provider = PROVIDERS.get(stack.getItem());

                if (provider != null) {
                        provider.addToTooltip(context, tooltip, flag, stack);
                }
        }
}
//?}