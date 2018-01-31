package teamrapture.mobularmachinery.tileentity.extruder;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import teamrapture.mobularmachinery.tileentity.TileEntityBase;

import javax.annotation.Nullable;

public class TileEntityExtruderTap extends TileEntityBase {

    public TileEntityExtruderTap() {
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        TileEntityRegionalExtruder extruder = null;
        BlockPos extruderPos = null;
        for (EnumFacing side : EnumFacing.VALUES) {
            BlockPos cip = pos.offset(side);
            if(world.getTileEntity(cip) instanceof TileEntityRegionalExtruder) {
                extruder = (TileEntityRegionalExtruder) world.getTileEntity(cip);
                extruderPos = cip;
            }
        }

        if(capability == CapabilityEnergy.ENERGY && extruder != null && extruder.isMultiblock && extruderPos != null) {
            return true;
        }

        return super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        TileEntityRegionalExtruder extruder = null;
        BlockPos extruderPos = null;
        for (EnumFacing side : EnumFacing.VALUES) {
            BlockPos cip = pos.offset(side);
            if(world.getTileEntity(cip) instanceof TileEntityRegionalExtruder) {
                extruder = (TileEntityRegionalExtruder) world.getTileEntity(cip);
                extruderPos = cip;
            }
        }

        if(capability == CapabilityEnergy.ENERGY && extruder != null && extruder.isMultiblock && extruderPos != null) {
            return (T) extruder.storage;
        }
        return super.getCapability(capability, facing);
    }
}
