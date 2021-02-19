package net.redd.lawnage;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import org.apache.logging.log4j.Level;

import static net.redd.lawnage.Main.LOGGER;

import java.util.HashMap;

public class BYGModRegistrar extends ModRegistrar {

    static { mod_id = "byg"; }

    public static BYGModRegistrar INSTANCE = new BYGModRegistrar();

    private BYGModRegistrar(){}

    public static HashMap<String, MaterialColor> variants = new HashMap<>();

    public static HashMap<String, Material> materials = new HashMap<>();

    static {
        variants.put("glowcelium_lawn", MaterialColor.GRASS);
        variants.put("sythian_nylium_lawn", Material.SOLID_ORGANIC.getColor());
        variants.put("embur_nylium_lawn", MaterialColor.ORANGE);
        variants.put("ether_phylium_lawn", MaterialColor.PURPLE);
        variants.put("shulkren_phylium_lawn", MaterialColor.GREEN);
        variants.put("ivis_phylium_lawn", MaterialColor.PURPLE);
        variants.put("nightshade_phylium_lawn", MaterialColor.BLUE);
        variants.put("bulbis_phycelium_lawn", MaterialColor.WHITE);

        materials.put("glowcelium_lawn", Material.SOIL);
        materials.put("sythian_nylium_lawn", Material.STONE);
        materials.put("embur_nylium_lawn", Material.STONE);
        materials.put("ether_phylium_lawn", Material.STONE);
        materials.put("shulkren_phylium_lawn", Material.STONE);
        materials.put("ivis_phylium_lawn", Material.STONE);
        materials.put("nightshade_phylium_lawn", Material.STONE);
        materials.put("bulbis_phycelium_lawn", Material.STONE);
    }

    @Override
    public void registerVariants() {
        if(!FabricLoader.getInstance().isModLoaded(mod_id)) {
            LOGGER.log(Level.INFO, "Mod byg is not present, skipping variants for that mod");
            return;
        }
        LOGGER.log(Level.INFO, "Registering variants from mod byg");
        for(String variant : variants.keySet()){
            LOGGER.log(Level.INFO, "Registering variant byg:" + variant);
            SimpleRegistry.registerBlockWithItem(variant, materials.get(variant), 0.4f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, variants.get(variant));
        }
    }


}
