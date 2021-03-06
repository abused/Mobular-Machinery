package teamrapture.mobularmachinery.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.entity.nonliving.EntityMechEgg;
import teamrapture.mobularmachinery.registry.ModResources;

public class RenderMechEgg extends Render<EntityMechEgg> {

	protected final Item item;
	private final RenderItem itemRenderer;

	public RenderMechEgg(RenderManager renderManager, Item itemIn) {
		super(renderManager);
		this.item = itemIn;
		this.itemRenderer = Minecraft.getMinecraft().getRenderItem();
	}

	private static final ResourceLocation MECH_EGG_TEXTURES = new ResourceLocation(Info.MODID,
			"textures/items/item_mechanized_egg.png");

	protected ResourceLocation getEntityTexture(EntityMechEgg entity) {
		return MECH_EGG_TEXTURES;
	}

	/**
	 * Renders the desired {@code T} type Entity.
	 */
	@Override
	public void doRender(EntityMechEgg entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x, (float) y, (float) z);
		GlStateManager.enableRescaleNormal();
		GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(
				(float) (this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX,
				1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

		if (this.renderOutlines) {
			GlStateManager.enableColorMaterial();
			GlStateManager.enableOutlineMode(this.getTeamColor(entity));
		}

		this.itemRenderer.renderItem(this.getStackToRender(entity), ItemCameraTransforms.TransformType.GROUND);

		if (this.renderOutlines) {
			GlStateManager.disableOutlineMode();
			GlStateManager.disableColorMaterial();
		}

		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	private ItemStack getStackToRender(EntityMechEgg entity) {
		return new ItemStack(ModResources.itemMechanizedEgg);
	}
}
