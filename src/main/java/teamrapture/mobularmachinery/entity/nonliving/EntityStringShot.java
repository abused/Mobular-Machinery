package teamrapture.mobularmachinery.entity.nonliving;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.registry.ModResources;

public class EntityStringShot extends EntityFireball {
	public EntityStringShot(World worldIn) {
		super(worldIn);
	}

	@SideOnly(Side.CLIENT)
	public EntityStringShot(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
		super(worldIn, x, y, z, accelX, accelY, accelZ);
	}

	public EntityStringShot(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
		super(worldIn, shooter, accelX, accelY, accelZ);
	}

	public void blockPlacer() {
		int i = MathHelper.floor(this.posX);
		int j = MathHelper.floor(this.posY);
		int k = MathHelper.floor(this.posZ);
		i = MathHelper.floor(this.posX + (double) ((float) (4 % 2 * 2 - 1) * 0.25F));
		j = MathHelper.floor(this.posY);
		k = MathHelper.floor(this.posZ + (double) ((float) (4 / 2 % 2 * 2 - 1) * 0.25F));
		BlockPos blockpos = new BlockPos(i, j, k);
		BlockPos blockpos1 = new BlockPos(i + 1, j, k);
		BlockPos blockpos2 = new BlockPos(i - 1, j, k);
		BlockPos blockpos3 = new BlockPos(i, j, k + 1);
		BlockPos blockpos4 = new BlockPos(i, j, k - 1);
		BlockPos blockpos5 = new BlockPos(i + 1, j, k + 1);
		BlockPos blockpos6 = new BlockPos(i - 1, j, k - 1);
		BlockPos blockpos7 = new BlockPos(i - 1, j, k + 1);
		BlockPos blockpos8 = new BlockPos(i + 1, j, k - 1);

		BlockPos blockpos9 = new BlockPos(i, j + 1, k);
		BlockPos blockpos10 = new BlockPos(i + 1, j + 1, k);
		BlockPos blockpos11 = new BlockPos(i - 1, j + 1, k);
		BlockPos blockpos12 = new BlockPos(i, j + 1, k + 1);
		BlockPos blockpos13 = new BlockPos(i, j + 1, k - 1);
		BlockPos blockpos14 = new BlockPos(i + 1, j + 1, k + 1);
		BlockPos blockpos15 = new BlockPos(i - 1, j + 1, k - 1);
		BlockPos blockpos16 = new BlockPos(i + 1, j + 1, k - 1);
		BlockPos blockpos17 = new BlockPos(i - 1, j + 1, k + 1);

		BlockPos blockpos18 = new BlockPos(i, j + 2, k);
		BlockPos blockpos19 = new BlockPos(i + 1, j + 2, k);
		BlockPos blockpos20 = new BlockPos(i -1, j + 2, k);
		BlockPos blockpos21 = new BlockPos(i , j + 2, k+1);
		BlockPos blockpos22 = new BlockPos(i , j + 2, k-1);
		BlockPos blockpos23 = new BlockPos(i+1, j + 2, k+1);
		BlockPos blockpos24 = new BlockPos(i - 1, j + 2, k-1);
		BlockPos blockpos25 = new BlockPos(i + 1, j + 2, k-1);
		BlockPos blockpos26 = new BlockPos(i - 1, j + 2, k+1);

		this.world.setBlockState(blockpos, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos1, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos2, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos3, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos4, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos5, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos6, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos7, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos8, ModResources.blockMechString.getDefaultState());

		this.world.setBlockState(blockpos9, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos10, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos11, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos12, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos13, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos14, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos15, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos16, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos17, ModResources.blockMechString.getDefaultState());

		this.world.setBlockState(blockpos18, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos19, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos20, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos21, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos22, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos23, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos24, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos25, ModResources.blockMechString.getDefaultState());
		this.world.setBlockState(blockpos26, ModResources.blockMechString.getDefaultState());
	}

	/**
	 * Called when this EntityFireball hits a block or entity.
	 */
	protected void onImpact(RayTraceResult result) {
		int i = MathHelper.floor(this.posX);
		int j = MathHelper.floor(this.posY);
		int k = MathHelper.floor(this.posZ);

		if (!this.world.isRemote) {
			if (result.entityHit != null) {
				result.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 6.0F);
				this.applyEnchantments(this.shootingEntity, result.entityHit);
			}

			boolean flag = this.world.getGameRules().getBoolean("mobGriefing");
			for (int l = 0; l < 4; ++l) {
				i = MathHelper.floor(this.posX + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
				j = MathHelper.floor(this.posY);
				k = MathHelper.floor(this.posZ + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
				BlockPos blockpos = new BlockPos(i, j, k);

				if (this.world.getBlockState(blockpos).getMaterial() == Material.AIR

						&& ModResources.blockMechString.canPlaceBlockAt(this.world, blockpos)) {
					blockPlacer();
				}
				this.setDead();
			}
		}
	}

	public static void registerFixesStringShot(DataFixer fixer) {
		EntityFireball.registerFixesFireball(fixer, "StringShot");
	}

}
