package teamrapture.mobularmachinery.client.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.client.model.ModelMechSpiderBoss;
import teamrapture.mobularmachinery.entity.boss.EntityMechSpiderBoss;


@SideOnly(Side.CLIENT)
public class RenderMechSpiderBoss extends RenderLiving<EntityMechSpiderBoss>{

	 private static final ResourceLocation SPIDY_TEXTURES = new ResourceLocation(Info.MODID, "textures/entity/spidy_boss.png");

	    public RenderMechSpiderBoss(RenderManager render)
	    {
	        super(render, new ModelMechSpiderBoss(), 1.0F);
	    }

	    /**
	     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	     */
	    protected ResourceLocation getEntityTexture(EntityMechSpiderBoss entity)
	    {
	        return SPIDY_TEXTURES;
	    }

}