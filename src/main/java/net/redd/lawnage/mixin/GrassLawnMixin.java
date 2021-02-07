package net.redd.lawnage.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.redd.lawnage.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlantBlock.class)
public class GrassLawnMixin {
	@Inject(at = @At("HEAD"), method = "canPlantOnTop", cancellable = true)
	private void init(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> info) {
		if (floor.isOf(Main.GrassLawn)) {
			info.setReturnValue(true);
		}
	}
}
