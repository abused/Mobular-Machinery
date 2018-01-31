package teamrapture.mobularmachinery.client.render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.client.model.ModelMechanicalGhast;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalGhast;

@SideOnly(Side.CLIENT)
public class RenderMechanicalGhast extends RenderLiving<EntityMechanicalGhast>
{
    private static final ResourceLocation GHAST_TEXTURES = new ResourceLocation(Info.MODID,"textures/entity/mechanical_ghast.png");
    private static final ResourceLocation GHAST_SHOOTING_TEXTURES = new ResourceLocation(Info.MODID,"textures/entity/mechanical_ghast_shooting.png");

    public RenderMechanicalGhast(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelMechanicalGhast(), 0.5F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityMechanicalGhast entity)
    {
        return entity.isAttacking() ? GHAST_SHOOTING_TEXTURES : GHAST_TEXTURES;
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityMechanicalGhast entitylivingbaseIn, float partialTickTime)
    {
        float f = 1.0F;
        float f1 = 4.5F;
        float f2 = 4.5F;
        GlStateManager.scale(4.5F, 4.5F, 4.5F);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
