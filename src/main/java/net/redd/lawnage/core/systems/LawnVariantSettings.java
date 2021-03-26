package net.redd.lawnage.core.systems;

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
    public boolean customModel;
    public String lootIdentifier, lootType;

    public LawnVariantSettings(Material mat, MaterialColor color, float strength, BlockSoundGroup sound, Tag<Item> tool, int toolLevel,boolean requiresTool, boolean customModel){
        this.mat = mat;
        this.color = color;
        this.strength = strength;
        this.sound = sound;
        this.tool = tool;
        this.toolLevel = toolLevel;
        this.requiresTool = requiresTool;
        this.customModel = customModel;
        this.lootIdentifier = "";
        this.lootType = "";
    }

    public boolean hasCustomDrop(){
        return lootIdentifier != "" && lootType != "";
    }

    public LawnVariantSettings setCustomDrop(String lootIdentifier, String lootType){
        this.lootType = lootType;
        this.lootIdentifier = lootIdentifier;
        return this;
    }

}
