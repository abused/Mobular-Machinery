package teamrapture.mobularmachinery.entity.friendly;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import teamrapture.mobularmachinery.entity.DropList;
import teamrapture.mobularmachinery.registry.ModResources;

public class EntityMechanicalChicken extends EntityMob implements IRangedAttackMob {

	public float wingRotation;
	public float destPos;
	public float oFlapSpeed;
	public float oFlap;
	public float wingRotDelta = 1.0F;
	/**
	 * The time until the next egg is spawned.
	 */
	public int timeUntilNextMechEgg;
	public DropList list = new DropList();

	public EntityMechanicalChicken(World worldIn) {
		super(worldIn);
		this.setSize(0.4F, 0.7F);
		this.timeUntilNextMechEgg = this.rand.nextInt(6000) + 6000;
		this.setPathPriority(PathNodeType.WATER, 0.0F);

	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 20, 10.0F));

		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
		this.tasks.addTask(3, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
	}

	@Override
	public float getEyeHeight() {
		return this.height;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.oFlap = this.wingRotation;
		this.oFlapSpeed = this.destPos;
		this.destPos = (float) ((double) this.destPos + (double) (this.onGround ? -1 : 4) * 0.3D);
		this.destPos = MathHelper.clamp(this.destPos, 0.0F, 1.0F);

		if (!this.onGround && this.wingRotDelta < 1.0F) {
			this.wingRotDelta = 1.0F;
		}

		this.wingRotDelta = (float) ((double) this.wingRotDelta * 0.9D);

		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.6D;
		}

		this.wingRotation += this.wingRotDelta * 2.0F;

		if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextMechEgg <= 0) {
			this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F,
					(this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			this.dropItem(ModResources.itemMechanizedEgg, 1);
			this.timeUntilNextMechEgg = this.rand.nextInt(6000) + 6000;
		}
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_CHICKEN_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_CHICKEN_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_CHICKEN_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
	}

	@Nullable
	@Override
	protected ResourceLocation getLootTable() {
		return LootTableList.ENTITIES_CHICKEN;
	}

	/**
	 * Get the experience points the entity currently has.
	 */
	@Override
	protected int getExperiencePoints(EntityPlayer player) {
		return super.getExperiencePoints(player);
	}

	public static void registerFixesMechanicalChicken(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntityMechanicalChicken.class);
	}

	/**
	 * Attack the specified entity using a ranged attack.
	 */
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		EntitySnowball entitymechEgg = new EntitySnowball(this.world, this);
		double d0 = target.posY + (double) target.getEyeHeight() - 1.100000023841858D;
		double d1 = target.posX - this.posX;
		double d2 = d0 - entitymechEgg.posY;
		double d3 = target.posZ - this.posZ;
		float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
		entitymechEgg.shoot(d1, d2 + (double) f, d3, 1.6F, 12.0F);
		this.playSound(SoundEvents.ENTITY_EGG_THROW, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.world.spawnEntity(entitymechEgg);

	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);

		if (compound.hasKey("EggLayTime")) {
			this.timeUntilNextMechEgg = compound.getInteger("EggLayTime");
		}
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("EggLayTime", this.timeUntilNextMechEgg);
	}

	@Override
	public void setSwingingArms(boolean swingingArms) {
	}

	//TODO -----------------------------------------------------------------------------------------------------
	//TODO THIS IS WHERE THE LIST ? / ARRAY will be called for dropping types of items in random chance
	@Override
	public boolean hitByEntity(Entity entityIn) {
		if (!this.world.isRemote) {
			if (rand.nextDouble() < 1.0D) this.entityDropItem(list.generateRandomItem(), 1 + rand.nextInt(1));
		}
		return false;
	}

	@Override
	public void onDeath(DamageSource cause) {
		if (!this.world.isRemote) {
			this.entityDropItem(new ItemStack(list.generateRandomItem().getItem(), rand.nextInt(2)), 0.2F);
		}
		super.onDeath(cause);
	}
}
