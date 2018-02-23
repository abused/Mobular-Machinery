package teamrapture.mobularmachinery.client.model;

import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalCreeper;

@SideOnly(Side.CLIENT)
public class ModelMechanicalCreeper extends AdvancedModelBase {
	public AdvancedModelRenderer body;
	public AdvancedModelRenderer leg1;
	public AdvancedModelRenderer leg1Front;
	public AdvancedModelRenderer leg2Front;
	public AdvancedModelRenderer head;
	public AdvancedModelRenderer leg2;
	public AdvancedModelRenderer gearCenter;
	public AdvancedModelRenderer gearPiece1;
	public AdvancedModelRenderer gearPiece2;
	public AdvancedModelRenderer gearPiece3;
	public AdvancedModelRenderer gearPiece4;
	private ModelAnimator animation;

	public ModelMechanicalCreeper() {
		this(0.0F);
	}

	public ModelMechanicalCreeper(float pi) {
		int i = 6;
		animation = ModelAnimator.create();
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.leg1Front = new AdvancedModelRenderer(this, 0, 16);
		this.leg1Front.setRotationPoint(2.0F, 12.0F, -4.0F);
		this.leg1Front.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
		this.gearPiece2 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece2.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece2, 0.0F, 0.0F, -0.7853981633974483F);
		this.leg2Front = new AdvancedModelRenderer(this, 0, 16);
		this.leg2Front.setRotationPoint(-2.0F, 12.0F, -4.0F);
		this.leg2Front.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
		this.head = new AdvancedModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		this.leg1 = new AdvancedModelRenderer(this, 0, 16);
		this.leg1.setRotationPoint(2.0F, 12.0F, 4.0F);
		this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
		this.gearPiece3 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece3.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece3, 0.0F, 0.0F, 0.7853981633974483F);
		this.gearCenter = new AdvancedModelRenderer(this, 46, 10);
		this.gearCenter.setRotationPoint(0.0F, 5.7F, 2.0F);
		this.gearCenter.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(gearCenter, 0.0F, 1.5707963267948966F, 0.0F);
		this.gearPiece1 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece1.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.body = new AdvancedModelRenderer(this, 16, 16);
		this.body.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
		this.leg2 = new AdvancedModelRenderer(this, 0, 16);
		this.leg2.setRotationPoint(-2.0F, 12.0F, 4.0F);
		this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
		this.gearPiece4 = new AdvancedModelRenderer(this, 37, 9);
		this.gearPiece4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece4.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2, 0.0F);
		this.body.addChild(this.leg1Front);
		this.gearCenter.addChild(this.gearPiece2);
		this.body.addChild(this.leg2Front);
		this.body.addChild(this.head);
		this.body.addChild(this.leg1);
		this.gearCenter.addChild(this.gearPiece3);
		this.body.addChild(this.gearCenter);
		this.gearCenter.addChild(this.gearPiece1);
		this.body.addChild(this.leg2);
		this.gearCenter.addChild(this.gearPiece4);
		updateDefaultPose();
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
		this.body.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(AdvancedModelRenderer AdvancedModelRenderer, float x, float y, float z) {
		AdvancedModelRenderer.rotateAngleX = x;
		AdvancedModelRenderer.rotateAngleY = y;
		AdvancedModelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,
			EntityMechanicalCreeper entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		resetToDefaultPose();
		EntityMechanicalCreeper entityMechanicalCreeper = (EntityMechanicalCreeper) entity;

		AdvancedModelRenderer[] leg0 = { leg1, leg2 };
		AdvancedModelRenderer[] leg01 = { leg1Front, leg2Front };

		// f = EntityMechanicalCreeper.ticksExisted;
		f1 = 0.5f;
		float speed = 0.09F;
		float speed2 = 0.45F;
		float degree = 0.0015F;

		chainWave(leg0, speed, degree, -10, f, -20f);
		chainWave(leg01, speed, degree, -10, f, -20f);

		

	}

	public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		EntityMechanicalCreeper entityMechanicalCreeper = (EntityMechanicalCreeper) entity;
		animation.update(entity);
		resetToDefaultPose();
		setRotationAngles(f, f1, f2, f3, f4, f5, entityMechanicalCreeper);

		float speed = 0.4f;
		float degree = 0.4f;
		float globalHeight = 0.4f;
		bob(body, speed * 1.5f, degree * 5f, false, f, f1);
		// bob(bottomGlassHolder, speed * 1.5f, degree * 5f, false, f, f1);

		f = entityMechanicalCreeper.ticksExisted;
		f1 = 0.5f;

		flap(gearCenter, 0.41f, 100f, false, 0f, 0f, f, f1);

	}
}
