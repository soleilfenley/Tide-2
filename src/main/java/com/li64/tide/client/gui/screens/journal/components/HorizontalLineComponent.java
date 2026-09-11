package com.li64.tide.client.gui.screens.journal.components;

import com.li64.tide.client.gui.screens.journal.ProfileComponent;
import net.minecraft.client.gui.Font;
import org.jetbrains.annotations.NotNull;

//? if >=26.2 {
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
//?} else {
/*
import com.li64.tide.util.TideUtils;
import net.minecraft.client.gui.GuiGraphics;
*/
//?}

public class HorizontalLineComponent extends ProfileComponent {
    private final boolean top;

    public HorizontalLineComponent(boolean top) {
        this.top = top;
    }

    @Override
    //? if >=26.2 {
    public void render(@NotNull GuiGraphicsExtractor graphics, Font font, int x, int y, int mouseX, int mouseY, float partialTick) {
        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, top ? ProfileComponent.LINE_TOP : ProfileComponent.LINE_BOTTOM, x, y + 4, ProfileComponent.AREA_WIDTH, 2);
    //?} else {
    /*
    public void render(@NotNull GuiGraphics graphics, Font font, int x, int y, int mouseX, int mouseY, float partialTick) {
    //  graphics.blit(top ? ProfileComponent.LINE_TOP : ProfileComponent.LINE_BOTTOM, x, y + 4, 0, 0,
    //            ProfileComponent.AREA_WIDTH, 2, 71, 2);
        TideUtils.blitNineSliced(graphics, top ? ProfileComponent.LINE_TOP : ProfileComponent.LINE_BOTTOM,
                x, y + 4, ProfileComponent.AREA_WIDTH, 2, 3, 0,
                71, 2, 0, 0, 71, 2);
    */
    //?}
    }

    @Override
    public int getRequiredHeight() {
        return 10;
    }
}
