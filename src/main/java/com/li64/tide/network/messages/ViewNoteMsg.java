package com.li64.tide.network.messages;

import com.li64.tide.Tide;
import com.li64.tide.client.TideClientHelper;
import net.minecraft.network.FriendlyByteBuf;
//? if >=26.2 {
import net.minecraft.resources.Identifier;
//?} else {
/*
import net.minecraft.resources.ResourceLocation;
*/
//?}
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public record ViewNoteMsg(ItemStack stack) implements TidePacketPayload {
        //? if >=26.2 {
        public static final Identifier ID = Tide.resource("view_note");
        @Override public Identifier id() { return ID; }
        //?} else {
        /*
        public static final ResourceLocation ID = Tide.resource("view_note");
        @Override public ResourceLocation id() { return ID; }
        */
        //?}
        
        public ViewNoteMsg(FriendlyByteBuf buf) {
                this(buf.readJsonWithCodec(ItemStack./*? if >=1.21 {*/SIMPLE_ITEM_CODEC/*?} else {*//*CODEC*//*?}*/));
        }
        
        public static void encode(ViewNoteMsg message, FriendlyByteBuf buf) {
                buf.writeJsonWithCodec(ItemStack./*? if >=1.21 {*/SIMPLE_ITEM_CODEC/*?} else {*//*CODEC*//*?}*/, message.stack);
        }
        
        public static void handle(ViewNoteMsg message, Player player) {
                TideClientHelper.openNoteScreen(message.stack);
        }
}