package teamrapture.mobularmachinery.entity.nonliving;

import io.netty.util.internal.MathUtil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitySteamStream extends EntityThrowable {


public EntitySteamStream(World worldIn)
{
    super(worldIn);
}

public EntitySteamStream(World worldIn, EntityLivingBase throwerIn)
{
    super(worldIn, throwerIn);
}

public EntitySteamStream(World worldIn, double x, double y, double z)
{
    super(worldIn, x, y, z);
}

public static void registerFixesSteam(DataFixer fixer)
{
    EntityThrowable.registerFixesThrowable(fixer, "Steam");
}

/**
 * Handler for {@link World#setEntityState}
 */

@SideOnly(Side.CLIENT)
public void handleStatusUpdate(byte id)
{
    if (id == 3)
    {
        for (int i = 0; i < 8; ++i)
        {
            this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY, this.posZ + MathHelper.sin(1), 0.0D, 0.0D, 0.0D );
            
         /* this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
         */   
        }
    }
}

/**
 * Called when this EntityThrowable hits a block or entity.
 */
protected void onImpact(RayTraceResult result)
{
    if (result.entityHit != null)
    {
        int i = 0;

        if (result.entityHit instanceof EntityBlaze)
        {
            i = 3;
        }

        result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
    }

    if (!this.world.isRemote)
    {
        this.world.setEntityState(this, (byte)3);
        this.setDead();
    }
}
}