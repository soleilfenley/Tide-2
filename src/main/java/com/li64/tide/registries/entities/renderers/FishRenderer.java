package com.li64.tide.registries.entities.renderers;

import com.li64.tide.Tide;
import com.li64.tide.registries.entities.models.FishModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
//? if >=26.2 {
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.resources.Identifier;
//?} else {
/*
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
*/
//?}
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FishRenderer<M extends FishModel> extends MobRenderer<Mob, FishModel> {
        //? if >=26.2 {
        private final Identifier texLocation;
        //?} else {
        /*
        private final ResourceLocation texLocation;
        */
        //?}
        private final double xTiltScale;
        private final float swimAnimSpeed;
        private final float swimAnimScale;
        private final boolean renderTranslucent;
        
        public FishRenderer(String key, M model, EntityRendererProvider.Context context) {
                super(context, model, model.shadowRadius());
                this.texLocation = Tide.resource("textures/entity/fish/" + key + ".png");
                this.xTiltScale = model.xTiltScale();
                this.swimAnimSpeed = model.swimAnimSpeed();
                this.swimAnimScale = model.swimAnimScale();
                this.renderTranslucent = model.renderTranslucent();
        }

        //? if >=26.2 {
        public @NotNull Identifier getTextureLocation() {
        //?} else {
        /*
        public @NotNull ResourceLocation getTextureLocation() {
        */
        //?}
                return this.texLocation;
        }
        
        @Override
        //? if >=26.2 {
        public @NotNull Identifier getTextureLocation(@NotNull Mob entity) {
        //?} else {
        /*
        public @NotNull ResourceLocation getTextureLocation(@NotNull Mob entity) {
        */
        //?}
                return this.getTextureLocation();
        }
        
        @Override
        //? if >=1.21 {
        protected void setupRotations(Mob fish, PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale) {
                super.setupRotations(fish, poseStack, bob, yBodyRot, partialTick, scale);
        //?} else {
        /*protected void setupRotations(Mob fish, PoseStack poseStack, float bob, float yBodyRot, float partialTick) {
                super.setupRotations(fish, poseStack, bob, yBodyRot, partialTick);
        *///?}
                float f = swimAnimScale * 4.3f * Mth.sin(swimAnimSpeed * (fish.tickCount + partialTick));
                poseStack.mulPose(Axis.YP.rotationDegrees(f));
                if (!(fish.isInWaterOrBubble() || fish.isInLava()) && flipInAir()) {
                poseStack.translate(0.1f, 0.1f, -0.1f);
                poseStack.mulPose(Axis.ZP.rotationDegrees(90f));
                }
                else {
                // temp workaround for a bug with alex's caves
                float tilt = Mth.clamp((float) (fish.getDeltaMovement().y() * 1.5 * xTiltScale), -Mth.HALF_PI, Mth.HALF_PI);
                if (Tide.PLATFORM.isModLoaded("alexscaves")) poseStack.mulPose(Axis.XP.rotation(tilt));
                else {
                        fish.setXRot(tilt);
                        poseStack.mulPose(Axis.XP.rotation(Mth.lerp(partialTick, fish.xRotO, fish.getXRot())));
                }
                }
        }
        
        private boolean flipInAir() {
                return model.flipInAir();
        }
        
        @Override
        protected @Nullable RenderType getRenderType(@NotNull Mob fish, boolean isVisible, boolean renderTranslucent, boolean appearsGlowing) {
                //? if >=26.2 {
                Identifier texture = this.getTextureLocation(fish);
                //?} else {
                /*
                ResourceLocation texture = this.getTextureLocation(fish);
                */
                //?}
                if (this.renderTranslucent) return RenderType.entityTranslucent(texture);
                return super.getRenderType(fish, isVisible, renderTranslucent, appearsGlowing);
        }
        
        @Override
        protected int getBlockLightLevel(@NotNull Mob fish, @NotNull BlockPos pos) {
                return Math.max(super.getBlockLightLevel(fish, pos), model.brightnessOverride());
        }
}
