package drzhark.mocreatures.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import drzhark.mocreatures.entity.ambient.DragonflyEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MoCModelDragonfly<T extends DragonflyEntity> extends SegmentedModel<T> {

    ModelRenderer Abdomen;
    ModelRenderer FrontLegs;
    ModelRenderer RAntenna;
    ModelRenderer LAntenna;
    ModelRenderer RearLegs;
    ModelRenderer MidLegs;
    ModelRenderer Mouth;
    ModelRenderer WingRearRight;
    ModelRenderer Thorax;
    ModelRenderer WingFrontRight;
    ModelRenderer WingFrontLeft;
    ModelRenderer WingRearLeft;
    ModelRenderer Head;

    public MoCModelDragonfly() {
        this.texWidth = 32;
        this.texHeight = 32;

        this.Head = new ModelRenderer(this, 0, 4);
        this.Head.addBox(-1F, 0F, -1F, 2, 1, 2);
        this.Head.setPos(0F, 21F, -2F);
        setRotation(this.Head, -2.171231F, 0F, 0F);

        this.RAntenna = new ModelRenderer(this, 0, 7);
        this.RAntenna.addBox(-0.5F, 0F, -1F, 1, 0, 1);
        this.RAntenna.setPos(-0.5F, 19.7F, -2.3F);
        setRotation(this.RAntenna, -1.041001F, 0.7853982F, 0F);

        this.LAntenna = new ModelRenderer(this, 4, 7);
        this.LAntenna.addBox(-0.5F, 0F, -1F, 1, 0, 1);
        this.LAntenna.setPos(0.5F, 19.7F, -2.3F);
        setRotation(this.LAntenna, -1.041001F, -0.7853982F, 0F);

        this.Mouth = new ModelRenderer(this, 0, 11);
        this.Mouth.addBox(-0.5F, 0F, 0F, 1, 1, 1);
        this.Mouth.setPos(0F, 21.1F, -2.3F);
        setRotation(this.Mouth, -2.171231F, 0F, 0F);

        this.Thorax = new ModelRenderer(this, 0, 0);
        this.Thorax.addBox(-1F, 0F, -1F, 2, 2, 2);
        this.Thorax.setPos(0F, 20F, -1F);

        this.Abdomen = new ModelRenderer(this, 8, 0);
        this.Abdomen.addBox(-0.5F, 0F, -1F, 1, 7, 1);
        this.Abdomen.setPos(0F, 20.5F, 0F);
        setRotation(this.Abdomen, 1.427659F, 0F, 0F);

        this.FrontLegs = new ModelRenderer(this, 0, 8);
        this.FrontLegs.addBox(-1F, 0F, 0F, 2, 3, 0);
        this.FrontLegs.setPos(0F, 21.5F, -1.8F);
        setRotation(this.FrontLegs, 0.1487144F, 0F, 0F);

        this.MidLegs = new ModelRenderer(this, 4, 8);
        this.MidLegs.addBox(-1F, 0F, 0F, 2, 3, 0);
        this.MidLegs.setPos(0F, 22F, -1.2F);
        setRotation(this.MidLegs, 0.5948578F, 0F, 0F);

        this.RearLegs = new ModelRenderer(this, 8, 8);
        this.RearLegs.addBox(-1F, 0F, 0F, 2, 3, 0);
        this.RearLegs.setPos(0F, 22F, -0.4F);
        setRotation(this.RearLegs, 1.070744F, 0F, 0F);

        this.WingFrontRight = new ModelRenderer(this, 0, 28);
        this.WingFrontRight.addBox(-7F, 0F, -1F, 7, 0, 2);
        this.WingFrontRight.setPos(-1F, 20F, -1F);
        setRotation(this.WingFrontRight, 0F, -0.1396263F, 0.0872665F);

        this.WingFrontLeft = new ModelRenderer(this, 0, 30);
        this.WingFrontLeft.addBox(0F, 0F, -1F, 7, 0, 2);
        this.WingFrontLeft.setPos(1F, 20F, -1F);
        setRotation(this.WingFrontLeft, 0F, 0.1396263F, -0.0872665F);

        this.WingRearRight = new ModelRenderer(this, 0, 24);
        this.WingRearRight.addBox(-7F, 0F, -1F, 7, 0, 2);
        this.WingRearRight.setPos(-1F, 20F, -1F);
        setRotation(this.WingRearRight, 0F, 0.3490659F, -0.0872665F);

        this.WingRearLeft = new ModelRenderer(this, 0, 26);
        this.WingRearLeft.addBox(0F, 0F, -1F, 7, 0, 2);
        this.WingRearLeft.setPos(1F, 20F, -1F);
        setRotation(this.WingRearLeft, 0F, -0.3490659F, 0.0872665F);

    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float time, float pitch, float yaw) {
        DragonflyEntity dragonfly = (DragonflyEntity) entity;
        //boolean onGround = dragonfly.onGround;
        boolean isFlying = (dragonfly.getIsFlying() || dragonfly.getDeltaMovement().y < -0.1D);
        setRotationAngles(limbSwing, limbSwingAmount, time, isFlying);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(this.Abdomen, this.FrontLegs, this.RAntenna, this.LAntenna,
                this.RearLegs, this.MidLegs, this.Mouth, this.WingRearRight, this.WingRearLeft,
                this.Thorax, this.WingFrontRight, this.WingFrontLeft, this.Head);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder vertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        super.renderToBuffer(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.Head.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.Abdomen.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.FrontLegs.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.RAntenna.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.LAntenna.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.RearLegs.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.MidLegs.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.Mouth.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.Thorax.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);

        matrixStack.pushPose();
//        GL11.glEnable(3042 /* GL_BLEND */);
//        float transparency = 0.6F;
//        GL11.glBlendFunc(770, 771);
//        GL11.glColor4f(0.8F, 0.8F, 0.8F, transparency);
        //GL11.glScalef(1.3F, 1.0F, 1.3F);
        this.WingRearRight.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.WingFrontRight.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.WingFrontLeft.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.WingRearLeft.render(matrixStack, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
//        GL11.glDisable(3042/* GL_BLEND */);
        matrixStack.popPose();
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    public void setRotationAngles(float f, float f1, float f2, boolean flying) {
        //super.setRotationAngles(f, f1, f2, f3, f4, f5);

        /**
         * f = distance walked f1 = speed 0 - 1 f2 = timer
         */

        float WingRot = 0F;
        float legMov = 0F;
        float legMovB = 0F;

        if (flying) {
            WingRot = MathHelper.cos((f2 * 2.0F)) * 0.5F;
            legMov = (f1 * 1.5F);
            legMovB = legMov;
        } else {
            legMov = MathHelper.cos((f * 1.5F) + 3.141593F) * 2.0F * f1;
            legMovB = MathHelper.cos(f * 1.5F) * 2.0F * f1;
        }

        this.WingFrontRight.zRot = WingRot;
        this.WingRearLeft.zRot = WingRot;

        this.WingFrontLeft.zRot = -WingRot;
        this.WingRearRight.zRot = -WingRot;

        this.FrontLegs.xRot = 0.1487144F + legMov;
        this.MidLegs.xRot = 0.5948578F + legMovB;
        this.RearLegs.xRot = 1.070744F + legMov;
    }

}
