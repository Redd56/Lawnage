package net.redd.lawnage;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {

	public static final ItemGroup PRIMARY = FabricItemGroupBuilder.create(
			new Identifier("lawnage", "standard"))
			.icon(() -> new ItemStack(GrassLawn))
			.build();


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
	public static final Block WarpedNyliumLawn = new NyliumLawn(AbstractBlock.Settings.of(Material.STONE, MaterialColor.field_25705).requiresTool().strength(0.4F).sounds(BlockSoundGroup.NYLIUM));
	public static final Block CrimsonNyliumLawn = new NyliumLawn(AbstractBlock.Settings.of(Material.STONE, MaterialColor.field_25702).requiresTool().strength(0.4F).sounds(BlockSoundGroup.NYLIUM));

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("lawnage", "grass_lawn"), GrassLawn);
		Registry.register(Registry.ITEM, new Identifier("lawnage", "grass_lawn"), new BlockItem(GrassLawn, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("lawnage", "biome_grass_lawn"), BiomeGrassLawn);
		Registry.register(Registry.ITEM, new Identifier("lawnage", "biome_grass_lawn"), new BlockItem(BiomeGrassLawn, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view,pos), BiomeGrassLawn);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> MaterialColor.GRASS.color, BiomeGrassLawn);

		Registry.register(Registry.BLOCK, new Identifier("lawnage", "mushroom_lawn"), MushroomLawn);
		Registry.register(Registry.ITEM, new Identifier("lawnage", "mushroom_lawn"), new BlockItem(MushroomLawn, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("lawnage", "warped_nylium_lawn"), WarpedNyliumLawn);
		Registry.register(Registry.ITEM, new Identifier("lawnage", "warped_nylium_lawn"), new BlockItem(WarpedNyliumLawn, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("lawnage", "crimson_nylium_lawn"), CrimsonNyliumLawn);
		Registry.register(Registry.ITEM, new Identifier("lawnage", "crimson_nylium_lawn"), new BlockItem(CrimsonNyliumLawn, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

	}



}
