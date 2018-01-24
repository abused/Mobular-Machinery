package teamrapture.mobularmachinery.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import teamrapture.mobularmachinery.utils.CustomEnergyStorage;

import javax.annotation.Nullable;

public class TileEntityPhotonCell extends TileEntityBase {

    public CustomEnergyStorage storage = new CustomEnergyStorage(10000, 10000);
    public boolean clearSkies = false;

    public TileEntityPhotonCell() {
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        storage.readFromNBT(nbt);
        clearSkies = nbt.getBoolean("ClearSkies");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        storage.writeToNBT(nbt);
        nbt.setBoolean("ClearSkies", clearSkies);
        return super.writeToNBT(nbt);
    }

    @Override
    public void update() {
        if(!world.isRemote) {
            IBlockState state = world.getBlockState(pos);
            world.notifyBlockUpdate(pos, state, state, 3);
        }

        if(world.canSeeSky(getPos())) {
            if(!clearSkies) {
                clearSkies = true;
            }
        }else {
            if(clearSkies) {
                clearSkies = false;
            }
        }

        for (EnumFacing side : EnumFacing.VALUES) {
            BlockPos cip = pos.offset(side);
            if (world.getTileEntity(cip) instanceof TileEntityPhotonCore) {
                TileEntityPhotonCore te = (TileEntityPhotonCore) world.getTileEntity(cip);
                if(te.isMultiblock) {
                    if(clearSkies && world.isDaytime()) {
                        storage.receiveEnergy(100, false);
                    }
                }
            }
        }
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityEnergy.ENERGY) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityEnergy.ENERGY) {
            return (T) storage;
        }
        return super.getCapability(capability, facing);
    }
}
