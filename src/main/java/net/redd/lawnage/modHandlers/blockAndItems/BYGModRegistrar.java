package net.redd.lawnage.modHandlers.blockAndItems;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.redd.lawnage.SimpleRegistry;
import net.redd.lawnage.register.LawnVariantSettings;
import net.redd.lawnage.modHandlers.ModRegistrar;
import org.apache.logging.log4j.Level;

import static net.redd.lawnage.Main.LOGGER;

import java.util.HashMap;

public class BYGModRegistrar extends ModRegistrar {

    static { mod_id = "byg"; }

    public static BYGModRegistrar INSTANCE = new BYGModRegistrar();

    private BYGModRegistrar(){}

    public static HashMap<String, LawnVariantSettings> variants = new HashMap<>();

    static {
        variants.put("glowcelium_lawn", new LawnVariantSettings(Material.SOIL, MaterialColor.GRASS, 0.4f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 1,false));
        variants.put("sythian_nylium_lawn", new LawnVariantSettings(Material.SOIL, MaterialColor.GOLD, 0.4f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 1,true));
        variants.put("embur_nylium_lawn", new LawnVariantSettings(Material.SOIL, MaterialColor.ORANGE_TERRACOTTA, 0.4f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 0,true));
        variants.put("ether_phylium_lawn", new LawnVariantSettings(Material.SOIL, MaterialColor.GRASS, 0.4f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 0,true));
        variants.put("shulkren_phylium_lawn", new LawnVariantSettings(Material.SOIL, MaterialColor.GRASS, 0.4f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 0,true));
        variants.put("ivis_phylium_lawn", new LawnVariantSettings(Material.SOIL, MaterialColor.GRASS, 0.4f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 0,true));
        variants.put("nightshade_phylium_lawn", new LawnVariantSettings(Material.SOIL, MaterialColor.GRASS, 0.4f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 0,true));
        variants.put("bulbis_phylium_lawn", new LawnVariantSettings(Material.SOIL, MaterialColor.GRASS, 0.4f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 0,true));
    }

    @Override
    public void registerVariants() {
        if(!FabricLoader.getInstance().isModLoaded(mod_id)) {
            LOGGER.log(Level.INFO, "Mod byg is not present, CORGI is sad and we are skipping variants for that mod");
            return;
        }
        LOGGER.log(Level.INFO, "Registering variants from mod byg");
        for(String variant : variants.keySet()){
            LOGGER.log(Level.INFO, "Registering variant byg:" + variant);
            LawnVariantSettings lvs = variants.get(variant);
            SimpleRegistry.registerBlockWithItem(variant, lvs.mat, lvs.strength, lvs.sound, lvs.tool, lvs.toolLevel, lvs.color,lvs.requiresTool);
        }
    }


}
