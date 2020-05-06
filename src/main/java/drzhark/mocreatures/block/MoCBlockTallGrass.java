package drzhark.mocreatures.block;

import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.init.MoCBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import java.util.List;
import java.util.Random;

public class MoCBlockTallGrass extends MoCBlock implements IShearable {

    protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 0.8D, 0.9D);
    protected static final VoxelShape SHAPE = VoxelShapes.create(AABB);

    public MoCBlockTallGrass(Block.Properties builder) {
        super(builder
                .sound(SoundType.PLANT));
    }
//
//    public MoCBlockTallGrass(Block.Properties builder, boolean lighted) {
//        this(builder);
//        if (lighted) {
//            this.setLightLevel(0.8F);
//        }
//    }

    public AxisAlignedBB getBoundingBox(BlockState state, IBlockAccess source, BlockPos pos) {
        return AABB;
    }

    @Override
    public VoxelShape getShape() {
        return this.SHAPE;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return null;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i'
     * (inclusive).
     */
    @Override
    public int quantityDroppedWithBonus(int par1, Random par2Random) {
        return 1 + par2Random.nextInt(par1 * 2 + 1);
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
        return true;
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return new java.util.ArrayList<ItemStack>(java.util.Arrays.asList(new ItemStack(MoCBlocks.mocTallGrass)));
    }

    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, BlockState state) {
        Block soil = worldIn.getBlockState(pos.down()).getBlock();
        return soil == MoCBlocks.mocGrass || soil == MoCBlocks.mocDirt || soil == Blocks.GRASS 
                || soil == Blocks.DIRT || soil == Blocks.FARMLAND;
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        BlockState soil = worldIn.getBlockState(pos.down());
        Block tempblock = soil.getBlock();
        if (tempblock instanceof MoCBlockDirt || tempblock instanceof MoCBlockGrass){
            return true;
        }
        return super.canPlaceBlockAt(worldIn, pos) && soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
    }
}
