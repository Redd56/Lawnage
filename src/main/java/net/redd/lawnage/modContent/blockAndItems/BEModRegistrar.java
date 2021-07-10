package net.redd.lawnage.modContent.blockAndItems;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.redd.lawnage.core.systems.SimpleRegistry;
import net.redd.lawnage.core.systems.LawnVariantSettings;
import net.redd.lawnage.core.systems.ModRegistrar;
import org.apache.logging.log4j.Level;

import java.util.HashMap;

import static net.redd.lawnage.Main.LOGGER;

public class BEModRegistrar extends ModRegistrar {
    static { mod_id = "betterend"; }

    public static BEModRegistrar INSTANCE = new BEModRegistrar();

    private BEModRegistrar(){}

    public static HashMap<String, LawnVariantSettings> variants = new HashMap<>();

    static {
        variants.put("sangnum_lawn", new LawnVariantSettings(Material.STONE, Material.SOLID_ORGANIC.getColor(), 0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 1,true));
        variants.put("end_mycelium_lawn", new LawnVariantSettings(Material.STONE, MaterialColor.GRASS, 0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 1,true));
        variants.put("end_moss_lawn", new LawnVariantSettings(Material.STONE, MaterialColor.GRASS, 0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 1,true));
        variants.put("chorus_nylium_lawn", new LawnVariantSettings(Material.STONE, MaterialColor.GRASS, 0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 1,true));
        variants.put("cave_moss_lawn", new LawnVariantSettings(Material.STONE, MaterialColor.GRASS, 0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 1,true));
        variants.put("crystal_moss_lawn", new LawnVariantSettings(Material.STONE, MaterialColor.GRASS, 0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 1,true));
        variants.put("shadow_grass_lawn", new LawnVariantSettings(Material.STONE, MaterialColor.GRASS, 0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 1,true));
        variants.put("pink_moss_lawn", new LawnVariantSettings(Material.STONE, MaterialColor.GRASS, 0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 1,true));
        variants.put("amber_moss_lawn", new LawnVariantSettings(Material.STONE, MaterialColor.GRASS, 0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 1,true));
        variants.put("jungle_moss_lawn", new LawnVariantSettings(Material.STONE, MaterialColor.GRASS, 0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 1,true));
        variants.put("rutiscis_lawn", new LawnVariantSettings(Material.STONE, MaterialColor.SAND, 3.0F, BlockSoundGroup.STONE, FabricToolTags.PICKAXES, 1,true));
    }

    @Override
    public void registerVariants() {
        if(!FabricLoader.getInstance().isModLoaded(mod_id)) {
            LOGGER.log(Level.INFO, "Mod better end not pressent, skipping registering of the varients");
            return;
        }
        LOGGER.log(Level.INFO, "Registering variants from mod better end");
        for(String variant : variants.keySet()){
//            LOGGER.log(Level.INFO, "Registering variant better end:" + variant);
            LawnVariantSettings lvs = variants.get(variant);
            if(lvs.hasCustomModel){
                SimpleRegistry.registerBlockWithItem(variant, lvs.mat, lvs.strength, lvs.sound, lvs.tool, lvs.toolLevel, lvs.color, lvs.requiresTool, lvs.customModel);
            } else {
                SimpleRegistry.registerBlockWithItem(variant, lvs.mat, lvs.strength, lvs.sound, lvs.tool, lvs.toolLevel, lvs.color, lvs.requiresTool);
            }
            if(lvs.hasCustomDrop()){
                SimpleRegistry.registerLootTable(variant, lvs.lootIdentifier, lvs.lootType);
            } else {
                SimpleRegistry.registerLootTable(variant,"lawnage:"+ variant, "minecraft:item");
            }
        }
    }


}
