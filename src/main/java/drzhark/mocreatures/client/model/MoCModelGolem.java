package drzhark.mocreatures.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import drzhark.mocreatures.entity.monster.MoCEntityGolem;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.opengl.GL11;

@OnlyIn(Dist.CLIENT)
public class MoCModelGolem extends EntityModel<MoCEntityGolem> {

    ModelRenderer blocks[][];
    ModelRenderer head;
    ModelRenderer headb;
    ModelRenderer chest;
    ModelRenderer chestb;

    byte blocksText[];
    float radianF = 57.29578F;
    int w = 32;
    int h = 16;
    float yOffset = 0F;
    boolean angry = false;


    public MoCModelGolem() {
        this.blocks = new ModelRenderer[23][28];
        this.blocksText = new byte[23];
        this.texWidth = 128;
        this.texHeight = 128;

        for (byte i = 0; i < 23; i++) {
            this.blocksText[i] = 30;
        }

        //head
        this.head = new ModelRenderer(this, 96, 64);
        this.head.addBox(-4F, -4F, -4F, 8, 8, 8);
        this.head.setPos(0F, -10F, 0F);
        setRotation(this.head, 0F, 0.7853982F, 0F);

        this.headb = new ModelRenderer(this, 96, 80);
        this.headb.addBox(-4F, -4F, -4F, 8, 8, 8);
        this.headb.setPos(0F, -10F, 0F);
        setRotation(this.headb, 0F, 0.7853982F, 0F);

        this.chest = new ModelRenderer(this, 96, 96);
        this.chest.addBox(-4F, -4F, -4F, 8, 8, 8);
        this.chest.setPos(0F, -3F, -7F);
        setRotation(this.chest, 0F, 0.7853982F, 0F);

        this.chestb = new ModelRenderer(this, 96, 112);
        this.chestb.addBox(-4F, -4F, -4F, 8, 8, 8);
        this.chestb.setPos(0F, -3F, -7F);
        setRotation(this.chestb, 0F, 0.7853982F, 0F);

        for (byte i = 0; i < 28; i++) {
            int textX = (i / 8) * this.w;
            int textY = (i % 8) * this.h;

            //lchest1
            this.blocks[0][i] = new ModelRenderer(this, textX, textY);
            this.blocks[0][i].addBox(-4F, 3F, -4F, 8, 8, 8);
            this.blocks[0][i].setPos(0F, -3F, 0F);
            setRotationG(this.blocks[0][i], -97F, -40F, 0F);

            //lchest2
            this.blocks[1][i] = new ModelRenderer(this, textX, textY);
            this.blocks[1][i].addBox(-4F, 3F, -4F, 8, 8, 8);
            this.blocks[1][i].setPos(0F, -3F, 0F);
            setRotationG(this.blocks[1][i], -55F, -41F, 0F);

            //rchest1
            this.blocks[2][i] = new ModelRenderer(this, textX, textY);
            this.blocks[2][i].addBox(-4F, 3F, -4F, 8, 8, 8);
            this.blocks[2][i].setPos(0F, -3F, 0F);
            setRotationG(this.blocks[2][i], -97F, 40F, 0F);

            //rchest2
            this.blocks[3][i] = new ModelRenderer(this, textX, textY);
            this.blocks[3][i].addBox(-4F, 3F, -4F, 8, 8, 8);
            this.blocks[3][i].setPos(0F, -3F, 0F);
            setRotationG(this.blocks[3][i], -55F, 41F, 0F);

            //back
            this.blocks[4][i] = new ModelRenderer(this, textX, textY);
            this.blocks[4][i].addBox(-7F, -14F, -1F, 8, 8, 8);
            this.blocks[4][i].setPos(0F, 6F, 3F);
            setRotation(this.blocks[4][i], 0F, 0.7853982F, 0F);

            //lback1
            this.blocks[5][i] = new ModelRenderer(this, textX, textY);
            this.blocks[5][i].addBox(-4F, 3F, -4F, 8, 8, 8);
            this.blocks[5][i].setPos(0F, -3F, 0F);
            setRotation(this.blocks[5][i], 1.919862F, 0.6981317F, 0F);

            //lback2
            this.blocks[6][i] = new ModelRenderer(this, textX, textY);
            this.blocks[6][i].addBox(-4F, 3F, -4F, 8, 8, 8);
            this.blocks[6][i].setPos(0F, -3F, 0F);
            setRotation(this.blocks[6][i], 1.183003F, 0.6981317F, 0F);

            //rback1
            this.blocks[7][i] = new ModelRenderer(this, textX, textY);
            this.blocks[7][i].addBox(-4F, 3F, -4F, 8, 8, 8);
            this.blocks[7][i].setPos(0F, -3F, 0F);
            setRotation(this.blocks[7][i], 1.919862F, -0.6981317F, 0F);

            //rback2
            this.blocks[8][i] = new ModelRenderer(this, textX, textY);
            this.blocks[8][i].addBox(-4F, 3F, -4F, 8, 8, 8);
            this.blocks[8][i].setPos(0F, -3F, 0F);
            setRotation(this.blocks[8][i], 1.183003F, -0.6981317F, 0F);

            //lshoulder
            this.blocks[9][i] = new ModelRenderer(this, textX, textY);
            this.blocks[9][i].addBox(0F, -2F, -4F, 8, 8, 8);
            this.blocks[9][i].setPos(8F, -3F, 0F);
            setRotation(this.blocks[9][i], 0F, 0F, -0.6981317F);

            //larm[12]
            this.blocks[10][i] = new ModelRenderer(this, textX, textY);
            this.blocks[10][i].addBox(2F, 4F, -4F, 8, 8, 8);
            this.blocks[10][i].setPos(8F, -3F, 0F);
            setRotation(this.blocks[10][i], 0F, 0F, -0.2094395F);

            //lhand
            this.blocks[11][i] = new ModelRenderer(this, textX, textY);
            this.blocks[11][i].addBox(4.5F, 11F, -4F, 8, 8, 8);
            this.blocks[11][i].setPos(8F, -3F, 0F);

            //rshoulder
            this.blocks[12][i] = new ModelRenderer(this, textX, textY);
            this.blocks[12][i].addBox(-8F, -2F, -4F, 8, 8, 8);
            this.blocks[12][i].setPos(-8F, -3F, 0F);
            setRotation(this.blocks[12][i], 0F, 0F, 0.6981317F);

            //rarm
            this.blocks[13][i] = new ModelRenderer(this, textX, textY);
            this.blocks[13][i].addBox(-10F, 4F, -4F, 8, 8, 8);
            this.blocks[13][i].setPos(-8F, -3F, 0F);
            setRotation(this.blocks[13][i], 0F, 0F, 0.2094395F);

            //rhand
            this.blocks[14][i] = new ModelRenderer(this, textX, textY);
            this.blocks[14][i].addBox(-12.5F, 11F, -4F, 8, 8, 8);
            this.blocks[14][i].setPos(-8F, -3F, 0F);

            //lthigh
            this.blocks[15][i] = new ModelRenderer(this, textX, textY);
            this.blocks[15][i].addBox(-3.5F, 0F, -4F, 8, 8, 8);
            this.blocks[15][i].setPos(5F, 4F, 0F);
            setRotation(this.blocks[15][i], -0.3490659F, 0F, 0F);

            //lknee
            this.blocks[16][i] = new ModelRenderer(this, textX, textY);
            this.blocks[16][i].addBox(-4F, 6F, -7F, 8, 8, 8);
            this.blocks[16][i].setPos(5F, 4F, 0F);

            //lfoot
            this.blocks[17][i] = new ModelRenderer(this, textX, textY);
            this.blocks[17][i].addBox(-3.5F, 12F, -5F, 8, 8, 8);
            this.blocks[17][i].setPos(5F, 4F, 0F);

            //rthigh
            this.blocks[18][i] = new ModelRenderer(this, textX, textY);
            this.blocks[18][i].addBox(-4.5F, 0F, -4F, 8, 8, 8);
            this.blocks[18][i].setPos(-5F, 4F, 0F);
            setRotation(this.blocks[18][i], -0.3490659F, 0F, 0F);

            //rknee
            this.blocks[19][i] = new ModelRenderer(this, textX, textY);
            this.blocks[19][i].addBox(-4F, 6F, -7F, 8, 8, 8);
            this.blocks[19][i].setPos(-5F, 4F, 0F);

            //rfoot
            this.blocks[20][i] = new ModelRenderer(this, textX, textY);
            this.blocks[20][i].addBox(-4.5F, 12F, -5F, 8, 8, 8);
            this.blocks[20][i].setPos(-5F, 4F, 0F);

            //groin
            this.blocks[21][i] = new ModelRenderer(this, textX, textY);
            this.blocks[21][i].addBox(0F, -4F, -8F, 8, 8, 8);
            this.blocks[21][i].setPos(0F, 6F, 3F);
            setRotation(this.blocks[21][i], 0F, 0.7853982F, 0F);

            //butt
            this.blocks[22][i] = new ModelRenderer(this, textX, textY);
            this.blocks[22][i].addBox(-4F, -4F, -4F, 8, 8, 8);
            this.blocks[22][i].setPos(0F, 6F, 3F);
            setRotation(this.blocks[22][i], -0.7435722F, 0F, 0F);
        }

    }

    @Override
    public void setupAnim(MoCEntityGolem entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        boolean openChest = entityIn.openChest();
        boolean isSummoning = entityIn.isMissingCubes();
        this.angry = entityIn.getGolemState() > 1;
        boolean throwing = (entityIn.tcounter > 25);

        for (int i = 0; i < 23; i++) {
            this.blocksText[i] = entityIn.getBlockText(i);
        }
        this.yOffset = entityIn.getAdjustedYOffset();
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, openChest, isSummoning, throwing);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    private void setRotationG(ModelRenderer model, float x, float y, float z) {
        model.xRot = x / this.radianF;
        model.yRot = y / this.radianF;
        model.zRot = z / this.radianF;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, boolean openChest, boolean isSummoning, boolean throwing) {
        float RLegXRot = MathHelper.cos((f * 0.6662F) + 3.141593F) * 1.2F * f1;
        float LLegXRot = MathHelper.cos(f * 0.6662F) * 1.2F * f1;
        float RArmZRot = -(MathHelper.cos(f2 * 0.09F) * 0.05F) + 0.05F;
        float LArmZRot = (MathHelper.cos(f2 * 0.09F) * 0.05F) - 0.05F;

        this.head.yRot = (45F + f3) / this.radianF;
        this.headb.yRot = (45F + f3) / this.radianF;

        if (isSummoning) {
            this.chest.yRot = (45F / this.radianF) + (f2 / 2F);
            this.chestb.yRot = (45F / this.radianF) + (f2 / 2F);
        } else {
            this.chest.yRot = 45F / this.radianF;
            this.chestb.yRot = 45F / this.radianF;
        }

        if (openChest) {
            this.chest.z = -7F;
            this.chestb.z = -7F;

            if (this.blocksText[0] != 30) {
                this.blocks[0][this.blocksText[0]].yRot = -60F / this.radianF;
            }
            if (this.blocksText[1] != 30) {
                this.blocks[1][this.blocksText[1]].yRot = -55F / this.radianF;
            }
            if (this.blocksText[2] != 30) {
                this.blocks[2][this.blocksText[2]].yRot = 60F / this.radianF;
            }
            if (this.blocksText[3] != 30) {
                this.blocks[3][this.blocksText[3]].yRot = 55F / this.radianF;
            }
        } else {
            this.chest.z = -4F;
            this.chestb.z = -4F;

            if (this.blocksText[0] != 30) {
                this.blocks[0][this.blocksText[0]].yRot = -40F / this.radianF;
            }
            if (this.blocksText[1] != 30) {
                this.blocks[1][this.blocksText[1]].yRot = -41F / this.radianF;
            }
            if (this.blocksText[2] != 30) {
                this.blocks[2][this.blocksText[2]].yRot = 40F / this.radianF;
            }
            if (this.blocksText[3] != 30) {
                this.blocks[3][this.blocksText[3]].yRot = 41F / this.radianF;
            }
        }

        if (this.blocksText[15] != 30) {
            this.blocks[15][this.blocksText[15]].xRot = (-20F / this.radianF) + LLegXRot;
        }

        if (this.blocksText[16] != 30) {
            this.blocks[16][this.blocksText[16]].xRot = LLegXRot;
        }

        if (this.blocksText[17] != 30) {
            this.blocks[17][this.blocksText[17]].xRot = LLegXRot;
        }

        if (this.blocksText[18] != 30) {
            this.blocks[18][this.blocksText[18]].xRot = (-20F / this.radianF) + RLegXRot;
        }

        if (this.blocksText[19] != 30) {
            this.blocks[19][this.blocksText[19]].xRot = RLegXRot;
        }

        if (this.blocksText[20] != 30) {
            this.blocks[20][this.blocksText[20]].xRot = RLegXRot;
        }

        if (throwing) {
            LLegXRot = -90F / this.radianF;
            RLegXRot = -90F / this.radianF;
            RArmZRot = 0F;
            LArmZRot = 0F;
        }

        if (this.blocksText[12] != 30) {
            this.blocks[12][this.blocksText[12]].zRot = (40F / this.radianF) + RArmZRot;
            this.blocks[12][this.blocksText[12]].xRot = LLegXRot;
        }

        if (this.blocksText[13] != 30) {
            this.blocks[13][this.blocksText[13]].zRot = (12F / this.radianF) + RArmZRot;
            this.blocks[13][this.blocksText[13]].xRot = LLegXRot;
        }

        if (this.blocksText[14] != 30) {
            this.blocks[14][this.blocksText[14]].zRot = RArmZRot;
            this.blocks[14][this.blocksText[14]].xRot = LLegXRot;
        }

        if (this.blocksText[9] != 30) {
            this.blocks[9][this.blocksText[9]].zRot = (-40F / this.radianF) + LArmZRot;
            this.blocks[9][this.blocksText[9]].xRot = RLegXRot;
        }

        if (this.blocksText[10] != 30) {
            this.blocks[10][this.blocksText[10]].zRot = (-12F / this.radianF) + LArmZRot;
            this.blocks[10][this.blocksText[10]].xRot = RLegXRot;
        }

        if (this.blocksText[11] != 30) {
            this.blocks[11][this.blocksText[11]].zRot = LArmZRot;
            this.blocks[11][this.blocksText[11]].xRot = RLegXRot;
        }

    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0F, yOffset, 0F);
        for (int i = 0; i < 23; i++) {
            //blocksText[i] = entityG.getBlockText(i);
            if (this.blocksText[i] != 30) {
                this.blocks[i][this.blocksText[i]].render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            }
        }

        if (angry) {
            this.headb.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.chestb.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        } else {
            this.head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.chest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        }
        matrixStackIn.popPose();
    }
}
