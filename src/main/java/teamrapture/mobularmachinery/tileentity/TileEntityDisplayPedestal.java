package teamrapture.mobularmachinery.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityDisplayPedestal extends TileEntityBase {

    public ItemStack stack = ItemStack.EMPTY;

    public TileEntityDisplayPedestal() {
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt.hasKey("item")) {
            stack = new ItemStack(nbt.getCompoundTag("item"));
        } else {
            stack = ItemStack.EMPTY;
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        if (!stack.isEmpty()) {
            NBTTagCompound tagCompound = new NBTTagCompound();
            stack.writeToNBT(tagCompound);
            nbt.setTag("item", tagCompound);
        }
        return super.writeToNBT(nbt);
    }


}
