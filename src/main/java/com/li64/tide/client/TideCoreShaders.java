package com.li64.tide.client;

//? if >=26.2 {
import net.minecraft.client.renderer.ShaderManager;
//?} else {
/*
import net.minecraft.client.renderer.ShaderInstance;
*/
//?}

public class TideCoreShaders {
    public static /*? if >=26.2 {*/ShaderManager/*?} else*//*ShaderInstance*//*?*/ FULL_WHITE;
    public static /*? if >=26.2 {*/ShaderManager/*?} else*//*ShaderInstance*//*?*/ FULL_WHITE_ITEM;

    public static /*? if >=26.2 {*/ShaderManager/*?} else*//*ShaderInstance*//*?*/ fullWhite() {
        return FULL_WHITE;
    }

    public static /*? if >=26.2 {*/ShaderManager/*?} else*//*ShaderInstance*//*?*/ fullWhiteItem() {
        return FULL_WHITE_ITEM;
    }
}
