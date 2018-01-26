package teamrapture.mobularmachinery.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IThrowableEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitySquiddyAttacker extends EntityFireball implements IThrowableEntity {
	private static final DataParameter<Boolean> INVULNERABLE = EntityDataManager.createKey(EntitySquiddyAttacker.class,
			DataSerializers.BOOLEAN);
	private Entity shooter;

	public EntitySquiddyAttacker(World worldIn) {
		super(worldIn);
		this.setSize(0.3125F, 0.3125F);
	}

	public EntitySquiddyAttacker(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
		super(worldIn, shooter, accelX, accelY, accelZ);
		this.setSize(0.3125F, 0.3125F);
		this.shooter = shooter;
	}

	@SideOnly(Side.CLIENT)
	public EntitySquiddyAttacker(World worldIn, double x, double y, double z, double accelX, double accelY,
			double accelZ) {
		super(worldIn, x, y, z, accelX, accelY, accelZ);
		this.setSize(0.3125F, 0.3125F);
	}

	public static void registerFixesSquiddy(DataFixer fixer) {
		EntityFireball.registerFixesFireball(fixer, "SquiddyAttacker");
	}

	/**
	 * Return the motion factor for this projectile. The factor is multiplied by
	 * the original motion.
	 */
	@Override
	protected float getMotionFactor() {
		return super.getMotionFactor();
	}

	/**
	 * Returns true if the entity is on fire. Used by render to add the fire
	 * effect on rendering.
	 */
	@Override
	public boolean isBurning() {
		return false;
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (this.world.isRemote || shootingEntity == null || result.entityHit == null
				|| !(result.entityHit instanceof EntityPlayer)) {
			return;
		}
		BlockPos blockPos = new BlockPos(result.entityHit);
		int squiddyMax = 8;
		int squiddyBound = rand.nextInt(squiddyMax - 1 + 1) + 1;

		for (int i2 = 0; i2 < squiddyBound; i2++) {
			EntitySquiddyAttackers squiddyWarrior = new EntitySquiddyAttackers(this.world);
			if (shootingEntity.getHealth() <= 200.0F && shootingEntity.getHealth() > 1.0F) {

			}
			squiddyWarrior.setPositionAndUpdate(blockPos.getX(), blockPos.getY(), blockPos.getZ());
			squiddyWarrior.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(squiddyWarrior)), null);
			this.world.spawnEntity(squiddyWarrior);
		}

		this.setDead();
	}

	/**
	 * Returns true if other Entities should be prevented from moving through
	 * this Entity.
	 */
	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		return false;
	}

	@Override
	protected void entityInit() {
		this.dataManager.register(INVULNERABLE, false);
	}

	/**
	 * Gets the entity that threw/created this entity.
	 *
	 * @return The owner instance, Null if none.
	 */
	@Override
	public Entity getThrower() {
		return shooter;
	}

	/**
	 * Sets the entity that threw/created this entity.
	 *
	 * @param entity
	 *            The new thrower/creator.
	 */
	@Override
	public void setThrower(Entity entity) {
		shooter = entity;
	}
}
