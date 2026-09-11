//? if fabric {
package com.li64.tide.datagen.fabric.providers.tags;

import com.li64.tide.Tide;
import com.li64.tide.data.TideTags;
import com.li64.tide.registries.TideFish;
import com.li64.tide.registries.TideItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

//? if >=26.2 {
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.data.tags.TagAppender;
//?} else {
/*
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
*/
//?}

//? if >=26.2 {
public class TideItemTagsProvider extends FabricTagsProvider<Item> {
        public TideItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
//?} else {
/*
public class TideItemTagsProvider extends FabricTagProvider<Item> {
        public TideItemTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registries) {
*/
//?}
                super(output, Registries.ITEM, registries);
        }
        
        @Override
        public @NotNull String getName() {
                return "Item Tags";
        }
        
        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
                //? if >=26.2 {
                // Mod specific tags
                tag(TideTags.Items.FISHING_RODS)
                        .add(TideTags.key(Items.FISHING_ROD))
                        .add(TideTags.key(TideItems.STONE_FISHING_ROD))
                        .add(TideTags.key(TideItems.IRON_FISHING_ROD))
                        .add(TideTags.key(TideItems.GOLDEN_FISHING_ROD))
                        .add(TideTags.key(TideItems.CRYSTAL_FISHING_ROD))
                        .add(TideTags.key(TideItems.DIAMOND_FISHING_ROD))
                        .add(TideTags.key(TideItems.NETHERITE_FISHING_ROD))
                        .add(TideTags.key(TideItems.MIDAS_FISHING_ROD))
                        .add(TideTags.key(TideItems.ECHO_FISHING_ROD))
                        .add(TideTags.key(TideItems.PRISMARINE_FISHING_ROD))
                        .add(TideTags.key(TideItems.SUNFLOWER_FISHING_ROD))
                        .add(TideTags.key(TideItems.VILLAGE_FISHING_ROD))
                        .add(TideTags.key(TideItems.BLAZING_FISHING_ROD))
                        .add(TideTags.key(TideItems.HONEYCOMB_FISHING_ROD));
        
                tag(TideTags.Items.LINES)
                        .add(TideTags.key(TideItems.FISHING_LINE))
                        .add(TideTags.key(TideItems.COPPER_LINE))
                        .add(TideTags.key(TideItems.IRON_LINE))
                        .add(TideTags.key(TideItems.GOLDEN_LINE))
                        .add(TideTags.key(TideItems.DIAMOND_LINE));
        
                tag(TideTags.Items.BOBBERS)
                        .add(TideTags.key(TideItems.RED_BOBBER))
                        .add(TideTags.key(TideItems.ORANGE_BOBBER))
                        .add(TideTags.key(TideItems.YELLOW_BOBBER))
                        .add(TideTags.key(TideItems.LIME_BOBBER))
                        .add(TideTags.key(TideItems.GREEN_BOBBER))
                        .add(TideTags.key(TideItems.LIGHT_BLUE_BOBBER))
                        .add(TideTags.key(TideItems.CYAN_BOBBER))
                        .add(TideTags.key(TideItems.BLUE_BOBBER))
                        .add(TideTags.key(TideItems.PURPLE_BOBBER))
                        .add(TideTags.key(TideItems.MAGENTA_BOBBER))
                        .add(TideTags.key(TideItems.PINK_BOBBER))
                        .add(TideTags.key(TideItems.WHITE_BOBBER))
                        .add(TideTags.key(TideItems.LIGHT_GRAY_BOBBER))
                        .add(TideTags.key(TideItems.GRAY_BOBBER))
                        .add(TideTags.key(TideItems.BLACK_BOBBER))
                        .add(TideTags.key(TideItems.BROWN_BOBBER))
                        .add(TideTags.key(TideItems.APPLE_BOBBER))
                        .add(TideTags.key(TideItems.GOLDEN_APPLE_BOBBER))
                        .add(TideTags.key(TideItems.ENCHANTED_GOLDEN_APPLE_BOBBER))
                        .add(TideTags.key(TideItems.IRON_BOBBER))
                        .add(TideTags.key(TideItems.GOLDEN_BOBBER))
                        .add(TideTags.key(TideItems.DIAMOND_BOBBER))
                        .add(TideTags.key(TideItems.NETHERITE_BOBBER))
                        .add(TideTags.key(TideItems.AMETHYST_BOBBER))
                        .add(TideTags.key(TideItems.ECHO_BOBBER))
                        .add(TideTags.key(TideItems.CHORUS_BOBBER))
                        .add(TideTags.key(TideItems.FEATHER_BOBBER))
                        .add(TideTags.key(TideItems.LICHEN_BOBBER))
                        .add(TideTags.key(TideItems.NAUTILUS_BOBBER))
                        .add(TideTags.key(TideItems.PEARL_BOBBER))
                        .add(TideTags.key(TideItems.HEART_BOBBER))
                        .add(TideTags.key(TideItems.GRASSY_BOBBER))
                        .add(TideTags.key(TideItems.DUCK_BOBBER));
        
                tag(TideTags.Items.HOOKS)
                        .add(TideTags.key(TideItems.FISHING_HOOK))
                        .add(TideTags.key(TideItems.FIERY_HOOK))
                        .add(TideTags.key(TideItems.PERMAFROST_HOOK))
                        .add(TideTags.key(TideItems.TWILIGHT_HOOK))
                        .add(TideTags.key(TideItems.LAVAPROOF_HOOK))
                        .add(TideTags.key(TideItems.VOID_HOOK))
                        .addOptional(ResourceKey.create(Registries.ITEM, Tide.resource("hybrid_aquatic", "barbed_hook")))
                        .addOptional(ResourceKey.create(Registries.ITEM, Tide.resource("hybrid_aquatic", "glowing_hook")))
                        .addOptional(ResourceKey.create(Registries.ITEM, Tide.resource("hybrid_aquatic", "magnetic_hook")))
                        .addOptional(ResourceKey.create(Registries.ITEM, Tide.resource("hybrid_aquatic", "creepermagnet_hook")))
                        .addOptional(ResourceKey.create(Registries.ITEM, Tide.resource("hybrid_aquatic", "ominous_hook")));
        
                tag(TideTags.Items.BAIT_ITEMS)
                        .add(TideTags.key(TideItems.BAIT))
                        .add(TideTags.key(TideItems.LUCKY_BAIT))
                        .add(TideTags.key(TideItems.MAGNETIC_BAIT))
                        .add(TideTags.key(TideItems.INCANDESCENT_BAIT))
                        .add(TideTags.key(TideItems.ABYSS_BAIT));
        
                tag(TideTags.Items.LUCK_BOOSTING_RODS)
                        .add(TideTags.key(TideItems.GOLDEN_FISHING_ROD))
                        .add(TideTags.key(TideItems.MIDAS_FISHING_ROD));
        
                tag(TideTags.Items.LAVA_FISHING_RODS)
                        .add(TideTags.key(TideItems.NETHERITE_FISHING_ROD))
                        .add(TideTags.key(TideItems.BLAZING_FISHING_ROD));
        
                tag(TideTags.Items.LAVA_BUCKETS)
                        .forceAddTag(TideTags.Convention.LAVA_BUCKETS)
                        .add(TideTags.key(Items.LAVA_BUCKET));
        
                tag(TideTags.Items.BAIT_PLANTS)
                        .forceAddTag(TideTags.Convention.CROPS)
                        .forceAddTag(TideTags.Convention.MUSHROOMS)
                        
                        // TODO(26.2): ItemTags.SMALL_FLOWERS removed — consider FabricTagsProvider.ItemTagsProvider + copy(BlockTags.SMALL_FLOWERS, ...)
                        .add(TideTags.key(Items.DANDELION))
                        .add(TideTags.key(Items.POPPY))
                        .add(TideTags.key(Items.BLUE_ORCHID))
                        .add(TideTags.key(Items.ALLIUM))
                        .add(TideTags.key(Items.AZURE_BLUET))
                        .add(TideTags.key(Items.RED_TULIP))
                        .add(TideTags.key(Items.ORANGE_TULIP))
                        .add(TideTags.key(Items.WHITE_TULIP))
                        .add(TideTags.key(Items.PINK_TULIP))
                        .add(TideTags.key(Items.OXEYE_DAISY))
                        .add(TideTags.key(Items.CORNFLOWER))
                        .add(TideTags.key(Items.LILY_OF_THE_VALLEY))
                        .add(TideTags.key(Items.TORCHFLOWER));
        
                tag(TideTags.Items.VANILLA_FISH)
                        .add(TideTags.key(Items.COD))
                        .add(TideTags.key(Items.SALMON))
                        .add(TideTags.key(Items.TROPICAL_FISH))
                        .add(TideTags.key(Items.PUFFERFISH));
        
                tag(TideTags.Items.LEGENDARY_FISH)
                        .add(TideTags.key(TideFish.SHOOTING_STARFISH))
                        .add(TideTags.key(TideFish.COELACANTH))
                        .add(TideTags.key(TideFish.DEVILS_HOLE_PUPFISH))
                        .add(TideTags.key(TideFish.MIDAS_FISH))
                        .add(TideTags.key(TideFish.ALPHA_FISH))
                        .add(TideTags.key(TideFish.VOIDSEEKER))
                        .add(TideTags.key(TideFish.DRAGON_FISH));
        
                tag(TideTags.Items.CAT_FOOD).forceAddTag(TideTags.Items.COOKABLE_FISH)
                        .add(TideTags.key(Items.SALMON))
                        .add(TideTags.key(Items.COD));
        
                TagAppender<Item> fishBuilder = tag(TideTags.Items.FISH)
                        .forceAddTag(TideTags.Items.VANILLA_FISH);
                TideFish.FISH_KEYS
                        .forEach(fishBuilder::add);
        
                TagAppender<Item> cookableFishBuilder = tag(TideTags.Items.COOKABLE_FISH);
                
                TideFish.COOKABLE_FISH_MAP.values().stream()
                        .flatMap(List::stream)
                        .sorted(Comparator.comparing(ResourceKey::toString))
                        .forEach(cookableFishBuilder::add);
        
                TagAppender<Item> cookedFishBuilder = tag(TideTags.Items.COOKED_FISH)
                        .add(TideTags.key(Items.COOKED_COD))
                        .add(TideTags.key(Items.COOKED_SALMON));
                        
                TideFish.COOKABLE_FISH_MAP.entrySet().stream()
                        .sorted(Comparator.comparing(entry -> entry.getKey().toString()))
                        .forEach(entry -> {
                                Item cookedItem = entry.getKey();
                        
                                TagAppender<Item> cookableTag = tag(TideTags.Cookables.getCookableTag(cookedItem));
                                entry.getValue().forEach(type -> cookableTag.add(type));
                                cookedFishBuilder.add(TideTags.key(cookedItem));
                        });
        
                tag(TideTags.Items.CRATES)
                        .add(TideTags.key(TideItems.WOODEN_CRATE))
                        .add(TideTags.key(TideItems.OBSIDIAN_CRATE))
                        .add(TideTags.key(TideItems.PURPUR_CRATE));
        
                tag(TideTags.Items.INFORMATIONAL)
                        .add(TideTags.key(TideItems.POCKET_WATCH))
                        .add(TideTags.key(TideItems.LUNAR_CALENDAR))
                        .add(TideTags.key(TideItems.DEPTH_METER))
                        .add(TideTags.key(TideItems.CLIMATE_GAUGE))
                        .add(TideTags.key(TideItems.WEATHER_RADIO))
                        .add(TideTags.key(TideItems.FISH_FINDER));
        
                tag(TideTags.Items.TRINKETS_INFORMATIONAL)
                        .forceAddTag(TideTags.Items.INFORMATIONAL);
        
                tag(TideTags.Items.CURIOS_INFORMATIONAL)
                        .forceAddTag(TideTags.Items.INFORMATIONAL);
        
                // Common tags
        
                tag(TagKey.create(Registries.ITEM, Tide.resource("forge", "tools/fishing_rods")))
                        .forceAddTag(TideTags.Items.FISHING_RODS);
        
                tag(ItemTags.FISHES).forceAddTag(TideTags.Items.FISH);
        
                tag(TideTags.Convention.RAW_FISH_FOODS)
                        .addTag(TideTags.Items.COOKABLE_FISH)
                        .add(TideTags.key(TideItems.FISH_SLICE));
        
                tag(TideTags.Convention.COOKED_FISH_FOODS)
                        .addTag(TideTags.Items.COOKED_FISH)
                        .add(TideTags.key(TideItems.COOKED_FISH_SLICE));
        
                tag(TideTags.Convention.BOW_TOOLS).add(TideTags.key(TideItems.STARLIGHT_BOW));
        
                tag(ItemTags.SWORDS)
                        .add(TideTags.key(TideFish.SAILFISH))
                        .add(TideTags.key(TideFish.SWORDFISH))
                        .add(TideTags.key(TideFish.BLAZING_SWORDFISH));
        
                tag(ItemTags.LECTERN_BOOKS)
                        .add(TideTags.key(TideItems.FISHING_JOURNAL));
        
                // Compat tags
        
                tag(TagKey.create(Registries.ITEM, Tide.resource("stardew_fishing", "starts_minigame")))
                        .addTag(TideTags.Items.FISH);
        
                tag(TagKey.create(Registries.ITEM, Tide.resource("stardew_fishing", "legendary_fish")))
                        .addTag(TideTags.Items.LEGENDARY_FISH);
                //?} else {
                /*
                // Mod specific tags
                getOrCreateTagBuilder(TideTags.Items.FISHING_RODS)
                        .add(Items.FISHING_ROD)
                        .add(TideItems.STONE_FISHING_ROD)
                        .add(TideItems.IRON_FISHING_ROD)
                        .add(TideItems.GOLDEN_FISHING_ROD)
                        .add(TideItems.CRYSTAL_FISHING_ROD)
                        .add(TideItems.DIAMOND_FISHING_ROD)
                        .add(TideItems.NETHERITE_FISHING_ROD)
                        .add(TideItems.MIDAS_FISHING_ROD)
                        .add(TideItems.ECHO_FISHING_ROD)
                        .add(TideItems.PRISMARINE_FISHING_ROD)
                        .add(TideItems.SUNFLOWER_FISHING_ROD)
                        .add(TideItems.VILLAGE_FISHING_ROD)
                        .add(TideItems.BLAZING_FISHING_ROD)
                        .add(TideItems.HONEYCOMB_FISHING_ROD);
        
                getOrCreateTagBuilder(TideTags.Items.LINES)
                        .add(TideItems.FISHING_LINE)
                        .add(TideItems.COPPER_LINE)
                        .add(TideItems.IRON_LINE)
                        .add(TideItems.GOLDEN_LINE)
                        .add(TideItems.DIAMOND_LINE);
        
                getOrCreateTagBuilder(TideTags.Items.BOBBERS)
                        .add(TideItems.RED_BOBBER)
                        .add(TideItems.ORANGE_BOBBER)
                        .add(TideItems.YELLOW_BOBBER)
                        .add(TideItems.LIME_BOBBER)
                        .add(TideItems.GREEN_BOBBER)
                        .add(TideItems.LIGHT_BLUE_BOBBER)
                        .add(TideItems.CYAN_BOBBER)
                        .add(TideItems.BLUE_BOBBER)
                        .add(TideItems.PURPLE_BOBBER)
                        .add(TideItems.MAGENTA_BOBBER)
                        .add(TideItems.PINK_BOBBER)
                        .add(TideItems.WHITE_BOBBER)
                        .add(TideItems.LIGHT_GRAY_BOBBER)
                        .add(TideItems.GRAY_BOBBER)
                        .add(TideItems.BLACK_BOBBER)
                        .add(TideItems.BROWN_BOBBER)
                        .add(TideItems.APPLE_BOBBER)
                        .add(TideItems.GOLDEN_APPLE_BOBBER)
                        .add(TideItems.ENCHANTED_GOLDEN_APPLE_BOBBER)
                        .add(TideItems.IRON_BOBBER)
                        .add(TideItems.GOLDEN_BOBBER)
                        .add(TideItems.DIAMOND_BOBBER)
                        .add(TideItems.NETHERITE_BOBBER)
                        .add(TideItems.AMETHYST_BOBBER)
                        .add(TideItems.ECHO_BOBBER)
                        .add(TideItems.CHORUS_BOBBER)
                        .add(TideItems.FEATHER_BOBBER)
                        .add(TideItems.LICHEN_BOBBER)
                        .add(TideItems.NAUTILUS_BOBBER)
                        .add(TideItems.PEARL_BOBBER)
                        .add(TideItems.HEART_BOBBER)
                        .add(TideItems.GRASSY_BOBBER)
                        .add(TideItems.DUCK_BOBBER);
        
                getOrCreateTagBuilder(TideTags.Items.HOOKS)
                        .add(TideItems.FISHING_HOOK)
                        .add(TideItems.FIERY_HOOK)
                        .add(TideItems.PERMAFROST_HOOK)
                        .add(TideItems.TWILIGHT_HOOK)
                        .add(TideItems.LAVAPROOF_HOOK)
                        .add(TideItems.VOID_HOOK)
                        .addOptional(Tide.resource("hybrid_aquatic", "barbed_hook"))
                        .addOptional(Tide.resource("hybrid_aquatic", "glowing_hook"))
                        .addOptional(Tide.resource("hybrid_aquatic", "magnetic_hook"))
                        .addOptional(Tide.resource("hybrid_aquatic", "creepermagnet_hook"))
                        .addOptional(Tide.resource("hybrid_aquatic", "ominous_hook"));
        
                getOrCreateTagBuilder(TideTags.Items.BAIT_ITEMS)
                        .add(TideItems.BAIT)
                        .add(TideItems.LUCKY_BAIT)
                        .add(TideItems.MAGNETIC_BAIT)
                        .add(TideItems.INCANDESCENT_BAIT)
                        .add(TideItems.ABYSS_BAIT);
        
                getOrCreateTagBuilder(TideTags.Items.LUCK_BOOSTING_RODS)
                        .add(TideItems.GOLDEN_FISHING_ROD)
                        .add(TideItems.MIDAS_FISHING_ROD);
        
                getOrCreateTagBuilder(TideTags.Items.LAVA_FISHING_RODS)
                        .add(TideItems.NETHERITE_FISHING_ROD)
                        .add(TideItems.BLAZING_FISHING_ROD);
        
                getOrCreateTagBuilder(TideTags.Items.LAVA_BUCKETS)
                        .forceAddTag(TideTags.Convention.LAVA_BUCKETS)
                        .add(Items.LAVA_BUCKET);
        
                getOrCreateTagBuilder(TideTags.Items.BAIT_PLANTS)
                        .forceAddTag(TideTags.Convention.CROPS)
                        .forceAddTag(TideTags.Convention.MUSHROOMS)
                        .forceAddTag(ItemTags.SMALL_FLOWERS);
        
                getOrCreateTagBuilder(TideTags.Items.VANILLA_FISH)
                        .add(Items.COD)
                        .add(Items.SALMON)
                        .add(Items.TROPICAL_FISH)
                        .add(Items.PUFFERFISH);
        
                getOrCreateTagBuilder(TideTags.Items.LEGENDARY_FISH)
                        .add(TideFish.SHOOTING_STARFISH)
                        .add(TideFish.COELACANTH)
                        .add(TideFish.DEVILS_HOLE_PUPFISH)
                        .add(TideFish.MIDAS_FISH)
                        .add(TideFish.ALPHA_FISH)
                        .add(TideFish.VOIDSEEKER)
                        .add(TideFish.DRAGON_FISH);
        
                getOrCreateTagBuilder(TideTags.Items.CAT_FOOD).forceAddTag(TideTags.Items.COOKABLE_FISH)
                        .add(Items.SALMON).add(Items.COD);
        
                FabricTagBuilder fishBuilder = getOrCreateTagBuilder(TideTags.Items.FISH)
                        .forceAddTag(TideTags.Items.VANILLA_FISH);
                TideFish.FISH_KEYS.forEach(fishBuilder::add);
        
                FabricTagBuilder cookableFishBuilder = getOrCreateTagBuilder(TideTags.Items.COOKABLE_FISH);
                TideFish.COOKABLE_FISH_MAP.values().stream()
                        .flatMap(List::stream)
                        .sorted(Comparator.comparing(ResourceKey::toString))
                        .forEach(cookableFishBuilder::add);
        
                FabricTagBuilder cookedFishBuilder = getOrCreateTagBuilder(TideTags.Items.COOKED_FISH)
                        .add(Items.COOKED_COD).add(Items.COOKED_SALMON);
                TideFish.COOKABLE_FISH_MAP.entrySet().stream()
                        .sorted(Comparator.comparing(entry -> entry.getKey().toString()))
                        .forEach(entry -> {
                        Item cookedItem = entry.getKey();
                        FabricTagBuilder cookableTag = getOrCreateTagBuilder(TideTags.Cookables.getCookableTag(cookedItem));
                        entry.getValue().forEach(cookableTag::add);
                        cookedFishBuilder.add(cookedItem);
                        });
        
                getOrCreateTagBuilder(TideTags.Items.CRATES)
                        .add(TideItems.WOODEN_CRATE)
                        .add(TideItems.OBSIDIAN_CRATE)
                        .add(TideItems.PURPUR_CRATE);
        
                getOrCreateTagBuilder(TideTags.Items.INFORMATIONAL)
                        .add(TideItems.POCKET_WATCH)
                        .add(TideItems.LUNAR_CALENDAR)
                        .add(TideItems.DEPTH_METER)
                        .add(TideItems.CLIMATE_GAUGE)
                        .add(TideItems.WEATHER_RADIO)
                        .add(TideItems.FISH_FINDER);
        
                getOrCreateTagBuilder(TideTags.Items.TRINKETS_INFORMATIONAL)
                        .forceAddTag(TideTags.Items.INFORMATIONAL);
        
                getOrCreateTagBuilder(TideTags.Items.CURIOS_INFORMATIONAL)
                        .forceAddTag(TideTags.Items.INFORMATIONAL);


                // Common tags
                
                getOrCreateTagBuilder(TagKey.create(Registries.ITEM, Tide.resource("forge", "tools/fishing_rods")))
                        .forceAddTag(TideTags.Items.FISHING_RODS);
        
                getOrCreateTagBuilder(ItemTags.FISHES).forceAddTag(TideTags.Items.FISH);
        
                getOrCreateTagBuilder(TideTags.Convention.RAW_FISH_FOODS)
                        .addTag(TideTags.Items.COOKABLE_FISH)
                        .add(TideItems.FISH_SLICE);
        
                getOrCreateTagBuilder(TideTags.Convention.COOKED_FISH_FOODS)
                        .addTag(TideTags.Items.COOKED_FISH)
                        .add(TideItems.COOKED_FISH_SLICE);
        
                getOrCreateTagBuilder(TideTags.Convention.BOW_TOOLS).add(TideItems.STARLIGHT_BOW);
        
                getOrCreateTagBuilder(ItemTags.SWORDS)
                        .add(TideFish.SAILFISH)
                        .add(TideFish.SWORDFISH)
                        .add(TideFish.BLAZING_SWORDFISH);
        
                getOrCreateTagBuilder(ItemTags.LECTERN_BOOKS).add(TideItems.FISHING_JOURNAL);

                
                // Compat tags
        
                getOrCreateTagBuilder(TagKey.create(Registries.ITEM, Tide.resource("stardew_fishing", "starts_minigame")))
                        .addTag(TideTags.Items.FISH);
        
                getOrCreateTagBuilder(TagKey.create(Registries.ITEM, Tide.resource("stardew_fishing", "legendary_fish")))
                        .addTag(TideTags.Items.LEGENDARY_FISH);
                */
                //?}

                //? if >=26.2 {
                tag(ItemTags.CAT_FOOD).forceAddTag(TideTags.Items.COOKABLE_FISH);
        
                tag(ItemTags.FISHING_ENCHANTABLE).forceAddTag(TideTags.Items.FISHING_RODS);
                tag(ItemTags.BOW_ENCHANTABLE).add(TideTags.key(TideItems.STARLIGHT_BOW));
                tag(ItemTags.DURABILITY_ENCHANTABLE)
                        .forceAddTag(TideTags.Items.FISHING_RODS)
                        .add(TideTags.key(TideItems.STARLIGHT_BOW));
                tag(ItemTags.EQUIPPABLE_ENCHANTABLE)
                        .add(TideTags.key(TideFish.SAILFISH))
                        .add(TideTags.key(TideFish.SWORDFISH))
                        .add(TideTags.key(TideFish.BLAZING_SWORDFISH));

                tag(TagKey.create(Registries.ITEM, Tide.resource("stardew_fishing", "starts_minigame")))
                        .addTag(TideTags.Items.FISH);
        
                tag(TagKey.create(Registries.ITEM, Tide.resource("stardew_fishing", "legendary_fish")))
                        .addTag(TideTags.Items.LEGENDARY_FISH);
        
                tag(ItemTags.FOOT_ARMOR).add(TideTags.key(TideItems.DRAGONFIN_BOOTS));
                tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(TideTags.key(TideItems.DRAGONFIN_BOOTS));
                //?} elif >=1.21 {
                /*
                getOrCreateTagBuilder(ItemTags.CAT_FOOD).forceAddTag(TideTags.Items.COOKABLE_FISH);
        
                getOrCreateTagBuilder(ItemTags.FISHING_ENCHANTABLE).forceAddTag(TideTags.Items.FISHING_RODS);
                getOrCreateTagBuilder(ItemTags.BOW_ENCHANTABLE).add(TideItems.STARLIGHT_BOW);
                getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                        .forceAddTag(TideTags.Items.FISHING_RODS)
                        .add(TideItems.STARLIGHT_BOW);
                getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE)
                        .add(TideFish.SAILFISH)
                        .add(TideFish.SWORDFISH)
                        .add(TideFish.BLAZING_SWORDFISH);
                getOrCreateTagBuilder(TagKey.create(Registries.ITEM, Tide.resource("stardew_fishing", "starts_minigame")))
                        .addTag(TideTags.Items.FISH);
        
                getOrCreateTagBuilder(TagKey.create(Registries.ITEM, Tide.resource("stardew_fishing", "legendary_fish")))
                        .addTag(TideTags.Items.LEGENDARY_FISH);
        
                getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(TideItems.DRAGONFIN_BOOTS);
                getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(TideItems.DRAGONFIN_BOOTS);
                */
                //?}
        }
}
//?}