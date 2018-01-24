package teamrapture.mobularmachinery.blocks.extruder;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.MobularMachinery;
import teamrapture.mobularmachinery.client.gui.GuiHandler;
import teamrapture.mobularmachinery.tileentity.extruder.TileEntityRegionalExtruder;

import javax.annotation.Nullable;

public class ExtruderFrame extends BlockContainer {

    public ExtruderFrame() {
        super(Material.ROCK);
        this.setRegistryName("extruder_frame");
        this.setUnlocalizedName("extruder_frame");
        this.setCreativeTab(MobularMachinery.mobularTab);
        this.setHardness(1.5f);
        this.setHarvestLevel("pickaxe", 1);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntityRegionalExtruder extruder = null;
        BlockPos extruderPos = null;
        for (EnumFacing side : EnumFacing.VALUES) {
            BlockPos cip = pos.offset(side);
            if(world.getTileEntity(cip) instanceof TileEntityRegionalExtruder) {
                extruder = (TileEntityRegionalExtruder) world.getTileEntity(cip);
                extruderPos = cip;
            }
        }

        if(!world.isRemote && extruder != null && extruder.isMultiblock && extruderPos != null) {
            player.openGui(MobularMachinery.instance, GuiHandler.REGIONAL_EXTRUDER, world, extruderPos.getX(), extruderPos.getY(), extruderPos.getZ());
        }

        return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
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
