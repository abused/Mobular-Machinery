package teamrapture.mobularmachinery.registry;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import teamrapture.mobularmachinery.blocks.HydroGen;
import teamrapture.mobularmachinery.blocks.photon.PhotonCell;
import teamrapture.mobularmachinery.blocks.photon.PhotonCore;
import teamrapture.mobularmachinery.client.render.PhotonCoreRender;
import teamrapture.mobularmachinery.items.ItemBase;
import teamrapture.mobularmachinery.tileentity.TileEntityHydroGen;
import teamrapture.mobularmachinery.tileentity.TileEntityPhotonCell;
import teamrapture.mobularmachinery.tileentity.TileEntityPhotonCore;

public class ModResources {

    public static Item itemGear = new ItemBase("item_gear");
    public static Block blockHydro = new HydroGen();
    public static Block blockPhotonCore = new PhotonCore();
    public static Block blockPhotonCell = new PhotonCell();

    public static void registerResources() {
        reg(itemGear);
        reg(blockHydro);
        reg(blockPhotonCore);
        reg(blockPhotonCell);
    }

    public static void registerRenders() {
        regRender(itemGear);
        regRender(blockPhotonCore);
        regRender(blockPhotonCell);
    }

    public static void registerTE() {
        GameRegistry.registerTileEntity(TileEntityHydroGen.class, "tile_hydro_gen");
        GameRegistry.registerTileEntity(TileEntityPhotonCore.class, "tile_photon_core");
        GameRegistry.registerTileEntity(TileEntityPhotonCell.class, "tile_photon_cell");
    }

    public static void registerTESR() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPhotonCore.class, new PhotonCoreRender());
    }

    public static void regRender(Object object) {
        if(object instanceof Block) {
            ModelResourceLocation res = new ModelResourceLocation(((Block) object).getRegistryName().toString(), "inventory");
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock((Block) object), 0, res);
        }else if(object instanceof Item) {
            ModelResourceLocation res = new ModelResourceLocation(((Item) object).getRegistryName().toString(), "inventory");
            ModelLoader.setCustomModelResourceLocation((Item) object, 0, res);
        }
    }

    public static void reg(Object object) {
        if(object instanceof Block) {
            ForgeRegistries.BLOCKS.register((Block) object);
            ForgeRegistries.ITEMS.register(new ItemBlock((Block) object).setRegistryName(((Block) object).getRegistryName()));
        }else if(object instanceof Item) {
            ForgeRegistries.ITEMS.register((Item) object);
        }
    }
}
