package teamrapture.mobularmachinery.client.render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.client.model.ModelMechOctopusBossMini;
import teamrapture.mobularmachinery.entity.monster.EntitySquiddyAttackers;

public class RenderSquiddyAttackers extends RenderLiving<EntitySquiddyAttackers> {

	private static final ResourceLocation OCTO_TEXTURES = new ResourceLocation(Info.MODID,
			"textures/entity/octo_boss.png");

	public RenderSquiddyAttackers(RenderManager render) {
		super(render, new ModelMechOctopusBossMini(), 1.0F);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntitySquiddyAttackers entity) {
		return OCTO_TEXTURES;
	}
	 @Override
	    protected void preRenderCallback(EntitySquiddyAttackers entityLivingBaseIn, float partialTickTime) {
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	    }
}
