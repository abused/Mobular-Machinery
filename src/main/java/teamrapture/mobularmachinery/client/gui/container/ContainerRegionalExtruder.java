package teamrapture.mobularmachinery.client.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import teamrapture.mobularmachinery.client.gui.slots.SlotInput;
import teamrapture.mobularmachinery.tileentity.extruder.TileEntityRegionalExtruder;

public class ContainerRegionalExtruder extends Container {

    private TileEntityRegionalExtruder tileEntityRegionalExtruder;

    public ContainerRegionalExtruder(IInventory playerInv, TileEntityRegionalExtruder te) {
        super();
        tileEntityRegionalExtruder = te;

        addSlotToContainer(new SlotInput(this.tileEntityRegionalExtruder.inventory, 0, 80, 8));

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
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        return super.transferStackInSlot(playerIn, index);
    }
}
