package com.li64.tide.registries.entities.renderers;

import com.li64.tide.registries.entities.models.FishModel;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.world.entity.Mob;
import org.jetbrains.annotations.NotNull;

//? if >=26.2 {
import net.minecraft.client.renderer.rendertype.RenderType;
//?} else {
/*
import net.minecraft.client.renderer.RenderType;
*/
//?}

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
