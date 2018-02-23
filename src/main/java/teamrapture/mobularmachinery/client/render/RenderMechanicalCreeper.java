package teamrapture.mobularmachinery.client.render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.client.model.ModelMechanicalCreeper;
import teamrapture.mobularmachinery.client.model.layer.LayerMechCreeperCharge;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalCreeper;

@SideOnly(Side.CLIENT)
public class RenderMechanicalCreeper extends RenderLiving<EntityMechanicalCreeper> {
	private static final ResourceLocation CREEPER_TEXTURES = new ResourceLocation(Info.MODID,
			"textures/entity/creeper/mechanical_creeper.png");

	public RenderMechanicalCreeper(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelMechanicalCreeper(), 0.5F);
		this.addLayer(new LayerMechCreeperCharge(this));
	}

	/**
	 * Allows the render to do state modifications necessary before the model is
	 * rendered.
	 */
	protected void preRenderCallback(EntityMechanicalCreeper entitylivingbaseIn, float partialTickTime) {
		float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
		float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
		f = MathHelper.clamp(f, 0.0F, 1.0F);
		f = f * f;
		f = f * f;
		float f2 = (1.0F + f * 0.8F) * f1;
		float f3 = (1.0F + f * 0.4F) / f1;
		GlStateManager.scale(f2, f3, f2);
	}

	/**
	 * Gets an RGBA int color multiplier to apply.
	 */
	protected int getColorMultiplier(EntityMechanicalCreeper entitylivingbaseIn, float lightBrightness,
			float partialTickTime) {
		float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);

		if ((int) (f * 10.0F) % 2 == 0) {
			return 0;
		} else {
			int i = (int) (f * 0.2F * 255.0F);
			i = MathHelper.clamp(i, 0, 255);
			return i << 10 | 822083583;
		}
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityMechanicalCreeper entity) {
		return CREEPER_TEXTURES;
	}
}