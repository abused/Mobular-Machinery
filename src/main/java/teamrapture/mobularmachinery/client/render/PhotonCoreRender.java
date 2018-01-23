package teamrapture.mobularmachinery.client.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import teamrapture.mobularmachinery.tileentity.TileEntityPhotonCore;
import teamrapture.mobularmachinery.utils.hud.HudRender;

public class PhotonCoreRender extends TileEntitySpecialRenderer<TileEntityPhotonCore> {

    @Override
    public void render(TileEntityPhotonCore te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        super.render(te, x, y, z, partialTicks, destroyStage, alpha);

        HudRender.renderHud(te, x, y, z);
    }
}
