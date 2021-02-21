package net.redd.lawnage;

import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.recipe.JIngredient;
import net.devtech.arrp.json.recipe.JIngredients;
import net.devtech.arrp.json.recipe.JRecipe;
import net.devtech.arrp.json.recipe.JResult;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.redd.lawnage.modHandlers.BYGModRegistrar;
import net.redd.lawnage.modHandlers.CSModRegistrar;
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
		registerBlockWithItem("grass_lawn", Material.SOIL, 0.6f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, MaterialColor.GRASS);
			registerRecipe(new Identifier("lawnage","grass_lawn"), JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item(Items.GRASS_BLOCK)), JResult.item(get("grass_lawn").asItem())));
		registerBlockWithItem("biome_grass_lawn", Material.SOIL, 0.6f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, MaterialColor.GRASS);
			registerRecipe(new Identifier("lawnage","biome_grass_lawn"), JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item(get("grass_lawn").asItem())), JResult.item(get("biome_grass_lawn").asItem())));
		registerBlockWithItem("mushroom_lawn", Material.SOIL, 0.6f, BlockSoundGroup.GRASS, FabricToolTags.SHOVELS, MaterialColor.BROWN);
			registerRecipe(new Identifier("lawnage","mushroom_lawn"), JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item(Items.MYCELIUM)), JResult.item(get("mushroom_lawn").asItem())));
		registerBlockWithItem("warped_nylium_lawn", Material.STONE, 0.4f, BlockSoundGroup.GRASS, FabricToolTags.PICKAXES, MaterialColor.field_25705);
				registerRecipe(new Identifier("lawnage","warped_nylium_lawn"), JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item(Items.WARPED_NYLIUM)), JResult.item(get("warped_nylium_lawn").asItem())));
		registerBlockWithItem("crimson_nylium", Material.STONE, 0.4f, BlockSoundGroup.GRASS, FabricToolTags.PICKAXES, MaterialColor.field_25702);
				JRecipe.shapeless(JIngredients.ingredients().add(JIngredient.ingredient().item(Items.CRIMSON_NYLIUM)), JResult.item(get("crimson_nylium_lawn").asItem()));

		ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view,pos), registeredBlocks.get("biome_grass_lawn"));
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> MaterialColor.GRASS.color, registeredBlocks.get("biome_grass_lawn"));

		//BYGModRegistrar.INSTANCE.registerVariants();
		CSModRegistrar.INSTANCE.registerVariants();


//		LAWNAGE_PACK.addRecipe(new Identifier("cns", "grass_lawn"),
//				JRecipe.shapeless(JIngredients.ingredients()
//					.add(JIngredient.ingredient().item(Items.GRASS_BLOCK)),
//					JResult.item(get("grass_lawn").asItem())));

		RRPCallback.EVENT.register(a -> a.add(LAWNAGE_PACK));
	}



}
