package com.li64.tide.mixin;

import com.google.common.collect.BiMap;
import com.li64.tide.Tide;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//? if >=26.2 {
import net.minecraft.resources.Identifier;
import net.minecraft.util.context.ContextKeySet;
//?} else {
/*
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
*/
//?}

import java.util.function.Consumer;

@Mixin(LootContextParamSets.class)
public class LootContextParamSetsMixin {
        //? if >=26.2 {
        @Shadow @Final private static BiMap<Identifier, ContextKeySet> REGISTRY;
        //?} else {
        /*
        @Shadow @Final private static BiMap<ResourceLocation, LootContextParamSet> REGISTRY;
        */
        //?}

    @Inject(at = @At(value = "HEAD"), method = "register", cancellable = true)
    private static void register(String registryName, Consumer</*? if >=26.2 {*/ContextKeySet/*?} else {*//*LootContextParamSet*//*?}*/.Builder> builderConsumer, CallbackInfoReturnable</*? if >=26.2 {*/ContextKeySet/*?} else {*//*LootContextParamSet*//*?}*/> cir) {
        if (registryName.matches("fishing")) {
            builderConsumer = builder -> {
                builder.required(LootContextParams.ORIGIN)
                        .required(LootContextParams.TOOL)
                        .optional(LootContextParams.THIS_ENTITY)
                        .optional(LootContextParams.BLOCK_STATE); // This entire mixin is just to add this line :(
            };
            /*? if >=26.2 {*/ContextKeySet/*?} else {*//*LootContextParamSet*//*?}*/.Builder builder = new /*? if >=26.2 {*/ContextKeySet/*?} else {*//*LootContextParamSet*//*?}*/.Builder();
            builderConsumer.accept(builder);
            /*? if >=26.2 {*/ContextKeySet/*?} else {*//*LootContextParamSet*//*?}*/ paramSet = builder.build();
            //? if >=26.2 {
            Identifier registry = Tide.resource("minecraft", registryName);
            //?} else {
            /*
            ResourceLocation registry = Tide.resource("minecraft", registryName);
            */
            //?}
            /*? if >=26.2 {*/ContextKeySet/*?} else {*//*LootContextParamSet*//*?}*/ newParamSet = REGISTRY.put(registry, paramSet);
            if (newParamSet != null) {
                throw new IllegalStateException("Loot table parameter set " + registry + " is already registered");
            } else {
                cir.setReturnValue(paramSet);
            }
        }
    }
}