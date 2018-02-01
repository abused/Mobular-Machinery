package teamrapture.mobularmachinery.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import teamrapture.mobularmachinery.MobularMachinery;
import teamrapture.mobularmachinery.tileentity.TileEntityDisplayPedestal;

import javax.annotation.Nullable;

public class DisplayPedestal extends BlockContainer {

    public DisplayPedestal() {
        super(Material.ROCK);
        this.setRegistryName("display_pedestal");
        this.setUnlocalizedName("display_pedestal");
        this.setCreativeTab(MobularMachinery.mobularTab);
        this.setHardness(1.0f);
        this.setHarvestLevel("pickaxe", 1);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack heldItem = player.getHeldItem(hand);
        TileEntityDisplayPedestal te = (TileEntityDisplayPedestal) world.getTileEntity(pos);

        if(heldItem != ItemStack.EMPTY) {
            if(te.stack == ItemStack.EMPTY) {
                te.stack = heldItem;
                if(player.getHeldItem(hand).getCount() > 1) {
                    player.getHeldItem(hand).shrink(1);
                }else {
                    player.setHeldItem(hand, ItemStack.EMPTY);
                }
            }
        }else {
            if(!te.stack.isEmpty()) {
                player.setHeldItem(hand, te.stack);
                te.stack = ItemStack.EMPTY;
            }
        }
        return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }
}
