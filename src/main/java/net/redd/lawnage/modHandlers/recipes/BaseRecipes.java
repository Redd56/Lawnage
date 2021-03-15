package net.redd.lawnage.recipes;

import net.devtech.arrp.json.recipe.JIngredient;
import net.devtech.arrp.json.recipe.JIngredients;
import net.devtech.arrp.json.recipe.JRecipe;
import net.devtech.arrp.json.recipe.JResult;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import static net.redd.lawnage.SimpleRegistry.get;
import static net.redd.lawnage.SimpleRegistry.registerRecipe;

public class BaseRecipes extends RecipeLoader {

    public static BaseRecipes INSTANCE = new BaseRecipes();

    private BaseRecipes(){}

    static { mod_id="lawnage"; }

    @Override
    public void registerRecipes() {
        registerRecipe(new Identifier("lawnage","grass_lawn"), JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item(Items.GRASS_BLOCK)), JResult.item(get("grass_lawn").asItem())));
        registerRecipe(new Identifier("lawnage","grass_lawn_foliage"), JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item(Items.GRASS_BLOCK)).add(JIngredient.ingredient().tag("lawnage:foliage")), JResult.item(get("grass_lawn").asItem())));

        registerRecipe(new Identifier("lawnage","biome_grass_lawn"),
                JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item(get("grass_lawn").asItem())), JResult.item(get("biome_grass_lawn").asItem())));

        registerRecipe(new Identifier("lawnage","mushroom_lawn"), JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item(Items.MYCELIUM)), JResult.item(get("mushroom_lawn").asItem())));

        registerRecipe(new Identifier("lawnage","warped_nylium_lawn"), JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item(Items.WARPED_NYLIUM)), JResult.item(get("warped_nylium_lawn").asItem())));

        registerRecipe(new Identifier("lawnage", "crimson_nylium_to_lawn"), JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item(Items.CRIMSON_NYLIUM)), JResult.item(get("crimson_nylium_lawn").asItem())));

    }

}
