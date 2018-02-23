package teamrapture.mobularmachinery.client.model;

import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalBlaze;
import teamrapture.mobularmachinery.entity.monster.EntityMechanicalBlaze;

/**
 * ModelBlaze - Either Mojang or a mod author Created using Tabula 7.0.0
 */
public class ModelMechanicalBlaze extends AdvancedModelBase {
	public AdvancedModelRenderer head;
	public AdvancedModelRenderer gearCenter1;
	public AdvancedModelRenderer gearCenter2;
	public AdvancedModelRenderer gearCenter3;
	public AdvancedModelRenderer gearCenter4;
	public AdvancedModelRenderer gearCenter5;
	public AdvancedModelRenderer gearCenter6;
	public AdvancedModelRenderer gearCenter7;
	public AdvancedModelRenderer gearCenter8;
	public AdvancedModelRenderer gearCenter9Bot;
	public AdvancedModelRenderer gearCenter10Bot;
	public AdvancedModelRenderer gearCenter11Bot;
	public AdvancedModelRenderer gearCenter12Bot;
	public AdvancedModelRenderer gearPiece1;
	public AdvancedModelRenderer gearPiece2;
	public AdvancedModelRenderer gearPiece3;
	public AdvancedModelRenderer gearPiece4;
	public AdvancedModelRenderer gearPiece1_1;
	public AdvancedModelRenderer gearPiece2_1;
	public AdvancedModelRenderer gearPiece3_1;
	public AdvancedModelRenderer gearPiece4_1;
	public AdvancedModelRenderer gearPiece1_2;
	public AdvancedModelRenderer gearPiece2_2;
	public AdvancedModelRenderer gearPiece3_2;
	public AdvancedModelRenderer gearPiece4_2;
	public AdvancedModelRenderer gearPiece1_3;
	public AdvancedModelRenderer gearPiece2_3;
	public AdvancedModelRenderer gearPiece3_3;
	public AdvancedModelRenderer gearPiece4_3;
	public AdvancedModelRenderer gearPiece1_4;
	public AdvancedModelRenderer gearPiece2_4;
	public AdvancedModelRenderer gearPiece3_4;
	public AdvancedModelRenderer gearPiece4_4;
	public AdvancedModelRenderer gearPiece1_5;
	public AdvancedModelRenderer gearPiece2_5;
	public AdvancedModelRenderer gearPiece3_5;
	public AdvancedModelRenderer gearPiece4_5;
	public AdvancedModelRenderer gearPiece1_6;
	public AdvancedModelRenderer gearPiece2_6;
	public AdvancedModelRenderer gearPiece3_6;
	public AdvancedModelRenderer gearPiece4_6;
	public AdvancedModelRenderer gearPiece1_7;
	public AdvancedModelRenderer gearPiece2_7;
	public AdvancedModelRenderer gearPiece3_7;
	public AdvancedModelRenderer gearPiece4_7;
	public AdvancedModelRenderer gearPiece1_8;
	public AdvancedModelRenderer gearPiece2_8;
	public AdvancedModelRenderer gearPiece3_8;
	public AdvancedModelRenderer gearPiece4_8;
	public AdvancedModelRenderer gearPiece1_9;
	public AdvancedModelRenderer gearPiece2_9;
	public AdvancedModelRenderer gearPiece3_9;
	public AdvancedModelRenderer gearPiece4_9;
	public AdvancedModelRenderer gearPiece1_10;
	public AdvancedModelRenderer gearPiece2_10;
	public AdvancedModelRenderer gearPiece3_10;
	public AdvancedModelRenderer gearPiece4_10;
	public AdvancedModelRenderer gearPiece1_11;
	public AdvancedModelRenderer gearPiece2_11;
	public AdvancedModelRenderer gearPiece3_11;
	public AdvancedModelRenderer gearPiece4_11;
	private ModelAnimator animation;

	public ModelMechanicalBlaze() {
		animation = ModelAnimator.create();
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.gearPiece2_7 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece2_7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece2_7.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece2_7, 0.0F, 0.0F, -0.7853981633974483F);
		this.gearPiece2_9 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece2_9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece2_9.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece2_9, 0.0F, 0.0F, -0.7853981633974483F);
		this.gearPiece3 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece3.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece3, 0.0F, 0.0F, 0.7853981633974483F);
		this.gearPiece3_11 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece3_11.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece3_11.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece3_11, 0.0F, 0.0F, 0.7853981633974483F);
		this.gearPiece3_8 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece3_8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece3_8.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece3_8, 0.0F, 0.0F, 0.7853981633974483F);
		this.gearCenter5 = new AdvancedModelRenderer(this, 50, 4);
		this.gearCenter5.setRotationPoint(-6.6F, 3.2F, -7.4F);
		this.gearCenter5.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(gearCenter5, 0.0F, 0.7853981633974483F, 0.0F);
		this.gearPiece2_5 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece2_5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece2_5.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece2_5, 0.0F, 0.0F, -0.7853981633974483F);
		this.gearPiece2_8 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece2_8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece2_8.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece2_8, 0.0F, 0.0F, -0.7853981633974483F);
		this.gearPiece2_2 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece2_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece2_2.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece2_2, 0.0F, 0.0F, -0.7853981633974483F);
		this.gearPiece1_6 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece1_6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece1_6.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.gearCenter2 = new AdvancedModelRenderer(this, 50, 4);
		this.gearCenter2.setRotationPoint(0.2F, 5.4F, -6.9F);
		this.gearCenter2.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.gearPiece4_4 = new AdvancedModelRenderer(this, 36, 9);
		this.gearPiece4_4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece4_4.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2, 0.0F);
		this.gearPiece3_7 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece3_7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece3_7.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece3_7, 0.0F, 0.0F, 0.7853981633974483F);
		this.gearPiece1_11 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece1_11.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece1_11.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.gearPiece3_4 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece3_4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece3_4.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece3_4, 0.0F, 0.0F, 0.7853981633974483F);
		this.gearPiece4_11 = new AdvancedModelRenderer(this, 36, 9);
		this.gearPiece4_11.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece4_11.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2, 0.0F);
		this.gearCenter1 = new AdvancedModelRenderer(this, 50, 4);
		this.gearCenter1.setRotationPoint(-6.6F, 3.2F, 7.4F);
		this.gearCenter1.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(gearCenter1, 0.0F, -0.7853981633974483F, 0.0F);
		this.gearPiece3_9 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece3_9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece3_9.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece3_9, 0.0F, 0.0F, 0.7853981633974483F);
		this.gearPiece1 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece1.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.gearCenter11Bot = new AdvancedModelRenderer(this, 50, 4);
		this.gearCenter11Bot.setRotationPoint(4.0F, 15.0F, -3.0F);
		this.gearCenter11Bot.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(gearCenter11Bot, 0.0F, -0.7853981633974483F, 0.0F);
		this.gearPiece4_5 = new AdvancedModelRenderer(this, 36, 9);
		this.gearPiece4_5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece4_5.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2, 0.0F);
		this.gearCenter8 = new AdvancedModelRenderer(this, 50, 4);
		this.gearCenter8.setRotationPoint(6.6F, 3.2F, 7.4F);
		this.gearCenter8.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(gearCenter8, 0.0F, 0.7853981633974483F, 0.0F);
		this.gearCenter10Bot = new AdvancedModelRenderer(this, 50, 4);
		this.gearCenter10Bot.setRotationPoint(-1.7F, 17.2F, 5.3F);
		this.gearCenter10Bot.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(gearCenter10Bot, 0.0F, -0.7853981633974483F, 0.0F);
		this.gearPiece2_4 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece2_4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece2_4.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece2_4, 0.0F, 0.0F, -0.7853981633974483F);
		this.gearPiece1_9 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece1_9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece1_9.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.gearPiece3_1 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece3_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece3_1.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece3_1, 0.0F, 0.0F, 0.7853981633974483F);
		this.gearPiece3_2 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece3_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece3_2.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece3_2, 0.0F, 0.0F, 0.7853981633974483F);
		this.gearPiece1_4 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece1_4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece1_4.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.gearPiece2_3 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece2_3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece2_3.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece2_3, 0.0F, 0.0F, -0.7853981633974483F);
		this.gearPiece1_7 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece1_7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece1_7.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.gearPiece4_10 = new AdvancedModelRenderer(this, 36, 9);
		this.gearPiece4_10.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece4_10.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2, 0.0F);
		this.gearPiece4 = new AdvancedModelRenderer(this, 36, 9);
		this.gearPiece4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece4.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2, 0.0F);
		this.gearPiece2 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece2.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece2, 0.0F, 0.0F, -0.7853981633974483F);
		this.gearCenter3 = new AdvancedModelRenderer(this, 50, 4);
		this.gearCenter3.setRotationPoint(0.2F, 0.0F, 6.9F);
		this.gearCenter3.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.gearPiece1_8 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece1_8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece1_8.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.gearPiece3_10 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece3_10.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece3_10.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece3_10, 0.0F, 0.0F, 0.7853981633974483F);
		this.gearPiece4_6 = new AdvancedModelRenderer(this, 36, 9);
		this.gearPiece4_6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece4_6.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2, 0.0F);
		this.gearPiece3_5 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece3_5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece3_5.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece3_5, 0.0F, 0.0F, 0.7853981633974483F);
		this.gearPiece1_1 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece1_1.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.gearCenter4 = new AdvancedModelRenderer(this, 50, 4);
		this.gearCenter4.setRotationPoint(-6.9F, 1.4F, -0.2F);
		this.gearCenter4.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(gearCenter4, 0.0F, 1.5707963267948966F, 0.0F);
		this.gearPiece4_2 = new AdvancedModelRenderer(this, 36, 9);
		this.gearPiece4_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece4_2.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2, 0.0F);
		this.gearPiece1_5 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece1_5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece1_5.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.gearPiece3_3 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece3_3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece3_3.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece3_3, 0.0F, 0.0F, 0.7853981633974483F);
		this.gearPiece1_10 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece1_10.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece1_10.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.gearPiece4_7 = new AdvancedModelRenderer(this, 36, 9);
		this.gearPiece4_7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece4_7.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2, 0.0F);
		this.gearCenter12Bot = new AdvancedModelRenderer(this, 50, 4);
		this.gearCenter12Bot.setRotationPoint(5.0F, 18.0F, 3.9F);
		this.gearCenter12Bot.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(gearCenter12Bot, 0.0F, 0.7853981633974483F, 0.0F);
		this.gearPiece4_9 = new AdvancedModelRenderer(this, 36, 9);
		this.gearPiece4_9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece4_9.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2, 0.0F);
		this.gearPiece4_3 = new AdvancedModelRenderer(this, 36, 9);
		this.gearPiece4_3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece4_3.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2, 0.0F);
		this.gearPiece4_8 = new AdvancedModelRenderer(this, 36, 9);
		this.gearPiece4_8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece4_8.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2, 0.0F);
		this.gearPiece1_3 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece1_3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece1_3.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.head = new AdvancedModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
		this.gearPiece2_11 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece2_11.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece2_11.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece2_11, 0.0F, 0.0F, -0.7853981633974483F);
		this.gearPiece2_1 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece2_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece2_1.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece2_1, 0.0F, 0.0F, -0.7853981633974483F);
		this.gearCenter7 = new AdvancedModelRenderer(this, 50, 4);
		this.gearCenter7.setRotationPoint(6.6F, 3.2F, -7.4F);
		this.gearCenter7.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(gearCenter7, 0.0F, -0.7853981633974483F, 0.0F);
		this.gearPiece4_1 = new AdvancedModelRenderer(this, 36, 9);
		this.gearPiece4_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece4_1.addBox(-1.0F, -4.0F, -1.0F, 2, 8, 2, 0.0F);
		this.gearPiece2_6 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece2_6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece2_6.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece2_6, 0.0F, 0.0F, -0.7853981633974483F);
		this.gearCenter6 = new AdvancedModelRenderer(this, 50, 4);
		this.gearCenter6.setRotationPoint(6.9F, 0.0F, -0.2F);
		this.gearCenter6.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(gearCenter6, 0.0F, 1.5707963267948966F, 0.0F);
		this.gearPiece1_2 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece1_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece1_2.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.gearCenter9Bot = new AdvancedModelRenderer(this, 50, 4);
		this.gearCenter9Bot.setRotationPoint(-3.1F, 16.0F, -3.7F);
		this.gearCenter9Bot.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(gearCenter9Bot, 0.0F, 0.7853981633974483F, 0.0F);
		this.gearPiece3_6 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece3_6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece3_6.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece3_6, 0.0F, 0.0F, 0.7853981633974483F);
		this.gearPiece2_10 = new AdvancedModelRenderer(this, 35, 0);
		this.gearPiece2_10.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.gearPiece2_10.addBox(-4.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.setRotateAngle(gearPiece2_10, 0.0F, 0.0F, -0.7853981633974483F);
		this.gearCenter8.addChild(this.gearPiece2_7);
		this.gearCenter10Bot.addChild(this.gearPiece2_9);
		this.gearCenter1.addChild(this.gearPiece3);
		this.gearCenter12Bot.addChild(this.gearPiece3_11);
		this.gearCenter9Bot.addChild(this.gearPiece3_8);
		this.gearCenter6.addChild(this.gearPiece2_5);
		this.gearCenter9Bot.addChild(this.gearPiece2_8);
		this.gearCenter3.addChild(this.gearPiece2_2);
		this.gearCenter7.addChild(this.gearPiece1_6);
		this.gearCenter5.addChild(this.gearPiece4_4);
		this.gearCenter8.addChild(this.gearPiece3_7);
		this.gearCenter12Bot.addChild(this.gearPiece1_11);
		this.gearCenter5.addChild(this.gearPiece3_4);
		this.gearCenter12Bot.addChild(this.gearPiece4_11);
		this.gearCenter10Bot.addChild(this.gearPiece3_9);
		this.gearCenter1.addChild(this.gearPiece1);
		this.gearCenter6.addChild(this.gearPiece4_5);
		this.gearCenter5.addChild(this.gearPiece2_4);
		this.gearCenter10Bot.addChild(this.gearPiece1_9);
		this.gearCenter2.addChild(this.gearPiece3_1);
		this.gearCenter3.addChild(this.gearPiece3_2);
		this.gearCenter5.addChild(this.gearPiece1_4);
		this.gearCenter4.addChild(this.gearPiece2_3);
		this.gearCenter8.addChild(this.gearPiece1_7);
		this.gearCenter11Bot.addChild(this.gearPiece4_10);
		this.gearCenter1.addChild(this.gearPiece4);
		this.gearCenter1.addChild(this.gearPiece2);
		this.gearCenter9Bot.addChild(this.gearPiece1_8);
		this.gearCenter11Bot.addChild(this.gearPiece3_10);
		this.gearCenter7.addChild(this.gearPiece4_6);
		this.gearCenter6.addChild(this.gearPiece3_5);
		this.gearCenter2.addChild(this.gearPiece1_1);
		this.gearCenter3.addChild(this.gearPiece4_2);
		this.gearCenter6.addChild(this.gearPiece1_5);
		this.gearCenter4.addChild(this.gearPiece3_3);
		this.gearCenter11Bot.addChild(this.gearPiece1_10);
		this.gearCenter8.addChild(this.gearPiece4_7);
		this.gearCenter10Bot.addChild(this.gearPiece4_9);
		this.gearCenter4.addChild(this.gearPiece4_3);
		this.gearCenter9Bot.addChild(this.gearPiece4_8);
		this.gearCenter4.addChild(this.gearPiece1_3);
		this.gearCenter12Bot.addChild(this.gearPiece2_11);
		this.gearCenter2.addChild(this.gearPiece2_1);
		this.gearCenter2.addChild(this.gearPiece4_1);
		this.gearCenter7.addChild(this.gearPiece2_6);
		this.gearCenter3.addChild(this.gearPiece1_2);
		this.gearCenter7.addChild(this.gearPiece3_6);
		this.gearCenter11Bot.addChild(this.gearPiece2_10);
		updateDefaultPose();
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
		this.gearCenter5.render(f5);
		this.gearCenter2.render(f5);
		this.gearCenter1.render(f5);
		this.gearCenter11Bot.render(f5);
		this.gearCenter8.render(f5);
		this.gearCenter10Bot.render(f5);
		this.gearCenter3.render(f5);
		this.gearCenter4.render(f5);
		this.gearCenter12Bot.render(f5);
		this.head.render(f5);
		this.gearCenter7.render(f5);
		this.gearCenter6.render(f5);
		this.gearCenter9Bot.render(f5);
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
			EntityMechanicalBlaze entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		resetToDefaultPose();
		EntityMechanicalBlaze EntityMechanicalBlaze = (EntityMechanicalBlaze) entity;

		AdvancedModelRenderer[] blazeGears = { gearCenter1, gearCenter2, gearCenter3, gearCenter4, gearCenter5,
				gearCenter6, gearCenter7, gearCenter8, gearCenter9Bot, gearCenter10Bot, gearCenter11Bot,
				gearCenter12Bot };

		f = EntityMechanicalBlaze.ticksExisted;
		f1 = 0.5f;
		float speed = 0.09F;
		float speed2 = 0.45F;
		float degree = 0.0015F;

		//chainWave(blazeGears, speed, degree, -10, f, -20);
		// chainWave(leg0, speed, degree, -10, f, -20f);
		// chainWave(leg01, speed, degree, -10, f, -20f);

		/*
		 * float co = f * (float) Math.PI * -0.1F;
		 * 
		 * for (int i = 0; i < 4; ++i) { this.blazeGears[i].rotationPointY =
		 * -2.0F + MathHelper.cos(((float) (i * 2) + f) * 0.25F);
		 * this.blazeGears[i].rotationPointX = MathHelper.cos(co) * 9.0F;
		 * this.blazeGears[i].rotationPointZ = MathHelper.sin(co) * 9.0F; ++co;
		 * }
		 * 
		 * co = ((float) Math.PI / 4F) + f * (float) Math.PI * 0.03F;
		 * 
		 * for (int j = 4; j < 8; ++j) { this.blazeGears[j].rotationPointY =
		 * 2.0F + MathHelper.cos(((float) (j * 2) + f) * 0.25F);
		 * this.blazeGears[j].rotationPointX = MathHelper.cos(co) * 7.0F;
		 * this.blazeGears[j].rotationPointZ = MathHelper.sin(co) * 7.0F; ++co;
		 * }
		 * 
		 * co = 0.47123894F + f * (float) Math.PI * -0.05F;
		 * 
		 * for (int k = 8; k < 12; ++k) { this.blazeGears[k].rotationPointY =
		 * 11.0F + MathHelper.cos(((float) k * 1.5F + f) * 0.5F);
		 * this.blazeGears[k].rotationPointX = MathHelper.cos(co) * 5.0F;
		 * this.blazeGears[k].rotationPointZ = MathHelper.sin(co) * 5.0F; ++co;
		 * }
		 */

		this.head.rotateAngleY = f3 * 0.017453292F;
		this.head.rotateAngleX = f4 * 0.017453292F;
	}

	public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		EntityMechanicalBlaze EntityMechanicalBlaze = (EntityMechanicalBlaze) entity;
		animation.update(entity);
		resetToDefaultPose();
		setRotationAngles(f, f1, f2, f3, f4, f5, EntityMechanicalBlaze);

		float speed = 0.9999f;
		float degree = 0.4f;
		float globalHeight = 0.4f;
		// bob(body, speed * 1.5f, degree * 5f, false, f, f1);
		// bob(bottomGlassHolder, speed * 1.5f, degree * 5f, false, f, f1);
		AdvancedModelRenderer[] blazeGears = { gearCenter1, gearCenter2, gearCenter3, gearCenter4, gearCenter5,
				gearCenter6, gearCenter7, gearCenter8, gearCenter9Bot, gearCenter10Bot, gearCenter11Bot,
				gearCenter12Bot };
		f = EntityMechanicalBlaze.ticksExisted;
		f1 = 0.5f;
		walk(gearCenter1, 0.001f, 360f, false, 0f, 0f, f, f1);
		walk(gearCenter2, 0.001f, 360f, false, 0f, 0f, f, f1);
		walk(gearCenter3, 0.001f, 360f, false, 0f, 0f, f, f1);
		walk(gearCenter4, 0.001f, 360f, false, 0f, 0f, f, f1);
		walk(gearCenter5, 0.001f, 360f, false, 0f, 0f, f, f1);
		walk(gearCenter6, 0.001f, 360f, false, 0f, 0f, f, f1);
		walk(gearCenter7, 0.001f, 360f, false, 0f, 0f, f, f1);
		walk(gearCenter8, 0.001f, 360f, false, 0f, 0f, f, f1);
		walk(gearCenter9Bot, 0.001f, 360f, false, 0f, 0f, f, f1);
		walk(gearCenter10Bot, 0.001f, 360f, false, 0f, 0f, f, f1);
		walk(gearCenter11Bot, 0.001f, 360f, false, 0f, 0f, f, f1);
		walk(gearCenter12Bot, 0.001f, 360f, false, 0f, 0f, f, f1);
		
		flap(gearCenter1, 0.001f, 360f, false, 0f, 0f, f, f1);
		flap(gearCenter2, 0.001f, 360f, false, 0f, 0f, f, f1);
		flap(gearCenter3, 0.001f, 360f, false, 0f, 0f, f, f1);
		flap(gearCenter4, 0.001f, 360f, false, 0f, 0f, f, f1);
		flap(gearCenter5, 0.001f, 360f, false, 0f, 0f, f, f1);
		flap(gearCenter6, 0.001f, 360f, false, 0f, 0f, f, f1);
		flap(gearCenter7, 0.001f, 360f, false, 0f, 0f, f, f1);
		flap(gearCenter8, 0.001f, 360f, false, 0f, 0f, f, f1);
		flap(gearCenter9Bot, 0.001f, 360f, false, 0f, 0f, f, f1);
		flap(gearCenter10Bot, 0.001f, 360f, false, 0f, 0f, f, f1);
		flap(gearCenter11Bot, 0.001f, 360f, false, 0f, 0f, f, f1);
		flap(gearCenter12Bot, 0.001f, 360f, false, 0f, 0f, f, f1);
		
		swing(gearCenter1, 0.001f, 360f, false, 0f, 0f, f, f1);
		swing(gearCenter2, 0.001f, 360f, false, 0f, 0f, f, f1);
		swing(gearCenter3, 0.001f, 360f, false, 0f, 0f, f, f1);
		swing(gearCenter4, 0.001f, 360f, false, 0f, 0f, f, f1);
		swing(gearCenter5, 0.001f, 360f, false, 0f, 0f, f, f1);
		swing(gearCenter6, 0.001f, 360f, false, 0f, 0f, f, f1);
		swing(gearCenter7, 0.001f, 360f, false, 0f, 0f, f, f1);
		swing(gearCenter8, 0.001f, 360f, false, 0f, 0f, f, f1);
		swing(gearCenter9Bot, 0.001f, 360f, true, 0f, 0f, f, f1);
		swing(gearCenter10Bot, 0.001f, 360f, true, 0f, 0f, f, f1);
		swing(gearCenter11Bot, 0.001f, 360f, true, 0f, 0f, f, f1);
		swing(gearCenter12Bot, 0.001f, 360f, true, 0f, 0f, f, f1);
		
		bob(gearCenter1, 0.001f, 360f, false, 0f, 0f);
		bob(gearCenter2, 0.001f, 360f, false, 0f, 0f);
		bob(gearCenter3, 0.001f, 360f, false, 0f, 0f);
		bob(gearCenter4, 0.001f, 360f, false, 0f, 0f);
		bob(gearCenter5, 0.001f, 360f, false, 0f, 0f);
		bob(gearCenter6, 0.001f, 360f, false, 0f, 0f);
		bob(gearCenter7, 0.001f, 360f, false, 0f, 0f);
		bob(gearCenter8, 0.001f, 360f, false, 0f, 0f);
		bob(gearCenter9Bot, 0.001f, 360f, true, 0f, 0f);
		bob(gearCenter10Bot, 0.001f, 360f, true, 0f, 0f);
		bob(gearCenter11Bot, 0.001f, 360f, true, 0f, 0f);
		bob(gearCenter12Bot, 0.001f, 360f, true, 0f, 0f);
		
//flap 
		//chainFlap(blazeGears, speed , degree * 10, -10f, f, -20f);

	}
}
