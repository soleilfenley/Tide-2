package com.li64.tide.registries.particles;

import org.jetbrains.annotations.NotNull;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

public class VoidRipple extends TideParticles {
        private final SpriteSet sprites;
        
        protected VoidRipple(ClientLevel level, double x, double y, double z, SpriteSet sprites, float quadSize) {
                super(level, x, y, z, sprites,
                        (q, cam) -> q.set(0, 0, 0, cam.rotation().w).rotateLocalX(-Mth.HALF_PI));
                this.lifetime = 8;
                this.sprites = sprites;
                this.quadSize = quadSize;
                this.setSpriteFromAge(sprites);
        }
        
        @Override
        public void tick() {
                super.tick();
                this.setSpriteFromAge(this.sprites);
        }
        
        @Override 
        protected Corner[] corners(float partialTicks) {
                float u0 = this.getU0(), u1 = this.getU1(), v0 = this.getV0(), v1 = this.getV1();
                return new Corner[] {
                        new Corner( 1f, -1f, u1, v1),
                        new Corner( 1f,  1f, u1, v0),
                        new Corner(-1f,  1f, u0, v0),
                        new Corner(-1f, -1f, u0, v1)
                };
        }

        public record LargeProvider(SpriteSet sprites) implements ParticleProvider<SimpleParticleType> {
                @Override 
                public @NotNull Particle createParticle(@NotNull SimpleParticleType type,
                                                        @NotNull ClientLevel level,
                                                        double x, double y, double z,
                                                        double vx, double vy, double vz
                                                        /*? if >=26.2 {*/, @NotNull RandomSource random/*?}*/
                ) {
                        return new VoidRipple(level, x, y, z, sprites, 0.5f);
                }
        }

        public record SmallProvider(SpriteSet sprites) implements ParticleProvider<SimpleParticleType> {
                @Override
                public @NotNull Particle createParticle(@NotNull SimpleParticleType type,
                                                        @NotNull ClientLevel level,
                                                        double x, double y, double z,
                                                        double vx, double vy, double vz
                                                        /*? if >=26.2 {*/, @NotNull RandomSource random/*?}*/
                ) {
                        return new VoidRipple(level, x, y, z, sprites, 0.25f);
                }
        }
}
