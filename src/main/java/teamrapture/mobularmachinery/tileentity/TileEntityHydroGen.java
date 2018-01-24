package teamrapture.mobularmachinery.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import teamrapture.mobularmachinery.registry.ModResources;
import teamrapture.mobularmachinery.utils.CustomEnergyStorage;

import javax.annotation.Nullable;

public class TileEntityHydroGen extends TileEntityInventory implements ITickable {

    public CustomEnergyStorage storage = new CustomEnergyStorage(100000);
    public FluidTank tank = new FluidTank(8000);
    public int generationPerMB = 10;
    public boolean generating = false;

    public TileEntityHydroGen() {
        super(1);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        storage.readFromNBT(nbt);
        if (nbt.hasKey("FluidData")) {
            this.tank.setFluid(FluidStack.loadFluidStackFromNBT(nbt.getCompoundTag("FluidData")));
        }

        if(tank != null && tank.getFluid() != null) {
            tank.readFromNBT(nbt);
        }

        if (this.tank != null) {
            this.tank.setTileEntity(this);
        }

        generating = nbt.getBoolean("Generating");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        storage.writeToNBT(nbt);
        if (this.tank != null && this.tank.getFluid() != null) {
            final NBTTagCompound tankTag = new NBTTagCompound();
            this.tank.getFluid().writeToNBT(tankTag);
            nbt.setTag("FluidData", tankTag);
            tank.writeToNBT(nbt);
        }
        nbt.setBoolean("Generating", generating);
        return super.writeToNBT(nbt);
    }

    @Override
    public void update() {
        if (!world.isRemote) {
            IBlockState state = world.getBlockState(pos);
            world.notifyBlockUpdate(pos, state, state, 3);
        }

        if (!inventory.getStackInSlot(0).isEmpty() && inventory.getStackInSlot(0).getItem() == FluidUtil.getFilledBucket(new FluidStack(ModResources.steam, 1000)).getItem()) {
            if (tank.getCapacity() - tank.getFluidAmount() >= 1000) {
                tank.fill(new FluidStack(ModResources.steam, 1000), true);
                inventory.setStackInSlot(0, new ItemStack(Items.BUCKET));
            }
        }

        if (storage.getMaxEnergyStored() - storage.getEnergyStored() >= generationPerMB && tank.getFluidAmount() >= 20 && tank.getFluid().getFluid() == ModResources.steam) {
            if (!generating) {
                generating = true;
            }
            tank.drain(20, true);
            storage.receiveEnergy(generationPerMB, false);
        } else {
            if (generating) {
                generating = false;
            }
        }

    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return true;
        }
        if(capability == CapabilityEnergy.ENERGY) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return (T) this.tank;
        }
        if(capability == CapabilityEnergy.ENERGY) {
            return (T) this.storage;
        }
        return super.getCapability(capability, facing);
    }
}
