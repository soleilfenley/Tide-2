package com.li64.tide.data.triggers;
import org.jetbrains.annotations.NotNull;
import net.minecraft.server.level.ServerPlayer;

//? if >=26.2 {
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.predicates.ContextAwarePredicate;
import net.minecraft.advancements.predicates.entity.EntityPredicate;
import net.minecraft.advancements.triggers.SimpleCriterionTrigger;
import java.util.Optional;
//?} elif >= 1.21 {
/*
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import java.util.Optional;
*/
//?} else {
/*
import com.li64.tide.Tide;
import net.minecraft.advancements.critereon.*;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
*/
//?}

//? if >= 1.21 {
public class TideSimpleTrigger extends SimpleCriterionTrigger<TideSimpleTrigger.TriggerInstance> {
    @SuppressWarnings("unused")
    public TideSimpleTrigger(String name) {}

    public @NotNull Codec<TriggerInstance> codec() {
        return TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, trigger -> true);
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleInstance {
        public static final Codec<TriggerInstance> CODEC = RecordCodecBuilder.create(
                builder -> builder.group(EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player")
                        .forGetter(TriggerInstance::player)).apply(builder, TriggerInstance::new));
    }
}
//?} else {
/*
public class TideSimpleTrigger extends SimpleCriterionTrigger<TideSimpleTrigger.TriggerInstance> {
    private final ResourceLocation id;

    public TideSimpleTrigger(String name) {
        this.id = Tide.resource(name);
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return this.id;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, instance -> true);
    }

    @Override
    protected @NotNull TriggerInstance createInstance(JsonObject json, ContextAwarePredicate predicate, DeserializationContext context) {
        return new TriggerInstance(id, predicate);
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {
        final ResourceLocation id;

        public TriggerInstance(ResourceLocation id, ContextAwarePredicate context) {
            super(id, context);
            this.id = id;
        }

        @Override
        public @NotNull ResourceLocation getCriterion() {
            return id;
        }

        @Override
        public @NotNull JsonObject serializeToJson(SerializationContext context) {
            return new JsonObject();
        }
    }
}
*///?}