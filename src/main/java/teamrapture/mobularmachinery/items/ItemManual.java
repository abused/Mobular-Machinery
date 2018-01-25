package teamrapture.mobularmachinery.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import teamrapture.mobularmachinery.MobularMachinery;
import teamrapture.mobularmachinery.client.gui.GuiHandler;

public class ItemManual extends Item {

    public ItemManual() {
        this.setRegistryName("item_mobular_manual");
        this.setUnlocalizedName("item_mobular_manual");
        this.setCreativeTab(MobularMachinery.mobularTab);
        this.setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if(world.isRemote) {
            player.openGui(MobularMachinery.instance, GuiHandler.MOBULAR_MANUAL, world, (int) player.posX, (int) player.posY, (int) player.posZ);
        }
        return super.onItemRightClick(world, player, hand);
    }
}
