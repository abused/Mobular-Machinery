package teamrapture.mobularmachinery.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.MobularMachinery;
import teamrapture.mobularmachinery.client.gui.GuiHandler;
import teamrapture.mobularmachinery.tileentity.TileEntityHydroGen;
import teamrapture.mobularmachinery.tileentity.TileEntityWaterVaporizer;
import teamrapture.mobularmachinery.utils.FluidUtils;

import javax.annotation.Nullable;

import static net.minecraftforge.fluids.capability.CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY;

public class WaterVaporizer extends BlockContainer {

    public WaterVaporizer() {
        super(Material.ROCK);
        this.setRegistryName("water_vaporizer");
        this.setUnlocalizedName("water_vaporizer");
        this.setCreativeTab(MobularMachinery.mobularTab);
        this.setHardness(1.5f);
        this.setHarvestLevel("pickaxe", 2);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack heldItem = player.getHeldItem(hand);
        final TileEntityWaterVaporizer vaporizer = (TileEntityWaterVaporizer) world.getTileEntity(pos);

        if(heldItem == FluidUtil.getFilledBucket(new FluidStack(FluidRegistry.WATER, 1000))) {
            IFluidHandler handler = vaporizer.getCapability(FLUID_HANDLER_CAPABILITY, facing);
            FluidActionResult res = FluidUtils.interactWithFluidHandler(heldItem, handler, player);
            if (res.isSuccess()) {
                player.setHeldItem(hand, res.getResult());
                return true;
            }
        }

        if(!world.isRemote) {
            player.openGui(MobularMachinery.instance, GuiHandler.WATER_VAPORIZER, world, pos.getX(), pos.getY(), pos.getZ());
        }

        return true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
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
        return new TileEntityWaterVaporizer();
    }
}
