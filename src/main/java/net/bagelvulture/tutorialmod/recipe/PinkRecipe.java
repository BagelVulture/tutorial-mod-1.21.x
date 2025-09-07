package net.bagelvulture.tutorialmod.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;

public record PinkRecipe(
        Ingredient inputItem,
        int inputCount,
        ItemStack output,
        int pinkingTime
) implements Recipe<PinkRecipeInput> {

    @Override
    public boolean matches(PinkRecipeInput input, net.minecraft.world.World world) {
        if (world.isClient()) return false;
        ItemStack stack = input.getStackInSlot(0);
        return inputItem.test(stack) && stack.getCount() >= inputCount;
    }

    @Override
    public ItemStack craft(PinkRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        ItemStack stack = input.getStackInSlot(0);
        stack.decrement(inputCount);
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.PINK_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.PINK_TYPE;
    }

    public static class Serializer implements RecipeSerializer<PinkRecipe> {
        public static final MapCodec<PinkRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(PinkRecipe::inputItem),
                Codec.INT.fieldOf("input_count").forGetter(PinkRecipe::inputCount),
                ItemStack.CODEC.fieldOf("result").forGetter(PinkRecipe::output),
                Codec.INT.fieldOf("pinkingtime").forGetter(PinkRecipe::pinkingTime)
        ).apply(inst, PinkRecipe::new));

        public static final PacketCodec<RegistryByteBuf, Integer> INT_CODEC = new PacketCodec<>() {
            @Override
            public Integer decode(RegistryByteBuf buf) {
                return buf.readInt();
            }

            @Override
            public void encode(RegistryByteBuf buf, Integer value) {
                buf.writeInt(value);
            }
        };

        public static final PacketCodec<RegistryByteBuf, PinkRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, PinkRecipe::inputItem,
                        INT_CODEC, PinkRecipe::inputCount,
                        ItemStack.PACKET_CODEC, PinkRecipe::output,
                        INT_CODEC, PinkRecipe::pinkingTime,
                        PinkRecipe::new
                );

        @Override
        public MapCodec<PinkRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, PinkRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}