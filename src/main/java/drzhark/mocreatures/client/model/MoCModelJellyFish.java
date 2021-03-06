package drzhark.mocreatures.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import drzhark.mocreatures.entity.aquatic.MoCEntityJellyFish;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MoCModelJellyFish extends EntityModel<MoCEntityJellyFish> {

    public MoCModelJellyFish() {
        this.texWidth = 64;
        this.texHeight = 16;

        this.Top = new ModelRenderer(this, 0, 10);
        this.Top.addBox(-2.5F, 0F, -2.5F, 5, 1, 5);
        this.Top.setPos(0F, 11F, 0F);

        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-4F, 0F, -4F, 8, 2, 8);
        this.Head.setPos(0F, 12F, 0F);

        this.HeadSmall = new ModelRenderer(this, 24, 0);
        this.HeadSmall.addBox(-2F, 0F, -2F, 4, 3, 4);
        this.HeadSmall.setPos(0F, 12.5F, 0F);

        this.Body = new ModelRenderer(this, 36, 0);
        this.Body.addBox(-3.5F, 0F, -3.5F, 7, 7, 7);
        this.Body.setPos(0F, 13.8F, 0F);

        this.BodyCenter = new ModelRenderer(this, 0, 0);
        this.BodyCenter.addBox(-1F, 0F, -1F, 2, 3, 2);
        this.BodyCenter.setPos(0F, 15.5F, 0F);

        this.BodyBottom = new ModelRenderer(this, 20, 10);
        this.BodyBottom.addBox(-2F, 0F, -2F, 4, 2, 4);
        this.BodyBottom.setPos(0F, 18.3F, 0F);

        this.Side1 = new ModelRenderer(this, 20, 10);
        this.Side1.addBox(-2F, 5F, 0F, 4, 2, 4);
        this.Side1.setPos(0F, 12.5F, 0F);
        setRotation(this.Side1, -0.7679449F, 0F, 0F);

        this.Side2 = new ModelRenderer(this, 20, 10);
        this.Side2.addBox(-4F, 5F, -2F, 4, 2, 4);
        this.Side2.setPos(0F, 12.5F, 0F);
        setRotation(this.Side2, 0F, 0F, -0.7679449F);

        this.Side3 = new ModelRenderer(this, 20, 10);
        this.Side3.addBox(0F, 5F, -2F, 4, 2, 4);
        this.Side3.setPos(0F, 12.5F, 0F);
        setRotation(this.Side3, 0F, 0F, 0.7679449F);

        this.Side4 = new ModelRenderer(this, 20, 10);
        this.Side4.addBox(-2F, 5F, -4F, 4, 2, 4);
        this.Side4.setPos(0F, 12.5F, 0F);
        setRotation(this.Side4, 0.7679449F, 0F, 0F);

        this.LegSmall1 = new ModelRenderer(this, 60, 2);
        this.LegSmall1.addBox(-1F, 0F, -1F, 1, 3, 1);
        this.LegSmall1.setPos(0F, 18.5F, 0F);

        this.LegC1 = new ModelRenderer(this, 15, 10);
        this.LegC1.addBox(-1F, 0F, -1F, 1, 4, 1);
        this.LegC1.setPos(-0.5F, 15.5F, -0.5F);
        setRotation(this.LegC1, -0.2602503F, 0F, 0.1487144F);

        this.LegC2 = new ModelRenderer(this, 15, 10);
        this.LegC2.addBox(-1F, 0F, 0F, 1, 4, 1);
        this.LegC2.setPos(0.5F, 15.5F, -0.5F);
        setRotation(this.LegC2, 0.1487144F, 1.747395F, 0F);

        this.LegC3 = new ModelRenderer(this, 15, 10);
        this.LegC3.addBox(-1F, 0F, 0F, 1, 4, 1);
        this.LegC3.setPos(-0.5F, 15.5F, 0.5F);
        setRotation(this.LegC3, 0.1115358F, 0.3717861F, 0.2230717F);

        this.Leg1 = new ModelRenderer(this, 0, 10);
        this.Leg1.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        this.Leg1.setPos(0F, 20F, 2.5F);

        this.Leg2 = new ModelRenderer(this, 0, 10);
        this.Leg2.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        this.Leg2.setPos(0F, 20F, -2.5F);

        this.Leg3 = new ModelRenderer(this, 0, 10);
        this.Leg3.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        this.Leg3.setPos(2.5F, 20F, 0F);

        this.Leg4 = new ModelRenderer(this, 0, 10);
        this.Leg4.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        this.Leg4.setPos(-2.5F, 20F, 0F);

        this.Leg5 = new ModelRenderer(this, 0, 10);
        this.Leg5.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        this.Leg5.setPos(2F, 20F, 2F);
        setRotation(this.Leg5, 0F, 0.7853982F, 0F);

        this.Leg6 = new ModelRenderer(this, 0, 10);
        this.Leg6.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        this.Leg6.setPos(2F, 20F, -2F);
        setRotation(this.Leg6, 0F, 0.7853982F, 0F);

        this.Leg7 = new ModelRenderer(this, 0, 10);
        this.Leg7.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        this.Leg7.setPos(-2F, 20F, -2F);
        setRotation(this.Leg7, 0F, 0.7853982F, 0F);

        this.Leg8 = new ModelRenderer(this, 60, 0);
        this.Leg8.addBox(0F, 0F, 0F, 1, 5, 1);
        this.Leg8.setPos(0F, 18.5F, 0F);

        this.Leg9 = new ModelRenderer(this, 0, 10);
        this.Leg9.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        this.Leg9.setPos(-2F, 20F, 2F);
        setRotation(this.Leg9, 0F, 0.7853982F, 0F);
    }

    @Override
    public void setupAnim(MoCEntityJellyFish entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4) {
        float f6 = f1 * 2.0F;
        if (f6 > 1.0F) {
            f6 = 1.0F;
        }

        this.LegSmall1.xRot = f6;
        this.LegC1.xRot = f6;
        this.LegC2.xRot = f6;
        this.LegC3.xRot = f6;
        this.Leg1.xRot = f6;
        this.Leg2.xRot = f6;
        this.Leg3.xRot = f6;
        this.Leg4.xRot = f6;
        this.Leg5.xRot = f6;
        this.Leg6.xRot = f6;
        this.Leg7.xRot = f6;
        this.Leg8.xRot = f6;
        this.Leg9.xRot = f6;
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    ModelRenderer Top;
    ModelRenderer Head;
    ModelRenderer HeadSmall;
    ModelRenderer Body;
    ModelRenderer BodyCenter;
    ModelRenderer BodyBottom;
    ModelRenderer Side1;
    ModelRenderer Side2;
    ModelRenderer Side3;
    ModelRenderer Side4;
    ModelRenderer LegSmall1;
    ModelRenderer LegC1;
    ModelRenderer LegC2;
    ModelRenderer LegC3;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Leg5;
    ModelRenderer Leg6;
    ModelRenderer Leg7;
    ModelRenderer Leg8;
    ModelRenderer Leg9;

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        /* Disable until transparency issues with players are fixed
        MoCEntityJellyFish jellyfish = (MoCEntityJellyFish) entity;
        boolean glowing = jellyfish.isGlowing();
        boolean outOfWater = !jellyfish.isInWater();
        GL11.glPushMatrix();

        if (outOfWater) {
            GL11.glTranslatef(0F, 0.6F, -0.3F);
        } else {
            GL11.glTranslatef(0F, 0.2F, 0F);

            //GL11.glRotatef((float) (f1 * -60D), -1F, 0.0F, 0.0F);

        }*/
        //GL11.glEnable(3042 /* GL_BLEND */);
        /*if (!glowing || outOfWater) {
            float transparency = 0.7F;
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(0.8F, 0.8F, 0.8F, transparency);
        } else {
            GL11.glBlendFunc(770, 1);
        }*/
        this.Top.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.HeadSmall.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.BodyCenter.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.BodyBottom.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Side1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Side2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Side3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Side4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.LegSmall1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.LegC1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.LegC2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.LegC3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Leg1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Leg2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Leg3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Leg4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Leg5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Leg6.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Leg7.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Leg8.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Leg9.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);

        //GL11.glDisable(3042/* GL_BLEND */);
        //GL11.glPopMatrix();
    }
}
