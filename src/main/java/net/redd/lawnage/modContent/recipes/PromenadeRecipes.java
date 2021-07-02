package net.redd.lawnage.modContent.recipes;

import net.devtech.arrp.json.recipe.*;
import net.minecraft.util.Identifier;
import net.redd.lawnage.core.systems.RecipeLoader;
import net.redd.lawnage.core.systems.SimpleRegistry;
import org.apache.logging.log4j.Level;

import static net.redd.lawnage.Main.LOGGER;
import static net.redd.lawnage.core.systems.SimpleRegistry.get;

public class PromenadeRecipes extends RecipeLoader{

    public static PromenadeRecipes INSTANCE = new PromenadeRecipes();

    private PromenadeRecipes(){}

    static {mod_id = "lawnage"; }
    public void registerRecipes() {
        LOGGER.log(Level.INFO,"LAWNAGE: loading recipes for Promenade addon!");
        {
            SimpleRegistry.registerRecipe(new Identifier(mod_id, "dylium_shapeless_0"), JRecipe.shapeless
                    (JIngredients.ingredients()
                                    .add(
                                            JIngredient.ingredient()
                                                    .item("promenade:black_dylium")
                                    ),
                            JResult.item(get("black_dylium_lawn").asItem())
                    ));
        }
    }



}
