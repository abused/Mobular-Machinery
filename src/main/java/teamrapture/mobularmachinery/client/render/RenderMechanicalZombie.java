package teamrapture.mobularmachinery.client.render;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.client.model.ModelMechanicalZombie;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalZombie;

@SideOnly(Side.CLIENT)
public class RenderMechanicalZombie extends RenderBiped<EntityMechanicalZombie> {
	private static final ResourceLocation MECH_ZOMBIE_TEXTURES = new ResourceLocation(Info.MODID,
			"textures/entity/mechanical_zombie.png");

	public RenderMechanicalZombie(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelMechanicalZombie(), 0.5F);
		LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this) {
			protected void initArmor() {
				this.modelLeggings = new ModelMechanicalZombie(0.5F, true);
				this.modelArmor = new ModelMechanicalZombie(1.0F, true);
			}
		};
		this.addLayer(layerbipedarmor);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityMechanicalZombie entity) {
		return MECH_ZOMBIE_TEXTURES;
	}
}
