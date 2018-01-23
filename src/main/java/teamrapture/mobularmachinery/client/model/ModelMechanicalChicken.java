package teamrapture.mobularmachinery.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Mech Chick Created using Tabula 7.0.0
 */
public class ModelMechanicalChicken extends ModelBase {
	public ModelRenderer body;
	public ModelRenderer head;
	public ModelRenderer leftWing;
	public ModelRenderer leftLeg;
	public ModelRenderer rightWing;
	public ModelRenderer rightLeg;
	public ModelRenderer wirebacktoneck;
	public ModelRenderer beak;
	public ModelRenderer redShitOnFace;
	public ModelRenderer wirebacktoneck_1;
	public ModelRenderer wirebacktoneck_2;
	public ModelRenderer wirebacktoneck_3;
	public ModelRenderer wirebacktoneck_4;
	public ModelRenderer wirebacktoneck_5;
	public ModelRenderer wirebacktoneck_6;
	public ModelRenderer wirebacktoneck_7;
	public ModelRenderer wirebacktoneck_8;
	public ModelRenderer wirebacktoneck_9;
	public ModelRenderer wirebacktoneck_10;
	public ModelRenderer wirebacktoneck_11;
	public ModelRenderer wirebacktoneck_12;

	public ModelMechanicalChicken() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.rightLeg = new ModelRenderer(this, 26, 0);
		this.rightLeg.setRotationPoint(-2.0F, 2.0F, 1.0F);
		this.rightLeg.addBox(-1.0F, 0.0F, -3.0F, 3, 5, 3, 0.0F);
		this.wirebacktoneck_3 = new ModelRenderer(this, 11, 0);
		this.wirebacktoneck_3.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.wirebacktoneck_3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.wirebacktoneck_5 = new ModelRenderer(this, 11, 0);
		this.wirebacktoneck_5.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.wirebacktoneck_5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.wirebacktoneck_11 = new ModelRenderer(this, 11, 0);
		this.wirebacktoneck_11.setRotationPoint(0.0F, 0.0F, -1.0F);
		this.wirebacktoneck_11.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.wirebacktoneck_10 = new ModelRenderer(this, 11, 0);
		this.wirebacktoneck_10.setRotationPoint(0.0F, 1.0F, -1.0F);
		this.wirebacktoneck_10.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.wirebacktoneck_12 = new ModelRenderer(this, 11, 0);
		this.wirebacktoneck_12.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.wirebacktoneck_12.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.beak = new ModelRenderer(this, 14, 0);
		this.beak.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.beak.addBox(-2.0F, -4.0F, -4.0F, 4, 2, 2, 0.0F);
		this.wirebacktoneck_7 = new ModelRenderer(this, 11, 0);
		this.wirebacktoneck_7.setRotationPoint(0.0F, 0.0F, -1.0F);
		this.wirebacktoneck_7.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.wirebacktoneck_1 = new ModelRenderer(this, 11, 0);
		this.wirebacktoneck_1.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.wirebacktoneck_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.wirebacktoneck_6 = new ModelRenderer(this, 11, 0);
		this.wirebacktoneck_6.setRotationPoint(0.0F, 0.0F, -1.0F);
		this.wirebacktoneck_6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.rightWing = new ModelRenderer(this, 28, 13);
		this.rightWing.setRotationPoint(-4.0F, -4.0F, 3.0F);
		this.rightWing.addBox(0.0F, 0.0F, -5.0F, 1, 4, 6, 0.0F);
		this.redShitOnFace = new ModelRenderer(this, 14, 4);
		this.redShitOnFace.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.redShitOnFace.addBox(-1.0F, -2.0F, -3.0F, 2, 2, 2, 0.0F);
		this.wirebacktoneck_4 = new ModelRenderer(this, 11, 0);
		this.wirebacktoneck_4.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.wirebacktoneck_4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.body = new ModelRenderer(this, 0, 9);
		this.body.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.body.addBox(-3.0F, -4.0F, -3.0F, 6, 6, 8, 0.0F);
		this.leftWing = new ModelRenderer(this, 28, 13);
		this.leftWing.setRotationPoint(4.0F, -4.0F, 1.0F);
		this.leftWing.addBox(-1.0F, 0.0F, -3.0F, 1, 4, 6, 0.0F);
		this.wirebacktoneck = new ModelRenderer(this, 11, 0);
		this.wirebacktoneck.setRotationPoint(-1.0F, -5.0F, 0.0F);
		this.wirebacktoneck.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.wirebacktoneck_2 = new ModelRenderer(this, 11, 0);
		this.wirebacktoneck_2.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.wirebacktoneck_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, -1.0F, -4.0F);
		this.head.addBox(-2.0F, -6.0F, -2.0F, 4, 6, 3, 0.0F);
		this.wirebacktoneck_9 = new ModelRenderer(this, 11, 0);
		this.wirebacktoneck_9.setRotationPoint(0.0F, 0.0F, -1.0F);
		this.wirebacktoneck_9.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.leftLeg = new ModelRenderer(this, 26, 0);
		this.leftLeg.setRotationPoint(1.0F, 2.0F, 1.0F);
		this.leftLeg.addBox(-1.0F, 0.0F, -3.0F, 3, 5, 3, 0.0F);
		this.wirebacktoneck_8 = new ModelRenderer(this, 11, 0);
		this.wirebacktoneck_8.setRotationPoint(0.0F, 0.0F, -1.0F);
		this.wirebacktoneck_8.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.body.addChild(this.rightLeg);
		this.wirebacktoneck_2.addChild(this.wirebacktoneck_3);
		this.wirebacktoneck_4.addChild(this.wirebacktoneck_5);
		this.wirebacktoneck_9.addChild(this.wirebacktoneck_11);
		this.wirebacktoneck_9.addChild(this.wirebacktoneck_10);
		this.wirebacktoneck_10.addChild(this.wirebacktoneck_12);
		this.head.addChild(this.beak);
		this.wirebacktoneck_6.addChild(this.wirebacktoneck_7);
		this.wirebacktoneck.addChild(this.wirebacktoneck_1);
		this.wirebacktoneck_5.addChild(this.wirebacktoneck_6);
		this.body.addChild(this.rightWing);
		this.head.addChild(this.redShitOnFace);
		this.wirebacktoneck_3.addChild(this.wirebacktoneck_4);
		this.body.addChild(this.leftWing);
		this.body.addChild(this.wirebacktoneck);
		this.wirebacktoneck_1.addChild(this.wirebacktoneck_2);
		this.body.addChild(this.head);
		this.wirebacktoneck_8.addChild(this.wirebacktoneck_9);
		this.body.addChild(this.leftLeg);
		this.wirebacktoneck_7.addChild(this.wirebacktoneck_8);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.body.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
