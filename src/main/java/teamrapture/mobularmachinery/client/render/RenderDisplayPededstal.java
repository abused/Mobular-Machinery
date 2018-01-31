package teamrapture.mobularmachinery.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import teamrapture.mobularmachinery.tileentity.TileEntityDisplayPedestal;

public class RenderDisplayPededstal extends TileEntitySpecialRenderer<TileEntityDisplayPedestal> {

    @Override
    public void render(TileEntityDisplayPedestal te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        {
            if (!te.stack.isEmpty()) {
                GlStateManager.translate(x + 0.5, y + 0.5, z + 0.5);
                GlStateManager.scale(0.7, 0.7, 0.7);
                long angle = (System.currentTimeMillis() / 10) % 360;
                GlStateManager.rotate(angle, 0, 1, 0);
                Minecraft.getMinecraft().getRenderItem().renderItem(te.stack, ItemCameraTransforms.TransformType.GROUND);
            }
        }
        GlStateManager.popMatrix();
    }
}
