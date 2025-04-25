package net.Borchik.lemonmod.datagen;

import net.Borchik.lemonmod.LemonMod;
import net.Borchik.lemonmod.block.ModBlocks;
import net.Borchik.lemonmod.item.Moditems;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.openjdk.nashorn.internal.ir.UnaryNode;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Moditems.LEMON_SLICE.get(), 9)
            .requires(Moditems.LEMON.get())
            .unlockedBy(getHasName(Moditems.LEMON.get()), has(Moditems.LEMON.get()))
            .save(consumer);
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Moditems.LEMON_SEEDS.get(), 3)
            .requires(Moditems.LEMON_SLICE.get())
            .unlockedBy(getHasName(Moditems.LEMON.get()), has(Moditems.LEMON.get()))
            .save(consumer);
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Moditems.ICE_CUBE.get(), 9)
            .requires(Items.ICE)
            .unlockedBy(getHasName(Items.ICE), has(Items.ICE))
            .save(consumer);
    }



    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, LemonMod.MOD_ID +":"+ getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial) {
        stonecutterResultFromBase(pFinishedRecipeConsumer, pCategory, pResult, pMaterial, 1);
    }
}