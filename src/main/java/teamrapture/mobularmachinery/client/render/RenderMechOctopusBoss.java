package teamrapture.mobularmachinery.client.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.client.model.ModelMechOctopusBoss;
import teamrapture.mobularmachinery.entity.boss.EntityMechOctopusBoss;
@SideOnly(Side.CLIENT)
public class RenderMechOctopusBoss extends RenderLiving<EntityMechOctopusBoss>{

	 private static final ResourceLocation OCTO_TEXTURES = new ResourceLocation(Info.MODID, "textures/entity/octo_boss.png");

	    public RenderMechOctopusBoss(RenderManager render)
	    {
	        super(render, new ModelMechOctopusBoss(), 1.0F);
	    }

	    /**
	     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	     */
	    protected ResourceLocation getEntityTexture(EntityMechOctopusBoss entity)
	    {
	        return OCTO_TEXTURES;
	    }

}
