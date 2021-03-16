package net.redd.lawnage.modContent.extras;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.MaterialColor;
import net.minecraft.client.color.world.BiomeColors;
import net.redd.lawnage.core.systems.SimpleRegistry;

public class BYGExtras {
    public void initBYGBiomeColors(){
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view,pos), SimpleRegistry.get("glowcelium_lawn"));
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> MaterialColor.GRASS.color, SimpleRegistry.get("glowcelium_lawn"));

    }
}
