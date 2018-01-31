package teamrapture.mobularmachinery.entity.monster;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.entity.nonliving.EntitySteamStream;
import teamrapture.mobularmachinery.registry.ModResources;

public class EntitySquiddyAttackers extends EntityMob implements IRangedAttackMob, IAnimatedEntity {
	public Animation ATTACK_ANIMATION;
	private int animationTick;
	private Animation currentAnim;
	private static final Predicate<Entity> NO_BAD_ENTITY = new Predicate<Entity>() {
		public boolean apply(@Nullable Entity p_apply_1_) {
			return p_apply_1_ instanceof EntityLivingBase
					&& ((EntityLivingBase) p_apply_1_).getCreatureAttribute() != EnumCreatureAttribute.UNDEAD
					&& ((EntityLivingBase) p_apply_1_).attackable();
		}
	};
	public EntitySquiddyAttackers(World worldIn) {
		super(worldIn);
		this.setSize(0.7F, 1.9F);
	}

	public static void registerFixesSquiddy(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntitySquiddyAttackers.class);
	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 50, 5.0F));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1,
				new EntityAINearestAttackableTarget(this, EntityPlayer.class, 10, false, false, NO_BAD_ENTITY));
	}
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return 15728880;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
	}

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	public void onLivingUpdate() {
		super.onLivingUpdate();

		if (!this.world.isRemote) {
			int i = MathHelper.floor(this.posX);
			int j = MathHelper.floor(this.posY);
			int k = MathHelper.floor(this.posZ);

			if (this.isWet()) {
				addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1000, 2));
			}

			if (this.world.getBiome(new BlockPos(i, 0, k)).getTemperature(new BlockPos(i, j, k)) > 1.0F) {
				addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 1000, 4));
			}

			if (!this.world.getGameRules().getBoolean("mobGriefing")) {
				return;
			}

			for (int l = 0; l < 4; ++l) {
				i = MathHelper.floor(this.posX + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
				j = MathHelper.floor(this.posY);
				k = MathHelper.floor(this.posZ + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
				BlockPos blockpos = new BlockPos(i, j, k);

				if (this.world.getBlockState(blockpos).getMaterial() == Material.AIR
						&& this.world.getBiome(blockpos).getTemperature(blockpos) < 0.8F
						&& Blocks.FLOWING_WATER.canPlaceBlockAt(this.world, blockpos)) {
					this.world.setBlockState(blockpos, Blocks.FLOWING_WATER.getDefaultState());
				}
			}
		}
	}

/*	@Nullable
	protected ResourceLocation getLootTable() {
		return LootTableList.ENTITIES_SNOWMAN;
	}
*/
	private void launchWitherSkullToEntity(int p_82216_1_, EntityLivingBase p_82216_2_) {
		this.launchWitherSkullToCoords(p_82216_1_, p_82216_2_.posX,
				p_82216_2_.posY + (double) p_82216_2_.getEyeHeight() * 0.5D, p_82216_2_.posZ,
				p_82216_1_ == 0 && this.rand.nextFloat() < 0.001F);
	}

	/**
	 * Launches a Wither skull toward (par2, par4, par6)
	 */
	private void launchWitherSkullToCoords(int p_82209_1_, double x, double y, double z, boolean invulnerable) {
		double d0 = this.posX;
		double d1 = this.posY;
		double d2 = this.posZ;
		double d3 = x - d0;
		double d4 = y - d1;
		double d5 = z - d2;
		EntitySteamStream entitywitherskull = new EntitySteamStream(this.world, this, d3, d4, d5);

		entitywitherskull.posY = d1;
		entitywitherskull.posX = d0;
		entitywitherskull.posZ = d2;
		this.world.spawnEntity(entitywitherskull);
	}

	/**
	 * Attack the specified entity using a ranged attack.
	 */
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		this.launchWitherSkullToEntity(0, target);
	}

	public float getEyeHeight() {
		return 1.7F;
	}

	@Nullable
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SNOWMAN_AMBIENT;
	}

	@Nullable
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_SNOWMAN_HURT;
	}

	@Nullable
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SNOWMAN_DEATH;
	}

	public void setSwingingArms(boolean swingingArms) {
	}

	@Override
	public int getAnimationTick() {
		return animationTick;
	}

	@Override
	public void setAnimationTick(int tick) {
		animationTick = tick;
	}

	@Override
	public Animation[] getAnimations() {
		return new Animation[] { ATTACK_ANIMATION };
	}

	@Override
	public Animation getAnimation() {
		return currentAnim == null ? NO_ANIMATION : currentAnim;
	}

	@Override
	public void setAnimation(Animation animation) {
		currentAnim = animation;
	}
	//TODO -----------------------------------------------------------------------------------------------------
		//TODO THIS IS WHERE THE LIST ? / ARRAY will be called for dropping types of items in random chance
		@Override
		public boolean hitByEntity(Entity entityIn)
		{
			if (!this.world.isRemote) {
				if(rand.nextDouble() < 1.0D) this.entityDropItem(new ItemStack(ModResources.itemGear, 1 + rand.nextInt(3)), 0.2F);
			}
			return false;
		}

		@Override
		public void onDeath(DamageSource cause) {
			if (!this.world.isRemote) {
				this.entityDropItem(new ItemStack(ModResources.itemCoil, rand.nextInt(5)), 0.2F);
			}
			super.onDeath(cause);
		}
}
