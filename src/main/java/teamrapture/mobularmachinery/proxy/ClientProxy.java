package teamrapture.mobularmachinery.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import teamrapture.mobularmachinery.client.render.RenderMechanicalChicken;
import teamrapture.mobularmachinery.entity.ModEntities;
import teamrapture.mobularmachinery.entity.friendly.EntityMechanicalChicken;
import teamrapture.mobularmachinery.registry.ModResources;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

	private static final Minecraft MC = Minecraft.getMinecraft();

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModResources.registerTESR();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        RenderManager rm = Minecraft.getMinecraft().getRenderManager();
		rm.entityRenderMap.put(EntityMechanicalChicken.class, new RenderMechanicalChicken(rm));
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModResources.registerRenders();
    }
}
