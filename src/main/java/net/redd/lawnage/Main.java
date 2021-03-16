package net.redd.lawnage;

import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.redd.lawnage.modHandlers.registar.BEModRegistrar;
import net.redd.lawnage.modHandlers.recipes.CinderscapesRecipes;
import net.redd.lawnage.modHandlers.registar.BYGModRegistrar;
import net.redd.lawnage.modHandlers.registar.CSModRegistrar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.redd.lawnage.SimpleRegistry.*;

public class Main implements ModInitializer {

	public static Logger LOGGER = LogManager.getLogger();

	public static Identifier IDENTIFIER = new Identifier("lawnage", "lawnage");

	public static final ItemGroup LAWNAGE = FabricItemGroupBuilder.build(IDENTIFIER,
			() -> new ItemStack(get("grass_lawn")));

	public static final RuntimeResourcePack LAWNAGE_PACK = RuntimeResourcePack.create("lawnage:main");

	@Override
	public void onInitialize() {
		/*
		 * Lawnage Lawn type registration
		*/
		registerBlockWithItem("grass_lawn", Material.SOIL, 0.6f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 1, MaterialColor.GRASS,false);
		registerBlockWithItem("biome_grass_lawn", Material.SOIL, 0.6f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 1, MaterialColor.GRASS,false);
		registerBlockWithItem("mushroom_lawn", Material.SOIL, 0.6f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, 1, MaterialColor.BROWN,false);
		registerBlockWithItem("warped_nylium_lawn", Material.STONE, 0.4f, BlockSoundGroup.GRASS, FabricToolTags.PICKAXES, 1, MaterialColor.field_25705,true);
		registerBlockWithItem("crimson_nylium_lawn", Material.STONE, 0.4f, BlockSoundGroup.GRASS, FabricToolTags.PICKAXES, 1, MaterialColor.field_25702,true);

		ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view,pos), registeredBlocks.get("biome_grass_lawn"));
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> MaterialColor.GRASS.color, registeredBlocks.get("biome_grass_lawn"));

		/*
		 * Lawnage Recipe Registration
		*/
		//BaseRecipes.INSTANCE.registerRecipes();

		/*
		 * Mod support Lawn type registration
		*/

//		BYGModRegistrar.INSTANCE.registerVariants();
		CSModRegistrar.INSTANCE.registerVariants();
//		BEModRegistrar.INSTANCE.registerVariants();

		/*
		 * Mod support Recipe registration
		*/
		CinderscapesRecipes.INSTANCE.registerRecipes();



		RRPCallback.EVENT.register(a -> a.add(LAWNAGE_PACK));
	}



}
