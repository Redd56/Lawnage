package net.redd.lawnage.modHandlers;

import net.devtech.arrp.json.recipe.JIngredient;
import net.devtech.arrp.json.recipe.JIngredients;
import net.devtech.arrp.json.recipe.JRecipe;
import net.devtech.arrp.json.recipe.JResult;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.redd.lawnage.SimpleRegistry;
import org.apache.logging.log4j.Level;

import java.util.HashMap;

import static net.redd.lawnage.Main.LOGGER;

public class CSModRegistrar extends ModRegistrar {

    static { mod_id="cinderscapes"; }

    public static CSModRegistrar INSTANCE = new CSModRegistrar();

    private CSModRegistrar(){}

    public static HashMap<String, LawnVariantSettings> variants = new HashMap<>();

    static {
        variants.put("umbral_nylium_lawn", new LawnVariantSettings(Material.STONE, MaterialColor.BLUE, 0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, JRecipe.shapeless(JIngredients.ingredients()
                        .add(JIngredient.ingredient().item(Items.GRASS_BLOCK)),
                JResult.item(SimpleRegistry.get("ubral_nylium_lawn").asItem()))));
    }

    @Override
    public void registerVariants() {
        if(!FabricLoader.getInstance().isModLoaded(mod_id)) {
            LOGGER.log(Level.INFO, "Mod cinderscapes is not present, skipping variants for that mod");
            return;
        }
        LOGGER.log(Level.INFO, "Registering variants from mod cinderscapes");
        for(String variant : variants.keySet()){
            LOGGER.log(Level.INFO, "Registering variant cinderscapes:" + variant);
            LawnVariantSettings lvs = variants.get(variant);
            SimpleRegistry.registerBlockWithItem(variant, lvs.mat, lvs.strength, lvs.sound, lvs.tool, lvs.color);
        }
    }



}
