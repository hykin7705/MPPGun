package com.mpp.bluecitizen.datagen;

import com.mpp.bluecitizen.core.registry.ItemRegistry;
import com.mrcrayfish.guns.crafting.WorkbenchIngredient;
import com.mrcrayfish.guns.crafting.WorkbenchRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class ModRecipeGenerator extends RecipeProvider {

	public ModRecipeGenerator(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		
		// Guns
		WorkbenchRecipeBuilder.crafting(ItemRegistry.TESTGUN.get())
			.addIngredient(WorkbenchIngredient.of(Tags.Items.INGOTS_IRON, 30))
			.addIngredient(WorkbenchIngredient.of(Items.OAK_PLANKS, 20))
			.addCriterion("has_iron_ingot", has(Tags.Items.INGOTS_IRON))
			.addCriterion("has_oak_planks", has(Items.OAK_PLANKS))
			.build(consumer);
	}
}
