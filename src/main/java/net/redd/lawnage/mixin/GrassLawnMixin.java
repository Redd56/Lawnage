package net.redd.lawnage.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.redd.lawnage.Main;
import net.redd.lawnage.SimpleRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlantBlock.class)
public class GrassLawnMixin {
	@Inject(at = @At("HEAD"), method = "canPlantOnTop", cancellable = true)
	private void init(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> info) {
		if (floor.isOf(SimpleRegistry.get("grass_lawn"))||floor.isOf(SimpleRegistry.get("biome_grass_lawn"))) {
			info.setReturnValue(true);
		}
	}
}
