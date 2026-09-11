package com.li64.tide.registries.entities.renderers;

import com.li64.tide.registries.entities.models.FishModel;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import org.jetbrains.annotations.NotNull;

//? if >=26.2 {
import com.li64.tide.client.renderer.state.FishRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
//?} else {
/*
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Mob;
*/
//?}

//? if >=26.2 {
public class GlowingEyesLayer<M extends FishModel> extends EyesLayer<FishRenderState, M> {
    private final RenderType eyeRenderType;

    public GlowingEyesLayer(RenderLayerParent<FishRenderState, M> parent, Identifier eyeTexture) {
        super(parent);
        this.eyeRenderType = RenderTypes.beaconBeam(eyeTexture, true);
    }

    public @NotNull RenderType renderType() {
            return eyeRenderType;
        }
}
//?} else {
/*
public class GlowingEyesLayer<M extends FishModel> extends EyesLayer<Mob, M> {
    private final RenderType eyeRenderType;

    public GlowingEyesLayer(RenderLayerParent<Mob, M> parent) {
        super(parent);
        this.eyeRenderType = RenderType.beaconBeam(parent.getTextureLocation(null).withPath(original ->
                original.substring(0, original.indexOf(".png")) + "_eyes.png"), true);
    }

    public @NotNull RenderType renderType() {
            return eyeRenderType;
        }
}
*/
//?}
