package com.li64.tide.registries.items;

//? if >=26.2 {
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
//?} else {
/*
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
*/
//?}

//? if >=26.2 {
public class SwordfishItem extends Item {
        public SwordfishItem(ToolMaterial tier, int damageMod, float speedMod, Properties properties) {
                super(properties.sword(tier, damageMod, speedMod));
        }
}
//?} elif >= 1.21 {
/*
public class SwordfishItem extends SwordItem {
        public SwordfishItem(Tiers tier, int damageMod, float speedMod, Properties properties) {
                super(tier, properties.attributes(SwordItem.createAttributes(tier, damageMod, speedMod)));
        }
        
        @Override
        public boolean isValidRepairItem(ItemStack stack, ItemStack repairCandidate) {
                return false;
        }
}
*/
//?} else {
/*
public class SwordfishItem extends SwordItem {
        public SwordfishItem(Tiers tier, int damageMod, float speedMod, Properties properties) {
                super(tier, damageMod, speedMod, properties);
        }
        
        @Override
        public boolean isValidRepairItem(ItemStack stack, ItemStack repairCandidate) {
                return false;
        }
}
*/
//?}
        
