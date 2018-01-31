package teamrapture.mobularmachinery.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import teamrapture.mobularmachinery.utils.CustomEnergyStorage;

import javax.annotation.Nullable;

public class TileEntityEnergyRelay extends TileEntityBase {

    public CustomEnergyStorage storage = new CustomEnergyStorage(5000);
    public int x = 0;
    public int y = 0;
    public int z = 0;

    public TileEntityEnergyRelay() {
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        storage.readFromNBT(nbt);
        x = nbt.getInteger("X");
        y = nbt.getInteger("Y");
        z = nbt.getInteger("Z");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        storage.writeToNBT(nbt);
        nbt.setInteger("X", x);
        nbt.setInteger("Y", y);
        nbt.setInteger("Z", z);
        return super.writeToNBT(nbt);
    }

    @Override
    public void update() {
        if(isLinked()) {
            BlockPos linkedPos = new BlockPos(x, y, z);
            TileEntityEnergyRelay relay = (TileEntityEnergyRelay) world.getTileEntity(linkedPos);
            int relayStorage = relay.storage.getEnergyStored();
            storage.setEnergyStored(relayStorage);
            relay.storage.setEnergyStored(relayStorage);
            handleSendingEnergy();
            relay.handleSendingEnergy();
        }
    }

    public boolean isLinked() {
        if(x != 0 && y != 0 && z != 0) {
            BlockPos linkedPos = new BlockPos(x, y, z);
            if(world.getTileEntity(linkedPos) instanceof TileEntityEnergyRelay) {
                return true;
            }
        }
        return false;
    }

    public void setRelayPosition(ItemStack stack) {
        NBTTagCompound tag = stack.getTagCompound();
        if(tag == null) {
            tag = new NBTTagCompound();
        }

        if(tag != null) {
            if(tag.hasKey("x") && tag.hasKey("y") && tag.hasKey("z")) {
                x = tag.getInteger("x");
                y = tag.getInteger("y");
                z = tag.getInteger("z");
            }else {
                x = 0;
                y = 0;
                z = 0;
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

    private void handleSendingEnergy() {
        int energyStored = storage.getEnergyStored();

        for (EnumFacing facing : EnumFacing.values()) {
            BlockPos pos = getPos().offset(facing);
            TileEntity te = world.getTileEntity(pos);
            if (isEnergyTE(te)) {
                EnumFacing opposite = facing.getOpposite();
                int rfToGive = 1000 <= energyStored ? 1000 : energyStored;
                int received;

                received = receiveEnergy(te, opposite, rfToGive);
                energyStored -= storage.extractEnergy(received, false);
                if (energyStored <= 0) {
                    break;
                }
            }
        }
    }

    public static int receiveEnergy(TileEntity tileEntity, EnumFacing from, int maxReceive) {
        if (tileEntity != null && tileEntity.hasCapability(CapabilityEnergy.ENERGY, from)) {
            net.minecraftforge.energy.IEnergyStorage capability = tileEntity.getCapability(CapabilityEnergy.ENERGY, from);
            if (capability.canReceive()) {
                return capability.receiveEnergy(maxReceive, false);
            }
        }
        return 0;
    }

    public static boolean isEnergyTE(TileEntity te) {
        return te != null && te.hasCapability(CapabilityEnergy.ENERGY, null);
    }
}
