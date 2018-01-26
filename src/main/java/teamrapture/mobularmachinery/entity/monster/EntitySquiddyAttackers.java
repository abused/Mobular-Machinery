package teamrapture.mobularmachinery.entity.monster;

import javax.annotation.Nullable;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import teamrapture.mobularmachinery.entity.nonliving.EntitySteamStream;

public class EntitySquiddyAttackers extends EntityMob implements IRangedAttackMob, IAnimatedEntity {
	public Animation ATTACK_ANIMATION;
	private int animationTick;
	private Animation currentAnim;

	public EntitySquiddyAttackers(World worldIn) {
		super(worldIn);
		this.setSize(0.7F, 1.9F);
	}

	public static void registerFixesSquiddy(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntitySquiddyAttackers.class);
	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 20, 10.0F));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1,
				new EntityAINearestAttackableTarget(this, EntityPlayer.class, 10, true, false, null));
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

	@Nullable
	protected ResourceLocation getLootTable() {
		return LootTableList.ENTITIES_SNOWMAN;
	}

	/**
	 * Attack the specified entity using a ranged attack.
	 */
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		EntitySteamStream entitySteamStream = new EntitySteamStream(this.world, this);
		double d0 = target.posY + (double) target.getEyeHeight() - 1.100000023841858D;
		double d1 = target.posX - this.posX;
		double d2 = d0 - entitySteamStream.posY;
		double d3 = target.posZ - this.posZ;
		float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
		entitySteamStream.shoot(d1, d2 + (double) f, d3, 1.6F, 12.0F);
		this.playSound(SoundEvents.ENTITY_SNOWMAN_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.world.spawnEntity(entitySteamStream);

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

}
