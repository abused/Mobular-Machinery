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
import teamrapture.mobularmachinery.client.render.RenderMechEgg;
import teamrapture.mobularmachinery.client.render.RenderMechOctopusBoss;
import teamrapture.mobularmachinery.client.render.RenderMechSpiderBoss;
import teamrapture.mobularmachinery.client.render.RenderMechanicalBlaze;
import teamrapture.mobularmachinery.client.render.RenderMechanicalChicken;
import teamrapture.mobularmachinery.client.render.RenderMechanicalCreeper;
import teamrapture.mobularmachinery.client.render.RenderMechanicalGhast;
import teamrapture.mobularmachinery.client.render.RenderMechanicalZombie;
import teamrapture.mobularmachinery.client.render.RenderSquiddyAttacker;
import teamrapture.mobularmachinery.client.render.RenderSquiddyAttackers;
import teamrapture.mobularmachinery.client.render.RenderSteamStream;
import teamrapture.mobularmachinery.client.render.RenderStringShot;
import teamrapture.mobularmachinery.entity.boss.EntityMechOctopusBoss;
import teamrapture.mobularmachinery.entity.boss.EntityMechSpiderBoss;
import teamrapture.mobularmachinery.entity.friendly.EntityMechanicalChicken;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalBlaze;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalCreeper;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalGhast;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalZombie;
import teamrapture.mobularmachinery.entity.monster.EntitySquiddyAttacker;
import teamrapture.mobularmachinery.entity.monster.EntitySquiddyAttackers;
import teamrapture.mobularmachinery.entity.nonliving.EntityMechEgg;
import teamrapture.mobularmachinery.entity.nonliving.EntitySteamStream;
import teamrapture.mobularmachinery.entity.nonliving.EntityStringShot;
import teamrapture.mobularmachinery.registry.ModResources;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

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
		rm.entityRenderMap.put(EntityMechOctopusBoss.class, new RenderMechOctopusBoss(rm));
		rm.entityRenderMap.put(EntitySquiddyAttacker.class, new RenderSquiddyAttacker(rm));
		rm.entityRenderMap.put(EntitySteamStream.class, new RenderSteamStream(rm, ModResources.itemSteamDummyItem));
		rm.entityRenderMap.put(EntitySquiddyAttackers.class, new RenderSquiddyAttackers(rm));
		rm.entityRenderMap.put(EntityMechanicalGhast.class, new RenderMechanicalGhast(rm));
		rm.entityRenderMap.put(EntityMechanicalZombie.class, new RenderMechanicalZombie(rm));
		rm.entityRenderMap.put(EntityMechEgg.class, new RenderMechEgg(rm, ModResources.itemMechanizedEgg));
		rm.entityRenderMap.put(EntityMechSpiderBoss.class, new RenderMechSpiderBoss(rm));
		rm.entityRenderMap.put(EntityStringShot.class, new RenderStringShot(rm, ModResources.itemMechanizedEgg));
		rm.entityRenderMap.put(EntityMechanicalCreeper.class, new RenderMechanicalCreeper(rm));
		rm.entityRenderMap.put(EntityMechanicalBlaze.class, new RenderMechanicalBlaze(rm));

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
