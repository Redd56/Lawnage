package net.redd.lawnage.core.content;

import net.devtech.arrp.json.recipe.*;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.redd.lawnage.core.systems.RecipeLoader;
import net.redd.lawnage.core.systems.SimpleRegistry;
import org.apache.logging.log4j.Level;

import static net.redd.lawnage.Main.LOGGER;
import static net.redd.lawnage.core.systems.SimpleRegistry.get;


public class Recipes extends RecipeLoader {

    public static Recipes INSTANCE = new Recipes();
    private Recipes(){}
    static {mod_id="lawnage";}

    @Override
    public void registerRecipes() {
        LOGGER.log(Level.INFO,"LAWNAGE: loading base recipes!");

        //biome lawn
        {
            SimpleRegistry.registerRecipe(new Identifier(mod_id, "biome_shapeless_0"), JRecipe.shapeless
                    (JIngredients.ingredients()
                                    .add(
                                            JIngredient.ingredient()
                                                    .item("grass_lawn")
                                    ),
                            JResult.item(get("biome_grass_lawn").asItem())
                    ));
        }
        //grass lawn
        {
            SimpleRegistry.registerRecipe(new Identifier(mod_id, "grass_shapeless_0"), JRecipe.shapeless
                    (JIngredients.ingredients()
                                    .add(
                                            JIngredient.ingredient()
                                                    .tag("c:foliage")
                                    )
                                    .add(
                                            JIngredient.ingredient()
                                                    .tag("c:dirt")
                                    ),

                            JResult.item(get("grass_lawn").asItem())
                    ));
        }
        {
            SimpleRegistry.registerRecipe(new Identifier(mod_id, "grass_shapeless_1"), JRecipe.shapeless
                    (JIngredients.ingredients()
                                    .add(
                                            JIngredient.ingredient()
                                                    .item("biome_grass_lawn")
                                    ),
                            JResult.item(get("grass_lawn").asItem())
                    ));
        }
        {
            SimpleRegistry.registerRecipe(new Identifier(mod_id, "grass_shapeless_2"), JRecipe.shapeless
                    (JIngredients.ingredients()
                                    .add(
                                            JIngredient.ingredient()
                                                    .item(Items.GRASS_BLOCK)
                                                    .item("byg:meadow_grass_block")
                                    ),
                            JResult.item(get("grass_lawn").asItem())
                    ));
        }
        //Mushroom lawn
        {
            SimpleRegistry.registerRecipe(new Identifier(mod_id, "mushroom_shapeless_0"), JRecipe.shapeless
                    (JIngredients.ingredients()
                                    .add(
                                            JIngredient.ingredient()
                                                    .tag("c:mushrooms")
                                    )
                                    .add(
                                            JIngredient.ingredient()
                                            .tag("c:dirt")
                                    ),
                            JResult.item(get("mushroom_lawn").asItem())
                    ));
        }
        {
            SimpleRegistry.registerRecipe(new Identifier(mod_id, "mushroom_shapeless_1"), JRecipe.shapeless
                    (JIngredients.ingredients()
                                    .add(
                                            JIngredient.ingredient()
                                                    .tag("c:mycelium")
                                    ),
                            JResult.item(get("grass_lawn").asItem())
                    ));
        }
        {
            SimpleRegistry.registerRecipe(new Identifier(mod_id, "mushroom_shaped_0"), JRecipe.shaped(
                    JPattern.pattern(
                            "ddd",
                            "dmd",
                            "ddd"
                    ),
                    JKeys.keys()
                            .key("d",
                                    JIngredient.ingredient()
                                            .tag("c:dirt")
                            )
                            .key("m",
                                    JIngredient.ingredient()
                                            .tag("c:mushroom_blocks")
                            ),
                    JResult.itemStack(get("mushroom_lawn").asItem(), 8)
            ));

        }
        //temp
//        {
//            SimpleRegistry.registerRecipe(new Identifier(mod_id, ""), JRecipe.shaped(
//                    JPattern.pattern(
//                            "nnn",
//                            "nun",
//                            "nnn"
//                    ),
//                    JKeys.keys()
//                            .key("u",
//                                    JIngredient.ingredient()
//                                            .tag("")
//                            )
//                            .key("n",
//                                    JIngredient.ingredient()
//                                            .item(Items.NETHERRACK)
//                            ),
//                    JResult.itemStack(get("").asItem(), 8)
//            ));
//
//        }
//        {
//            SimpleRegistry.registerRecipe(new Identifier(mod_id, "umbral_shapeless_0"), JRecipe.shapeless
//                    (JIngredients.ingredients()
//                                    .add(
//                                            JIngredient.ingredient()
//                                                    .item("cinderscapes:umbral_nylium")
//                                    ),
//                            JResult.item(get("umbral_nylium_lawn").asItem())
//                    ));
//        }
    }

}
