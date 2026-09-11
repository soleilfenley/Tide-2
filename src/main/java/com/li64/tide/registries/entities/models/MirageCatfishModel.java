package com.li64.tide.registries.entities.models;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

//? if >=26.2 {
import net.minecraft.util.ARGB;
//?} else {
/*
import net.minecraft.util.FastColor;
*/
//?}

public class MirageCatfishModel extends FishModel {
    public static final ModelLayerLocation MODEL_LOCATION = createModelLocation("mirage_catfish");

    public MirageCatfishModel(EntityRendererProvider.Context context) {
        super(context, MODEL_LOCATION);
        this.addSwimAnimation("front/head", 0.6f, -0.15f);
        this.addSwimAnimation("rear", 0.6f, 0.15f);
        this.addSwimAnimation("rear/tail", 0.6f, 0.15f);
        this.addSwimAnimation("rear/tail/fin", 0.6f, 0.15f);
    }

    @Override
    public int tint() {
            //? if >=26.2 {
            return ARGB.color(150, 255, 255, 255);
            //?} else {
            /*
            return FastColor.ARGB32.color(150, 255, 255, 255);
            */
            //?}
    }

    @Override
    public boolean renderTranslucent() {
        return true;
    }
}