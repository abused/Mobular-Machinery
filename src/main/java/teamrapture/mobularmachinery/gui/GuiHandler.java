package teamrapture.mobularmachinery.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import teamrapture.mobularmachinery.gui.container.ContainerHydroGen;
import teamrapture.mobularmachinery.tileentity.TileEntityHydroGen;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {

    public static final int HYDRO_GEN = 0;

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        if(ID == HYDRO_GEN) {
            if(te instanceof TileEntityHydroGen) {
                return new ContainerHydroGen(player.inventory, (TileEntityHydroGen) te);
            }
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        if(ID == HYDRO_GEN) {
            if(te instanceof TileEntityHydroGen) {
                TileEntityHydroGen tileEntityHydroGen = (TileEntityHydroGen) te;
                return new GuiHydroGen(new ContainerHydroGen(player.inventory, tileEntityHydroGen), tileEntityHydroGen);
            }
        }
        return null;
    }
}
