package com.li64.tide.client;

//? if >=26.2 {
import net.minecraft.resources.Identifier;
//?} else {
/*
import net.minecraft.client.renderer.ShaderInstance;
*/
//?}

public class TideCoreShaders {

        //? if >=26.2 {
        public static final Identifier FULL_WHITE = Identifier.fromNamespaceAndPath("tide", "full_white");
        //?} else {
        /*
        public static ShaderInstance FULL_WHITE;
        public static ShaderInstance FULL_WHITE_ITEM;
        */
        //?}

        //? if >=26.2 {
        public static Identifier fullWhite() { return FULL_WHITE; }
        //?} else {
        /*
        public static ShaderInstance fullWhite() { return FULL_WHITE; }
        public static ShaderInstance fullWhiteItem() { return FULL_WHITE_ITEM; }
        */
        //?}
}
