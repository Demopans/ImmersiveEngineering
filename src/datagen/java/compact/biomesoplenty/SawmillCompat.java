/*
 * BluSunrize
 * Copyright (c) 2024
 *
 * This code is licensed under "Blu's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package compact.biomesoplenty;

import blusunrize.immersiveengineering.data.recipes.IERecipeProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import compact.WoodDict;

public class SawmillCompat extends IERecipeProvider
{
	public SawmillCompat(PackOutput p_248933_)
	{
		super(p_248933_);
	}

	@Override
	protected void buildRecipes(RecipeOutput recipeOutput)
	{

	}

	/**
	 * Enum of bop woods
	 */
	private enum WoodList{

	}

	/**
	 * Adds logs to sawmill
	 */
	private void sawmill(RecipeOutput out){}
}
