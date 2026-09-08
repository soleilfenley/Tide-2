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

public class OpenJournalMsg implements TidePacketPayload {
        //? if >=26.2 {
        public static final Identifier ID = Tide.resource("open_journal");
        @Override public Identifier id() { return ID; }
        //?} else {
        /*
        public static final ResourceLocation ID = Tide.resource("open_journal");
        @Override public ResourceLocation id() { return ID; }
        */
        //?}

        public OpenJournalMsg() {}
        public OpenJournalMsg(FriendlyByteBuf buf) {}
        
        public static void encode(OpenJournalMsg message, FriendlyByteBuf buf) {}
        
        public static void handle(OpenJournalMsg message, Player player) {
                TideClientHelper.openJournalScreen();
        }
}