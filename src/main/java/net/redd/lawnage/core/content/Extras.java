package net.redd.lawnage.core.content;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.MaterialColor;
import net.minecraft.client.color.world.BiomeColors;
import net.redd.lawnage.core.systems.SimpleRegistry;

public class Extras{

public void initBiomeColors(){
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view,pos), SimpleRegistry.get("biome_grass_lawn"));
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> MaterialColor.GRASS.color, SimpleRegistry.get("biome_grass_lawn"));
}
}
