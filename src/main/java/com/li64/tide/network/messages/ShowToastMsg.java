package com.li64.tide.network.messages;

import com.li64.tide.Tide;
import com.li64.tide.client.TideClientHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
//? if >=26.2 {
import net.minecraft.resources.Identifier;
//?} else {
/*
import net.minecraft.resources.ResourceLocation;
*/
//?}
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public record ShowToastMsg(
        Component title,
        Component description,
        ItemStack display
) implements TidePacketPayload {
        //? if >=26.2 {
        public static final Identifier ID = Tide.resource("show_toast");
        @Override
        public Identifier id() {return ID;}
        //?} else {
        /*
        public static final ResourceLocation ID = Tide.resource("show_toast");
        @Override
        public ResourceLocation id() {return ID;}
         */
        //?}

        public ShowToastMsg(FriendlyByteBuf buf) {
                this(
                        Component.translatable(buf.readUtf()),
                        Component.translatable(buf.readUtf()),
                        BuiltInRegistries.ITEM.getOptional(
                                //? if >=26.2 {
                                Identifier.tryParse(buf.readUtf())
                                //?} else {
                                /*
                                ResourceLocation.tryParse(buf.readUtf())
                                */
                                //?}
                        )
                                .orElseThrow()
                                .getDefaultInstance()
                );
        }

        public static void encode(ShowToastMsg message, FriendlyByteBuf buf) {
                buf.writeUtf(message.title.getString());
                buf.writeUtf(message.description.getString());
                buf.writeUtf(
                        BuiltInRegistries.ITEM.getKey(
                                message.display.getItem()
                        ).toString()
                );
        }

        public static void handle(ShowToastMsg message, Player player) {
                TideClientHelper.showToast(
                        message.title,
                        message.description,
                        message.display
                );
        }
}
