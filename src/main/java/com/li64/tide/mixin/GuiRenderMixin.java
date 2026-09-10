package com.li64.tide.mixin;

import com.li64.tide.client.gui.TideGuiOverlays;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//? if >=26.2 {
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.Hud;
//?} elif >= 1.21 {
/*
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.Gui;
*/
//?} else {
/*
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.Gui;
*/
//?}

//? if >=26.2 {
@Mixin(value = Hud.class)
//?} else {
/*
@Mixin(value = Gui.class)
*/
//?}
public class GuiRenderMixin {
        //? if >=26.2 {
        @Inject(at = @At(value = "TAIL"), method = "extractRenderState")
        public void extractRenderState(GuiGraphicsExtractor graphics, DeltaTracker deltaTracker, CallbackInfo ci) {
        //?} elif >=1.21 {
        /*
        @Inject(at = @At(value = "TAIL"), method = "render")
        public void render(GuiGraphics graphics, DeltaTracker deltaTracker, CallbackInfo ci) {
        */
        //?} else {
        /*
        @Inject(at = @At(value = "TAIL"), method = "render")
        public void render(GuiGraphics graphics, float partialTick, CallbackInfo ci) {
        */
        //?}
                TideGuiOverlays.render(graphics);
    }
}
