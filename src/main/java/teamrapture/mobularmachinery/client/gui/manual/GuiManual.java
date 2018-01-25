package teamrapture.mobularmachinery.client.gui.manual;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import teamrapture.mobularmachinery.Info;

import java.io.IOException;

public class GuiManual extends GuiScreen {

    public static final ResourceLocation MANUAL_GUI = new ResourceLocation(Info.MODID, "textures/gui/manual_gui.png");
    int xSize, ySize, guiLeft, guiTop;
    String indexText = I18n.format("mobularmachinery.format.text").replace("&", "\u00a7");
    String machinesText = I18n.format("format.machines").replace("&", "\u00a7");
    String mobsText = I18n.format("format.mobs").replace("&", "\u00a7");
    private ButtonIndex indexButton, mobsButton, machinesButton, githubButton;
    private int mainPages = 0;
    private int machinePages = 0;
    private int mobPages = 0;

    @Override
    public void initGui() {
        xSize = 256;
        ySize = 167;
        guiLeft = (width - xSize) / 2;
        guiTop = (height - ySize) / 2;

        String index = I18n.format("Home").replace("&", "\u00a7");
        String machines = I18n.format("Machines").replace("&", "\u00a7");
        String mobs = I18n.format("Mobs").replace("&", "\u00a7");
        String github = I18n.format("github").replace("&", "\u00a7");

        buttonList.add(this.indexButton = new ButtonIndex(0, guiLeft + 3, guiTop + 5, 69, 28, index));
        buttonList.add(this.machinesButton = new ButtonIndex(1, guiLeft + 3, guiTop + 30, 69, 28, machines));
        buttonList.add(this.mobsButton = new ButtonIndex(2, guiLeft + 3, guiTop + 55, 69, 28, mobs));
        buttonList.add(this.mobsButton = new ButtonIndex(2, guiLeft + 3, guiTop + 55, 69, 28, mobs));
        buttonList.add(this.githubButton = new ButtonIndex(3, guiLeft + 3, guiTop + 80, 69, 28, github));

        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        GlStateManager.color(1F, 1F, 1F);
        mc.getTextureManager().bindTexture(MANUAL_GUI);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);


        if(mainPages == 0) {
            String index = "&b&nMobular Machinery Manual";
            int centered = (74 / 2) - (index.length() / 2);
            mc.fontRenderer.drawString(I18n.format(index).replace("&", "\u00a7"), guiLeft + 75 + centered, guiTop + 14, 0xFFFFFF);
            TextHelper.renderText(guiLeft + 84, guiTop + 42, 172, indexText, false, true);
        }else if(mainPages == 1) {
            String machines = "&b&nMobular Machinery Machines";
            int centered = (74 / 2) - (machines.length() / 2);
            mc.fontRenderer.drawString(I18n.format(machines).replace("&", "\u00a7"), guiLeft + 75 + centered, guiTop + 14, 0xFFFFFF);
            TextHelper.renderText(guiLeft + 84, guiTop + 42, 172, machinesText, false, true);
        }else if(mainPages == 2) {
            String mobs = "&b&nMobular Machinery Mobs";
            int centered = (74 / 2) - (mobs.length() / 2);
            mc.fontRenderer.drawString(I18n.format(mobs).replace("&", "\u00a7"), guiLeft + 75 + centered, guiTop + 14, 0xFFFFFF);
            TextHelper.renderText(guiLeft + 84, guiTop + 42, 172, mobsText, false, true);
        }else {
            mainPages = 0;
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    public void actionPerformed(GuiButton button) throws IOException {
        if(button == indexButton)
            mainPages = 0;

        if(button == machinesButton)
            mainPages = 1;

        if(button == mobsButton)
            mainPages = 2;

        if(button == githubButton)
            Minecraft.getMinecraft().displayGuiScreen(new GuiConfirmOpenLink(this, "https://github.com/abused/mobular-machinery", 1, true));
    }
}
