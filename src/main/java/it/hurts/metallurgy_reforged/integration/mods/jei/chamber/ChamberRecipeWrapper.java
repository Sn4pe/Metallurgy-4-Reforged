/*
 * -------------------------------------------------------------------------------------------------------
 * Class: ChamberRecipeWrapper
 * This class is part of Metallurgy 4 Reforged
 * Complete source code is available at: https://github.com/Davoleo/Metallurgy-4-Reforged
 * This code is licensed under GNU GPLv3
 * Authors: ItHurtsLikeHell & Davoleo
 * Copyright (c) 2019.
 * --------------------------------------------------------------------------------------------------------
 */

package it.hurts.metallurgy_reforged.integration.mods.jei.chamber;

import it.hurts.metallurgy_reforged.recipe.SublimationRecipes;
import it.hurts.metallurgy_reforged.util.ItemUtils;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

import static it.hurts.metallurgy_reforged.gui.hud.SublimationChamberHUD.drawTexturedModalRect;

public class ChamberRecipeWrapper implements IRecipeWrapper {

	private ItemStack input;
	private PotionEffect effect;

	public ChamberRecipeWrapper(ItemStack input, PotionEffect effect)
	{
		this.input = input;
		this.effect = effect;
	}

	public ItemStack getInput()
	{
		return input;
	}

	public static List<ChamberRecipeWrapper> getRecipeInputs()
	{
		ArrayList<ChamberRecipeWrapper> recipes = new ArrayList<>();

		SublimationRecipes.getInstance().recipesMap().forEach((input, effect) -> {
			recipes.add(new ChamberRecipeWrapper(input, effect));
		});

		return recipes;
	}

	@Override
	public void getIngredients(IIngredients ingredients)
	{
		ingredients.setInput(VanillaTypes.ITEM, input);
	}

	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY)
	{
		int color = ItemUtils.getMetalFromItem(input.getItem()).getStats().getMetalColor();

		GlStateManager.pushMatrix();
		minecraft.getTextureManager().bindTexture(GuiContainer.INVENTORY_BACKGROUND);
		drawTexturedModalRect(106, 27, effect.getPotion().getStatusIconIndex() % 8 * 18, 198 + effect.getPotion().getStatusIconIndex() / 8 * 18, 18, 18);
		minecraft.fontRenderer.drawString(effect.getDuration() / 20 + " seconds", 50, 5, color);
		GlStateManager.popMatrix();
	}

}