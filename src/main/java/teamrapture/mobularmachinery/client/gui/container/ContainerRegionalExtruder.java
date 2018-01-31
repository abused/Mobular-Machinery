package teamrapture.mobularmachinery.client.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import teamrapture.mobularmachinery.client.gui.slots.SlotInput;
import teamrapture.mobularmachinery.client.gui.slots.SlotOutput;
import teamrapture.mobularmachinery.registry.ModResources;
import teamrapture.mobularmachinery.tileentity.extruder.TileEntityRegionalExtruder;

public class ContainerRegionalExtruder extends Container {

    private TileEntityRegionalExtruder tileEntityRegionalExtruder;

    public ContainerRegionalExtruder(IInventory playerInv, TileEntityRegionalExtruder te) {
        super();
        tileEntityRegionalExtruder = te;

        addSlotToContainer(new SlotInput(this.tileEntityRegionalExtruder.inventory, 0, 80, 8));

        for(int s = 1; s < 10; s++) {
            addSlotToContainer(new SlotOutput(this.tileEntityRegionalExtruder.inventory, s, -10 + s * 18, 52));
        }

        int i;
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 0 || index == 1 || index == 2 || index == 3 || index == 4 || index == 5 || index == 6 || index == 7 || index == 8 || index == 9)
            {
                if (!this.mergeItemStack(itemstack1, 3, 37, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }

            if(index != 0) {
                //if(itemstack1.getItem() == ModResources.itemBossHeart) {
                    if(!this.mergeItemStack(itemstack1, 0, 1, true)) {
                        return ItemStack.EMPTY;
                    }
                //}
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }
}
