package net.redd.lawnage.core.systems;

import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class LawnVariantSettings {

    public Material mat;
    public MapColor color;
    public float strength;
    public BlockSoundGroup sound;
    public boolean requiresTool;
    public String lootIdentifier, lootType;

    public LawnVariantSettings(Material mat, MapColor color, float strength, BlockSoundGroup sound,boolean requiresTool){
        this.mat = mat;
        this.color = color;
        this.strength = strength;
        this.sound = sound;
        this.requiresTool = requiresTool;
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
