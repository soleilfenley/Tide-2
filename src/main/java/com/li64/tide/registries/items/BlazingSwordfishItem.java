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
    
    //? if >=26.2 {
    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.igniteForTicks(80);
        super.postHurtEnemy(stack, target, attacker);
    }
    //?} elif >= 1.21 {
    /*
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.igniteForTicks(80);
        return super.hurtEnemy(stack, target, attacker);
    }
    */
    //?} else {
    /*
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setSecondsOnFire(4);
        return super.hurtEnemy(stack, target, attacker);
    }
    */
    //?}
}
