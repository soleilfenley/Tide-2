//? if fabric {
package com.li64.tide.datagen.fabric.providers.loot;

import com.li64.tide.data.loot.LootTableRef;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.storage.loot.LootTable;

//? if >=26.2 {
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.context.ContextKeySet;
//?} elif >= 1.21 {
/*
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
*/
//?} else
/*
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
*/
//?}

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public abstract class TideAbstractLootProvider extends SimpleFabricLootTableProvider {
    /*? if >=1.21*/protected final HolderLookup.Provider registries;

    @SuppressWarnings("unused")
    public TideAbstractLootProvider(FabricPackOutput output,
                                    CompletableFuture<HolderLookup.Provider> registryLookup,
                                    /*? if >=26.2 {*/ContextKeySet/*?} else*//*LootContextParamSet*//*?*/ lootType) {
        super(output/*? if >=1.21 {*/, registryLookup/*?}*/, lootType);
        /*? if >=1.21*/this.registries = registryLookup.join();
    }

    //? if >=1.21 {
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        this.generateLoot((ref, builder) -> output.accept(ref.getKey(), builder));
    }
    //?} else {
    /*public void generate(BiConsumer<ResourceLocation, LootTable.Builder> output) {
        this.generateLoot((ref, builder) -> output.accept(ref.getId(), builder));
    }
    *///?}

    public abstract void generateLoot(TideLootOutput output);

    @FunctionalInterface
    public interface TideLootOutput {
        void accept(LootTableRef ref, LootTable.Builder builder);
    }
}
//?}