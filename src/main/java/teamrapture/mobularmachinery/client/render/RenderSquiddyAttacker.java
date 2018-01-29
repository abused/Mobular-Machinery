package teamrapture.mobularmachinery.client.render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.client.model.ModelMechOctopusBoss;
import teamrapture.mobularmachinery.entity.monster.EntitySquiddyAttacker;

@SideOnly(Side.CLIENT)
public class RenderSquiddyAttacker extends Render<EntitySquiddyAttacker> {
	private static final ResourceLocation Octo_TEXTURES = new ResourceLocation(Info.MODID, "textures/entity/octo_boss.png");

	private final ModelMechOctopusBoss modelMechOctopusBoss = new ModelMechOctopusBoss();

	public RenderSquiddyAttacker(RenderManager renderManagerIn) {
		super(renderManagerIn);
	}

	private float getRenderYaw(float prevRotationYaw, float rotationYaw, float partialTicks) {
		float f;

		f = rotationYaw - prevRotationYaw;
		while (f < -180.0F) {

			f += 360.0F;
		}

		while (f >= 180.0F) {
			f -= 360.0F;
		}

		return prevRotationYaw + partialTicks * f;
	}

	/**
	 * Renders the desired {@code T} type Entity.
	 */
	@Override
	public void doRender(EntitySquiddyAttacker entity, double x, double y, double z, float entityYaw,
			float partialTicks) {
		GlStateManager.pushMatrix();
		GlStateManager.disableCull();
		float f = this.getRenderYaw(entity.prevRotationYaw, entity.rotationYaw, partialTicks);
		float f1 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks;
		GlStateManager.translate((float) x, (float) y, (float) z);
		GlStateManager.enableRescaleNormal();
		GlStateManager.scale(-0.5F, -0.5F, 0.5F);
		GlStateManager.enableAlpha();
		this.bindEntityTexture(entity);

		if (this.renderOutlines) {
			GlStateManager.enableColorMaterial();
			GlStateManager.enableOutlineMode(this.getTeamColor(entity));
		}

		this.modelMechOctopusBoss.render(entity, 0.0F, 0.0F, 0.0F, f, f1, 0.0625F);

		if (this.renderOutlines) {
			GlStateManager.disableOutlineMode();
			GlStateManager.disableColorMaterial();
		}

		GlStateManager.popMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(EntitySquiddyAttacker entity) {
		return Octo_TEXTURES;
	}
}
