package net.redd.lawnage.core.systems;

import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.JRecipe;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.redd.lawnage.Main;

import java.util.HashMap;


import static net.devtech.arrp.api.RuntimeResourcePack.id;
import static net.devtech.arrp.json.loot.JLootTable.*;
import static net.devtech.arrp.json.blockstate.JState.*;
import static net.devtech.arrp.json.models.JModel.*;

public class SimpleRegistry {

    public static HashMap<String, Block> registeredBlocks = new HashMap<>();
    public static HashMap<String, BlockItem> registeredItems = new HashMap<>();

    public static void registerBlockWithItem(String path, Material mat, float strength, BlockSoundGroup sounds, Tag<Item> toolTags, int toolLevel, MaterialColor color, boolean requiresTool){
        registerBlockWithItem(path, mat,  strength, sounds,toolTags, toolLevel, color, requiresTool,null);
    }
    public static void registerBlockWithItem(String path, Material mat, float strength, BlockSoundGroup sounds, Tag<Item> toolTags, int toolLevel, MaterialColor color, boolean requiresTool, JModel customModel){
        Block block = (requiresTool)
                ? new LawnBlock(FabricBlockSettings.of(mat, color).strength(strength).sounds(sounds).breakByTool(toolTags, toolLevel).requiresTool())
                : new LawnBlock(FabricBlockSettings.of(mat, color).strength(strength).sounds(sounds).breakByTool(toolTags, toolLevel));
        Identifier id = new Identifier("lawnage", path);
        BlockItem bi = new BlockItem(block, new FabricItemSettings().group(Main.LAWNAGE));
        Registry.register(Registry.BLOCK, id, block);
        Registry.register(Registry.ITEM, id, bi);
        registeredBlocks.put(id.getPath(), block);
        registeredItems.put(id.getPath(), bi);

        if(customModel != null){
            Main.LAWNAGE_PACK.addModel(customModel,id);
        }
        else {
            JModel model = model().textures(textures().var("all", "block/" + id.getPath()).particle(id.getNamespace() +":block/" + id.getPath())).parent("block/cube_all");
            System.out.println("Adding model: " + id);
//                    .element(element().from(0, 0, 0).to(16, 16, 16)
//                            .faces(faces()
//                                    .down(face("all").cullface(Direction.DOWN).uv(0,0,16,16))
//                                    .up(face("all").cullface(Direction.UP).uv(0,0,16,16))
//                                    .north(face("all").cullface(Direction.NORTH).uv(0,0,16,16))
//                                    .south(face("all").cullface(Direction.SOUTH).uv(0,0,16,16))
//                                    .west(face("all").cullface(Direction.WEST).uv(0,0,16,16))
//                                    .east(face("all").cullface(Direction.EAST).uv(0,0,16,16))
//                            )
//                    );
            Main.LAWNAGE_PACK.addModel(model ,id);

        }

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
