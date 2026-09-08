package com.li64.tide.data.loaders;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
//? if >=26.2 {
import net.minecraft.resources.Identifier;
//?} else {
/*
import net.minecraft.resources.ResourceLocation;
*/
//?}
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.Map;

public class VoidHeightLoader extends SimpleJsonResourceReloadListener {
    public VoidHeightLoader(Gson gson) {
        super(gson, "");
    }

    
    //? if >=26.2 {
    protected void apply(Map<ResourceLocation, JsonElement> object, Identifier resourceManager, ProfilerFiller profiler) {
    //?} else {
    /*
    @Override
    protected void apply(Map<ResourceLocation, JsonElement> object, ResourceManager resourceManager, ProfilerFiller profiler) {
    */
    //?}

    }
}
