package teamrapture.mobularmachinery;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import teamrapture.mobularmachinery.proxy.CommonProxy;

@Mod(modid = Info.MODID, name = Info.NAME, version = Info.VERSION, acceptedMinecraftVersions = Info.ACCEPTED_VERSIONS)
public class MobularMachinery {

    @Mod.Instance(Info.MODID)
    public static MobularMachinery instance;

    @SidedProxy(clientSide = "teamrapture.mobularmachinery.proxy.ClientProxy", serverSide = "teamrapture.mobularmachinery.proxy.CommonProxy")
    static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    public static CreativeTabs mobularTab = new CreativeTabs("MobularTab") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.SPAWN_EGG);
        }
    };
}
