package teamrapture.mobularmachinery.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
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

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityEnergyRelay();
    }
}
