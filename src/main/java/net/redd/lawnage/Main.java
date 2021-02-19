package net.redd.lawnage;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.*;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {

	public static Logger LOGGER = LogManager.getLogger();

	public static Identifier IDENTIFIER = new Identifier("lawnage", "lawnage");

	public static final ItemGroup LAWNAGE = FabricItemGroupBuilder.build(IDENTIFIER,
			() -> new ItemStack(SimpleRegistry.get("grass_lawn")));


	@Override
	public void onInitialize() {
		SimpleRegistry.registerBlockWithItem("grass_lawn", Material.SOIL, 0.6f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, MaterialColor.GRASS);
		SimpleRegistry.registerBlockWithItem("biome_grass_lawn", Material.SOIL, 0.6f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, MaterialColor.GRASS);
		SimpleRegistry.registerBlockWithItem("mushroom_lawn", Material.SOIL, 0.6f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, MaterialColor.BROWN);
		SimpleRegistry.registerBlockWithItem("warped_nylium_lawn", Material.STONE, 0.4f, BlockSoundGroup.GRASS, FabricToolTags.PICKAXES, MaterialColor.field_25705);
		SimpleRegistry.registerBlockWithItem("crimson_nylium_lawn", Material.STONE, 0.4f, BlockSoundGroup.GRASS, FabricToolTags.PICKAXES, MaterialColor.field_25702);

		ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view,pos), SimpleRegistry.registeredBlocks.get("biome_grass_lawn"));
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> MaterialColor.GRASS.color, SimpleRegistry.registeredBlocks.get("biome_grass_lawn"));

		BYGModRegistrar.INSTANCE.registerVariants();
	}



}
