package teamrapture.mobularmachinery.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import teamrapture.mobularmachinery.MobularMachinery;
import teamrapture.mobularmachinery.client.gui.GuiHandler;
import teamrapture.mobularmachinery.registry.ModResources;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        ModResources.registerResources();
    }

    public void init(FMLInitializationEvent e) {
        ModResources.registerTE();
        NetworkRegistry.INSTANCE.registerGuiHandler(MobularMachinery.instance, new GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent e) {
    }
}
