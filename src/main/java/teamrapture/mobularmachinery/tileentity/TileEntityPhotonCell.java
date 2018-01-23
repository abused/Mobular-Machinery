package teamrapture.mobularmachinery.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
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

        for (int i = 0; i < 50; i++) {
            BlockPos blockPos = new BlockPos(pos.getX(), pos.getY() + i, pos.getZ());
            Block block = world.getBlockState(blockPos).getBlock();
            if(i >= 50) {
                if(block == Blocks.AIR) {
                    clearSkies = true;
                }else {
                    clearSkies = false;
                }
            }else {
                if(clearSkies) {
                   clearSkies = false;
                }
            }
        }

        if(clearSkies) {
            storage.receiveEnergy(100, false);
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
