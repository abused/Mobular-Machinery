package teamrapture.mobularmachinery;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import teamrapture.mobularmachinery.capabilities.SteamCapabilities;
import teamrapture.mobularmachinery.capabilities.steamstorage.SteamStorage;
import teamrapture.mobularmachinery.capabilities.steamstorage.SteamStorageProvider;
import teamrapture.mobularmachinery.proxy.CommonProxy;
import teamrapture.mobularmachinery.registry.ConfigHandler;
import teamrapture.mobularmachinery.registry.ModResources;

@Mod(modid = Info.MODID, name = Info.NAME, version = Info.VERSION, acceptedMinecraftVersions = Info.ACCEPTED_VERSIONS)
public class MobularMachinery {

    @Mod.Instance
    public static MobularMachinery instance;

    @SidedProxy(clientSide = "teamrapture.mobularmachinery.proxy.ClientProxy", serverSide = "teamrapture.mobularmachinery.proxy.CommonProxy")
    static CommonProxy proxy;

    static {
        FluidRegistry.enableUniversalBucket();
    }

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
            return new ItemStack(ModResources.itemGear);
        }
    };
    @Mod.EventBusSubscriber(modid = Info.MODID)
	public static class Handler {

		@SubscribeEvent
		public static void caps(AttachCapabilitiesEvent event) {
			if (event.getObject() instanceof EntityPlayer) {
				event.addCapability(new ResourceLocation(Info.MODID, "steam"), new SteamStorageProvider(SteamStorage.create(ConfigHandler.steamMaxAmount, Long.MAX_VALUE, Long.MAX_VALUE)));
			}
		}

		@SubscribeEvent
		public static void clone(PlayerEvent.Clone event) {
			if (event.isWasDeath()) {
				EntityPlayer dead = event.getOriginal();
				EntityPlayer alive = event.getEntityPlayer();

				if (dead.hasCapability(SteamCapabilities.STEAM, null) && alive.hasCapability(SteamCapabilities.STEAM, null)) alive.getCapability(SteamCapabilities.STEAM, null).deserializeNBT(dead.getCapability(SteamCapabilities.STEAM, null).serializeNBT());
			}
		}

	}
}
