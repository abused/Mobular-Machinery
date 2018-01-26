package teamrapture.mobularmachinery.entity.boss;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.entity.monster.EntitySquiddyAttacker;
import teamrapture.mobularmachinery.registry.ModResources;

public class EntityMechOctopusBoss extends EntityMob implements IAnimatedEntity, IRangedAttackMob {

	private final BossInfoServer bossInfo = (BossInfoServer) (new BossInfoServer(this.getDisplayName(),
			BossInfo.Color.YELLOW, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

	public Animation ATTACK_ANIMATION;
	private int animationTick;
	private Animation currentAnim;

	public EntityMechOctopusBoss(World worldIn) {
		super(worldIn);
		this.setHealth(this.getMaxHealth());
		setPathPriority(PathNodeType.WATER, 0);
		ATTACK_ANIMATION = Animation.create(20);
		experienceValue = 30;
		setSize(2F, 4.7F);
		this.isImmuneToFire = true;
		((PathNavigateGround) this.getNavigator()).setCanSwim(true);
		stepHeight = 1;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(1, new EntityAISwimming(this));
		tasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, 0, true, false, null));
		tasks.addTask(3, new EntityAIAttackMelee(this, 1, true));
		tasks.addTask(4, new EntityAIAttackRanged(this, 2.25D, 60, 100.0F));
		tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(6, new EntityAILookIdle(this));
		targetTasks.addTask(7, new EntityAIHurtByTarget(this, false, new Class[0]));

	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 12
				&& this.getAttackTarget() != null) {
			this.attackEntityAsMob(this.getAttackTarget());
		}
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
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6000000238418579D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.0D);
	}

	public boolean isNonBoss() {
		return false;
	}

	public void setSwingingArms(boolean swingingArms) {
	}

	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable(source)) {
			return false;
		} else if (source != DamageSource.DROWN && !(source.getTrueSource() instanceof EntityMechOctopusBoss)) {

			Entity entity1 = source.getTrueSource();

			if (entity1 != null && !(entity1 instanceof EntityPlayer) && entity1 instanceof EntityLivingBase
					&& ((EntityLivingBase) entity1).getCreatureAttribute() == this.getCreatureAttribute()) {
				return false;
			}

			return super.attackEntityFrom(source, amount);
		}
		return false;
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
	 * Launches a Freeze Bomb toward (par2, par4, par6)
	 */
	private void launchSquiddies(int pos, double x, double y, double z) {
		this.world.playEvent(null, 1024, new BlockPos(this), 0);
		double d0 = this.getX(pos);
		double d1 = this.getY(pos);
		double d2 = this.getZ(pos);
		double d3 = x - d0;
		double d4 = y - d1;
		double d5 = z - d2;
		EntitySquiddyAttacker squiddie = new EntitySquiddyAttacker(this.world, this, d3, d4, d5);
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
