package teamrapture.mobularmachinery.entity.boss;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public class EntityMechOctopusBoss extends EntityMob implements IAnimatedEntity {
	private final BossInfoServer bossInfo = (BossInfoServer) (new BossInfoServer(this.getDisplayName(),
			BossInfo.Color.YELLOW, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

	public Animation ATTACK_ANIMATION;
	private int animationTick;
	private Animation currentAnim;

	public EntityMechOctopusBoss(World worldIn) {
		super(worldIn);
		setPathPriority(PathNodeType.WATER, 0);
		ATTACK_ANIMATION = Animation.create(20);
		tasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, 0, true, false, null));
		tasks.addTask(2, new EntityAIAttackMelee(this, 1, true));
		experienceValue = 30;
		setSize(2.5F, 3.7F);

		stepHeight = 1;
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

}
