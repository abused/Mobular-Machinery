package teamrapture.mobularmachinery.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import teamrapture.mobularmachinery.registry.ModResources;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        ModResources.registerResources();
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }
}
