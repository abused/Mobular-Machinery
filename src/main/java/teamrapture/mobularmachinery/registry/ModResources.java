package teamrapture.mobularmachinery.registry;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import teamrapture.mobularmachinery.items.ItemBase;

public class ModResources {

    public static Item itemGear = new ItemBase("item_gear");

    public static void registerResources() {
        reg(itemGear);
    }

    public static void registerRenders() {
        regRender(itemGear);
    }

    public static void regRender(Object object) {
        if(object instanceof Block) {
            ModelResourceLocation res = new
                    ModelResourceLocation(((Block) object).getRegistryName().toString(), "inventory");
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock((Block) object), 0, res);
        }else if(object instanceof Item) {
            ModelResourceLocation res = new ModelResourceLocation(((Item) object).getRegistryName().toString(), "inventory");
            ModelLoader.setCustomModelResourceLocation((Item) object, 0, res);
        }
    }

    public static void reg(Object object) {
        if(object instanceof Block) {
            ForgeRegistries.BLOCKS.register((Block) object);
            ForgeRegistries.ITEMS.register(new ItemBlock((Block) object).setRegistryName(((Block) object).getRegistryName()));
        }else if(object instanceof Item) {
            ForgeRegistries.ITEMS.register((Item) object);
        }
    }
}
