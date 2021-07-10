package net.redd.lawnage.modContent.BlockSoundGroups;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class BEBlockSoundGroup {
    public static final BlockSoundGroup BE_TERRAIN;


    static {
        BE_TERRAIN = new BlockSoundGroup(1.0F, 1.0F,
                SoundEvents.BLOCK_STONE_BREAK,
                SoundEvents.BLOCK_WART_BLOCK_STEP,
                SoundEvents.BLOCK_STONE_PLACE,
                SoundEvents.BLOCK_STONE_HIT,
                SoundEvents.BLOCK_STONE_FALL);
    }
}