package teamrapture.mobularmachinery.client.gui.manual;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import teamrapture.mobularmachinery.Info;

public class ButtonForward extends GuiButton {

    public static final ResourceLocation MANUAL_GUI = new ResourceLocation(Info.MODID, "textures/gui/manual_gui.png");
    int xSize, ySize;

    public ButtonForward(int buttonId, int x, int y, int width, int height, String buttonText) {
        super(buttonId, x, y, width, height, buttonText);
        xSize = 25;
        ySize = 13;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        mc.getTextureManager().bindTexture(MANUAL_GUI);
        drawTexturedModalRect(x, y, 70, 168, xSize, ySize);
    }
}