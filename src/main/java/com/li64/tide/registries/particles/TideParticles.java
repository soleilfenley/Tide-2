package com.li64.tide.registries.particles;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.function.BiConsumer;

//?if >=26.2 {
import net.minecraft.client.renderer.state.level.QuadParticleRenderState;
import net.minecraft.util.ARGB;
//?} else {
/* 
import com.mojang.blaze3d.vertex.VertexConsumer;
*/
//?}


//? if >=26.2 {
public abstract class TideParticles extends SingleQuadParticle {
//?} else {
/*
public abstract class TideParticles extends TextureSheetParticle {
*/
//?}
        protected final BiConsumer<Quaternionf, Camera> facingCameraFunc;

        protected TideParticles(ClientLevel level, double x, double y, double z,
                        SpriteSet sprites, BiConsumer<Quaternionf, Camera> facingCameraFunc
        ) {
                //? if >=26.2 {
                super(level, x, y, z, 0, 0, 0, sprites.first());
                //?} else {
                /*
                super(level, x, y, z, 0, 0, 0);
                */
                //?}
                this.hasPhysics = false;
                this.xd = 0;
                this.yd = 0;
                this.zd = 0;
                this.facingCameraFunc = facingCameraFunc;
        }

        protected Vec3 relativePos(Camera cam, float partialTicks) {
                //? if >=26.2 {
                Vec3 camPos = cam.position();
                //?} else {
                /*Vec3 camPos = cam.getPosition();*/
                //?}
                return new Vec3(
                        Mth.lerp(partialTicks, this.xo, this.x) - camPos.x(),
                        Mth.lerp(partialTicks, this.yo, this.y) - camPos.y(),
                        Mth.lerp(partialTicks, this.zo, this.z) - camPos.z()
                );
        }

        protected Quaternionf cameraRotation(Camera cam, float partialTicks) {
                Quaternionf q = new Quaternionf();
                facingCameraFunc.accept(q, cam);
                if (this.roll != 0F) q.rotateZ(Mth.lerp(partialTicks, this.oRoll, this.roll));
                return q;
        }
        //? if >=26.2 {
        @Override 
        public @NotNull ParticleRenderType getGroup() {
                return ParticleRenderType.SINGLE_QUADS;
        }

        @Override 
        protected @NotNull SingleQuadParticle.Layer getLayer() {
                return SingleQuadParticle.Layer.TRANSLUCENT;
        }

        protected void addVertex(QuadParticleRenderState state, Quaternionf q,
                        float x, float y, float z,
                        float xOffset, float yOffset, float quadSize,
                        float u, float v, int color, int light
        ) {
                Vector3f pos = new Vector3f(xOffset, yOffset, 0F).rotate(q).mul(quadSize).add(x, y, z);
                state.add(SingleQuadParticle.Layer.TRANSLUCENT, 
                        pos.x(), pos.y(), pos.z(), 
                        0f, 0f, 0f, 1f, 
                        1f, 
                        u, u, v, v, 
                        color, light);
        }

        protected int packedColor() {
                return ARGB.colorFromFloat(this.alpha, this.rCol, this.gCol, this.bCol);
        }
        //?} else {
        /*
        @Override
        public @NotNull ParticleRenderType getRenderType() {
                return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
        }

        protected void addVertexLegacy(VertexConsumer buffer, Quaternionf q, float x, float y, float z,
                        float xOffset, float yOffset, float quadSize, float u, float v, int packedLight)
        {
                Vector3f pos = new Vector3f(xOffset, yOffset, 0.0F).rotate(q).mul(quadSize).add(x, y, z);
                buffer.addVertex(pos.x(), pos.y(), pos.z())
                        .setColor(this.rCol, this.gCol, this.bCol, this.alpha)
                        .setUv(u, v)
                        .setUv2(packedLight & 0xFFFF, packedLight >> 16 & 0xFFFF);
        }
        */
        //?}

        //? if >=26.2 {
        @Override
        public @NotNull SingleQuadParticle.FacingCameraMode getFacingCameraMode() {
                return (q, cam, f) -> facingCameraFunc.accept(q, cam);
        }
        //?} elif >=1.21 {
        /*
        @Override
        public @NotNull FacingCameraMode getFacingCameraMode() {
                return (q, cam, f) -> facingCameraFunc.accept(q, cam);
        }*/
        //?}

        protected record Corner(float xOffset, float yOffset, float u, float v) {}
        protected abstract Corner[] corners(float partialTicks);

        //? if >=26.2 {
        @Override 
        public void extract(@NotNull QuadParticleRenderState state, Camera cam, float partialTicks) {
                Vec3 p = this.relativePos(cam, partialTicks);
                Quaternionf q = this.cameraRotation(cam, partialTicks);
                float size = this.getQuadSize(partialTicks);
                int color = this.packedColor();
                int light = this.getLightCoords(partialTicks);

                for (Corner c : this.corners(partialTicks)) {
                        this.addVertex(state, q, (float) p.x, (float) p.y, (float) p.z, 
                                c.xOffset(), c.yOffset(), size, c.u(), c.v(), color, light);
                }
        }
        //?} else {
        /*
        @Override
        public void render(VertexConsumer buffer, Camera cam, float partialTicks) {
                Vec3 p = this.relativePos(cam, partialTicks);
                Quaternionf q = this.cameraRotation(cam, partialTicks);
                float size = this.getQuadSize(partialTicks);
                int color = this.getLightColor(partialTicks);
        
                for (Corner c : this.corners(partialTicks)) {
                this.addVertexLegacy(buffer, q, (float) p.x, (float) p.y, (float) p.z,c.xOffset(), c.yOffset(), size, c.u(), c.v(), color);
                }
        }
        */
        //?}
}