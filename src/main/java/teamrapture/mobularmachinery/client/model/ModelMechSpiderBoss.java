package teamrapture.mobularmachinery.client.model;

import org.lwjgl.opengl.GL11;

import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.entity.boss.EntityMechSpiderBoss;

/**
 * ModelMechSpiderBoss - EPIIC_THUNDERCAT Created using Tabula 7.0.0
 */
@SideOnly(Side.CLIENT)
public class ModelMechSpiderBoss extends AdvancedModelBase {
	public AdvancedModelRenderer spiderBossBody;
	public AdvancedModelRenderer bottomGlassHolder;
	public AdvancedModelRenderer legOneBottom;
	public AdvancedModelRenderer legTwoBottom;
	public AdvancedModelRenderer legThreeBottom;
	public AdvancedModelRenderer topBrainHousing;
	public AdvancedModelRenderer gearHolder;
	public AdvancedModelRenderer legOneJoint;
	public AdvancedModelRenderer steppingOneLeg;
	public AdvancedModelRenderer legTwoJoint;
	public AdvancedModelRenderer steppingTwoLeg;
	public AdvancedModelRenderer legThreeJoint;
	public AdvancedModelRenderer steppingThreeLeg;
	public AdvancedModelRenderer gearCenter;
	public AdvancedModelRenderer gearPiece1;
	public AdvancedModelRenderer gearPiece2;
	public AdvancedModelRenderer gearPiece3;
	public AdvancedModelRenderer gearPiece4;
	private ModelAnimator animation;

	public ModelMechSpiderBoss() {
		animation = ModelAnimator.create();
		this.textureWidth = 142;
		this.textureHeight = 142;
		this.legOneJoint = new AdvancedModelRenderer(this, 94, 0);
		this.legOneJoint.setRotationPoint(-1.2F, -38.4F, -1.7F);
		this.legOneJoint.addBox(-2.5F, -3.0F, -2.5F, 5, 3, 5, 0.0F);
		this.setRotateAngle(legOneJoint, -1.2747884856566583F, -2.231054382824351F, 0.22759093446006054F);
		this.steppingTwoLeg = new AdvancedModelRenderer(this, 0, 47);
		this.steppingTwoLeg.setRotationPoint(1.0F, -1.0F, -1.0F);
		this.steppingTwoLeg.addBox(-3.0F, -89.0F, -2.0F, 5, 90, 5, 0.0F);
		this.setRotateAngle(steppingTwoLeg, -1.2747884856566583F, -0.4553564018453205F, 0.0F);
		this.gearHolder = new AdvancedModelRenderer(this, 7, 17);
		this.gearHolder.setRotationPoint(0.0F, 12.3F, 0.0F);
		this.gearHolder.addBox(-1.0F, 0.0F, -0.5F, 2, 15, 2, 0.0F);
		this.gearCenter = new AdvancedModelRenderer(this, 20, 0);
		this.gearCenter.setRotationPoint(0.0F, 15.9F, 0.5F);
		this.gearCenter.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.gearPiece2 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece2.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece2, 0.0F, 0.0F, -0.7853981633974483F);
		this.gearPiece4 = new AdvancedModelRenderer(this, 36, 9);
		this.gearPiece4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece4.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2, 0.0F);
		this.legTwoJoint = new AdvancedModelRenderer(this, 94, 0);
		this.legTwoJoint.setRotationPoint(-1.2F, -38.4F, -1.7F);
		this.legTwoJoint.addBox(-2.5F, -3.0F, -2.5F, 5, 3, 5, 0.0F);
		this.setRotateAngle(legTwoJoint, -1.2747884856566583F, -2.231054382824351F, 0.22759093446006054F);
		this.gearPiece1 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece1.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.bottomGlassHolder = new AdvancedModelRenderer(this, 69, 46);
		this.bottomGlassHolder.setRotationPoint(0.0F, -6.0F, 0.0F);
		this.bottomGlassHolder.addBox(-7.0F, 0.0F, -8.0F, 15, 20, 15, 0.0F);
		this.legTwoBottom = new AdvancedModelRenderer(this, 20, 66);
		this.legTwoBottom.setRotationPoint(13.0F, -15.0F, 0.0F);
		this.legTwoBottom.addBox(-3.0F, -39.0F, -4.0F, 5, 40, 5, 0.0F);
		this.setRotateAngle(legTwoBottom, 0.0F, -2.0032889154390916F, 0.6829473363053812F);
		this.steppingOneLeg = new AdvancedModelRenderer(this, 0, 47);
		this.steppingOneLeg.setRotationPoint(1.0F, -1.0F, -1.0F);
		this.steppingOneLeg.addBox(-3.0F, -89.0F, -2.0F, 5, 90, 5, 0.0F);
		this.setRotateAngle(steppingOneLeg, -1.2747884856566583F, -0.4553564018453205F, 0.0F);
		this.steppingThreeLeg = new AdvancedModelRenderer(this, 0, 47);
		this.steppingThreeLeg.setRotationPoint(1.0F, -1.0F, -1.0F);
		this.steppingThreeLeg.addBox(-3.0F, -89.0F, -2.0F, 5, 90, 5, 0.0F);
		this.setRotateAngle(steppingThreeLeg, -1.0471975511965976F, -0.4553564018453205F, -0.40980330836826856F);
		this.topBrainHousing = new AdvancedModelRenderer(this, 22, 34);
		this.topBrainHousing.setRotationPoint(0.0F, -13.0F, -3.0F);
		this.topBrainHousing.addBox(-7.0F, -10.0F, -7.0F, 15, 10, 15, 0.0F);
		this.spiderBossBody = new AdvancedModelRenderer(this, 21, 82);
		this.spiderBossBody.setRotationPoint(0.0F, -19.0F, 0.0F);
		this.spiderBossBody.addBox(-15.0F, -16.0F, -17.0F, 30, 30, 30, 0.0F);
		this.gearPiece3 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece3.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece3, 0.0F, 0.0F, 0.7853981633974483F);
		this.legThreeJoint = new AdvancedModelRenderer(this, 94, 0);
		this.legThreeJoint.setRotationPoint(-1.2F, -38.4F, -1.7F);
		this.legThreeJoint.addBox(-2.5F, -3.0F, -2.5F, 5, 3, 5, 0.0F);
		this.setRotateAngle(legThreeJoint, -1.2747884856566583F, -2.231054382824351F, 0.22759093446006054F);
		this.legThreeBottom = new AdvancedModelRenderer(this, 20, 66);
		this.legThreeBottom.setRotationPoint(1.0F, -16.0F, 11.0F);
		this.legThreeBottom.addBox(-3.0F, -39.0F, -4.0F, 5, 40, 5, 0.0F);
		this.setRotateAngle(legThreeBottom, 1.0016444577195458F, 2.5953045977155678F, 0.27314402793711257F);
		this.legOneBottom = new AdvancedModelRenderer(this, 20, 66);
		this.legOneBottom.setRotationPoint(-10.0F, -13.0F, -10.0F);
		this.legOneBottom.addBox(-3.0F, -39.0F, -4.0F, 5, 40, 5, 0.0F);
		this.setRotateAngle(legOneBottom, 0.5462880558742251F, 0.136659280431156F, -0.27314402793711257F);
		this.legOneBottom.addChild(this.legOneJoint);
		this.legTwoJoint.addChild(this.steppingTwoLeg);
		this.spiderBossBody.addChild(this.gearHolder);
		this.gearHolder.addChild(this.gearCenter);
		this.gearCenter.addChild(this.gearPiece2);
		this.gearCenter.addChild(this.gearPiece4);
		this.legTwoBottom.addChild(this.legTwoJoint);
		this.gearCenter.addChild(this.gearPiece1);
		this.spiderBossBody.addChild(this.legTwoBottom);
		this.legOneJoint.addChild(this.steppingOneLeg);
		this.legThreeJoint.addChild(this.steppingThreeLeg);
		this.spiderBossBody.addChild(this.topBrainHousing);
		this.gearCenter.addChild(this.gearPiece3);
		this.legThreeBottom.addChild(this.legThreeJoint);
		this.spiderBossBody.addChild(this.legThreeBottom);
		this.spiderBossBody.addChild(this.legOneBottom);
		updateDefaultPose();
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
		this.spiderBossBody.render(f5);
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8F);
		this.bottomGlassHolder.render(f5);
		GlStateManager.disableBlend();

	}

	public void setRotateAngle(AdvancedModelRenderer AdvancedModelRenderer, float x, float y, float z) {
		AdvancedModelRenderer.rotateAngleX = x;
		AdvancedModelRenderer.rotateAngleY = y;
		AdvancedModelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,
			EntityMechSpiderBoss entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		resetToDefaultPose();
		EntityMechSpiderBoss entityMechSpiderBoss = (EntityMechSpiderBoss) entity;

		AdvancedModelRenderer[] leg1 = { this.legOneBottom, this.legOneJoint, this.steppingOneLeg };
		AdvancedModelRenderer[] leg2 = { this.legTwoBottom, this.legTwoJoint, this.steppingTwoLeg };
		AdvancedModelRenderer[] leg3 = { this.legThreeBottom, this.legThreeJoint, this.steppingThreeLeg };

		// f = entityMechSpiderBoss.ticksExisted;
		f1 = 0.5f;
		float speed = 0.09F;
		float speed2 = 0.45F;
		float degree = 0.0015F;

		chainWave(leg1, speed, degree, -10, f, -20f);
		chainWave(leg2, speed, degree, -10, f, -20f);
		chainWave(leg3, speed, degree, -10, f, -20f);
		chainFlap(leg1, speed, degree, 10, f, -20f);
		chainFlap(leg2, speed, degree, 10, f, -20f);
		chainFlap(leg3, speed, degree, 10, f, -20f);
		chainSwing(leg1, 4 * speed, degree, -100, f, -200f);
		chainSwing(leg2, 4 * speed, degree, -100, f, -200f);
		chainSwing(leg3, 4 * speed, degree, -100, f, -200f);
		bob(spiderBossBody, speed * 1.5f, degree * 5f, false, f, f1);
		bob(bottomGlassHolder, speed * 1.5f, degree * 5f, false, f, f1);

	}

	public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		EntityMechSpiderBoss entityMechSpiderBoss = (EntityMechSpiderBoss) entity;
		animation.update(entity);
		resetToDefaultPose();
		setRotationAngles(f, f1, f2, f3, f4, f5, entityMechSpiderBoss);

		float speed = 0.4f;
		float degree = 0.4f;
		float globalHeight = 0.4f;
		bob(spiderBossBody, speed * 1.5f, degree * 5f, false, f, f1);
		bob(bottomGlassHolder, speed * 1.5f, degree * 5f, false, f, f1);

		f = entityMechSpiderBoss.ticksExisted;
		f1 = 0.5f;

		flap(gearCenter, 0.41f, 100f, false, 0f, 0f, f, f1);
		if (entityMechSpiderBoss.getAnimation() == EntityMechSpiderBoss.ATTACK_ANIMATION) {
			if (!entityMechSpiderBoss.swingDirection) {
				animation.setAnimation(entityMechSpiderBoss.ATTACK_ANIMATION);
				animation.setStaticKeyframe(6);
				animation.startKeyframe(15);
				animation.rotate(legOneBottom, 0, 0.1F, 0);
				animation.rotate(legOneJoint, -0.5F, 0.2F, 0);
				animation.rotate(steppingOneLeg, 0.2F, 0.3F, 0);

				animation.endKeyframe();
				animation.setStaticKeyframe(5);
				animation.endKeyframe();
				animation.resetKeyframe(5);

			}
		}
	}
}