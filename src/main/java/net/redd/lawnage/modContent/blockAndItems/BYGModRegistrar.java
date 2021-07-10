package net.redd.lawnage.modContent.blockAndItems;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.redd.lawnage.core.systems.SimpleRegistry;
import net.redd.lawnage.modContent.recipes.BYGRecipes;
import net.redd.lawnage.core.systems.LawnVariantSettings;
import net.redd.lawnage.core.systems.ModRegistrar;
import org.apache.logging.log4j.Level;

import static net.redd.lawnage.Main.LOGGER;

import java.util.HashMap;

public class BYGModRegistrar extends ModRegistrar {

    static { mod_id = "byg"; }

    public static BYGModRegistrar INSTANCE = new BYGModRegistrar();

    private BYGModRegistrar(){}

    public static HashMap<String, LawnVariantSettings> variants = new HashMap<>();

    static {
        variants.put("glowcelium_lawn", new LawnVariantSettings(Material.SOIL, Material.SOLID_ORGANIC.getColor(), 0.4f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 0,false));
        variants.put("sythian_nylium_lawn", new LawnVariantSettings(Material.SOIL, MapColor.GOLD, 0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 1,true));
        variants.put("embur_nylium_lawn", new LawnVariantSettings(Material.SOIL, MapColor.ORANGE, 0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 1,true));
        variants.put("ether_phylium_lawn", new LawnVariantSettings(Material.SOIL, MapColor.field_25703, 0.4f, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 1,true));
        variants.put("shulkren_phylium_lawn", new LawnVariantSettings(Material.SOIL, MapColor.LIME, 0.4f, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 1,true));
        variants.put("ivis_phylium_lawn", new LawnVariantSettings(Material.SOIL, MapColor.PURPLE, 0.4f, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 1,true));
        variants.put("nightshade_phylium_lawn", new LawnVariantSettings(Material.SOIL, MapColor.LAPIS_BLUE, 0.4f, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 1,true));
        variants.put("bulbis_phylium_lawn", new LawnVariantSettings(Material.SOIL, MapColor.WHITE, 0.4f, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 1,true));
    }

    @Override
    public void registerVariants() {
        if(!FabricLoader.getInstance().isModLoaded(mod_id)) {
            LOGGER.log(Level.INFO, "Mod byg is not present, CORGI is sad and we are skipping variants for that mod");
            return;
        }
        LOGGER.log(Level.INFO, "Registering variants from mod byg");
        for(String variant : variants.keySet()){
//            LOGGER.log(Level.INFO, "Registering variant byg:" + variant);
            LawnVariantSettings lvs = variants.get(variant);
            if(lvs.hasCustomModel){
                SimpleRegistry.registerBlockWithItem(variant, lvs.mat, lvs.strength, lvs.sound, lvs.tool, lvs.toolLevel, lvs.color, lvs.requiresTool, lvs.customModel);
            } else {
                SimpleRegistry.registerBlockWithItem(variant, lvs.mat, lvs.strength, lvs.sound, lvs.tool, lvs.toolLevel, lvs.color, lvs.requiresTool);
            }

            if(lvs.hasCustomDrop()){
                SimpleRegistry.registerLootTable(variant, lvs.lootIdentifier, lvs.lootType);
            } else {
                SimpleRegistry.registerLootTable(variant, "lawnage:"+ variant, "minecraft:item");
            }
        }
        BYGRecipes.INSTANCE.registerRecipes();
    }


}
