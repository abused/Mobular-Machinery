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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.entity.nonliving.EntityStringShot;
import teamrapture.mobularmachinery.registry.ModResources;

@SideOnly(Side.CLIENT)
public class RenderStringShot extends Render<EntityStringShot>{
	 protected final Item item;
	    private final RenderItem itemRenderer;

	    public RenderStringShot(RenderManager renderManager, Item itemIn) {
	        super(renderManager);
	        this.item = itemIn;
	        this.itemRenderer = Minecraft.getMinecraft().getRenderItem();
	    }

	    private static final ResourceLocation STEAM_TEXTURES = new ResourceLocation(Info.MODID,
	            "textures/items/item_wiring.png");

	    protected ResourceLocation getEntityTexture(EntityStringShot entity) {
	        return STEAM_TEXTURES;
	    }

	    /**
	     * Renders the desired {@code T} type Entity.
	     */
	    @Override
	    public void doRender(EntityStringShot entity, double x, double y, double z, float entityYaw,
	                         float partialTicks) {
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

	private ItemStack getStackToRender(EntityStringShot entity) {
	        return new ItemStack(ModResources.itemWiring);
	    }
}
