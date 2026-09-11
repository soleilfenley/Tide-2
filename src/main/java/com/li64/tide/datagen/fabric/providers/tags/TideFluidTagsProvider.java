//? if fabric {
package com.li64.tide.datagen.fabric.providers.tags;

import com.li64.tide.data.TideTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.material.Fluid;
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
public class TideFluidTagsProvider extends FabricTagsProvider<Fluid> {
        public TideFluidTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
//?} else {
/*
public class TideFluidTagsProvider extends FabricTagProvider<Fluid> {
        public TideFluidTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registries) {
*/
//?}
                super(output, Registries.FLUID, registries);
        }
        
        @Override
        public @NotNull String getName() {
                return "Tide Fluid Tags";
        }
        
        @Override
        protected void addTags(HolderLookup.Provider provider) {
                //? if >=26.2 {
                tag(TideTags.Fluids.WATER_FISHING)
                        .forceAddTag(FluidTags.WATER);
        
                tag(TideTags.Fluids.LAVA_FISHING)
                        .forceAddTag(FluidTags.LAVA);
        
                tag(TideTags.Fluids.CAN_FISH_IN)
                        .forceAddTag(TideTags.Fluids.WATER_FISHING)
                        .forceAddTag(TideTags.Fluids.LAVA_FISHING);
                //?} else {
                /*
                getOrCreateTagBuilder(TideTags.Fluids.WATER_FISHING)
                        .forceAddTag(FluidTags.WATER);
        
                getOrCreateTagBuilder(TideTags.Fluids.LAVA_FISHING)
                        .forceAddTag(FluidTags.LAVA);
        
                getOrCreateTagBuilder(TideTags.Fluids.CAN_FISH_IN)
                        .forceAddTag(TideTags.Fluids.WATER_FISHING)
                        .forceAddTag(TideTags.Fluids.LAVA_FISHING);
                */
                //?}
        }
}
//?}