package net.redd.lawnage.recipes;

import net.devtech.arrp.json.recipe.JIngredient;
import net.devtech.arrp.json.recipe.JIngredients;
import net.devtech.arrp.json.recipe.JRecipe;
import net.devtech.arrp.json.recipe.JResult;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.redd.lawnage.SimpleRegistry;
import org.apache.logging.log4j.Level;

import static net.redd.lawnage.Main.LOGGER;

public class CinderscapesRecipes extends RecipeLoader {

    public static CinderscapesRecipes INSTANCE = new CinderscapesRecipes();

    private CinderscapesRecipes(){}

    static { mod_id="cinderscapes"; }

    @Override
    public void registerRecipes() {
        SimpleRegistry.registerRecipe(new Identifier("lawnage", "umbral_nylium_lawn_nylium_to_lawn"), JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item(Items.GRASS_BLOCK)), JResult.item(SimpleRegistry.get("umbral_nylium_lawn").asItem())));
        LOGGER.log(Level.INFO,"LAWNAGE: recipes loaded for cinderscapes addon");
    }

}
