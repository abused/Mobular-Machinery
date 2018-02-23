package teamrapture.mobularmachinery.registry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.blocks.DisplayPedestal;
import teamrapture.mobularmachinery.blocks.EnergyRelay;
import teamrapture.mobularmachinery.blocks.FluidSteam;
import teamrapture.mobularmachinery.blocks.GearBlock;
import teamrapture.mobularmachinery.blocks.HydroGen;
import teamrapture.mobularmachinery.blocks.MechanicalString;
import teamrapture.mobularmachinery.blocks.WaterVaporizer;
import teamrapture.mobularmachinery.blocks.extruder.ExtruderFrame;
import teamrapture.mobularmachinery.blocks.extruder.ExtruderInventory;
import teamrapture.mobularmachinery.blocks.extruder.ExtruderTap;
import teamrapture.mobularmachinery.blocks.extruder.RegionalExtruder;
import teamrapture.mobularmachinery.blocks.photon.PhotonCell;
import teamrapture.mobularmachinery.blocks.photon.PhotonCore;
import teamrapture.mobularmachinery.client.render.RenderDisplayPededstal;
import teamrapture.mobularmachinery.client.render.RenderPhotonCore;
import teamrapture.mobularmachinery.client.render.RenderRegionalExtruder;
import teamrapture.mobularmachinery.items.ItemBase;
import teamrapture.mobularmachinery.items.ItemLinker;
import teamrapture.mobularmachinery.items.ItemManual;
import teamrapture.mobularmachinery.items.ItemMechanizedEgg;
import teamrapture.mobularmachinery.items.ItemSteamCreative;
import teamrapture.mobularmachinery.items.ItemSteamGun;
import teamrapture.mobularmachinery.items.ItemSteamTank;
import teamrapture.mobularmachinery.items.ItemSteamTankChecker;
import teamrapture.mobularmachinery.tileentity.TileEntityDisplayPedestal;
import teamrapture.mobularmachinery.tileentity.TileEntityEnergyRelay;
import teamrapture.mobularmachinery.tileentity.TileEntityHydroGen;
import teamrapture.mobularmachinery.tileentity.TileEntityPhotonCell;
import teamrapture.mobularmachinery.tileentity.TileEntityPhotonCore;
import teamrapture.mobularmachinery.tileentity.TileEntityWaterVaporizer;
import teamrapture.mobularmachinery.tileentity.extruder.TileEntityExtruderInventory;
import teamrapture.mobularmachinery.tileentity.extruder.TileEntityExtruderTap;
import teamrapture.mobularmachinery.tileentity.extruder.TileEntityRegionalExtruder;
import teamrapture.mobularmachinery.utils.FluidBlock;

public class ModResources {

	public static Item itemGear = new ItemBase("item_gear");
	public static Item itemMechanizedEgg = new ItemMechanizedEgg();
	public static Item itemBossHeart = new ItemBase("item_boss_heart");
	public static Item itemWiring = new ItemBase("item_wiring");
	public static Item itemCreativeSteamGiver = new ItemSteamCreative("creative_steam_checker");
	public static Item itemSteamTank = new ItemSteamTank("steam_tank");
	public static Item itemSteamTankChecker = new ItemSteamTankChecker("steam_checker");
	
	public static Item itemSteamDummyItem = new ItemBase("steam");
	public static Item itemCoil = new ItemBase("item_coil");
	public static Item itemLinker = new ItemLinker();

	public static Item itemManual = new ItemManual();
	public static Item itemSteamGun = new ItemSteamGun("steam_guns");

	public static Block blockHydroGen = new HydroGen();
	public static Block blockMechString = new MechanicalString();
	public static Block blockPhotonCore = new PhotonCore();
	public static Block blockPhotonCell = new PhotonCell();
	public static Block blockWaterVaporizer = new WaterVaporizer();
	public static Block blockRegionalExtruder = new RegionalExtruder();
	public static Block blockExtruderFrame = new ExtruderFrame();
	public static Block blockExtruderTap = new ExtruderTap();
	public static Block blockExtruderInventory = new ExtruderInventory();
	public static Block blockEnergyRelay = new EnergyRelay();
	public static Block blockGear = new GearBlock();
	public static Block blockDisplayPedestal = new DisplayPedestal();

	public static Fluid steam = new FluidSteam();
	public static FluidBlock steam_block;

	public static void registerResources() {
		reg(itemMechanizedEgg);
		reg(itemGear);
		reg(itemWiring);
		reg(itemSteamGun);
		reg(itemSteamDummyItem);
		reg(itemBossHeart);
		reg(itemManual);
		reg(itemLinker);
		reg(itemCoil);
		reg(itemCreativeSteamGiver);
		reg(itemSteamTank);
		reg(itemSteamTankChecker);
		reg(blockHydroGen);
		reg(blockPhotonCore);
		reg(blockPhotonCell);
		reg(blockWaterVaporizer);
		reg(blockRegionalExtruder);
		reg(blockExtruderFrame);
		reg(blockExtruderTap);
		reg(blockExtruderInventory);
		reg(blockEnergyRelay);
		reg(blockGear);
		reg(blockDisplayPedestal);
		reg(blockMechString);

		FluidRegistry.registerFluid(steam);
		FluidRegistry.addBucketForFluid(steam);

		steam_block = new FluidBlock(steam, Material.WATER);
		reg(steam_block);
	}

	public static void registerRenders() {
		regRender(itemCreativeSteamGiver);
		regRender(itemSteamTank);
		regRender(itemSteamTankChecker);
		
		regRender(itemWiring);
		regRender(itemGear);
		regRender(itemSteamGun);
		regRender(itemLinker);
		regRender(itemSteamDummyItem);
		regRender(itemMechanizedEgg);
		regRender(itemBossHeart);
		regRender(blockMechString);
		regRender(itemCoil);
		regRender(itemManual);
		regRender(blockPhotonCore);
		regRender(blockPhotonCell);
		regRender(blockWaterVaporizer);
		regRender(blockHydroGen);
		regRender(blockRegionalExtruder);
		regRender(blockExtruderFrame);
		regRender(blockExtruderTap);
		regRender(blockExtruderInventory);
		regRender(blockEnergyRelay);
		regRender(blockGear);
		regRender(blockDisplayPedestal);

		steam_block.regFluid();
	}

	public static void registerTE() {
		GameRegistry.registerTileEntity(TileEntityHydroGen.class, "tile_hydro_gen");
		GameRegistry.registerTileEntity(TileEntityPhotonCore.class, "tile_photon_core");
		GameRegistry.registerTileEntity(TileEntityPhotonCell.class, "tile_photon_cell");
		GameRegistry.registerTileEntity(TileEntityWaterVaporizer.class, "tile_water_vaporizer");
		GameRegistry.registerTileEntity(TileEntityRegionalExtruder.class, "tile_regional_extruder");
		GameRegistry.registerTileEntity(TileEntityExtruderTap.class, "tile_extruder_tap");
		GameRegistry.registerTileEntity(TileEntityExtruderInventory.class, "tile_extruder_inventory");
		GameRegistry.registerTileEntity(TileEntityEnergyRelay.class, "tile_energy_relay");
		GameRegistry.registerTileEntity(TileEntityDisplayPedestal.class, "tile_display_pedestal");
	}

	@SideOnly(Side.CLIENT)
	public static void registerTESR() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPhotonCore.class, new RenderPhotonCore());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRegionalExtruder.class, new RenderRegionalExtruder());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDisplayPedestal.class, new RenderDisplayPededstal());
	}

	public static void regRender(Object object) {
		if (object instanceof Block) {
			ModelResourceLocation res = new ModelResourceLocation(((Block) object).getRegistryName().toString(),
					"inventory");
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock((Block) object), 0, res);
		} else if (object instanceof Item) {
			ModelResourceLocation res = new ModelResourceLocation(((Item) object).getRegistryName().toString(),
					"inventory");
			ModelLoader.setCustomModelResourceLocation((Item) object, 0, res);
		}
	}

	public static void reg(Object object) {
		if (object instanceof Block) {
			ForgeRegistries.BLOCKS.register((Block) object);
			ForgeRegistries.ITEMS
					.register(new ItemBlock((Block) object).setRegistryName(((Block) object).getRegistryName()));
		} else if (object instanceof Item) {
			ForgeRegistries.ITEMS.register((Item) object);
		}
	}
}
