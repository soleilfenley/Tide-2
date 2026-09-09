package com.li64.tide.client.gui;

import com.li64.tide.client.gui.overlays.CastBarOverlay;
import com.li64.tide.client.gui.overlays.CatchMinigameOverlay;
import com.li64.tide.client.gui.overlays.SonarOverlay;
import com.li64.tide.client.gui.overlays.FishingInfoOverlay;
import net.minecraft.client.Minecraft;

//? if >=26.2 {
import net.minecraft.client.gui.GuiGraphicsExtractor;
//?} else {
/*
import net.minecraft.client.gui.GuiGraphics;
*/
//?}

public class TideGuiOverlays {
        public static void render(/*? if >=26.2 {*/GuiGraphicsExtractor/*?} else {*//*GuiGraphics*//*?}*/ graphics) {
                /*? if >=26.2 {*/float dt = Minecraft.getInstance().getDeltaTracker().getRealtimeDeltaTicks();
                /*?} elif >=1.21 {*//*float dt = Minecraft.getInstance().getTimer().getRealtimeDeltaTicks();*/
                /*?} else*//*float dt = Minecraft.getInstance().getDeltaFrameTime();*/
                CatchMinigameOverlay.render(graphics, dt);
                CastBarOverlay.render(graphics, dt);
                SonarOverlay.render(graphics, dt);
                FishingInfoOverlay.render(graphics, dt);
        }
}
