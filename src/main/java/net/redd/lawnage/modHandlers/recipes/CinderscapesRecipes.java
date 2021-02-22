package net.redd.lawnage.modHandlers.recipes;

import net.devtech.arrp.json.recipe.*;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.redd.lawnage.SimpleRegistry;
import org.apache.logging.log4j.Level;

import static net.redd.lawnage.Main.LOGGER;
import static net.redd.lawnage.SimpleRegistry.get;

public class CinderscapesRecipes extends RecipeLoader {

    public static CinderscapesRecipes INSTANCE = new CinderscapesRecipes();

    private CinderscapesRecipes(){}

    static { mod_id="cinderscapes"; }

    @Override
    public void registerRecipes() {
        LOGGER.log(Level.INFO,"LAWNAGE: loading recipes for cinderscapes addon!");

        {
            SimpleRegistry.registerRecipe(new Identifier("lawnage", "umbral_shaped_0"), JRecipe.shaped(
                    JPattern.pattern(
                            "nnn",
                            "nun",
                            "nnn"
                    ),
                    JKeys.keys()
                            .key("u",
                                    JIngredient.ingredient()
                                            .tag("lawnage:umbral_block")
                            )
                            .key("n",
                                    JIngredient.ingredient()
                                            .item(Items.NETHERRACK)
                            ),
                    JResult.itemStack(get("umbral_nylium_lawn").asItem(), 8)
            ));

        }

        {
            SimpleRegistry.registerRecipe(new Identifier("lawnage", "umbral_shapeless_0"), JRecipe.shapeless
                            (JIngredients.ingredients()
                                    .add(
                                            JIngredient.ingredient()
                                            .item("cinderscapes:umbral_nylium")
                                    ),
                            JResult.item(get("umbral_nylium_lawn").asItem())
            ));
        }

        {
            SimpleRegistry.registerRecipe(new Identifier("lawnage", "umbral_shapeless_1"), JRecipe.shapeless(
                    JIngredients.ingredients()
                            .add(
                                    JIngredient.ingredient()
                                            .item(Items.NETHERRACK)
                            )
                            .add(
                                    JIngredient.ingredient()
                                            .item("cinderscapes:umbral_fungus")
                            ),
                    JResult.item(get("umbral_nylium_lawn").asItem())));
        }

        LOGGER.log(Level.INFO,"LAWNAGE: successfully loaded recipes for cinderscapes addon!");
    }

}
