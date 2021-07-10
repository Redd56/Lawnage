package net.redd.lawnage.modContent.BlockSoundGroups;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class BNBlockSoundGroup {
    public static final BlockSoundGroup BN_TERRAIN;


    static {
        BN_TERRAIN = new BlockSoundGroup(1.0F, 1.0F,
                SoundEvents.BLOCK_NETHERRACK_BREAK,
                SoundEvents.BLOCK_WART_BLOCK_STEP,
                SoundEvents.BLOCK_NETHERRACK_PLACE,
                SoundEvents.BLOCK_NETHERRACK_HIT,
                SoundEvents.BLOCK_NETHERRACK_FALL);
    }
}
