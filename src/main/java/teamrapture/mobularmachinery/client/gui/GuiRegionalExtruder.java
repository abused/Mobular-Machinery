package teamrapture.mobularmachinery.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.config.GuiUtils;
import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.client.gui.container.ContainerRegionalExtruder;
import teamrapture.mobularmachinery.tileentity.extruder.TileEntityRegionalExtruder;

import java.util.ArrayList;
import java.util.List;

public class GuiRegionalExtruder extends GuiContainer {

    public static ResourceLocation background = new ResourceLocation(Info.MODID, "textures/gui/regional_extruder.png");

    public static final int WIDTH = 176;
    public static final int HEIGHT = 166;
    TileEntityRegionalExtruder tile;

    public GuiRegionalExtruder(ContainerRegionalExtruder container, TileEntityRegionalExtruder te) {
        super(container);
        tile = (TileEntityRegionalExtruder) te;
        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        renderEnergy();
        renderWork();

        if (this.isPointInRegion(9, 9, 50, 14, mouseX, mouseY)) {
            List<String> energy = new ArrayList<String>();
            energy.add(tile.storage.getEnergyStored() + " / " + tile.storage.getMaxEnergyStored() + "  FE");
            GuiUtils.drawHoveringText(energy, mouseX, mouseY, mc.displayWidth, mc.displayHeight, -1, mc.fontRenderer);
        }

        if (this.isPointInRegion(117, 12, 50, 7, mouseX, mouseY)) {
            List<String> fluid = new ArrayList<String>();
            fluid.add(tile.workTime + " / 50  Work");
            GuiUtils.drawHoveringText(fluid, mouseX, mouseY, mc.displayWidth, mc.displayHeight, -1, mc.fontRenderer);
        }
    }

    public void renderEnergy() {
        if (tile.storage.getEnergyStored() > 0) {
            int i = 48;
            int j = tile.storage.getEnergyStored() * i / tile.storage.getMaxEnergyStored();
            drawTexturedModalRect(guiLeft + 10, guiTop + 10, 178, 2, j, 12);
        }
    }

    public void renderWork() {
        if (tile.workTime > 0) {
            int i = 48;
            int j = tile.workTime * i / 50;
            drawTexturedModalRect(guiLeft + 118, guiTop + 13, 178, 15, j, 5);
        }
    }
}
