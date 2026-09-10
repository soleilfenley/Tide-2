package com.li64.tide.mixin;

//? if >= 26.2 {
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.li64.tide.client.TideRenderTypes;
import com.mojang.blaze3d.vertex.QuadInstance;

import net.minecraft.client.renderer.feature.ItemFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;

@Mixin (ItemFeatureRenderer.class)
public class ItemFeatureRendererMixin {
        private static final ThreadLocal<Integer> SILHOUETTE_COLOR = new ThreadLocal<>();

        public static void pushSilhouetteColor(int color) {
                SILHOUETTE_COLOR.set(color);
        }

        public static void popSilhouetteColor() {
                SILHOUETTE_COLOR.remove();
        }

        @Redirect(
                method = "prepareMainSubmit",
                at = @At(
                        value = "INVOKE",
                        target = "Lcom/mojang/blaze3d/vertex/QuadInstance;setColor(I)V"
                )
        )
        private void tide$forceSilhouetteColor(QuadInstance instance, int color) {
                Integer silhouette = SILHOUETTE_COLOR.get();
                instance.setColor(silhouette != null ? silhouette : color);
        }

        @ModifyArg(
                method = "prepareMainSubmit",
                at = @At(
                        value = "INVOKE",
                        target = "Lnet/minecraft/client/renderer/feature/RenderTypeFeatureRenderer;getVertexBuilder(Lnet/minecraft/client/renderer/rendertype/RenderType;)Lcom/mojang/blaze3d/vertex/VertexConsumer;"
                ),
                index = 0
        )
        private RenderType tide$useSilhouetteRenderType(RenderType renderType) {
                if (SILHOUETTE_COLOR.get() != null) {
                        renderType = TideRenderTypes.singleColorItem();
                }
                return renderType;
        }
}
//?}