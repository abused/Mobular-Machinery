package teamrapture.mobularmachinery.tileentity.extruder;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import teamrapture.mobularmachinery.tileentity.TileEntityBase;

import javax.annotation.Nullable;

public class TileEntityExtruderInventory extends TileEntityBase {

    public TileEntityExtruderInventory() {
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
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

        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && extruder != null && extruder.isMultiblock && extruderPos != null) {
            return (T) extruder.inventory;
        }
        return super.getCapability(capability, facing);
    }
}
