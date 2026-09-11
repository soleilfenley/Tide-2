package com.li64.tide.client.renderer.state;

//? if >=26.2 {
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class FishRenderState extends LivingEntityRenderState {
        public boolean isInLava;
        public float partialTick;
        public float xRotO;
        public float yRotO;
        public float tilt;
        public float swimAnim;
        public float deltaMovementY;
}
//?}