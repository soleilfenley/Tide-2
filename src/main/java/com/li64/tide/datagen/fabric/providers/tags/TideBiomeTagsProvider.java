//? if fabric {
package com.li64.tide.datagen.fabric.providers.tags;

import com.li64.tide.Tide;
import com.li64.tide.data.TideTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

//? if >=26.2 {
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
//?} else {
/*
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
*/
//?}

//? if >=26.2 {
public class TideBiomeTagsProvider extends FabricTagsProvider<Biome> {
        public TideBiomeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
//?} else {
/*
public class TideBiomeTagsProvider extends FabricTagProvider<Biome> {
        public TideBiomeTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registries) {
*/
//?}
                super(output, Registries.BIOME, registries);
        }
        
        @Override
        public @NotNull String getName() {
                return "Biome Tags";
        }
        
        @Override
        protected void addTags(HolderLookup.Provider provider) {
                //? if >=26.2 {
                tag(TideTags.Biomes.WATER_BIOMES)
                        .forceAddTag(BiomeTags.IS_RIVER)
                        .forceAddTag(BiomeTags.IS_OCEAN);
        
                tag(TideTags.Biomes.HAS_FISHING_BOAT)
                        .forceAddTag(BiomeTags.IS_OCEAN);
        
                tag(TideTags.Biomes.HAS_END_OASIS)
                        .add(Biomes.END_MIDLANDS)
                        .add(Biomes.END_HIGHLANDS);
        
                tag(TideTags.Biomes.CAN_CATCH_STARFISH)
                        .forceAddTag(BiomeTags.IS_DEEP_OCEAN);
        
                tag(TideTags.Biomes.IS_SALTWATER)
                        .forceAddTag(TideTags.Convention.IS_OCEAN)
                        .forceAddTag(TideTags.Convention.IS_BEACH)
                        .add(Biomes.STONY_SHORE)
                        .add(Biomes.MUSHROOM_FIELDS);
        
                tag(TideTags.Biomes.HAS_CHERRY_GROVE_FISH)
                        .add(Biomes.CHERRY_GROVE)
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "snowblossom_grove")));
        
                tag(TideTags.Biomes.HAS_DEEP_DARK_FISH)
                        .add(Biomes.DEEP_DARK);
        
                tag(TideTags.Biomes.HAS_PLAINS_FISH)
                        .forceAddTag(TideTags.Convention.IS_PLAINS)
                        .add(Biomes.PLAINS)
                        .add(Biomes.SUNFLOWER_PLAINS);
        
                tag(TideTags.Biomes.HAS_DESERT_FISH)
                        .forceAddTag(TideTags.Convention.IS_DESERT)
                        .forceAddTag(TideTags.Convention.IS_BADLANDS)
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "dune_beach")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "lush_desert")));
        
                tag(TideTags.Biomes.HAS_COASTAL_FISH)
                        .forceAddTag(BiomeTags.IS_BEACH)
                        .add(Biomes.STONY_SHORE);
        
                tag(TideTags.Biomes.HAS_DRIPSTONE_FISH)
                        .add(Biomes.DRIPSTONE_CAVES);
        
                tag(TideTags.Biomes.HAS_FROZEN_FISH)
                        .forceAddTag(TideTags.Convention.IS_ICY)
                        .forceAddTag(TideTags.Convention.IS_SNOWY)
                        .add(Biomes.FROZEN_RIVER)
                        .add(Biomes.FROZEN_OCEAN)
                        .add(Biomes.SNOWY_BEACH)
                        .add(Biomes.SNOWY_PLAINS)
                        .add(Biomes.ICE_SPIKES)
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "auroral_garden")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "cold_desert")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "tundra")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "wintry_origin_valley")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "snowy_coniferous_forest")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "snowy_fir_clearing")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "snowy_maple_woods")));
        
                tag(TideTags.Biomes.HAS_JUNGLE_FISH)
                        .forceAddTag(TideTags.Convention.IS_JUNGLE)
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "floodplain")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "rainforest")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "rocky_rainforest")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "tropics")));
        
                tag(TideTags.Biomes.HAS_MOUNTAIN_FISH)
                        .forceAddTag(TideTags.Convention.IS_MOUNTAIN)
                        .forceAddTag(BiomeTags.IS_MOUNTAIN);
        
                tag(TideTags.Biomes.HAS_MUSHROOM_FISH)
                        .forceAddTag(TideTags.Convention.IS_MUSHROOM)
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "fungal_jungle")));
        
                tag(TideTags.Biomes.HAS_SWAMP_FISH)
                        .forceAddTag(TideTags.Convention.IS_SWAMP)
                        // .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("hybrid_aquatic", "swamp"))
                        // .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("hybrid_aquatic", "mangroves"))
                        // .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("hybrid_aquatic", "marshes"))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "bayou")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "bog")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "marsh")));
        
                tag(TideTags.Biomes.THE_VOID)
                        .add(Biomes.THE_VOID);
                //?} else {
                /*
                getOrCreateTagBuilder(TideTags.Biomes.WATER_BIOMES)
                        .forceAddTag(BiomeTags.IS_RIVER)
                        .forceAddTag(BiomeTags.IS_OCEAN);
        
                getOrCreateTagBuilder(TideTags.Biomes.HAS_FISHING_BOAT)
                        .forceAddTag(BiomeTags.IS_OCEAN);
        
                getOrCreateTagBuilder(TideTags.Biomes.HAS_END_OASIS)
                        .add(Biomes.END_MIDLANDS)
                        .add(Biomes.END_HIGHLANDS);
        
                getOrCreateTagBuilder(TideTags.Biomes.CAN_CATCH_STARFISH)
                        .forceAddTag(BiomeTags.IS_DEEP_OCEAN);
        
                getOrCreateTagBuilder(TideTags.Biomes.IS_SALTWATER)
                        .forceAddTag(TideTags.Convention.IS_OCEAN)
                        .forceAddTag(TideTags.Convention.IS_BEACH)
                        .add(Biomes.STONY_SHORE)
                        .add(Biomes.MUSHROOM_FIELDS);
        
                getOrCreateTagBuilder(TideTags.Biomes.HAS_CHERRY_GROVE_FISH)
                        .add(Biomes.CHERRY_GROVE)
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "snowblossom_grove")));
        
                getOrCreateTagBuilder(TideTags.Biomes.HAS_DEEP_DARK_FISH)
                        .add(Biomes.DEEP_DARK);
        
                getOrCreateTagBuilder(TideTags.Biomes.HAS_PLAINS_FISH)
                        .forceAddTag(TideTags.Convention.IS_PLAINS)
                        .add(Biomes.PLAINS)
                        .add(Biomes.SUNFLOWER_PLAINS);
        
                getOrCreateTagBuilder(TideTags.Biomes.HAS_DESERT_FISH)
                        .forceAddTag(TideTags.Convention.IS_DESERT)
                        .forceAddTag(TideTags.Convention.IS_BADLANDS)
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "dune_beach")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "lush_desert")));
        
                getOrCreateTagBuilder(TideTags.Biomes.HAS_COASTAL_FISH)
                        .forceAddTag(BiomeTags.IS_BEACH)
                        .add(Biomes.STONY_SHORE);
        
                getOrCreateTagBuilder(TideTags.Biomes.HAS_DRIPSTONE_FISH)
                        .add(Biomes.DRIPSTONE_CAVES);
        
                getOrCreateTagBuilder(TideTags.Biomes.HAS_FROZEN_FISH)
                        .forceAddTag(TideTags.Convention.IS_ICY)
                        .forceAddTag(TideTags.Convention.IS_SNOWY)
                        .add(Biomes.FROZEN_RIVER)
                        .add(Biomes.FROZEN_OCEAN)
                        .add(Biomes.SNOWY_BEACH)
                        .add(Biomes.SNOWY_PLAINS)
                        .add(Biomes.ICE_SPIKES)
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "auroral_garden")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "cold_desert")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "tundra")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "wintry_origin_valley")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "snowy_coniferous_forest")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "snowy_fir_clearing")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "snowy_maple_woods")));
        
                getOrCreateTagBuilder(TideTags.Biomes.HAS_JUNGLE_FISH)
                        .forceAddTag(TideTags.Convention.IS_JUNGLE)
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "floodplain")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "rainforest")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "rocky_rainforest")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "tropics")));
        
                getOrCreateTagBuilder(TideTags.Biomes.HAS_MOUNTAIN_FISH)
                        .forceAddTag(TideTags.Convention.IS_MOUNTAIN)
                        .forceAddTag(BiomeTags.IS_MOUNTAIN);
        
                getOrCreateTagBuilder(TideTags.Biomes.HAS_MUSHROOM_FISH)
                        .forceAddTag(TideTags.Convention.IS_MUSHROOM)
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "fungal_jungle")));
        
                getOrCreateTagBuilder(TideTags.Biomes.HAS_SWAMP_FISH)
                        .forceAddTag(TideTags.Convention.IS_SWAMP)
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("hybrid_aquatic", "swamp")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("hybrid_aquatic", "mangroves")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("hybrid_aquatic", "marshes")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "bayou")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "bog")))
                        .addOptional(ResourceKey.create(Registries.BIOME, Tide.resource("biomesoplenty", "marsh")));
        
                getOrCreateTagBuilder(TideTags.Biomes.THE_VOID)
                        .add(Biomes.THE_VOID);
                */
                //?}
        }
}
//?}
