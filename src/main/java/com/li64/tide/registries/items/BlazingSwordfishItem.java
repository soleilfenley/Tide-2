package com.li64.tide.registries.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

//? if >=26.2 {
import net.minecraft.world.item.ToolMaterial;
//?} else {
/*
import net.minecraft.world.item.Tiers;
*/
//?}

public class BlazingSwordfishItem extends SwordfishItem {
                //? if >=26.2 {
                public BlazingSwordfishItem(ToolMaterial tier, int damageMod, float speedMod, Properties properties) {
                //?} else {
                /*
                public BlazingSwordfishItem(Tiers tier, int damageMod, float speedMod, Properties properties) {
                */
                //?}
        super(tier, damageMod, speedMod, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        /*? if >=1.21 {*/target.igniteForTicks(80);
        /*?} else {*//*target.setSecondsOnFire(4);*//*?}*/
        return super.hurtEnemy(stack, target, attacker);
    }
}
