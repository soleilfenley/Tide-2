//? if fabric {
package com.li64.tide.datagen.fabric.providers.tags;

import com.li64.tide.Tide;
import com.li64.tide.data.TideTags;
import com.li64.tide.registries.TideBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
public class TideBlockTagsProvider extends FabricTagsProvider<Block> {
        public TideBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
//?} else {
/*
public class TideBlockTagsProvider extends FabricTagProvider<Block> {
        public TideBlockTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registries) {
*/
//?}
                super(output, Registries.BLOCK, registries);
        }

        @Override
        public @NotNull String getName() {
                return "Block Tags";
        }
        
        @Override
        protected void addTags(HolderLookup.Provider provider) {
                //? if >=26.2 {
                tag(TideTags.Blocks.INFORMATIONAL)
                        .add(TideTags.key(TideBlocks.LUNAR_CALENDAR))
                        .add(TideTags.key(TideBlocks.WEATHER_RADIO));
        
                tag(TideTags.Blocks.DESERT_WELL_LOOT)
                        .add(TideTags.key(Blocks.SUSPICIOUS_SAND));
        
                tag(TideTags.Blocks.CHASM_EEL_CAN_EAT)
                        .add(TideTags.key(Blocks.BEDROCK));
        
                tag(BlockTags.MINEABLE_WITH_AXE)
                        .add(TideTags.key(TideBlocks.WOODEN_CRATE))
                        .add(TideTags.key(TideBlocks.ANGLING_TABLE))
                        .add(TideTags.key(TideBlocks.FISH_DISPLAY));
        
                tag(BlockTags.MINEABLE_WITH_PICKAXE)
                        .add(TideTags.key(TideBlocks.PURPUR_CRATE))
                        .add(TideTags.key(TideBlocks.OBSIDIAN_CRATE))
                        .add(TideTags.key(TideBlocks.WEATHER_RADIO));
        
                tag(BlockTags.NEEDS_DIAMOND_TOOL)
                        .add(TideTags.key(TideBlocks.OBSIDIAN_CRATE));
        
                tag(TagKey.create(Registries.BLOCK,
                        Tide.resource("visualworkbench", "unaltered_workbenches")))
                        .add(TideTags.key(TideBlocks.ANGLING_TABLE));
                //?} else {
                /*
                getOrCreateTagBuilder(TideTags.Blocks.INFORMATIONAL)
                        .add(TideBlocks.LUNAR_CALENDAR)
                        .add(TideBlocks.WEATHER_RADIO);
        
                getOrCreateTagBuilder(TideTags.Blocks.DESERT_WELL_LOOT)
                        .add(Blocks.SUSPICIOUS_SAND);
        
                getOrCreateTagBuilder(TideTags.Blocks.CHASM_EEL_CAN_EAT)
                        .add(Blocks.BEDROCK);
        
                getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                        .add(TideBlocks.WOODEN_CRATE)
                        .add(TideBlocks.ANGLING_TABLE)
                        .add(TideBlocks.FISH_DISPLAY);
        
                getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                        .add(TideBlocks.PURPUR_CRATE)
                        .add(TideBlocks.OBSIDIAN_CRATE)
                        .add(TideBlocks.WEATHER_RADIO);
        
                getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                        .add(TideBlocks.OBSIDIAN_CRATE);
        
                getOrCreateTagBuilder(TagKey.create(Registries.BLOCK,
                        Tide.resource("visualworkbench", "unaltered_workbenches")))
                        .add(TideBlocks.ANGLING_TABLE);
                */
                //?}
        }
}
//?}