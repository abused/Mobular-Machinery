package teamrapture.mobularmachinery.items;

import net.minecraft.item.Item;
import teamrapture.mobularmachinery.MobularMachinery;

public class ItemBase extends Item {

    public ItemBase(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(MobularMachinery.mobularTab);
    }
}
