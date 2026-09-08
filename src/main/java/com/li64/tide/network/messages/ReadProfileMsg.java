package com.li64.tide.network.messages;

import com.li64.tide.Tide;
import com.li64.tide.data.player.TidePlayerData;
import net.minecraft.network.FriendlyByteBuf;
//? if >=26.2 {
import net.minecraft.resources.Identifier;
//?} else {
/*
import net.minecraft.resources.ResourceLocation;
*/
//?}
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public record ReadProfileMsg(int fish) implements TidePacketPayload {
        //? if >=26.2 {
        public static final Identifier ID = Tide.resource("read_profile");
        @Override public Identifier id() { return ID; }
        //?} else {
        /*
        public static final ResourceLocation ID = Tide.resource("read_profile");
        @Override public ResourceLocation id() { return ID; }
        */
        //?}

    public ReadProfileMsg(ItemStack fishItem) {
        this(Item.getId(fishItem.getItem()));
    }

    public ReadProfileMsg(FriendlyByteBuf buf) {
        this(buf.readInt());
    }

    public static void encode(ReadProfileMsg message, FriendlyByteBuf buf) {
        buf.writeInt(message.fish);
    }

    public static void handle(ReadProfileMsg message, Player player) {
        TidePlayerData data = TidePlayerData.getOrCreate((ServerPlayer) player);
        data.markAsRead(new ItemStack(Item.byId(message.fish)));
        data.syncTo((ServerPlayer) player);
    }
}