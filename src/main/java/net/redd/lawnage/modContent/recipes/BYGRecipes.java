package net.redd.lawnage.modContent.recipes;

import net.devtech.arrp.json.recipe.*;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.redd.lawnage.core.systems.RecipeLoader;
import net.redd.lawnage.core.systems.SimpleRegistry;
import org.apache.logging.log4j.Level;

import static net.redd.lawnage.Main.LOGGER;
import static net.redd.lawnage.core.systems.SimpleRegistry.get;

public class BYGRecipes extends RecipeLoader {

    public static BYGRecipes INSTANCE = new BYGRecipes();

    private BYGRecipes(){}

    static { mod_id="lawnage"; }

    @Override
    public void registerRecipes() {
        LOGGER.log(Level.INFO,"LAWNAGE: loading recipes for byg addon!");
        //glowcelium
        {
            SimpleRegistry.registerRecipe(new Identifier(mod_id, "glowcelium_shaped_0"), JRecipe.shaped(
                    JPattern.pattern(
                            "ddd",
                            "dgd",
                            "ddd"
                    ),
                    JKeys.keys()
                            .key("g",
                                    JIngredient.ingredient()
                                            .item("byg:purple_glowshroom_block")
                                            .item("byg:blue_glowshroom_block")
                                            .item("byg:red_glowshroom_stem")
                                            .item("byg:yellow_glowshroom_stem")
                            )
                            .key("d",
                                    JIngredient.ingredient()
                                            .item(Items.DIRT)
                            ),
                    JResult.itemStack(get("glowcelium_lawn").asItem(), 8)
            ));

        }
        {
            SimpleRegistry.registerRecipe(new Identifier(mod_id, "glowcelium_shaped_1"), JRecipe.shaped(
                    JPattern.pattern(
                            " d ",
                            "dgd",
                            " d "
                    ),
                    JKeys.keys()
                            .key("g",
                                    JIngredient.ingredient()
                                            .item("byg:purple_glowcane_block")
                                            .item("byg:blue_glowcane_block")
                                            .item("byg:red_glowcane_block")
                                            .item("byg:pink_glowcane_block")
                            )
                            .key("d",
                                    JIngredient.ingredient()
                                            .item(Items.DIRT)
                            ),
                    JResult.itemStack(get("glowcelium_lawn").asItem(), 8)
            ));

        }
        {
            SimpleRegistry.registerRecipe(new Identifier(mod_id, "glowcelium_shapeless_0"), JRecipe.shapeless
                            (JIngredients.ingredients()
                                    .add(
                                            JIngredient.ingredient()
                                            .item("byg:glowcelium_block")

                                    ),
                            JResult.item(get("glowcelium_lawn").asItem())
            ));
        }
        {
            SimpleRegistry.registerRecipe(new Identifier(mod_id, "glowcelium_shapeless_1"), JRecipe.shapeless(
                    JIngredients.ingredients()
                            .add(
                                    JIngredient.ingredient()
                                            .item(Items.DIRT)
                            )
                            .add(
                                    JIngredient.ingredient()
                                            .item("byg:purple_glowcane")
                                            .item("byg:blue_glowcane")
                                            .item("byg:red_glowcane")
                                            .item("byg:pink_glowcane")
                                            .item("byg:purple_glowcane_dust")
                                            .item("byg:blue_glowcane_dust")
                                            .item("byg:red_glowcane_dust")
                                            .item("byg:pink_glowcane_dust")
                                            .item("byg:blue_glowshroom")
                                            .item("byg:purple_glowshroom")
                            ),
                    JResult.item(get("glowcelium_lawn").asItem())));
        }

        //



        LOGGER.log(Level.INFO,"LAWNAGE: successfully loaded recipes for cinderscapes addon!");
    }

}
