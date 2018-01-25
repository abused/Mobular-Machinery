package teamrapture.mobularmachinery.client.gui.manual;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import teamrapture.mobularmachinery.Info;

public class ButtonIndex extends GuiButton {

    public static final ResourceLocation MANUAL_GUI = new ResourceLocation(Info.MODID, "textures/gui/manual_gui.png");
    int xSize, ySize;

    public ButtonIndex(int buttonId, int x, int y, int width, int height, String buttonText) {
        super(buttonId, x, y, width, height, buttonText);
        xSize = 69;
        ySize = 28;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        FontRenderer fontrenderer = mc.fontRenderer;
        int j = 14737632;
        mc.getTextureManager().bindTexture(MANUAL_GUI);
        drawTexturedModalRect(x, y, 0, 170, xSize, ySize);
        this.drawCenteredString(fontrenderer, this.displayString, this.x + this.width / 2, this.y + (this.height - 8) / 2, j);
    }
}