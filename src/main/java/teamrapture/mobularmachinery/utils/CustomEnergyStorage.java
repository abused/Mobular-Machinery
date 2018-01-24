package teamrapture.mobularmachinery.utils;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;

public class CustomEnergyStorage extends EnergyStorage {

    public CustomEnergyStorage(int capacity) {
        super(capacity);
    }

    public CustomEnergyStorage(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }

    public CustomEnergyStorage(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract);
    }

    public CustomEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }

    public void setEnergyStored(int amount) {
        this.energy = amount;

        if(this.energy > capacity) {
            this.energy = capacity;
        }else if(energy < 0) {
            energy = 0;
        }
    }

    public CustomEnergyStorage readFromNBT(NBTTagCompound nbt) {

        this.energy = nbt.getInteger("Energy");

        if (energy > capacity) {
            energy = capacity;
        }
        return this;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {

        if (energy < 0) {
            energy = 0;
        }
        nbt.setInteger("Energy", energy);
        return nbt;
    }

    public void handleSendingEnergy(EnergyStorage storage, BlockPos getPos, World world, int send) {
        int energyStored = getEnergyStored();

        for (EnumFacing facing : EnumFacing.values()) {
            BlockPos pos = getPos.offset(facing);
            TileEntity te = world.getTileEntity(pos);
            if (isEnergyTE(te)) {
                EnumFacing opposite = facing.getOpposite();
                int rfToGive = send <= energyStored ? send : energyStored;
                int received = receiveExternalEnergy(te, opposite, rfToGive);

                energyStored -= storage.extractEnergy(received, false);
                if (energyStored <= 0) {
                    break;
                }
            }
        }
    }

    public boolean isEnergyTE(TileEntity te) {
        return te != null && te.hasCapability(CapabilityEnergy.ENERGY, null);
    }

    public int receiveExternalEnergy(TileEntity tileEntity, EnumFacing from, int maxReceive) {
        if (tileEntity != null && tileEntity.hasCapability(CapabilityEnergy.ENERGY, from)) {
            net.minecraftforge.energy.IEnergyStorage capability = tileEntity.getCapability(CapabilityEnergy.ENERGY, from);
            if (capability.canReceive()) {
                return capability.receiveEnergy(maxReceive, false);
            }
        }
        return 0;
    }
}