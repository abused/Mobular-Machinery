package teamrapture.mobularmachinery.proxy;

import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import teamrapture.mobularmachinery.MobularMachinery;
import teamrapture.mobularmachinery.capabilities.IWeaponHolder;
import teamrapture.mobularmachinery.capabilities.SteamCapabilities;
import teamrapture.mobularmachinery.capabilities.steamstorage.SteamStorage;
import teamrapture.mobularmachinery.client.gui.GuiHandler;
import teamrapture.mobularmachinery.entity.ModEntities;
import teamrapture.mobularmachinery.registry.ModResources;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        ModResources.registerResources();
        ModEntities.init();
        CapabilityManager.INSTANCE.register(IWeaponHolder.class, new SteamCapabilities.CapabilitySteamHolder<>(), SteamStorage.class);
		
    }

    public void init(FMLInitializationEvent e) {
        ModResources.registerTE();
        NetworkRegistry.INSTANCE.registerGuiHandler(MobularMachinery.instance, new GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent e) {
    }
}
