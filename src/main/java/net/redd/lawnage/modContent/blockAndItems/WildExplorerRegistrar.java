package net.redd.lawnage.modContent.blockAndItems;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.redd.lawnage.core.systems.SimpleRegistry;
import net.redd.lawnage.core.systems.LawnVariantSettings;
import net.redd.lawnage.core.systems.ModRegistrar;
import org.apache.logging.log4j.Level;

import java.util.HashMap;

import static net.redd.lawnage.Main.LOGGER;

public class WildExplorerRegistrar extends ModRegistrar {
    static { mod_id = "wild_explorer"; }

    public static WildExplorerRegistrar INSTANCE = new WildExplorerRegistrar();

    public static HashMap<String, LawnVariantSettings> variants = new HashMap<>();

    private WildExplorerRegistrar(){}

    static  {
        variants.put("black_dylium_lawn",new LawnVariantSettings(Material.STONE, Material.SOLID_ORGANIC.getColor(), 0.4f, BlockSoundGroup.NYLIUM, FabricToolTags.PICKAXES, 1,true));
    }

    @Override
    public void registerVariants() {
        if(!FabricLoader.getInstance().isModLoaded(mod_id)) {
            LOGGER.log(Level.INFO, "You don't seem to be a Wild Explorer. ;-;");
            return;
        }
        LOGGER.log(Level.INFO, "¡A WILD EXPLORER HAS BEEN DETECTED!");
        LOGGER.log(Level.INFO, "¡EXECUTING DYLIUMIFICATION!");
        for(String variant : variants.keySet()){
//            LOGGER.log(Level.INFO, "Registering variant wild explorer:" + variant);
            LawnVariantSettings lvs = variants.get(variant);
            SimpleRegistry.registerBlockWithItem(variant, lvs.mat, lvs.strength, lvs.sound, lvs.tool, lvs.toolLevel, lvs.color, lvs.requiresTool);
            SimpleRegistry.registerLootTable(variant, "lawnage:"+ variant, "minecraft:item");
        }
    }
}
