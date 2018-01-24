package teamrapture.mobularmachinery.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
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

public class TileEntityWaterVaporizer extends TileEntityInventory {

    public CustomEnergyStorage storage = new CustomEnergyStorage(50000);
    public FluidTank waterTank = new FluidTank(8000);
    public FluidTank vaporTank = new FluidTank(8000);
    public int generateVapor = 0;
    public int generateLavaVapor = 0;
    public boolean runByLava = true;

    public TileEntityWaterVaporizer() {
        super(2);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt.hasKey("WaterFluidData")) {
            this.waterTank.setFluid(FluidStack.loadFluidStackFromNBT(nbt.getCompoundTag("WaterFluidData")));
        }

        if(waterTank != null && waterTank.getFluid() != null) {
            waterTank.readFromNBT(nbt);
        }

        if (this.waterTank != null) {
            this.waterTank.setTileEntity(this);
        }

        if (nbt.hasKey("VaporFluidData")) {
            this.vaporTank.setFluid(FluidStack.loadFluidStackFromNBT(nbt.getCompoundTag("VaporFluidData")));
        }

        if(vaporTank != null && vaporTank.getFluid() != null) {
            vaporTank.readFromNBT(nbt);
        }

        if (this.vaporTank != null) {
            this.vaporTank.setTileEntity(this);
        }

        generateVapor = nbt.getInteger("GenerateVapor");
        generateLavaVapor = nbt.getInteger("GenerateLavaVapor");
        runByLava = nbt.getBoolean("LavaRunning");
        storage.readFromNBT(nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        if (this.waterTank != null && this.waterTank.getFluid() != null) {
            final NBTTagCompound tankTag = new NBTTagCompound();
            this.waterTank.getFluid().writeToNBT(tankTag);
            nbt.setTag("WaterFluidData", tankTag);
            waterTank.writeToNBT(nbt);
        }

        if (this.vaporTank != null && this.vaporTank.getFluid() != null) {
            final NBTTagCompound tankTag = new NBTTagCompound();
            this.vaporTank.getFluid().writeToNBT(tankTag);
            nbt.setTag("VaporFluidData", tankTag);
            vaporTank.writeToNBT(nbt);
        }

        nbt.setInteger("GenerateVapor", generateVapor);
        nbt.setInteger("GenerateLavaVapor", generateLavaVapor);
        nbt.setBoolean("LavaRunning", runByLava);
        storage.writeToNBT(nbt);
        return super.writeToNBT(nbt);
    }

    @Override
    public void update() {
        super.update();
        if (!inventory.getStackInSlot(0).isEmpty()) {
            ItemStack stack = inventory.getStackInSlot(0);
            if (stack.getItem() == Items.WATER_BUCKET && waterTank.getCapacity() - waterTank.getFluidAmount() >= 1000) {
                inventory.setStackInSlot(0, new ItemStack(Items.BUCKET));
                waterTank.fill(new FluidStack(FluidRegistry.WATER, 1000), true);
            }
        }

        if (!inventory.getStackInSlot(1).isEmpty()) {
            ItemStack stack2 = inventory.getStackInSlot(1);
            if(stack2.getItem() == Items.BUCKET && vaporTank.getFluidAmount() >= 1000) {
                inventory.setStackInSlot(1, FluidUtil.getFilledBucket(new FluidStack(ModResources.steam, 1000)));
                vaporTank.drain(1000, true);
            }
        }

        for (EnumFacing side : EnumFacing.VALUES) {
            BlockPos cip = pos.offset(side);
            if (world.getBlockState(cip).getBlock() == Blocks.LAVA || world.getBlockState(cip).getBlock() == Blocks.FLOWING_LAVA) {
                if(waterTank.getFluidAmount() >= 100 && vaporTank.getCapacity() - vaporTank.getFluidAmount() >= 100) {
                    generateLavaVapor++;

                    if(!runByLava) {
                        runByLava = true;
                    }

                    if(generateLavaVapor >= 100) {
                     generateLavaVapor = 0;
                        vaporTank.fill(new FluidStack(ModResources.steam, 100), true);
                        waterTank.drain(200, true);
                    }
                }else if(generateLavaVapor > 0) {
                    generateLavaVapor = 0;
                }
            }
        }
        if(storage.getEnergyStored() >= 600 && waterTank.getFluidAmount() >= 200) {
            if (vaporTank.getCapacity() - vaporTank.getFluidAmount() >= 200) {
                generateVapor++;

                if(runByLava) {
                    runByLava = false;
                }

                if(generateVapor >= 30) {
                    generateVapor = 0;
                    vaporTank.fill(new FluidStack(ModResources.steam, 200), true);
                    waterTank.drain(200, true);
                    storage.extractEnergy(600, false);

                }
            }else if(generateVapor > 0) {
                generateVapor = 0;
            }
        }else if(generateVapor > 0) {
            generateVapor = 0;
        }
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityEnergy.ENERGY) {
            return true;
        }
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            if(facing == EnumFacing.UP) {
                return (T) this.waterTank;
            }else if(facing == EnumFacing.DOWN) {
                return (T) this.vaporTank;
            }
        }
        if(capability == CapabilityEnergy.ENERGY) {
            return (T) this.storage;
        }
        return super.getCapability(capability, facing);
    }
}
