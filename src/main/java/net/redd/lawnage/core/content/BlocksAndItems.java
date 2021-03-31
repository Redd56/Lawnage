package net.redd.lawnage.core.content;


import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.redd.lawnage.core.systems.ModRegistrar;
import net.redd.lawnage.core.systems.SimpleRegistry;
import net.redd.lawnage.core.systems.LawnVariantSettings;
import org.apache.logging.log4j.Level;

import java.util.HashMap;

import static net.redd.lawnage.Main.LOGGER;

public class BlocksAndItems extends ModRegistrar {

    public static BlocksAndItems INSTANCE = new BlocksAndItems();
    private Extras extras = new Extras();

    private BlocksAndItems(){}

    public static HashMap<String, LawnVariantSettings> variants = new HashMap<>();

    static {
        variants.put("grass_lawn",new LawnVariantSettings( Material.SOIL, Material.SOLID_ORGANIC.getColor() ,0.6f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 1, false));
        variants.put("biome_grass_lawn",new LawnVariantSettings( Material.SOIL, Material.SOLID_ORGANIC.getColor(), 0.6f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 1,false));
        variants.put("mushroom_lawn",new LawnVariantSettings( Material.SOIL, MapColor.PURPLE,0.6f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 1, false));
        variants.put("warped_nylium_lawn", new LawnVariantSettings( Material.STONE, MapColor.TEAL,0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 1, true));
        variants.put("crimson_nylium_lawn",new LawnVariantSettings( Material.STONE, MapColor.DULL_RED,  0.4f,  BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 1,true));
    }

    @Override
    public void registerVariants() {
        LOGGER.log(Level.INFO, "LAWNAGE: Registering base blocks and items");
        for(String variant : variants.keySet()){
//            LOGGER.log(Level.INFO, "Registering block lawnage:" + variant);
            LawnVariantSettings lvs = variants.get(variant);
            SimpleRegistry.registerBlockWithItem(variant, lvs.mat, lvs.strength, lvs.sound, lvs.tool, lvs.toolLevel, lvs.color, lvs.requiresTool);
            if(lvs.hasCustomDrop()){
                SimpleRegistry.registerLootTable(variant, lvs.lootIdentifier, lvs.lootType);
            } else {
                SimpleRegistry.registerLootTable(variant, "lawnage:"+ variant, "minecraft:item");
            }
        }
        Recipes.INSTANCE.registerRecipes();
        Extras.INSTANCE.initBiomeColors();


    }


}
