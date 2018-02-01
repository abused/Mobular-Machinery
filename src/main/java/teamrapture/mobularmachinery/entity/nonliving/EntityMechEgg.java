package teamrapture.mobularmachinery.entity.nonliving;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.entity.friendly.EntityMechanicalChicken;
import teamrapture.mobularmachinery.registry.ModResources;

public class EntityMechEgg extends EntityThrowable {
	public EntityMechEgg(World worldIn) {
		super(worldIn);
	}

	public EntityMechEgg(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityMechEgg(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public static void registerFixesMechEgg(DataFixer fixer) {
		EntityThrowable.registerFixesThrowable(fixer, "MechEgg");
	}

	/**
	 * Handler for {@link World#setEntityState}
	 */
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			double d0 = 0.08D;

			for (int i = 0; i < 8; ++i) {
				this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ,
						((double) this.rand.nextFloat() - 0.5D) * 0.08D,
						((double) this.rand.nextFloat() - 0.5D) * 0.08D,
						((double) this.rand.nextFloat() - 0.5D) * 0.08D, Item.getIdFromItem(ModResources.itemMechanizedEgg));
			}
		}
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(RayTraceResult result) {
		if (result.entityHit != null) {
			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
		}

		if (!this.world.isRemote) {
			if (this.rand.nextInt(8) == 0) {
				int i = 1;

				if (this.rand.nextInt(32) == 0) {
					i = 4;
				}

				for (int j = 0; j < i; ++j) {
					EntityMechanicalChicken EntityMechanicalChicken = new EntityMechanicalChicken(this.world);
					// EntityMechanicalChicken.setGrowingAge(-24000);
					EntityMechanicalChicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw,
							0.0F);
					this.world.spawnEntity(EntityMechanicalChicken);
				}
			}

			this.world.setEntityState(this, (byte) 3);
			this.setDead();
		}
	}
}
