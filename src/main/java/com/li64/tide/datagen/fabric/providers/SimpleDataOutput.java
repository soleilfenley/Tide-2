package com.li64.tide.datagen.fabric.providers;

import com.li64.tide.Tide;
//? if >=26.2 {
import net.minecraft.resources.Identifier;
//?} else {
/*
import net.minecraft.resources.ResourceLocation;
*/
//?}

public interface SimpleDataOutput<T> {
    default void accept(String path, T data) {
        accept(Tide.resource(path), data);
    }

    //? if >=26.2 {
    void accept(Identifier path, T data);
    //?} else {
    /*
    void accept(ResourceLocation path, T data);
    */
    //?}
}