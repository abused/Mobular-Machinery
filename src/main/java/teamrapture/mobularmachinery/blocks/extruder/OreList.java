package teamrapture.mobularmachinery.blocks.extruder;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OreList {

    public List<ItemStack> oreList = new ArrayList<>();

    public OreList() {
        for (String name : OreDictionary.getOreNames()) {
            if(name.startsWith("ore")) {
                for (ItemStack stack : OreDictionary.getOres(name)) {
                    if(!oreList.contains(stack)) {
                        oreList.add(stack);
                    }
                }
            }
        }
    }

    public ItemStack generateRandomOre() {
        Random rand = new Random();
        int count = oreList.size();
        int randSelection = rand.nextInt(count);

        return oreList.get(randSelection);
    }
}
