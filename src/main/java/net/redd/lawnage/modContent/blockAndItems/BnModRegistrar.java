package net.redd.lawnage.modContent.blockAndItems;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.redd.lawnage.core.systems.SimpleRegistry;
import net.redd.lawnage.core.systems.LawnVariantSettings;
import net.redd.lawnage.core.systems.ModRegistrar;
import net.redd.lawnage.modContent.BlockSoundGroups.BNBlockSoundGroup;
import org.apache.logging.log4j.Level;

import java.util.HashMap;

import static net.redd.lawnage.Main.LOGGER;

public class BnModRegistrar extends ModRegistrar {


    static { mod_id = "betternether"; }

    public static BnModRegistrar INSTANCE = new BnModRegistrar();

    private BnModRegistrar(){}

    public static HashMap<String, LawnVariantSettings> variants = new HashMap<>();

    static {
//        variants.put("netherrack_moss_lawn", new LawnVariantSettings(Material.STONE, Material.SOLID_ORGANIC.getColor(), 0.4f, BNBlockSoundGroup.BN_TERRAIN, FabricToolTags.PICKAXES, 1,true));
        }

    @Override
    public void registerVariants() {
        if(!FabricLoader.getInstance().isModLoaded(mod_id)) {
            LOGGER.log(Level.INFO, "LAWANGE: Mod better nether not pressent, skipping registering of the varients");
            return;
        }

        LOGGER.log(Level.INFO, "LAWANGE: Registering variants from mod better nether");
        for(String variant : variants.keySet()){
            LOGGER.log(Level.INFO, "LAWANGE: Registering variant better nether:" + variant);
            LawnVariantSettings lvs = variants.get(variant);
            SimpleRegistry.registerBlockWithItem(variant, lvs.mat, lvs.strength, lvs.sound, lvs.color, lvs.requiresTool);
            if(lvs.hasCustomDrop()){
                SimpleRegistry.registerLootTable(variant, lvs.lootIdentifier, lvs.lootType);
            } else {
                SimpleRegistry.registerLootTable(variant,"lawnage:" + variant, "minecraft:item");
            }
        }
    }
    //test


}
