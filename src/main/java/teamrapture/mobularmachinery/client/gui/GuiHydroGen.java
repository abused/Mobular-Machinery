package teamrapture.mobularmachinery.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.client.config.GuiUtils;
import org.lwjgl.opengl.GL11;
import teamrapture.mobularmachinery.Info;
import teamrapture.mobularmachinery.client.gui.container.ContainerHydroGen;
import teamrapture.mobularmachinery.tileentity.TileEntityHydroGen;

import java.util.ArrayList;
import java.util.List;

public class GuiHydroGen extends GuiContainer {

    public static ResourceLocation background = new ResourceLocation(Info.MODID, "textures/gui/hydro_gen.png");

    public static final int WIDTH = 176;
    public static final int HEIGHT = 166;
    TileEntityHydroGen tile;

    public GuiHydroGen(ContainerHydroGen containerMeatPacker, TileEntityHydroGen te) {
        super(containerMeatPacker);
        tile = (TileEntityHydroGen) te;
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
        renderFluid();

        GL11.glPushMatrix();
        this.fontRenderer.drawString("Generating", guiLeft + 91, guiTop + 20, 4210752);
        this.fontRenderer.drawString(tile.generationPerMB + " FU / 20mb", guiLeft + 91, guiTop + 30, 4210752);
        this.fontRenderer.drawString(tile.storage.getEnergyStored() + " / " + tile.storage.getMaxEnergyStored(), guiLeft + 91, guiTop + 40, 4210752);
        GL11.glScaled(1, 1.5, 1);
        GL11.glPopMatrix();

        if (this.isPointInRegion(32, 15, 14, 50, mouseX, mouseY)) {
            List<String> energy = new ArrayList<String>();
            energy.add(tile.storage.getEnergyStored() + " / " + tile.storage.getMaxEnergyStored() + "  FU");
            GuiUtils.drawHoveringText(energy, mouseX, mouseY, mc.displayWidth, mc.displayHeight, -1, mc.fontRenderer);
        }

        if (this.isPointInRegion(9, 15, 14, 50, mouseX, mouseY)) {
            List<String> fluid = new ArrayList<String>();
            fluid.add(tile.tank.getFluidAmount() + " / " + tile.tank.getCapacity() + "  MB");
            GuiUtils.drawHoveringText(fluid, mouseX, mouseY, mc.displayWidth, mc.displayHeight, -1, mc.fontRenderer);
        }
    }

    public void renderEnergy() {
        if (tile.storage.getEnergyStored() > 0) {
            int i = 48;
            int j = tile.storage.getEnergyStored() * i / tile.storage.getMaxEnergyStored();
            drawTexturedModalRect(guiLeft + 33, guiTop + 64 - j, 180, 49 - j, 12, j);
        }
    }

    public void renderFluid() {
        if(tile.tank != null && tile.tank.getFluidAmount() > 0) {
            int i = tile.tank.getFluidAmount() * 48 / tile.tank.getCapacity();
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            final int color = tile.tank.getFluid().getFluid().getColor();
            final int brightness = mc.world.getCombinedLight(new BlockPos(guiLeft + 10, guiTop + 7, 0), tile.tank.getFluid().getFluid().getLuminosity());
            final Minecraft mc = Minecraft.getMinecraft();
            final Tessellator tessellator = Tessellator.getInstance();
            final BufferBuilder buffer = tessellator.getBuffer();

            buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.BLOCK);
            mc.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            setupRenderState();

            final TextureAtlasSprite still = mc.getTextureMapBlocks().getTextureExtry(tile.tank.getFluid().getFluid().getStill().toString());
            addTexturedQuad(buffer, still, guiLeft + 10, guiTop + 64 - i, 12, i, color, brightness);

            tessellator.draw();

            cleanupRenderState();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    public static void setupRenderState() {
        GlStateManager.pushMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        if (Minecraft.isAmbientOcclusionEnabled()) {
            GL11.glShadeModel(GL11.GL_SMOOTH);
        }
        else {
            GL11.glShadeModel(GL11.GL_FLAT);
        }
    }

    public static void addTexturedQuad(BufferBuilder buffer, TextureAtlasSprite sprite, double x, double y, double width, double height, int color, int brightness) {
        if (sprite == null) {
            return;
        }

        final int firstLightValue = brightness >> 0x10 & 0xFFFF;
        final int secondLightValue = brightness & 0xFFFF;
        final int alpha = color >> 24 & 0xFF;
        final int red = color >> 16 & 0xFF;
        final int green = color >> 8 & 0xFF;
        final int blue = color & 0xFF;

        addTextureQuad(buffer, sprite, x, y, width, height, red, green, blue, alpha, firstLightValue, secondLightValue);
    }

    public static void addTextureQuad (BufferBuilder buffer, TextureAtlasSprite sprite, double x, double y, double width, double height, int red, int green, int blue, int alpha, int light1, int light2) {

        double minU;
        double maxU;
        double minV;
        double maxV;

        final double x2 = x + width;
        final double y2 = y + height;

        final double u = x % 1d;
        double u1 = u + width;

        while (u1 > 1f) {
            u1 -= 1f;
        }

        final double vy = y % 1d;
        double vy1 = vy + height;

        while (vy1 > 1f) {
            vy1 -= 1f;
        }

        minU = sprite.getMinU();
        maxU = sprite.getMaxU();
        minV = sprite.getMinV();
        maxV = sprite.getMaxV();

        buffer.pos(x, y, 0).color(red, green, blue, alpha).tex(minU, maxV).lightmap(light1, light2).endVertex();
        buffer.pos(x, y2, 0).color(red, green, blue, alpha).tex(minU, minV).lightmap(light1, light2).endVertex();
        buffer.pos(x2, y2, 0).color(red, green, blue, alpha).tex(maxU, minV).lightmap(light1, light2).endVertex();
        buffer.pos(x2, y, 0).color(red, green, blue, alpha).tex(maxU, maxV).lightmap(light1, light2).endVertex();
    }

    public static void cleanupRenderState() {
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        RenderHelper.enableStandardItemLighting();
    }
}
