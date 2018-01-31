package teamrapture.mobularmachinery.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import teamrapture.mobularmachinery.tileentity.extruder.TileEntityRegionalExtruder;

public class RenderRegionalExtruder extends TileEntitySpecialRenderer<TileEntityRegionalExtruder> {

    @Override
    public void render(TileEntityRegionalExtruder te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        {
            if (!te.inventory.getStackInSlot(0).isEmpty()) {
                GlStateManager.translate(x + 0.5, y + 0.5, z + 0.5);
                GlStateManager.scale(0.7, 0.7, 0.7);
                long angle = (System.currentTimeMillis() / 10) % 360;
                GlStateManager.rotate(angle, 0, 1, 0);
                Minecraft.getMinecraft().getRenderItem().renderItem(te.inventory.getStackInSlot(0), ItemCameraTransforms.TransformType.GROUND);
            }
        }
        GlStateManager.popMatrix();
    }
}
