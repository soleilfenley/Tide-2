package com.li64.tide.data.loot;

import com.li64.tide.Tide;
import com.li64.tide.config.TideServerConfig;
import com.li64.tide.data.fishing.FishData;
import com.li64.tide.data.item.TideItemData;
import com.li64.tide.registries.TideLootFunctions;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import org.jetbrains.annotations.NotNull;

//? if >=26.2 {
import com.mojang.serialization.MapCodec;
//?} else {
/*
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
*/
//?}

public class RandomizeFishLengthFunction implements LootItemFunction {
    public static final MapCodec<RandomizeFishLengthFunction> CODEC = MapCodec.unit(RandomizeFishLengthFunction::new);

    public RandomizeFishLengthFunction() {}

    public @NotNull 
    //? if >=26.2 {
    MapCodec<? extends LootItemFunction> codec() {
    //?} elif >= 1.21 {
    /*
    LootItemFunctionType<RandomizeFishLengthFunction> getType() {
    */
    //?} else
    /*
    LootItemFunctionType getType() {
    */
    //?}
        return TideLootFunctions.RANDOMIZE_FISH_LENGTH;
    }

    @Override
    public ItemStack apply(ItemStack stack, LootContext context) {
        if (Tide.SERVER_CONFIG.items.fishItemSizes != TideServerConfig.Items.SizeMode.ALWAYS
                || FishData.get(stack).map(FishData::size).isEmpty()) return stack;
        FishData.get(stack).ifPresent(data -> TideItemData.FISH_LENGTH
                .set(stack, data.getRandomLength(context.getRandom())));
        return stack;
    }
}
