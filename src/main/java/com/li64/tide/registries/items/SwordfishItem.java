package com.li64.tide.registries.items;

import net.minecraft.world.item.ItemStack;

//? if >=26.2 {
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ToolMaterial;
//?} else {
/*
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
*/
//?}

public class SwordfishItem extends SwordItem {
    public SwordfishItem(/*? if >=26.2 {*/ToolMaterial/*?} else {*//*Tiers*//*?}*/ tier, int damageMod, float speedMod, Properties properties) {
        /*? if >=1.21 {*/super(tier, properties.attributes(SwordItem.createAttributes(tier, damageMod, speedMod)));
        /*?} else {*//*super(tier, damageMod, speedMod, properties);*//*?}*/
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack repairCandidate) {
        return false;
    }
}
