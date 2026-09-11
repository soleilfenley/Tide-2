//? if fabric {
package com.li64.tide.datagen.fabric.providers.tags;

import com.li64.tide.data.TideTags;
import com.li64.tide.registries.TideEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

//? if >=26.2 {
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.world.entity.EntityTypes;
//?} else {
/*
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
*/
//?}

//? if >=26.2 {
public class TideEntityTypeTagsProvider extends FabricTagsProvider<EntityType<?>> {
        public TideEntityTypeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
//?} else {
/*
public class TideEntityTypeTagsProvider extends FabricTagProvider<EntityType<?>> {
        public TideEntityTypeTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registries) {
*/
//?}
                super(output, Registries.ENTITY_TYPE, registries);
        }
        
        @Override
        public @NotNull String getName() {
                return "Entity Type Tags";
        }
        
        @Override
        protected void addTags(HolderLookup.Provider provider) {

                //? if >=26.2 {
                tag(EntityTypeTags.ARROWS).add(TideTags.key(TideEntityTypes.STAR_ARROW));
        
                tag(TideTags.Entities.IGNORES_POCKET_WATCH)
                        .add(TideTags.key(EntityTypes.ENDER_DRAGON))
                        .add(TideTags.key(EntityTypes.WITHER))
                        .add(TideTags.key(EntityTypes.ELDER_GUARDIAN))
                        .add(TideTags.key(EntityTypes.WARDEN));
                //?} else {
                /*
                getOrCreateTagBuilder(EntityTypeTags.ARROWS).add(TideEntityTypes.STAR_ARROW);
        
                getOrCreateTagBuilder(TideTags.Entities.IGNORES_POCKET_WATCH)
                        .add(EntityType.ENDER_DRAGON)
                        .add(EntityType.WITHER)
                        .add(EntityType.ELDER_GUARDIAN)
                        .add(EntityType.WARDEN);
                */
                //?}
                
                //? if >=26.2 {
                var aquatic = tag(EntityTypeTags.AQUATIC);
                TideEntityTypes.FISH_ENTITIES.forEach(type -> aquatic.add(TideTags.key(type)));
                //?} elif >=1.21 {
                /*
                var aquatic = getOrCreateTagBuilder(EntityTypeTags.AQUATIC);
                TideEntityTypes.FISH_ENTITIES.forEach(aquatic::add);
                */
                //?}
    }
}
//?}