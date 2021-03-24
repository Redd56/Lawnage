package net.redd.lawnage;

import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.redd.lawnage.core.content.BlocksAndItems;
import net.redd.lawnage.modContent.blockAndItems.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.redd.lawnage.core.systems.SimpleRegistry.*;

public class Main implements ModInitializer {

	public static Logger LOGGER = LogManager.getLogger();

	public static Identifier IDENTIFIER = new Identifier("lawnage", "lawnage");

	public static final ItemGroup LAWNAGE = FabricItemGroupBuilder.build(IDENTIFIER,
			() -> new ItemStack(get("grass_lawn")));

	public static final RuntimeResourcePack LAWNAGE_PACK = RuntimeResourcePack.create("lawnage:main");

	@Override
	public void onInitialize() {
		/*
		 * Register blocks
		*/
		BlocksAndItems.INSTANCE.registerVariants();
		BYGModRegistrar.INSTANCE.registerVariants();
		CSModRegistrar.INSTANCE.registerVariants();
		BEModRegistrar.INSTANCE.registerVariants();
//		BnModRegistrar.INSTANCE.registerVariants();
		WildExplorerRegistrar.INSTANCE.registerVariants();

		RRPCallback.EVENT.register(a -> a.add(LAWNAGE_PACK));
	}



}
