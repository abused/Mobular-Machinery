package teamrapture.mobularmachinery.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.BlockWeb;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.MobularMachinery;
import teamrapture.mobularmachinery.registry.ModResources;
import teamrapture.mobularmachinery.utils.Utils;

public class MechanicalString extends BlockWeb implements net.minecraftforge.common.IShearable {
	public float width;

	public float height;

	public MechanicalString() {
		super();
		this.setRegistryName("mechanical_wiring");
		this.setUnlocalizedName("mechanical_wiring");
		this.setCreativeTab(MobularMachinery.mobularTab);
		this.setHardness(0.05f);
	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {

		return ModResources.itemWiring.getItemFromBlock(ModResources.blockMechString);

	}

	/**
	 * Called When an Entity Collided with the Block
	 */
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		entityIn.setInWeb();
		if (entityIn instanceof EntityPlayer) {
			((EntityPlayer) entityIn).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 100, 20, true, true));
			((EntityPlayer) entityIn).setFire(25);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		Utils.spawnParticles(worldIn, EnumParticleTypes.FIREWORKS_SPARK, 5/2, pos.getX()+0.5, pos.getY()+0.5, pos.getZ()+0.5, 0, 0, 0, 2.2f/32);
		
		
		/*
		 * for (int i = 0; i < 5; ++i) { double d0 = rand.nextGaussian() *
		 * 0.08D; double d1 = rand.nextGaussian() * 0.08D; double d2 =
		 * rand.nextGaussian() * 0.08D;
		 * worldIn.spawnParticle(EnumParticleTypes.CLOUD, pos.getX() + (double)
		 * (rand.nextFloat() * width * 2.0F) - (double) width, pos.getY() + 1.0D
		 * + (double) (rand.nextFloat() * height / 3), pos.getZ() + (double)
		 * (rand.nextFloat() * width * 2.0F) - (double) this.width, d0, d1, d2,
		 * new int[0]); }
		 */
	}

	/**
	 * Called before the Block is set to air in the world. Called regardless of
	 * if the player's tool can actually collect this block
	 */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 20, true, true));
		getItemDropped(state, worldIn.rand, 100);

	}

	/**
	 * Called after the block is set in the Chunk data, but before the Tile
	 * Entity is set
	 */
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {

		// playsound electric explosion
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks
	 * for render
	 */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	protected boolean canSilkHarvest() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/**
	 * Spawns the block's drops in the world. By the time this is called the
	 * Block has possibly been set to air via Block.removedByPlayer
	 */
	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state,
			@Nullable TileEntity te, ItemStack stack) {
		if (!worldIn.isRemote && stack.getItem() == Items.SHEARS) {
			player.addStat(StatList.getBlockStats(this));
			spawnAsEntity(worldIn, pos, new ItemStack(Item.getItemFromBlock(this), 1));
		} else {
			super.harvestBlock(worldIn, player, pos, state, te, stack);
		}
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public java.util.List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		return com.google.common.collect.Lists.newArrayList(new ItemStack(Item.getItemFromBlock(this)));
	}

	/**
	 * Get the geometry of the queried face at the given position and state.
	 * This is used to decide whether things like buttons are allowed to be
	 * placed on the face, or how glass panes connect to the face, among other
	 * things.
	 * <p>
	 * Common values are {@code SOLID}, which is the default, and
	 * {@code UNDEFINED}, which represents something that does not fit the other
	 * descriptions and will generally cause other things not to connect to the
	 * face.
	 * 
	 * @return an approximation of the form of the given face
	 */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}
