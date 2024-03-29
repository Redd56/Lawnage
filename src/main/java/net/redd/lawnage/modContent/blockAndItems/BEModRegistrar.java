package net.redd.lawnage.modContent.blockAndItems;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.redd.lawnage.core.systems.SimpleRegistry;
import net.redd.lawnage.core.systems.LawnVariantSettings;
import net.redd.lawnage.core.systems.ModRegistrar;
import net.redd.lawnage.modContent.BlockSoundGroups.BEBlockSoundGroup;
import org.apache.logging.log4j.Level;

import java.util.HashMap;

import static net.redd.lawnage.Main.LOGGER;

public class BEModRegistrar extends ModRegistrar {
    static { mod_id = "betterend"; }

    public static BEModRegistrar INSTANCE = new BEModRegistrar();

    private BEModRegistrar(){}

    public static HashMap<String, LawnVariantSettings> variants = new HashMap<>();

    static {
//        variants.put("sangnum_lawn", new LawnVariantSettings(Material.STONE, MapColor.RED, 0.4f, BEBlockSoundGroup.BE_TERRAIN, FabricToolTags.PICKAXES, 1,true));
//        variants.put("end_mycelium", new LawnVariantSettings(Material.STONE, MapColor.LIGHT_BLUE, 0.4f, BEBlockSoundGroup.BE_TERRAIN, FabricToolTags.PICKAXES, 1,true));
//        variants.put("end_moss", new LawnVariantSettings(Material.STONE, MapColor.CYAN, 0.4f, BEBlockSoundGroup.BE_TERRAIN, FabricToolTags.PICKAXES, 1,true));
//        variants.put("chorus_nylium", new LawnVariantSettings(Material.STONE, MapColor.MAGENTA, 0.4f, BEBlockSoundGroup.BE_TERRAIN, FabricToolTags.PICKAXES, 1,true));
//        variants.put("cave_moss", new LawnVariantSettings(Material.STONE, MapColor.PURPLE, 0.4f, BEBlockSoundGroup.BE_TERRAIN, FabricToolTags.PICKAXES, 1,true));
//        variants.put("crystal_moss", new LawnVariantSettings(Material.STONE, MapColor.PINK, 0.4f, BEBlockSoundGroup.BE_TERRAIN, FabricToolTags.PICKAXES, 1,true));
//        variants.put("shadow_grass", new LawnVariantSettings(Material.STONE, MapColor.BLACK, 0.4f, BEBlockSoundGroup.BE_TERRAIN, FabricToolTags.PICKAXES, 1,true));
//        variants.put("pink_moss", new LawnVariantSettings(Material.STONE, MapColor.PINK, 0.4f, BEBlockSoundGroup.BE_TERRAIN, FabricToolTags.PICKAXES, 1,true));
//        variants.put("amber_moss", new LawnVariantSettings(Material.STONE, MapColor.ORANGE, 0.4f, BEBlockSoundGroup.BE_TERRAIN, FabricToolTags.PICKAXES, 1,true));
//        variants.put("jungle_moss", new LawnVariantSettings(Material.STONE, MapColor.GREEN, 0.4f, BEBlockSoundGroup.BE_TERRAIN, FabricToolTags.PICKAXES, 1,true));
//        variants.put("rutiscis", new LawnVariantSettings(Material.STONE, MapColor.ORANGE, 3.0F, BEBlockSoundGroup.BE_TERRAIN, FabricToolTags.PICKAXES, 1,true));
    }

    @Override
    public void registerVariants() {
        if(!FabricLoader.getInstance().isModLoaded(mod_id)) {
            LOGGER.log(Level.INFO, "LAWNAGE: Mod better end not pressent, skipping registering of the varients");
            return;
        }
        LOGGER.log(Level.INFO, "LAWNAGE: Registering variants from mod better end");
        for(String variant : variants.keySet()){
//            LOGGER.log(Level.INFO, "LAWNAGE: Registering variant better end:" + variant);
            LawnVariantSettings lvs = variants.get(variant);
            SimpleRegistry.registerBlockWithItem(variant, lvs.mat, lvs.strength, lvs.sound, lvs.color, lvs.requiresTool);
            if(lvs.hasCustomDrop()){
                SimpleRegistry.registerLootTable(variant, lvs.lootIdentifier, lvs.lootType);
            } else {
                SimpleRegistry.registerLootTable(variant,"lawnage:"+ variant, "minecraft:item");
            }
        }
    }


}
