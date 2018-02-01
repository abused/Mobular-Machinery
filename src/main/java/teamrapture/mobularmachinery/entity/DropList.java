package teamrapture.mobularmachinery.entity;

import net.minecraft.item.ItemStack;
import teamrapture.mobularmachinery.registry.ModResources;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DropList {

    public List<ItemStack> list = new ArrayList<>();

    public DropList() {
        list.add(new ItemStack(ModResources.itemCoil));
        list.add(new ItemStack(ModResources.itemGear));
    }

    public ItemStack generateRandomItem() {
        Random rand = new Random();
        int count = list.size();
        int randSelection = rand.nextInt(count);

        return list.get(randSelection);
    }
}
