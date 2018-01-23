package teamrapture.mobularmachinery.client.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.client.model.ModelMechanicalChicken;
import teamrapture.mobularmachinery.entity.friendly.EntityMechanicalChicken;


@SideOnly(Side.CLIENT)
public class RenderMechanicalChicken extends RenderLiving<EntityMechanicalChicken>
{
    private static final ResourceLocation MECH_CHICKEN_TEXTURES = new ResourceLocation(Info.MODID, "textures/entity/mechanical_chicken.png");

    public RenderMechanicalChicken(RenderManager p_i47211_1_)
    {
        super(p_i47211_1_, new ModelMechanicalChicken(), 0.3F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityMechanicalChicken entity)
    {
        return MECH_CHICKEN_TEXTURES;
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityMechanicalChicken livingBase, float partialTicks)
    {
        float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
        float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
}