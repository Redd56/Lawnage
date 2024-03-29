package net.redd.lawnage.core.systems;

import net.devtech.arrp.json.recipe.JRecipe;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.redd.lawnage.Main;

import java.util.HashMap;


import static net.devtech.arrp.api.RuntimeResourcePack.id;
import static net.devtech.arrp.json.loot.JLootTable.*;

public class SimpleRegistry {

    public static HashMap<String, Block> registeredBlocks = new HashMap<>();
    public static HashMap<String, BlockItem> registeredItems = new HashMap<>();

    public static void registerBlockWithItem(String path, Material mat, float strength, BlockSoundGroup sounds, MapColor color, boolean requiresTool){
        Block block = (requiresTool)
                ? new LawnBlock(FabricBlockSettings.of(mat, color).strength(strength).sounds(sounds).requiresTool())
                : new LawnBlock(FabricBlockSettings.of(mat, color).strength(strength).sounds(sounds));
        Identifier id = new Identifier("lawnage", path);    
        BlockItem bi = new BlockItem(block, new FabricItemSettings().group(Main.LAWNAGE));
        Registry.register(Registry.BLOCK, id, block);
        Registry.register(Registry.ITEM, id, bi);
        registeredBlocks.put(id.getPath(), block);
        registeredItems.put(id.getPath(), bi);
        path += "_recipe";

    }
    public static void registerRecipe(Identifier id, JRecipe recipe){
        Main.LAWNAGE_PACK.addRecipe(id, recipe);
    }

    public static void registerLootTable(String path, String lootIdentifier, String lootType){
        Main.LAWNAGE_PACK.addLootTable((id("lawnage:blocks/"+path)),
                loot("minecraft:block")
                        .pool(pool()
                                .rolls(1)
                                .entry(entry()
                                        .type(lootType)
                                        .name(lootIdentifier)))
        );
    }

    public static Block get(String path) { return registeredBlocks.get(path); }


}
