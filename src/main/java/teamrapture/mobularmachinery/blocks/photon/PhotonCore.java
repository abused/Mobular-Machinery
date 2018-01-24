package teamrapture.mobularmachinery.blocks.photon;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import teamrapture.mobularmachinery.MobularMachinery;
import teamrapture.mobularmachinery.tileentity.TileEntityPhotonCell;
import teamrapture.mobularmachinery.tileentity.TileEntityPhotonCore;

import javax.annotation.Nullable;

public class PhotonCore extends BlockContainer {

    public PhotonCore() {
        super(Material.ROCK);
        this.setRegistryName("photon_core");
        this.setUnlocalizedName("photon_core");
        this.setCreativeTab(MobularMachinery.mobularTab);
        this.setHardness(1.5f);
        this.setHarvestLevel("pickaxe", 2);
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
        return new TileEntityPhotonCore();
    }
}
