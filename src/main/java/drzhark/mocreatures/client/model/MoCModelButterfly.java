package drzhark.mocreatures.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import drzhark.mocreatures.entity.ambient.ButterflyEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MoCModelButterfly<T extends ButterflyEntity> extends EntityModel<T> {

    ModelRenderer Abdomen;
    ModelRenderer FrontLegs;
    ModelRenderer RightAntenna;
    ModelRenderer LeftAntenna;
    ModelRenderer RearLegs;
    ModelRenderer MidLegs;
    ModelRenderer Head;
    ModelRenderer Thorax;
    ModelRenderer WingRight;
    ModelRenderer WingLeft;
    ModelRenderer Mouth;
    ModelRenderer WingLeftFront;
    ModelRenderer WingRightFront;
    ModelRenderer WingRightBack;
    ModelRenderer WingLeftBack;

    public MoCModelButterfly() {
        this.texWidth = 32;
        this.texHeight = 32;

        this.Head = new ModelRenderer(this, 0, 11);
        this.Head.addBox(-0.5F, 0F, 0F, 1, 1, 1);
        this.Head.setPos(0F, 21.9F, -1.3F);
        setRotation(this.Head, -2.171231F, 0F, 0F);

        this.Mouth = new ModelRenderer(this, 0, 8);
        this.Mouth.addBox(0F, 0F, 0F, 1, 2, 0);
        this.Mouth.setPos(-0.2F, 22F, -2.5F);
        setRotation(this.Mouth, 0.6548599F, 0F, 0F);

        this.RightAntenna = new ModelRenderer(this, 0, 7);
        this.RightAntenna.addBox(-0.5F, 0F, -1F, 1, 0, 1);
        this.RightAntenna.setPos(-0.5F, 21.7F, -2.3F);
        setRotation(this.RightAntenna, -1.041001F, 0.7853982F, 0F);

        this.LeftAntenna = new ModelRenderer(this, 4, 7);
        this.LeftAntenna.addBox(-0.5F, 0F, -1F, 1, 0, 1);
        this.LeftAntenna.setPos(0.5F, 21.7F, -2.3F);
        setRotation(this.LeftAntenna, -1.041001F, -0.7853982F, 0F);

        this.Thorax = new ModelRenderer(this, 0, 0);
        this.Thorax.addBox(-0.5F, 1.5F, -1F, 1, 1, 2);
        this.Thorax.setPos(0F, 20F, -1F);

        this.Abdomen = new ModelRenderer(this, 8, 1);
        this.Abdomen.addBox(-0.5F, 0F, -1F, 1, 3, 1);
        this.Abdomen.setPos(0F, 21.5F, 0F);
        setRotation(this.Abdomen, 1.427659F, 0F, 0F);

        this.FrontLegs = new ModelRenderer(this, 0, 8);
        this.FrontLegs.addBox(-1F, 0F, 0F, 2, 3, 0);
        this.FrontLegs.setPos(0F, 21.5F, -1.8F);
        setRotation(this.FrontLegs, 0.1487144F, 0F, 0F);

        this.MidLegs = new ModelRenderer(this, 4, 8);
        this.MidLegs.addBox(-1F, 0F, 0F, 2, 3, 0);
        this.MidLegs.setPos(0F, 22F, -1.2F);
        setRotation(this.MidLegs, 0.5948578F, 0F, 0F);

        this.RearLegs = new ModelRenderer(this, 0, 8);
        this.RearLegs.addBox(-1F, 0F, 0F, 2, 3, 0);
        this.RearLegs.setPos(0F, 22.5F, -0.4F);
        setRotation(this.RearLegs, 1.070744F, 0F, 0F);

        this.WingLeftFront = new ModelRenderer(this, 4, 20);
        this.WingLeftFront.addBox(0F, 0F, -4F, 8, 0, 6);
        this.WingLeftFront.setPos(0.3F, 21.4F, -1F);

        this.WingLeft = new ModelRenderer(this, 4, 26);
        this.WingLeft.addBox(0F, 0F, -1F, 8, 0, 6);
        this.WingLeft.setPos(0.3F, 21.5F, -0.5F);

        this.WingLeftBack = new ModelRenderer(this, 4, 0);
        this.WingLeftBack.addBox(0F, 0F, -1F, 5, 0, 8);
        this.WingLeftBack.setPos(0.3F, 21.2F, -1F);
        setRotation(this.WingLeftBack, 0F, 0F, 0.5934119F);

        /*
         * WingRight = new ModelRenderer(this, 4, 14); WingRight.addBox(-8F, 0F,
         * 0F, 8, 0, 6); WingRight.setRotationPoint(-0.3F, 21.5F, 0F); WingLeft
         * = new ModelRenderer(this, 4, 26); WingLeft.addBox(0F, 0F, 0F, 8, 0,
         * 6); WingLeft.setRotationPoint(0.3F, 21.5F, 0F);
         */

        this.WingRightFront = new ModelRenderer(this, 4, 8);
        this.WingRightFront.addBox(-8F, 0F, -4F, 8, 0, 6);
        this.WingRightFront.setPos(-0.3F, 21.4F, -1F);

        this.WingRight = new ModelRenderer(this, 4, 14);
        this.WingRight.addBox(-8F, 0F, -1F, 8, 0, 6);
        this.WingRight.setPos(-0.3F, 21.5F, -0.5F);

        this.WingRightBack = new ModelRenderer(this, 14, 0);
        this.WingRightBack.addBox(-5F, 0F, -1F, 5, 0, 8);
        this.WingRightBack.setPos(0.3F, 21.2F, -1F);
        setRotation(this.WingRightBack, 0F, 0F, -0.5934119F);
    }

    @Override
    public void setupAnim(T entityIn, float v, float v1, float v2, float v3, float v4) {
        ButterflyEntity butterfly = (ButterflyEntity) entityIn;
        boolean flying = (butterfly.getIsFlying() || butterfly.getDeltaMovement().y < -0.1D);
        setRotationAngles(v, v1, v2, v3, v4, !flying);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, boolean onGround) {

        /**
         * buttefly to have two / 3 movs: 1 slow movement when idle on ground
         * has to be random from closing up to horizontal 2 fast wing flapping
         * flying movement, short range close to 0 degree RLegXRot =
         * MathHelper.cos((f * 0.6662F) + 3.141593F) * 0.8F * f1;
         */

        /**
         * f = distance walked f1 = speed 0 - 1 f2 = timer
         */

        float f2a = f2 % 100F;
        float WingRot = 0F;
        float legMov = 0F;
        float legMovB = 0F;

        if (!onGround) //flying
        {
            WingRot = MathHelper.cos((f2 * 0.9F)) * 0.9F;

            /*
             * WingRot = MathHelper.cos((f2 * 0.6662F)) * 0.5F; if (f2a > 40 &
             * f2a < 60) { WingRot = MathHelper.cos((f2 * 0.9F)) * 0.9F; }
             */
            legMov = (f1 * 1.5F);
            legMovB = legMov;
        } else {
            legMov = MathHelper.cos((f * 1.5F) + 3.141593F) * 2.0F * f1;
            legMovB = MathHelper.cos(f * 1.5F) * 2.0F * f1;
            if (f2a > 40 & f2a < 60) //random movement
            {
                WingRot = MathHelper.cos((f2 * 0.15F)) * 0.9F;
            }

        }

        float baseAngle = 0.52359F;

        this.WingLeft.zRot = -baseAngle + WingRot;
        this.WingRight.zRot = baseAngle - WingRot;
        this.WingLeftFront.zRot = -baseAngle + WingRot;

        this.WingLeftBack.zRot = 0.5934119F + -baseAngle + WingRot;
        this.WingRightFront.zRot = baseAngle - WingRot;
        this.WingRightBack.zRot = -0.5934119F + baseAngle - WingRot;

        this.FrontLegs.xRot = 0.1487144F + legMov;
        this.MidLegs.xRot = 0.5948578F + legMovB;
        this.RearLegs.xRot = 1.070744F + legMov;

    }

    @Override       //TODO: Fix rotation angles
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder iVertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {

        this.Abdomen.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.FrontLegs.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.RightAntenna.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.LeftAntenna.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.RearLegs.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.MidLegs.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.Head.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.Thorax.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);

        this.Mouth.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);

        matrixStack.pushPose();
//        GL11.glEnable(3042 /* GL_BLEND */);
//        float transparency = 0.8F;
//        GL11.glBlendFunc(770, 771);
//        GL11.glColor4f(0.8F, 0.8F, 0.8F, transparency);
        //GL11.glScalef(1.3F, 1.0F, 1.3F);
        this.WingRight.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.WingLeft.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.WingRightFront.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.WingLeftFront.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.WingRightBack.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.WingLeftBack.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
//        GL11.glDisable(3042/* GL_BLEND */);
        matrixStack.popPose();
    }
}
