package teamrapture.mobularmachinery.blocks.extruder;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.MobularMachinery;
import teamrapture.mobularmachinery.tileentity.extruder.TileEntityRegionalExtruder;

import javax.annotation.Nullable;

public class RegionalExtruder extends BlockContainer {

    public RegionalExtruder() {
        super(Material.ROCK);
        this.setRegistryName("regional_extruder");
        this.setUnlocalizedName("regional_extruder");
        this.setCreativeTab(MobularMachinery.mobularTab);
        this.setHardness(1.5f);
        this.setHarvestLevel("pickaxe", 2);
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
        return new TileEntityRegionalExtruder();
    }
}
