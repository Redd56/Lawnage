package net.redd.lawnage;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.MinecraftDedicatedServer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.Biome;

public class Main implements ModInitializer {
	public static final Block BiomeGrassLawn = new Block(FabricBlockSettings.of(Material.SOIL)
			.strength(0.6f)
			.sounds(BlockSoundGroup.GRASS)
			.breakByTool(FabricToolTags.SHOVELS));
	public static final Block GrassLawn = new Block(FabricBlockSettings.of(Material.SOIL)
			.strength(0.6f)
			.sounds(BlockSoundGroup.GRASS)
			.breakByTool(FabricToolTags.SHOVELS));
	public static final Block MushroomLawn = new Block(FabricBlockSettings.of(Material.SOIL)
			.strength(0.6f)
			.sounds(BlockSoundGroup.GRASS)
			.breakByTool(FabricToolTags.SHOVELS));
	public static final Block WarpedNyliumLawn = new NyliumLawn(AbstractBlock.Settings.of(Material.STONE, MaterialColor.field_25705).requiresTool().strength(0.4F).sounds(BlockSoundGroup.NYLIUM).ticksRandomly());
	public static final Block CrimsonNyliumLawn = new NyliumLawn(AbstractBlock.Settings.of(Material.STONE, MaterialColor.field_25702).requiresTool().strength(0.4F).sounds(BlockSoundGroup.NYLIUM).ticksRandomly());

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("lawnage", "grasslawn"), GrassLawn);
		Registry.register(Registry.ITEM, new Identifier("lawnage", "grasslawn"), new BlockItem(GrassLawn, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("lawnage", "biomegrasslawn"), BiomeGrassLawn);
		Registry.register(Registry.ITEM, new Identifier("lawnage", "biomegrasslawn"), new BlockItem(BiomeGrassLawn, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("lawnage", "mushroomlawn"), MushroomLawn);
		Registry.register(Registry.ITEM, new Identifier("lawnage", "mushroomlawn"), new BlockItem(MushroomLawn, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("lawnage", "warpednyliumlawn"), WarpedNyliumLawn);
		Registry.register(Registry.ITEM, new Identifier("lawnage", "warpednyliumlawn"), new BlockItem(WarpedNyliumLawn, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("lawnage", "crimsonnyliumlawn"), CrimsonNyliumLawn);
		Registry.register(Registry.ITEM, new Identifier("lawnage", "crimsonnyliumlawn"), new BlockItem(CrimsonNyliumLawn, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view,pos), BiomeGrassLawn);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> MaterialColor.GRASS.color, BiomeGrassLawn);
	}



}
