package drzhark.mocreatures.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraftforge.common.ToolType;

import java.util.Random;

import net.minecraft.block.AbstractBlock;

public class MoCBlockGrass extends MoCBlock {

    public MoCBlockGrass(AbstractBlock.Properties builder) {
        super(builder
                .sound(SoundType.GRASS)
                .strength(0.5F)
                .harvestTool(ToolType.SHOVEL)
                .harvestLevel(0)
                .randomTicks()
        );
    }

//    public void updateTick(World worldIn, BlockPos pos, BlockState state, Random rand) {
//        if (!worldIn.isRemote) {
//            if (worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getLightOpacity(worldIn, pos.up()) > 2) {
//                worldIn.setBlockState(pos, MoCBlocks.MOCDIRT.getDefaultState());
//            } else {
//                if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {
//                    for (int i = 0; i < 4; ++i) {
//                        BlockPos blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
//                        BlockState blockstate = worldIn.getBlockState(blockpos1.up());
//                        BlockState iblockstate1 = worldIn.getBlockState(blockpos1);
//
//                        if (iblockstate1.getBlock() == MoCBlocks.mocDirt && worldIn.getLightFromNeighbors(blockpos1.up()) >= 4
//                                && blockstate.getLightOpacity(worldIn, blockpos1.up()) <= 2) {
//                            worldIn.setBlockState(blockpos1, MoCBlocks.mocGrass.getDefaultState());
//                        }
//                    }
//                }
//            }
//        }
//    }
}
