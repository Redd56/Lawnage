package net.redd.lawnage.modContent.extras;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.MapColor;
import net.minecraft.client.color.world.BiomeColors;
import net.redd.lawnage.core.systems.SimpleRegistry;
import org.apache.logging.log4j.Level;

import static net.redd.lawnage.Main.LOGGER;

public class BYGExtras {
    public static BYGExtras INSTANCE = new BYGExtras();

    public void initBYGBiomeColors(){
        LOGGER.log(Level.INFO,"LAWNAGE: Registering BYG Extras!");
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view,pos), SimpleRegistry.get("glowcelium_lawn"));
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> MapColor.GRASS.color, SimpleRegistry.get("glowcelium_lawn"));

    }
}
