package net.redd.lawnage.register;

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
    public int toolLevel;
    public boolean requiresTool;

    public LawnVariantSettings(Material mat, MaterialColor color, float strength, BlockSoundGroup sound, Tag<Item> tool, int toolLevel,boolean requiresTool){
        this.mat = mat;
        this.color = color;
        this.strength = strength;
        this.sound = sound;
        this.tool = tool;
        this.toolLevel = toolLevel;
        this.requiresTool = requiresTool;
    }

}
