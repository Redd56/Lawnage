package net.redd.lawnage.modContent.blockAndItems;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.redd.lawnage.core.systems.SimpleRegistry;
import net.redd.lawnage.modContent.recipes.CinderscapesRecipes;
import net.redd.lawnage.core.systems.LawnVariantSettings;
import net.redd.lawnage.core.systems.ModRegistrar;
import org.apache.logging.log4j.Level;

import java.util.HashMap;

import static net.redd.lawnage.Main.LOGGER;

public class CSModRegistrar extends ModRegistrar {

    static { mod_id="cinderscapes"; }

    public static CSModRegistrar INSTANCE = new CSModRegistrar();

    private CSModRegistrar(){}

    public static HashMap<String, LawnVariantSettings> variants = new HashMap<>();

    static {
        variants.put("umbral_nylium_lawn", new LawnVariantSettings(Material.STONE, MapColor.BLUE, 0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 0,true));

    }

    @Override
    public void registerVariants() {
        if(!FabricLoader.getInstance().isModLoaded(mod_id)) {
            LOGGER.log(Level.INFO, "LAWNAGE: Mod cinderscapes is not present, skipping addon for that mod");
            return;
        }
        LOGGER.log(Level.INFO, "LAWNAGE: Registering variants from mod cinderscapes addon");
        for(String variant : variants.keySet()){
//            LOGGER.log(Level.INFO, "LAWNAGE: Registering variant cinderscapes:" + variant);
            LawnVariantSettings lvs = variants.get(variant);
            SimpleRegistry.registerBlockWithItem(variant, lvs.mat, lvs.strength, lvs.sound, lvs.tool, lvs.toolLevel, lvs.color, lvs.requiresTool);
            SimpleRegistry.registerLootTable(variant, "lawnage:"+ variant, "minecraft:item");
        }
        CinderscapesRecipes.INSTANCE.registerRecipes();
    }



}
