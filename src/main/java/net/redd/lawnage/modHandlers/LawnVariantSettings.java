package net.redd.lawnage.modHandlers;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;

public class LawnVariantSettings {

    public Material mat;
    public MaterialColor color;
    public float strength;
    public BlockSoundGroup sound;
    public Tag<Item> tool;

    public LawnVariantSettings(Material mat, MaterialColor color, float strength, BlockSoundGroup sound, Tag<Item> tool){
        this.mat = mat;
        this.color = color;
        this.strength = strength;
        this.sound = sound;
        this.tool = tool;
    }

}
