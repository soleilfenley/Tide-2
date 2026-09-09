package com.li64.tide.client.gui.screens.journal;

import net.minecraft.client.gui.Font;
//? if >=26.2 {
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.resources.Identifier;
//?} else {
/*
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
*/
//?}
import org.jetbrains.annotations.NotNull;
public abstract class ProfileComponent {
    public static final int AREA_X = 203;
    public static final int AREA_Y = 24;
    public static final int AREA_WIDTH = 174;
    protected static final int TEXT_COLOR = FishingJournal.TEXT_COLOR;
    //? if >=26.2 {
    protected static final Identifier LINE_TOP = FishingJournal.LINE_TOP;
    protected static final Identifier LINE_BOTTOM = FishingJournal.LINE_BOTTOM;

    public abstract void render(@NotNull GuiGraphicsExtractor graphics, Font font, int x, int y, int mouseX, int mouseY, float partialTick);
    //?} else {
    /*
    protected static final ResourceLocation LINE_TOP = FishingJournal.LINE_TOP;
    protected static final ResourceLocation LINE_BOTTOM = FishingJournal.LINE_BOTTOM;

    public abstract void render(@NotNull GuiGraphics graphics, Font font, int x, int y, int mouseX, int mouseY, float partialTick);
    */
    //?}
    public abstract int getRequiredHeight();
}
