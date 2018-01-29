package teamrapture.mobularmachinery.entity.nonliving;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitySteamStream extends EntityFireball {

	public EntitySteamStream(World worldIn) {
		super(worldIn);
		this.setSize(0.3125F, 0.3125F);
	}

	public EntitySteamStream(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
		super(worldIn, shooter, accelX, accelY, accelZ);
		this.setSize(0.3125F, 0.3125F);
	}
	
	@SideOnly(Side.CLIENT)
    public EntitySteamStream(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ)
    {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
        this.setSize(0.3125F, 0.3125F);
    }
	 
	public static void registerFixesSteam(DataFixer fixer) {
		EntityThrowable.registerFixesThrowable(fixer, "Steam");
	}

	/**
	 * Handler for {@link World#setEntityState}
	 */
	 @Override
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY,
					this.posZ + MathHelper.sin(1.223F), 0.0D, 0.0D, 0.0D);
			this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY,
					this.posZ + MathHelper.sin(1.823F), 0.0D, 0.0D, 0.0D);
			this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY,
					this.posZ + MathHelper.sin(2.823F), 0.0D, 0.0D, 0.0D);
			this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY,
					this.posZ + MathHelper.sin(3.823F), 0.0D, 0.0D, 0.0D);
			this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY,
					this.posZ + MathHelper.sin(2.123F), 0.0D, 0.0D, 0.0D);
			this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY,
					this.posZ + MathHelper.sin(1.323F), 0.0D, 0.0D, 0.0D);

			for (int i = 0; i < 8; i++) {
				this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY,
						this.posZ + MathHelper.sin(1.223F), 0.0D, 0.0D, 0.0D);
				this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY,
						this.posZ + MathHelper.sin(1.823F), 0.0D, 0.0D, 0.0D);
				this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY,
						this.posZ + MathHelper.sin(2.823F), 0.0D, 0.0D, 0.0D);
				this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY,
						this.posZ + MathHelper.sin(3.823F), 0.0D, 0.0D, 0.0D);
				this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY,
						this.posZ + MathHelper.sin(2.123F), 0.0D, 0.0D, 0.0D);
				this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY,
						this.posZ + MathHelper.sin(1.323F), 0.0D, 0.0D, 0.0D);

			}
		}
	}
	 @Override
	 public boolean isBurning()
	    {
	        return false;
	    }
	 @Override
	 protected boolean isFireballFiery()
	    {
	        return false;
	    }
	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			if (result.entityHit != null) {
				if (this.shootingEntity != null) {
					if (result.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingEntity), 8.0F)) {
						if (result.entityHit.isEntityAlive()) {
							this.applyEnchantments(this.shootingEntity, result.entityHit);
						} else {
							this.shootingEntity.heal(5.0F);
						}
					}
				} else {
					result.entityHit.attackEntityFrom(DamageSource.MAGIC, 5.0F);
				}

				if (result.entityHit instanceof EntityLivingBase) {
					int i = 0;

					if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
						i = 10;
					} else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
						i = 40;
					}

					if (i > 0) {
						((EntityLivingBase) result.entityHit)
								.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 20 * i, 1));
					}
				}
			}

		//	this.world.newExplosion(this, this.posX, this.posY, this.posZ, 1.0F, false,
			//		this.world.getGameRules().getBoolean("mobGriefing"));
			this.setDead();
		}
	}
}