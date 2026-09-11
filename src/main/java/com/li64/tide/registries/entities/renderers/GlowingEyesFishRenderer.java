package com.li64.tide.registries.entities.renderers;

import com.li64.tide.Tide;
import com.li64.tide.registries.entities.models.FishModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

//? if >=26.2 {
import net.minecraft.resources.Identifier;
//?} else {
/*
import net.minecraft.world.entity.Mob;
*/
//?}

public class GlowingEyesFishRenderer<M extends FishModel> extends FishRenderer<M> {
    public GlowingEyesFishRenderer(String key, M model, EntityRendererProvider.Context context) {
        super(key, model, context);
        //? if >=26.2 {
        Identifier eyeTexture = Tide.resource("textures/entity/fish/" + key + "_eyes.png");
        this.addLayer(new GlowingEyesLayer<M>(this, eyeTexture));
        //?} else {
        /*
        this.addLayer(new GlowingEyesLayer<>(this));
        */
        //?}
    }
}
