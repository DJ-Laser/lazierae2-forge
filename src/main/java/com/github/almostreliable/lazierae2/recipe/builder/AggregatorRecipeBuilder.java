package com.github.almostreliable.lazierae2.recipe.builder;

import com.github.almostreliable.lazierae2.core.Setup.Recipes.Serializers;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

import static com.github.almostreliable.lazierae2.core.Constants.AGGREGATOR_ID;

public class AggregatorRecipeBuilder extends MachineRecipeBuilder {

    AggregatorRecipeBuilder(IItemProvider output, int outputCount) {
        super(output, outputCount);
    }

    public AggregatorRecipeBuilder input(Ingredient input) {
        if (inputs.size() < 3) inputs.add(input);
        return this;
    }

    public AggregatorRecipeBuilder input(IItemProvider input) {
        return input(Ingredient.of(input));
    }

    public AggregatorRecipeBuilder input(ITag<Item> input) {
        return input(Ingredient.of(input));
    }

    public AggregatorRecipeBuilder processingTime(int ticks) {
        processingTime = ticks;
        return this;
    }

    public AggregatorRecipeBuilder energyCost(int energy) {
        energyCost = energy;
        return this;
    }

    @Override
    protected void validateProcessingTime() {
        // TODO: read from config
        if (processingTime == 0) processingTime = 200;
    }

    @Override
    protected void validateEnergyCost() {
        // TODO: read from config
        if (energyCost == 0) energyCost = 1_000;
    }

    @Override
    protected void build(Consumer<? super IFinishedRecipe> consumer, ResourceLocation recipeId) {
        consumer.accept(new Recipe(this, recipeId));
    }

    @Override
    protected String getMachineId() {
        return AGGREGATOR_ID;
    }

    private static final class Recipe extends FinishedMachineRecipe<AggregatorRecipeBuilder> {

        private Recipe(AggregatorRecipeBuilder builder, ResourceLocation recipeId) {
            super(builder, recipeId, builder.getMachineId());
        }

        @Override
        public IRecipeSerializer<?> getType() {
            return Serializers.AGGREGATOR.get();
        }
    }
}
