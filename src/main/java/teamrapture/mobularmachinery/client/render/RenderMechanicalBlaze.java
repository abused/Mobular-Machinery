package teamrapture.mobularmachinery.client.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.client.model.ModelMechanicalBlaze;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalBlaze;

@SideOnly(Side.CLIENT)
public class RenderMechanicalBlaze extends RenderLiving<EntityMechanicalBlaze> {
	private static final ResourceLocation MECH_BLAZE_TEXTURES = new ResourceLocation(Info.MODID,
			"textures/entity/mechanical_blaze.png");

	public RenderMechanicalBlaze(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelMechanicalBlaze(), 0.5F);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityMechanicalBlaze entity) {
		return MECH_BLAZE_TEXTURES;
	}
}
