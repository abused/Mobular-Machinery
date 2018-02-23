package teamrapture.mobularmachinery.entity.boss;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalGhast;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalZombie;
import teamrapture.mobularmachinery.entity.nonliving.EntityStringShot;
import teamrapture.mobularmachinery.registry.ModResources;

public class EntityMechSpiderBoss extends EntityMob implements IRangedAttackMob, IAnimatedEntity {
	private final BossInfoServer bossInfo = (BossInfoServer) (new BossInfoServer(this.getDisplayName(),
			BossInfo.Color.RED, BossInfo.Overlay.PROGRESS)).setDarkenSky(false);
	public static final Animation ATTACK_ANIMATION = Animation.create(50);
	private int animationTick;
	private Animation currentAnim;
	public boolean swingDirection;
	private static final Predicate<Entity> NO_BAD_ENTITY = new Predicate<Entity>() {
		public boolean apply(@Nullable Entity p_apply_1_) {
			return p_apply_1_ instanceof EntityLivingBase
					&& ((EntityLivingBase) p_apply_1_).getCreatureAttribute() != EnumCreatureAttribute.UNDEAD
					&& ((EntityLivingBase) p_apply_1_).attackable();
		}
	};
	private int spawn;

	public EntityMechSpiderBoss(World worldIn) {
		super(worldIn);
		this.setHealth(this.getMaxHealth());

		experienceValue = 30;
		setSize(2F, 4.7F);
		this.isImmuneToFire = true;
		stepHeight = 2;
		spawn = 0;
	}

	@Override
	protected void initEntityAI() {

	//	tasks.addTask(1, new EntityAIAttackMelee(this, 2, true));
		tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		targetTasks.addTask(3,
				new EntityAINearestAttackableTarget(this, EntityPlayer.class, 10, false, false, NO_BAD_ENTITY));

		tasks.addTask(1, new EntityAIAttackRanged(this, 0.25D, 200, 10.0F));
		targetTasks.addTask(7, new EntityAIHurtByTarget(this, false, new Class[0]));

	}

	@Override
	protected boolean canDespawn() {
		return false;
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

	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);

		if (this.hasCustomName()) {
			this.bossInfo.setName(this.getDisplayName());
		}
	}

	public void removeTrackingPlayer(EntityPlayerMP player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	public void addTrackingPlayer(EntityPlayerMP player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return 15728880;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);

		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(500.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(80.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
	}

	public boolean isNonBoss() {
		return false;
	}

	public void setSwingingArms(boolean swingingArms) {
	}

	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable(source)) {
			return false;
		} else if (source != DamageSource.DROWN && !(source.getTrueSource() instanceof EntityMechSpiderBoss)) {

			Entity entity1 = source.getTrueSource();

			if (entity1 != null && !(entity1 instanceof EntityPlayer) && entity1 instanceof EntityLivingBase
					&& ((EntityLivingBase) entity1).getCreatureAttribute() == this.getCreatureAttribute()) {
				return false;
			}

			return super.attackEntityFrom(source, amount);
		}
		return false;
	}

	public boolean isAIEnabled() {
		return true;
	}

	private void mobSpawning() {
		for (int i = 0; i < 20 + world.rand.nextInt(19); i++) {
			EntityLiving entity = null;
			switch (world.rand.nextInt(4)) {
			case 0: {
				entity = new EntitySpider(world);

				break;
			}
			case 1: {
				entity = new EntityCaveSpider(world);

				break;
			}case 2: {
				entity = new EntityMechanicalGhast(world);

				break;
			}case 3: {
				entity = new EntityMechanicalZombie(world);

				break;
			}

			}
			if (entity != null) {
				float range = 6F;
				entity.setPosition(posX + 0.5 + Math.random() * range - range / 2, this.posY + 2,
						posZ + 0.5 + Math.random() * range - range / 2);
				entity.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(entity)), null);
			}
			world.spawnEntity(entity);
		}
	}

	@Override
	public void onLivingUpdate() {

		super.updateAITasks();

		if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 12
				&& this.getAttackTarget() != null) {
			this.attackEntityAsMob(this.getAttackTarget());
		}

		if (this.getHealth() < this.getMaxHealth() * 0.75F && this.getHealth() > 0.0F && this.spawn == 0) {
			this.world.setEntityState(this, (byte) 12);

			if (!this.world.isRemote) {
				mobSpawning();

			}
			this.spawn = 1;
		}

		if (this.getHealth() < this.getMaxHealth() * 0.25F && this.getHealth() > 0.0F && this.spawn == 1) {
			this.world.setEntityState(this, (byte) 12);

			if (!this.world.isRemote) {
				mobSpawning();
				
			}
			this.spawn = 2;
		}

		super.onLivingUpdate();
	}

	@SideOnly(Side.CLIENT)
	private void spawnParticles(EnumParticleTypes particleType) {
		for (int i = 0; i < 5; ++i) {
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.world.spawnParticle(particleType.CLOUD,
					this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width,
					this.posY + 1.0D + (double) (this.rand.nextFloat() * this.height),
					this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2,
					new int[0]);
		}
	}

	@Override
	protected void updateAITasks() {

		/*
		 * this.world.newExplosion(this, this.posX, this.posY + (double)
		 * this.getEyeHeight(), this.posZ, 7.0F, false,
		 * this.world.getGameRules().getBoolean("mobGriefing"));
		 * //this.world.playBroadcastSound(1023, new BlockPos(this), 0);
		 */

		{
			super.updateAITasks();

			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
	}

	public void setInWeb() {
	}

	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		EntityItem entityitem = this.dropItem(ModResources.itemBossHeart, 1);

		if (entityitem != null) {
			entityitem.setNoDespawn();
		}
	}

	/**
	 * Sets the custom name tag for this entity
	 */
	public void setCustomNameTag(String name) {
		super.setCustomNameTag(name);
		this.bossInfo.setName(this.getDisplayName());
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {

		if (this.getAnimation() == NO_ANIMATION) {
			this.setAnimation(ATTACK_ANIMATION);
			return false;
		}

		if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 15) {
			IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this),
					(float) iattributeinstance.getAttributeValue());

			return flag;
		}

		return false;
	}

	private void launchSquiddiesToEntity(int pos, EntityLivingBase entity) {
		this.launchSquiddies(pos, entity.posX, entity.posY + (double) entity.getEyeHeight() * 0.5D, entity.posZ);
	}

	/**
	 * Launches a stringbomb toward (par2, par4, par6)
	 */
	private void launchSquiddies(int pos, double x, double y, double z) {
		this.world.playEvent(null, 1024, new BlockPos(this), 0);
		double d0 = this.posX;
		double d1 = this.posY;
		double d2 = this.posZ;
		double d3 = x - d0;
		double d4 = y - d1;
		double d5 = z - d2;
		EntityStringShot squiddie = new EntityStringShot(this.world, this, d3, d4, d5);
		squiddie.posY = d1;
		squiddie.posX = d0;
		squiddie.posZ = d2;
		this.world.spawnEntity(squiddie);
	}

	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		this.launchSquiddiesToEntity(0, target);
	}

	private double getX(int xPos) {
		if (xPos <= 0) {
			return this.posX;
		}

		return this.posX;
	}

	private double getY(int yPos) {
		return yPos <= 0 ? this.posY : this.posY;
	}

	private double getZ(int zPos) {
		if (zPos <= 0) {
			return this.posZ;
		}
		return zPos;

	}

}
