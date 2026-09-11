package com.li64.tide.client.renderer.state;


//? if >=26.2 {
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class TideFishingHookRenderState extends EntityRenderState {
        public float partialTick;
        public float initialYaw;
        public Player player;
        public ItemStack hook;
        public ItemStack line;
        public ItemStack bobber;
        public Vec3 position;
        public int id;
        public boolean allowModifiers;
}
//?}