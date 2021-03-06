package net.minecraft.world.level.levelgen.feature.blockplacers;

import com.mojang.serialization.Codec;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public abstract class BlockPlacer {
   public static final Codec<BlockPlacer> CODEC = Registry.BLOCK_PLACER_TYPES.dispatch(BlockPlacer::type, BlockPlacerType::codec);

   public abstract void place(LevelAccessor p_67483_, BlockPos p_67484_, BlockState p_67485_, Random p_67486_);

   protected abstract BlockPlacerType<?> type();
}