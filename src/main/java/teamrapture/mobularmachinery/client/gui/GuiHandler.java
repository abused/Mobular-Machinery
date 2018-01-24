package teamrapture.mobularmachinery.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import teamrapture.mobularmachinery.client.gui.container.ContainerHydroGen;
import teamrapture.mobularmachinery.client.gui.container.ContainerRegionalExtruder;
import teamrapture.mobularmachinery.client.gui.container.ContainerWaterVaporizer;
import teamrapture.mobularmachinery.tileentity.TileEntityHydroGen;
import teamrapture.mobularmachinery.tileentity.TileEntityWaterVaporizer;
import teamrapture.mobularmachinery.tileentity.extruder.TileEntityRegionalExtruder;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {

    public static final int HYDRO_GEN = 0;
    public static final int WATER_VAPORIZER = 1;
    public static final int REGIONAL_EXTRUDER = 2;

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        if (ID == HYDRO_GEN) {
            if (te instanceof TileEntityHydroGen) {
                return new ContainerHydroGen(player.inventory, (TileEntityHydroGen) te);
            }
        }

        if (ID == WATER_VAPORIZER) {
            if (te instanceof TileEntityWaterVaporizer) {
                return new ContainerWaterVaporizer(player.inventory, (TileEntityWaterVaporizer) te);
            }
        }

        if (ID == REGIONAL_EXTRUDER) {
            return new ContainerRegionalExtruder(player.inventory, (TileEntityRegionalExtruder) te);
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        if (ID == HYDRO_GEN) {
            if (te instanceof TileEntityHydroGen) {
                TileEntityHydroGen tileEntityHydroGen = (TileEntityHydroGen) te;
                return new GuiHydroGen(new ContainerHydroGen(player.inventory, tileEntityHydroGen), tileEntityHydroGen);
            }
        }

        if (ID == WATER_VAPORIZER) {
            if (te instanceof TileEntityWaterVaporizer) {
                TileEntityWaterVaporizer tileEntityWaterVaporizer = (TileEntityWaterVaporizer) te;
                return new GuiWaterVaporizer(new ContainerWaterVaporizer(player.inventory, tileEntityWaterVaporizer), tileEntityWaterVaporizer);
            }
        }

        if (ID == REGIONAL_EXTRUDER) {
            TileEntityRegionalExtruder tileEntityRegionalExtruder = (TileEntityRegionalExtruder) te;
            return new GuiRegionalExtruder(new ContainerRegionalExtruder(player.inventory, tileEntityRegionalExtruder), tileEntityRegionalExtruder);
        }
        return null;
    }
}
