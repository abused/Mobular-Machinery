package teamrapture.mobularmachinery.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import teamrapture.mobularmachinery.registry.ModResources;
import teamrapture.mobularmachinery.utils.CustomEnergyStorage;
import teamrapture.mobularmachinery.utils.MobularUtils;
import teamrapture.mobularmachinery.utils.hud.IHudSupport;

import javax.annotation.Nullable;
import java.util.Random;

public class TileEntityPhotonCore extends TileEntityBase implements IHudSupport {

    public CustomEnergyStorage storage = new CustomEnergyStorage(1000000, 10000);
    public boolean isMultiblock = false;

    public TileEntityPhotonCore() {
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        storage.readFromNBT(nbt);
        isMultiblock = nbt.getBoolean("Multiblock");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        storage.writeToNBT(nbt);
        nbt.setBoolean("Multiblock", isMultiblock);
        return super.writeToNBT(nbt);
    }

    @Override
    public void update() {
        if (!world.isRemote) {
            IBlockState state = world.getBlockState(pos);
            world.notifyBlockUpdate(pos, state, state, 3);
        }
        checkMultiblock();

        for (EnumFacing side : EnumFacing.VALUES) {
            BlockPos cip = pos.offset(side);
            if (!(world.getTileEntity(cip) instanceof TileEntityPhotonCell)) {
                storage.handleSendingEnergy(storage, getPos(), world, 2000);
            }else if(world.getTileEntity(cip) instanceof TileEntityPhotonCell) {
                TileEntityPhotonCell cell = (TileEntityPhotonCell) world.getTileEntity(cip);
                if(cell.storage.getEnergyStored() >= 500 && storage.getMaxEnergyStored() - storage.getEnergyStored() >= 500) {
                    cell.storage.extractEnergy(500, false);
                    storage.receiveEnergy(500, false);
                }
            }
        }

    }

    public boolean checkMultiblock() {
        BlockPos pos1 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
        BlockPos pos2 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
        BlockPos pos3 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
        BlockPos pos4 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);

        if(world.getBlockState(pos1).getBlock() == ModResources.blockPhotonCell) {
            if (world.getBlockState(pos2).getBlock() == ModResources.blockPhotonCell) {
                if (world.getBlockState(pos3).getBlock() == ModResources.blockPhotonCell) {
                    if (world.getBlockState(pos4).getBlock() == ModResources.blockPhotonCell) {
                        if (!isMultiblock) {
                            isMultiblock = true;
                        }
                        return true;
                    }
                }
            }
        }

        if(isMultiblock) {
            isMultiblock = false;
        }
        return false;
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

    @Override
    public EnumFacing getBlockOrientation() {
        return MobularUtils.getOrientationHoriz(getBlockMetadata());
    }

    @Override
    public boolean isBlockAboveAir() {
        return getWorld().isAirBlock(pos.up());
    }

    @Override
    public BlockPos getBlockPos() {
        return getPos();
    }

    @Override
    public String getDisplay() {
        return storage.getEnergyStored() + " / " + storage.getMaxEnergyStored() + " FU";
    }
}
