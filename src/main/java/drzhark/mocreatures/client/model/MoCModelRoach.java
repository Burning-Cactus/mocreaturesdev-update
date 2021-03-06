package drzhark.mocreatures.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import drzhark.mocreatures.entity.ambient.RoachEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class MoCModelRoach extends EntityModel<RoachEntity> {

    ModelRenderer Head;
    ModelRenderer LAnthenna;
    ModelRenderer LAnthennaB;
    ModelRenderer RAnthenna;
    ModelRenderer RAnthennaB;
    ModelRenderer Thorax;
    ModelRenderer FrontLegs;
    ModelRenderer MidLegs;
    ModelRenderer RearLegs;
    ModelRenderer Abdomen;
    ModelRenderer TailL;
    ModelRenderer TailR;
    ModelRenderer LShellClosed;
    ModelRenderer RShellClosed;
    ModelRenderer LShellOpen;
    ModelRenderer RShellOpen;
    ModelRenderer LeftWing;
    ModelRenderer RightWing;
    private float radianF = 57.29578F;
    private boolean isFlying = false;

    public MoCModelRoach() {
        this.texWidth = 32;
        this.texHeight = 32;

        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-0.5F, 0F, -1F, 1, 1, 2);
        this.Head.setPos(0F, 23F, -2F);
        setRotation(this.Head, -2.171231F, 0F, 0F);

        this.LAnthenna = new ModelRenderer(this, 3, 21);
        //LAnthenna.addBox(0F, 0F, 0F, 4, 0, 1);
        //LAnthenna.setRotationPoint(0F, 22F, -2.5F);
        this.LAnthenna.addBox(0F, 0F, 0F, 4, 0, 1);
        this.LAnthenna.setPos(0.5F, 0F, 0F);

        //LAnthenna.addBox(0.5F, 0.7F, -1.5F, 4, 0, 1);
        //LAnthenna.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotation(this.LAnthenna, -90F / this.radianF, 0.4363323F, 0F);//-45F/radianF);
        this.Head.addChild(this.LAnthenna);

        this.LAnthennaB = new ModelRenderer(this, 4, 21);
        //LAnthennaB.addBox(3.9F, 7F, -1.7F, 3, 0, 1);
        //LAnthennaB.setRotationPoint(0F, 15F, -2.5F);

        this.LAnthennaB.addBox(0F, 0F, 1F, 3, 0, 1);
        this.LAnthennaB.setPos(2.5F, 0F, -0.5F);

        //LAnthennaB.addBox(0F, 0F, 1F, 3, 0, 1);
        //LAnthennaB.setRotationPoint(2.5F, 0F, 0F);
        setRotation(this.LAnthennaB, 0F, 45F / this.radianF, 0F);
        this.LAnthenna.addChild(this.LAnthennaB);

        this.RAnthenna = new ModelRenderer(this, 3, 19);
        this.RAnthenna.addBox(-4.5F, 0F, 0F, 4, 0, 1);
        //RAnthenna.setRotationPoint(-3.5F, 0.7F, -1.5F);
        //RAnthenna.setRotationPoint(0F, 0.7F, -1.5F);
        this.RAnthenna.setPos(0F, 0F, 0F);
        setRotation(this.RAnthenna, -90F / this.radianF, -0.4363323F, 0F);
        this.Head.addChild(this.RAnthenna);

        this.RAnthennaB = new ModelRenderer(this, 4, 19);
        this.RAnthennaB.addBox(-4.0F, 0F, 1F, 3, 0, 1);
        this.RAnthennaB.setPos(-2.5F, 0F, 0.5F);
        setRotation(this.RAnthennaB, 0F, -45F / this.radianF, 0F);
        this.RAnthenna.addChild(this.RAnthennaB);

        this.Thorax = new ModelRenderer(this, 0, 3);
        this.Thorax.addBox(-1F, 0F, -1F, 2, 1, 2);
        this.Thorax.setPos(0F, 22F, -1F);

        this.FrontLegs = new ModelRenderer(this, 0, 11);
        this.FrontLegs.addBox(-2F, 0F, 0F, 4, 2, 0);
        this.FrontLegs.setPos(0F, 23F, -1.8F);
        setRotation(this.FrontLegs, -1.115358F, 0F, 0F);

        this.MidLegs = new ModelRenderer(this, 0, 13);
        this.MidLegs.addBox(-2.5F, 0F, 0F, 5, 2, 0);
        this.MidLegs.setPos(0F, 23F, -1.2F);
        setRotation(this.MidLegs, 1.264073F, 0F, 0F);

        this.RearLegs = new ModelRenderer(this, 0, 15);
        this.RearLegs.addBox(-2F, 0F, 0F, 4, 4, 0);
        this.RearLegs.setPos(0F, 23F, -0.4F);
        setRotation(this.RearLegs, 1.368173F, 0F, 0F);

        this.Abdomen = new ModelRenderer(this, 0, 6);
        this.Abdomen.addBox(-1F, 0F, -1F, 2, 4, 1);
        this.Abdomen.setPos(0F, 22F, 0F);
        setRotation(this.Abdomen, 1.427659F, 0F, 0F);

        this.TailL = new ModelRenderer(this, 2, 29);
        this.TailL.addBox(-0.5F, 0F, 0F, 1, 2, 0);
        this.TailL.setPos(0F, 23F, 3.6F);
        setRotation(this.TailL, 1.554066F, 0.6457718F, 0F);

        this.TailR = new ModelRenderer(this, 0, 29);
        this.TailR.addBox(-0.5F, 0F, 0F, 1, 2, 0);
        this.TailR.setPos(0F, 23F, 3.6F);
        setRotation(this.TailR, 1.554066F, -0.6457718F, 0F);

        this.LShellClosed = new ModelRenderer(this, 4, 23);
        this.LShellClosed.addBox(0F, 0F, 0F, 2, 0, 6);
        this.LShellClosed.setPos(0F, 21.5F, -1.5F);
        setRotation(this.LShellClosed, -0.1487144F, -0.0872665F, 0.1919862F);

        this.RShellClosed = new ModelRenderer(this, 0, 23);
        this.RShellClosed.addBox(-2F, 0F, 0F, 2, 0, 6);
        this.RShellClosed.setPos(0F, 21.5F, -1.5F);
        setRotation(this.RShellClosed, -0.1487144F, 0.0872665F, -0.1919862F);

        this.LShellOpen = new ModelRenderer(this, 4, 23);
        this.LShellOpen.addBox(0F, 0F, 0F, 2, 0, 6);
        this.LShellOpen.setPos(0F, 21.5F, -1.5F);
        setRotation(this.LShellOpen, 1.117011F, -0.0872665F, 1.047198F);

        this.RShellOpen = new ModelRenderer(this, 0, 23);
        this.RShellOpen.addBox(-2F, 0F, 0F, 2, 0, 6);
        this.RShellOpen.setPos(0F, 21.5F, -1.5F);
        setRotation(this.RShellOpen, 1.117011F, 0.0872665F, -1.047198F);

        this.LeftWing = new ModelRenderer(this, 11, 21);
        this.LeftWing.addBox(0F, 1F, -1F, 6, 0, 2);
        this.LeftWing.setPos(0F, 21.5F, -1.5F);
        this.LeftWing.setTexSize(32, 32);
        this.LeftWing.mirror = true;
        setRotation(this.LeftWing, 0F, -1.047198F, -0.4363323F);
        this.RightWing = new ModelRenderer(this, 11, 19);
        this.RightWing.addBox(-6F, 1F, -1F, 6, 0, 2);
        this.RightWing.setPos(0F, 21.5F, -1.5F);
        this.RightWing.setTexSize(32, 32);
        this.RightWing.mirror = true;
        setRotation(this.RightWing, 0F, 1.047198F, 0.4363323F);
    }

    @Override
    public void setupAnim(RoachEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        RoachEntity entityroach = entityIn;
        this.isFlying = (entityroach.getIsFlying() || entityroach.getDeltaMovement().y < -0.1D);

        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, isFlying);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, boolean isFlying) {
        this.Head.xRot = -2.171231F + (f4 / 57.29578F);
        //Head.rotateAngleY = f3 / 57.29578F;

        //f1 = movement speed!
        //f2 = timer!

        float antMov = 5F / this.radianF + (f1 * 1.5F);

        this.LAnthenna.zRot = -antMov;
        this.RAnthenna.zRot = antMov;

        float legMov = 0F;
        float legMovB = 0F;

        float frontLegAdj = 0F;

        if (isFlying) {
            float WingRot = MathHelper.cos((f2 * 2.0F)) * 0.7F;
            this.RightWing.yRot = 1.047198F + WingRot;
            this.LeftWing.yRot = -1.047198F - WingRot;
            legMov = (f1 * 1.5F);
            legMovB = legMov;
            frontLegAdj = 1.4F;

        } else {
            legMov = MathHelper.cos((f * 1.5F) + 3.141593F) * 0.6F * f1;
            legMovB = MathHelper.cos(f * 1.5F) * 0.8F * f1;
        }

        //AntennaB.rotateAngleX = 2.88506F - legMov;

        this.FrontLegs.xRot = -1.115358F + frontLegAdj + legMov;
        this.MidLegs.xRot = 1.264073F + legMovB;
        this.RearLegs.xRot = 1.368173F - frontLegAdj + legMov;

    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.Head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        //LAnthenna.render(f5);
        //LAnthennaB.render(f5);
        //RAnthenna.render(f5);
        //RAnthennaB.render(f5);
        this.Thorax.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.FrontLegs.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.MidLegs.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.RearLegs.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Abdomen.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.TailL.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.TailR.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);

        if (!isFlying) {
            this.LShellClosed.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.RShellClosed.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        } else {
            this.LShellOpen.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.RShellOpen.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            matrixStackIn.pushPose();
            this.LeftWing.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.RightWing.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            matrixStackIn.popPose();
//            GL11.glPushMatrix();
//            GL11.glEnable(3042 /* GL_BLEND */);
//            float transparency = 0.6F;
//            GL11.glBlendFunc(770, 771);
//            GL11.glColor4f(0.8F, 0.8F, 0.8F, transparency);
//            this.LeftWing.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
//            this.RightWing.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
//            GL11.glDisable(3042/* GL_BLEND */);
//            GL11.glPopMatrix();
        }
    }
}
