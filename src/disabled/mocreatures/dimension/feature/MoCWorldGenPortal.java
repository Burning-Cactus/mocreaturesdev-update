package drzhark.mocreatures.dimension.feature;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class MoCWorldGenPortal extends Feature<NoFeatureConfig> { //TODO: Low priority, move this

    private Block pillarBlock;
    private Block stairBlock;
    private Block wallBlock;
    private Block centerBlock;

    public MoCWorldGenPortal(Block pillar, Block stair, Block wall, Block center) {
        this.pillarBlock = pillar;
        this.stairBlock = stair;
        this.wallBlock = wall;
        this.centerBlock = center;
    }

    public boolean generatePillar(World world, BlockPos pos) {
        for (int nY = pos.getY(); nY < pos.getY() + 6; nY++) {
            world.setBlockState(new BlockPos(pos.getX(), nY, pos.getZ()), this.pillarBlock.getDefaultState(), 2);
        }
        return true;
    }

    @Override
    public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (world.getBlockState(pos).getBlock() == this.centerBlock || world.getBlockState(pos.down()).getBlock() == this.centerBlock
                || world.getBlockState(pos.up()).getBlock() == this.centerBlock) {
            return true;
        }

        if (world.isAirBlock(pos) || !world.isAirBlock(pos.up())) {
            return false;
        }

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        //System.out.println("GENERATING Portal @ " + pos);

        this.stairMetadata = 2;
        for (int nZ = z - 3; nZ < z + 3; nZ = nZ + 5) {
            for (int nX = x - 2; nX < x + 2; nX++) {
                if (nZ > z) {
                    this.stairMetadata = 3;
                }

                world.setBlockState(new BlockPos(nX, y + 1, nZ), this.stairBlock.getStateFromMeta(this.stairMetadata), 2);
            }
        }

        for (int nX = x - 2; nX < x + 2; nX++) {
            for (int nZ = z - 2; nZ < z + 2; nZ++) {
                world.setBlockState(new BlockPos(nX, y + 1, nZ), this.wallBlock.getStateFromMeta(this.wallMetadata), 2);
            }
        }

        for (int nX = x - 1; nX < x + 1; nX++) {
            for (int nZ = z - 1; nZ < z + 1; nZ++) {
                world.setBlockState(new BlockPos(nX, y + 1, nZ), this.centerBlock.getStateFromMeta(this.centerMetadata), 2);
            }
        }

        for (int j = x - 3; j < x + 3; j = j + 5) {
            for (int nZ = z - 3; nZ < z + 3; nZ++) {
                world.setBlockState(new BlockPos(j, y + 6, nZ), this.wallBlock.getStateFromMeta(this.wallMetadata), 2);
            }
        }

        generatePillar(world, new BlockPos(x - 3, y, z - 3));
        generatePillar(world, new BlockPos(x - 3, y, z + 2));
        generatePillar(world, new BlockPos(x + 2, y, z - 3));
        generatePillar(world, new BlockPos(x + 2, y, z + 2));

        return true;
    }
}
