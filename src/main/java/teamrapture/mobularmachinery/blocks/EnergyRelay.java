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
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import teamrapture.mobularmachinery.MobularMachinery;
import teamrapture.mobularmachinery.tileentity.TileEntityEnergyRelay;

import javax.annotation.Nullable;

public class EnergyRelay extends BlockContainer {

    public EnergyRelay() {
        super(Material.ROCK);
        this.setRegistryName("energy_relay");
        this.setUnlocalizedName("energy_relay");
        this.setCreativeTab(MobularMachinery.mobularTab);
        this.setHardness(1.0f);
        this.setHarvestLevel("pickaxe", 1);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntityEnergyRelay te = (TileEntityEnergyRelay) world.getTileEntity(pos);
        if(te.isLinked()) {
            if(!world.isRemote) {
                player.sendMessage(new TextComponentString("The tile is linked with a storage of: " + te.storage.getEnergyStored()));
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
        return new TileEntityEnergyRelay();
    }
}
