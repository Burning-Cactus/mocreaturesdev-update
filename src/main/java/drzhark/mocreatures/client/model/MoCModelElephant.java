package drzhark.mocreatures.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import drzhark.mocreatures.entity.passive.MoCEntityElephant;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MoCModelElephant<T extends MoCEntityElephant> extends EntityModel<T> {

    ModelRenderer Head;
    ModelRenderer Neck;
    ModelRenderer HeadBump;
    ModelRenderer Chin;
    ModelRenderer LowerLip;
    ModelRenderer Back;
    ModelRenderer LeftSmallEar;
    ModelRenderer LeftBigEar;
    ModelRenderer RightSmallEar;
    ModelRenderer RightBigEar;
    ModelRenderer Hump;
    ModelRenderer Body;
    ModelRenderer Skirt;
    ModelRenderer RightTuskA;
    ModelRenderer RightTuskB;
    ModelRenderer RightTuskC;
    ModelRenderer RightTuskD;
    ModelRenderer LeftTuskA;
    ModelRenderer LeftTuskB;
    ModelRenderer LeftTuskC;
    ModelRenderer LeftTuskD;
    ModelRenderer TrunkA;
    ModelRenderer TrunkB;
    ModelRenderer TrunkC;
    ModelRenderer TrunkD;
    ModelRenderer TrunkE;
    ModelRenderer FrontRightUpperLeg;
    ModelRenderer FrontRightLowerLeg;
    ModelRenderer FrontLeftUpperLeg;
    ModelRenderer FrontLeftLowerLeg;
    ModelRenderer BackRightUpperLeg;
    ModelRenderer BackRightLowerLeg;
    ModelRenderer BackLeftUpperLeg;
    ModelRenderer BackLeftLowerLeg;
    ModelRenderer TailRoot;
    ModelRenderer Tail;
    ModelRenderer TailPlush;
    ModelRenderer StorageRightBedroll;
    ModelRenderer StorageLeftBedroll;
    ModelRenderer StorageFrontRightChest;
    ModelRenderer StorageBackRightChest;
    ModelRenderer StorageFrontLeftChest;
    ModelRenderer StorageBackLeftChest;
    ModelRenderer StorageRightBlankets;
    ModelRenderer StorageLeftBlankets;
    ModelRenderer HarnessBlanket;
    ModelRenderer HarnessUpperBelt;
    ModelRenderer HarnessLowerBelt;
    ModelRenderer CabinPillow;
    ModelRenderer CabinLeftRail;
    ModelRenderer Cabin;
    ModelRenderer CabinRightRail;
    ModelRenderer CabinBackRail;
    ModelRenderer CabinRoof;
    ModelRenderer FortNeckBeam;
    ModelRenderer FortBackBeam;
    ModelRenderer TuskLD1;
    ModelRenderer TuskLD2;
    ModelRenderer TuskLD3;
    ModelRenderer TuskLD4;
    ModelRenderer TuskLD5;
    ModelRenderer TuskRD1;
    ModelRenderer TuskRD2;
    ModelRenderer TuskRD3;
    ModelRenderer TuskRD4;
    ModelRenderer TuskRD5;
    ModelRenderer TuskLI1;
    ModelRenderer TuskLI2;
    ModelRenderer TuskLI3;
    ModelRenderer TuskLI4;
    ModelRenderer TuskLI5;
    ModelRenderer TuskRI1;
    ModelRenderer TuskRI2;
    ModelRenderer TuskRI3;
    ModelRenderer TuskRI4;
    ModelRenderer TuskRI5;
    ModelRenderer TuskLW1;
    ModelRenderer TuskLW2;
    ModelRenderer TuskLW3;
    ModelRenderer TuskLW4;
    ModelRenderer TuskLW5;
    ModelRenderer TuskRW1;
    ModelRenderer TuskRW2;
    ModelRenderer TuskRW3;
    ModelRenderer TuskRW4;
    ModelRenderer TuskRW5;

    ModelRenderer FortFloor1;
    ModelRenderer FortFloor2;
    ModelRenderer FortFloor3;
    ModelRenderer FortBackWall;
    ModelRenderer FortBackLeftWall;
    ModelRenderer FortBackRightWall;
    ModelRenderer StorageUpLeft;
    ModelRenderer StorageUpRight;

    float radianF = 57.29578F;

    private boolean isSitting;
    private int tailCounter;
    private int earCounter;
    private int trunkCounter;
    int tusks;
    private boolean age;
    private int edad;
    private int type;
    private int storage;
    private int harness;

    public MoCModelElephant() {
        this.texWidth = 128;
        this.texHeight = 256;

        this.Head = new ModelRenderer(this, 60, 0);
        this.Head.addBox(-5.5F, -6F, -8F, 11, 15, 10);
        this.Head.setPos(0F, -10F, -16.5F);
        setRotation(this.Head, -0.1745329F, 0F, 0F);

        this.Neck = new ModelRenderer(this, 46, 48);
        this.Neck.addBox(-4.95F, -6F, -8F, 10, 14, 8);
        this.Neck.setPos(0F, -8F, -10F);
        setRotation(this.Neck, -0.2617994F, 0F, 0F);

        this.HeadBump = new ModelRenderer(this, 104, 41);
        this.HeadBump.addBox(-3F, -9F, -6F, 6, 3, 6);
        this.HeadBump.setPos(0F, -10F, -16.5F);
        setRotation(this.HeadBump, -0.1745329F, 0F, 0F);

        /*
         * Chin = new ModelRenderer(this, 86, 56); Chin.addBox(-1.5F, -1F, -4F,
         * 3, 5, 4); Chin.setRotationPoint(0F, -2F, -17.46667F);
         * setRotation(Chin, 2.054118F, 0F, 0F); LowerLip = new
         * ModelRenderer(this, 80, 65); LowerLip.addBox(-2F, -1F, -6F, 4, 2, 6);
         * LowerLip.setRotationPoint(0F, -2F, -17.46667F); setRotation(LowerLip,
         * 1.570796F, 0F, 0F);
         */

        this.Chin = new ModelRenderer(this, 86, 56);
        this.Chin.addBox(-1.5F, -6F, -10.7F, 3, 5, 4);
        this.Chin.setPos(0F, -10F, -16.5F);
        setRotation(this.Chin, 2.054118F, 0F, 0F);

        this.LowerLip = new ModelRenderer(this, 80, 65);
        this.LowerLip.addBox(-2F, -2F, -14F, 4, 2, 6);
        this.LowerLip.setPos(0F, -10F, -16.5F);
        setRotation(this.LowerLip, 1.570796F, 0F, 0F);

        this.Back = new ModelRenderer(this, 0, 48);
        this.Back.addBox(-5F, -10F, -10F, 10, 2, 26);
        this.Back.setPos(0F, -4F, -3F);

        this.LeftSmallEar = new ModelRenderer(this, 102, 0);
        this.LeftSmallEar.addBox(2F, -8F, -5F, 8, 10, 1);
        this.LeftSmallEar.setPos(0F, -10F, -16.5F);
        setRotation(this.LeftSmallEar, -0.1745329F, -0.5235988F, 0.5235988F);
        this.LeftBigEar = new ModelRenderer(this, 102, 0);
        this.LeftBigEar.addBox(2F, -8F, -5F, 12, 14, 1);
        this.LeftBigEar.setPos(0F, -10F, -16.5F);
        setRotation(this.LeftBigEar, -0.1745329F, -0.5235988F, 0.5235988F);
        this.RightSmallEar = new ModelRenderer(this, 106, 15);
        this.RightSmallEar.addBox(-10F, -8F, -5F, 8, 10, 1);
        this.RightSmallEar.setPos(0F, -10F, -16.5F);
        setRotation(this.RightSmallEar, -0.1745329F, 0.5235988F, -0.5235988F);
        this.RightBigEar = new ModelRenderer(this, 102, 15);
        this.RightBigEar.addBox(-14F, -8F, -5F, 12, 14, 1);
        this.RightBigEar.setPos(0F, -10F, -16.5F);
        setRotation(this.RightBigEar, -0.1745329F, 0.5235988F, -0.5235988F);

        this.Hump = new ModelRenderer(this, 88, 30);
        this.Hump.addBox(-6F, -2F, -3F, 12, 3, 8);
        this.Hump.setPos(0F, -13F, -5.5F);

        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.addBox(-8F, -10F, -10F, 16, 20, 28);
        this.Body.setPos(0F, -2F, -3F);

        this.Skirt = new ModelRenderer(this, 28, 94);
        this.Skirt.addBox(-8F, -10F, -6F, 16, 28, 6);
        this.Skirt.setPos(0F, 8F, -3F);
        setRotation(this.Skirt, 1.570796F, 0F, 0F);

        this.RightTuskA = new ModelRenderer(this, 2, 60);
        this.RightTuskA.addBox(-3.8F, -3.5F, -19F, 2, 2, 10);
        this.RightTuskA.setPos(0F, -10F, -16.5F);
        setRotation(this.RightTuskA, 1.22173F, 0F, 0.1745329F);

        this.RightTuskB = new ModelRenderer(this, 0, 0);
        this.RightTuskB.addBox(-3.8F, 6.2F, -24.2F, 2, 2, 7);
        this.RightTuskB.setPos(0F, -10F, -16.5F);
        setRotation(this.RightTuskB, 0.6981317F, 0F, 0.1745329F);

        this.RightTuskC = new ModelRenderer(this, 0, 18);
        this.RightTuskC.addBox(-3.8F, 17.1F, -21.9F, 2, 2, 5);
        this.RightTuskC.setPos(0F, -10F, -16.5F);
        setRotation(this.RightTuskC, 0.1745329F, 0F, 0.1745329F);

        this.RightTuskD = new ModelRenderer(this, 14, 18);
        this.RightTuskD.addBox(-3.8F, 25.5F, -14.5F, 2, 2, 5);
        this.RightTuskD.setPos(0F, -10F, -16.5F);
        setRotation(this.RightTuskD, -0.3490659F, 0F, 0.1745329F);

        this.LeftTuskA = new ModelRenderer(this, 2, 48);
        this.LeftTuskA.addBox(1.8F, -3.5F, -19F, 2, 2, 10);
        this.LeftTuskA.setPos(0F, -10F, -16.5F);
        setRotation(this.LeftTuskA, 1.22173F, 0F, -0.1745329F);

        this.LeftTuskB = new ModelRenderer(this, 0, 9);
        this.LeftTuskB.addBox(1.8F, 6.2F, -24.2F, 2, 2, 7);
        this.LeftTuskB.setPos(0F, -10F, -16.5F);
        setRotation(this.LeftTuskB, 0.6981317F, 0F, -0.1745329F);

        this.LeftTuskC = new ModelRenderer(this, 0, 18);
        this.LeftTuskC.addBox(1.8F, 17.1F, -21.9F, 2, 2, 5);
        this.LeftTuskC.setPos(0F, -10F, -16.5F);
        setRotation(this.LeftTuskC, 0.1745329F, 0F, -0.1745329F);

        this.LeftTuskD = new ModelRenderer(this, 14, 18);
        this.LeftTuskD.addBox(1.8F, 25.5F, -14.5F, 2, 2, 5);
        this.LeftTuskD.setPos(0F, -10F, -16.5F);
        setRotation(this.LeftTuskD, -0.3490659F, 0F, -0.1745329F);

        //original
        this.TrunkA = new ModelRenderer(this, 0, 76);
        this.TrunkA.addBox(-4F, -2.5F, -18F, 8, 7, 10);
        this.TrunkA.setPos(0F, -3F, -22.46667F);
        setRotation(this.TrunkA, 1.570796F, 0F, 0F);

        this.TrunkB = new ModelRenderer(this, 0, 93);
        this.TrunkB.addBox(-3F, -2.5F, -7F, 6, 5, 7);
        this.TrunkB.setPos(0F, 6.5F, -22.5F);
        setRotation(this.TrunkB, 1.658063F, 0F, 0F);

        this.TrunkC = new ModelRenderer(this, 0, 105);
        this.TrunkC.addBox(-2.5F, -2F, -4F, 5, 4, 5);
        this.TrunkC.setPos(0F, 13F, -22.0F);
        setRotation(this.TrunkC, 1.919862F, 0F, 0F);

        this.TrunkD = new ModelRenderer(this, 0, 114);
        this.TrunkD.addBox(-2F, -1.5F, -5F, 4, 3, 5);
        this.TrunkD.setPos(0F, 16F, -21.5F);
        setRotation(this.TrunkD, 2.216568F, 0F, 0F);

        this.TrunkE = new ModelRenderer(this, 0, 122);
        this.TrunkE.addBox(-1.5F, -1F, -4F, 3, 2, 4);
        this.TrunkE.setPos(0F, 19.5F, -19F);
        setRotation(this.TrunkE, 2.530727F, 0F, 0F);

        this.FrontRightUpperLeg = new ModelRenderer(this, 100, 109);
        this.FrontRightUpperLeg.addBox(-3.5F, 0F, -3.5F, 7, 12, 7);
        this.FrontRightUpperLeg.setPos(-4.6F, 4F, -9.6F);

        this.FrontRightLowerLeg = new ModelRenderer(this, 100, 73);
        this.FrontRightLowerLeg.addBox(-3.5F, 0F, -3.5F, 7, 10, 7);
        this.FrontRightLowerLeg.setPos(-4.6F, 14F, -9.6F);

        this.FrontLeftUpperLeg = new ModelRenderer(this, 100, 90);
        this.FrontLeftUpperLeg.addBox(-3.5F, 0F, -3.5F, 7, 12, 7);
        this.FrontLeftUpperLeg.setPos(4.6F, 4F, -9.6F);

        this.FrontLeftLowerLeg = new ModelRenderer(this, 72, 73);
        this.FrontLeftLowerLeg.addBox(-3.5F, 0F, -3.5F, 7, 10, 7);
        this.FrontLeftLowerLeg.setPos(4.6F, 14F, -9.6F);

        this.BackRightUpperLeg = new ModelRenderer(this, 72, 109);
        this.BackRightUpperLeg.addBox(-3.5F, 0F, -3.5F, 7, 12, 7);
        this.BackRightUpperLeg.setPos(-4.6F, 4F, 11.6F);

        this.BackRightLowerLeg = new ModelRenderer(this, 100, 56);
        this.BackRightLowerLeg.addBox(-3.5F, 0F, -3.5F, 7, 10, 7);
        this.BackRightLowerLeg.setPos(-4.6F, 14F, 11.6F);

        this.BackLeftUpperLeg = new ModelRenderer(this, 72, 90);
        this.BackLeftUpperLeg.addBox(-3.5F, 0F, -3.5F, 7, 12, 7);
        this.BackLeftUpperLeg.setPos(4.6F, 4F, 11.6F);

        this.BackLeftLowerLeg = new ModelRenderer(this, 44, 77);
        this.BackLeftLowerLeg.addBox(-3.5F, 0F, -3.5F, 7, 10, 7);
        this.BackLeftLowerLeg.setPos(4.6F, 14F, 11.6F);

        this.TailRoot = new ModelRenderer(this, 20, 105);
        this.TailRoot.addBox(-1F, 0F, -2F, 2, 10, 2);
        this.TailRoot.setPos(0F, -8F, 15F);
        setRotation(this.TailRoot, 0.296706F, 0F, 0F);

        this.Tail = new ModelRenderer(this, 20, 117);
        this.Tail.addBox(-1F, 9.7F, -0.2F, 2, 6, 2);
        this.Tail.setPos(0F, -8F, 15F);
        setRotation(this.Tail, 0.1134464F, 0F, 0F);

        this.TailPlush = new ModelRenderer(this, 26, 76);
        this.TailPlush.addBox(-1.5F, 15.5F, -0.7F, 3, 6, 3);
        this.TailPlush.setPos(0F, -8F, 15F);
        setRotation(this.TailPlush, 0.1134464F, 0F, 0F);

        this.StorageRightBedroll = new ModelRenderer(this, 90, 231);
        this.StorageRightBedroll.addBox(-2.5F, 8F, -8F, 3, 3, 16);
        this.StorageRightBedroll.setPos(-9F, -10.2F, 1F);
        setRotation(this.StorageRightBedroll, 0F, 0F, 0.418879F);

        this.StorageLeftBedroll = new ModelRenderer(this, 90, 231);
        this.StorageLeftBedroll.addBox(-0.5F, 8F, -8F, 3, 3, 16);
        this.StorageLeftBedroll.setPos(9F, -10.2F, 1F);
        setRotation(this.StorageLeftBedroll, 0F, 0F, -0.418879F);

        this.StorageFrontRightChest = new ModelRenderer(this, 76, 208);
        this.StorageFrontRightChest.addBox(-3.5F, 0F, -5F, 5, 8, 10);
        this.StorageFrontRightChest.setPos(-11F, -1.2F, -4.5F);
        setRotation(this.StorageFrontRightChest, 0F, 0F, -0.2617994F);

        this.StorageBackRightChest = new ModelRenderer(this, 76, 208);
        this.StorageBackRightChest.addBox(-3.5F, 0F, -5F, 5, 8, 10);
        this.StorageBackRightChest.setPos(-11F, -1.2F, 6.5F);
        setRotation(this.StorageBackRightChest, 0F, 0F, -0.2617994F);

        this.StorageFrontLeftChest = new ModelRenderer(this, 76, 226);
        this.StorageFrontLeftChest.addBox(-1.5F, 0F, -5F, 5, 8, 10);
        this.StorageFrontLeftChest.setPos(11F, -1.2F, -4.5F);
        setRotation(this.StorageFrontLeftChest, 0F, 0F, 0.2617994F);

        this.StorageBackLeftChest = new ModelRenderer(this, 76, 226);
        this.StorageBackLeftChest.addBox(-1.5F, 0F, -5F, 5, 8, 10);
        this.StorageBackLeftChest.setPos(11F, -1.2F, 6.5F);
        setRotation(this.StorageBackLeftChest, 0F, 0F, 0.2617994F);

        this.StorageRightBlankets = new ModelRenderer(this, 0, 228);
        this.StorageRightBlankets.addBox(-4.5F, -1F, -7F, 5, 10, 14);
        this.StorageRightBlankets.setPos(-9F, -10.2F, 1F);

        this.StorageLeftBlankets = new ModelRenderer(this, 38, 228);
        this.StorageLeftBlankets.addBox(-0.5F, -1F, -7F, 5, 10, 14);
        this.StorageLeftBlankets.setPos(9F, -10.2F, 1F);

        this.HarnessBlanket = new ModelRenderer(this, 0, 196);
        this.HarnessBlanket.addBox(-8.5F, -2F, -3F, 17, 14, 18);
        this.HarnessBlanket.setPos(0F, -13.2F, -3.5F);

        this.HarnessUpperBelt = new ModelRenderer(this, 70, 196);
        this.HarnessUpperBelt.addBox(-8.5F, 0.5F, -2F, 17, 10, 2);
        this.HarnessUpperBelt.setPos(0F, -2F, -2.5F);

        this.HarnessLowerBelt = new ModelRenderer(this, 70, 196);
        this.HarnessLowerBelt.addBox(-8.5F, 0.5F, -2.5F, 17, 10, 2);
        this.HarnessLowerBelt.setPos(0F, -2F, 7F);

        this.CabinPillow = new ModelRenderer(this, 76, 146);
        this.CabinPillow.addBox(-6.5F, 0F, -6.5F, 13, 4, 13);
        this.CabinPillow.setPos(0F, -16F, 2F);

        this.CabinLeftRail = new ModelRenderer(this, 56, 147);
        this.CabinLeftRail.addBox(-7F, 0F, 7F, 14, 1, 1);
        this.CabinLeftRail.setPos(0F, -23F, 1.5F);
        setRotation(this.CabinLeftRail, 0F, 1.570796F, 0F);

        this.Cabin = new ModelRenderer(this, 0, 128);
        this.Cabin.addBox(-7F, 0F, -7F, 14, 20, 14);
        this.Cabin.setPos(0F, -35F, 2F);

        this.CabinRightRail = new ModelRenderer(this, 56, 147);
        this.CabinRightRail.addBox(-7F, 0F, 7F, 14, 1, 1);
        this.CabinRightRail.setPos(0F, -23F, 1.5F);
        setRotation(this.CabinRightRail, 0F, -1.570796F, 0F);

        this.CabinBackRail = new ModelRenderer(this, 56, 147);
        this.CabinBackRail.addBox(-7F, 0F, 7F, 14, 1, 1);
        this.CabinBackRail.setPos(0F, -23F, 1.5F);

        this.CabinRoof = new ModelRenderer(this, 56, 128);
        this.CabinRoof.addBox(-7.5F, 0F, -7.5F, 15, 4, 15);
        this.CabinRoof.setPos(0F, -34F, 2F);

        this.FortNeckBeam = new ModelRenderer(this, 26, 180);
        this.FortNeckBeam.addBox(-12F, 0F, -20.5F, 24, 4, 4);
        this.FortNeckBeam.setPos(0F, -16F, 10F);

        this.FortBackBeam = new ModelRenderer(this, 26, 180);
        this.FortBackBeam.addBox(-12F, 0F, 0F, 24, 4, 4);
        this.FortBackBeam.setPos(0F, -16F, 10F);

        this.TuskLD1 = new ModelRenderer(this, 108, 207);
        this.TuskLD1.addBox(1.3F, 5.5F, -24.2F, 3, 3, 7);
        this.TuskLD1.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskLD1, 0.6981317F, 0F, -0.1745329F);

        this.TuskLD2 = new ModelRenderer(this, 112, 199);
        this.TuskLD2.addBox(1.29F, 16.5F, -21.9F, 3, 3, 5);
        this.TuskLD2.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskLD2, 0.1745329F, 0F, -0.1745329F);

        this.TuskLD3 = new ModelRenderer(this, 110, 190);
        this.TuskLD3.addBox(1.3F, 24.9F, -15.5F, 3, 3, 6);
        this.TuskLD3.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskLD3, -0.3490659F, 0F, -0.1745329F);

        this.TuskLD4 = new ModelRenderer(this, 86, 175);
        this.TuskLD4.addBox(2.7F, 14.5F, -21.9F, 0, 7, 5);
        this.TuskLD4.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskLD4, 0.1745329F, 0F, -0.1745329F);

        this.TuskLD5 = new ModelRenderer(this, 112, 225);
        this.TuskLD5.addBox(2.7F, 22.9F, -17.5F, 0, 7, 8);
        this.TuskLD5.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskLD5, -0.3490659F, 0F, -0.1745329F);

        this.TuskRD1 = new ModelRenderer(this, 108, 207);
        this.TuskRD1.addBox(-4.3F, 5.5F, -24.2F, 3, 3, 7);
        this.TuskRD1.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskRD1, 0.6981317F, 0F, 0.1745329F);

        this.TuskRD2 = new ModelRenderer(this, 112, 199);
        this.TuskRD2.addBox(-4.29F, 16.5F, -21.9F, 3, 3, 5);
        this.TuskRD2.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskRD2, 0.1745329F, 0F, 0.1745329F);

        this.TuskRD3 = new ModelRenderer(this, 110, 190);
        this.TuskRD3.addBox(-4.3F, 24.9F, -15.5F, 3, 3, 6);
        this.TuskRD3.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskRD3, -0.3490659F, 0F, 0.1745329F);

        this.TuskRD4 = new ModelRenderer(this, 86, 163);
        this.TuskRD4.addBox(-2.8F, 14.5F, -21.9F, 0, 7, 5);
        this.TuskRD4.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskRD4, 0.1745329F, 0F, 0.1745329F);

        this.TuskRD5 = new ModelRenderer(this, 112, 232);
        this.TuskRD5.addBox(-2.8F, 22.9F, -17.5F, 0, 7, 8);
        this.TuskRD5.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskRD5, -0.3490659F, 0F, 0.1745329F);

        this.TuskLI1 = new ModelRenderer(this, 108, 180);
        this.TuskLI1.addBox(1.3F, 5.5F, -24.2F, 3, 3, 7);
        this.TuskLI1.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskLI1, 0.6981317F, 0F, -0.1745329F);

        this.TuskLI2 = new ModelRenderer(this, 112, 172);
        this.TuskLI2.addBox(1.29F, 16.5F, -21.9F, 3, 3, 5);
        this.TuskLI2.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskLI2, 0.1745329F, 0F, -0.1745329F);

        this.TuskLI3 = new ModelRenderer(this, 110, 163);
        this.TuskLI3.addBox(1.3F, 24.9F, -15.5F, 3, 3, 6);
        this.TuskLI3.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskLI3, -0.3490659F, 0F, -0.1745329F);

        this.TuskLI4 = new ModelRenderer(this, 96, 175);
        this.TuskLI4.addBox(2.7F, 14.5F, -21.9F, 0, 7, 5);
        this.TuskLI4.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskLI4, 0.1745329F, 0F, -0.1745329F);

        this.TuskLI5 = new ModelRenderer(this, 112, 209);
        this.TuskLI5.addBox(2.7F, 22.9F, -17.5F, 0, 7, 8);
        this.TuskLI5.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskLI5, -0.3490659F, 0F, -0.1745329F);

        this.TuskRI1 = new ModelRenderer(this, 108, 180);
        this.TuskRI1.addBox(-4.3F, 5.5F, -24.2F, 3, 3, 7);
        this.TuskRI1.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskRI1, 0.6981317F, 0F, 0.1745329F);

        this.TuskRI2 = new ModelRenderer(this, 112, 172);
        this.TuskRI2.addBox(-4.29F, 16.5F, -21.9F, 3, 3, 5);
        this.TuskRI2.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskRI2, 0.1745329F, 0F, 0.1745329F);

        this.TuskRI3 = new ModelRenderer(this, 110, 163);
        this.TuskRI3.addBox(-4.3F, 24.9F, -15.5F, 3, 3, 6);
        this.TuskRI3.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskRI3, -0.3490659F, 0F, 0.1745329F);

        this.TuskRI4 = new ModelRenderer(this, 96, 163);
        this.TuskRI4.addBox(-2.8F, 14.5F, -21.9F, 0, 7, 5);
        this.TuskRI4.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskRI4, 0.1745329F, 0F, 0.1745329F);

        this.TuskRI5 = new ModelRenderer(this, 112, 216);
        this.TuskRI5.addBox(-2.8F, 22.9F, -17.5F, 0, 7, 8);
        this.TuskRI5.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskRI5, -0.3490659F, 0F, 0.1745329F);

        this.TuskLW1 = new ModelRenderer(this, 56, 166);
        this.TuskLW1.addBox(1.3F, 5.5F, -24.2F, 3, 3, 7);
        this.TuskLW1.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskLW1, 0.6981317F, 0F, -0.1745329F);

        this.TuskLW2 = new ModelRenderer(this, 60, 158);
        this.TuskLW2.addBox(1.29F, 16.5F, -21.9F, 3, 3, 5);
        this.TuskLW2.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskLW2, 0.1745329F, 0F, -0.1745329F);

        this.TuskLW3 = new ModelRenderer(this, 58, 149);
        this.TuskLW3.addBox(1.3F, 24.9F, -15.5F, 3, 3, 6);
        this.TuskLW3.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskLW3, -0.3490659F, 0F, -0.1745329F);

        this.TuskLW4 = new ModelRenderer(this, 46, 164);
        this.TuskLW4.addBox(2.7F, 14.5F, -21.9F, 0, 7, 5);
        this.TuskLW4.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskLW4, 0.1745329F, 0F, -0.1745329F);

        this.TuskLW5 = new ModelRenderer(this, 52, 192);
        this.TuskLW5.addBox(2.7F, 22.9F, -17.5F, 0, 7, 8);
        this.TuskLW5.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskLW5, -0.3490659F, 0F, -0.1745329F);

        this.TuskRW1 = new ModelRenderer(this, 56, 166);
        this.TuskRW1.addBox(-4.3F, 5.5F, -24.2F, 3, 3, 7);
        this.TuskRW1.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskRW1, 0.6981317F, 0F, 0.1745329F);

        this.TuskRW2 = new ModelRenderer(this, 60, 158);
        this.TuskRW2.addBox(-4.29F, 16.5F, -21.9F, 3, 3, 5);
        this.TuskRW2.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskRW2, 0.1745329F, 0F, 0.1745329F);

        this.TuskRW3 = new ModelRenderer(this, 58, 149);
        this.TuskRW3.addBox(-4.3F, 24.9F, -15.5F, 3, 3, 6);
        this.TuskRW3.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskRW3, -0.3490659F, 0F, 0.1745329F);

        this.TuskRW4 = new ModelRenderer(this, 46, 157);
        this.TuskRW4.addBox(-2.8F, 14.5F, -21.9F, 0, 7, 5);
        this.TuskRW4.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskRW4, 0.1745329F, 0F, 0.1745329F);

        this.TuskRW5 = new ModelRenderer(this, 52, 199);
        this.TuskRW5.addBox(-2.8F, 22.9F, -17.5F, 0, 7, 8);
        this.TuskRW5.setPos(0F, -10F, -16.5F);
        setRotation(this.TuskRW5, -0.3490659F, 0F, 0.1745329F);

        this.FortFloor1 = new ModelRenderer(this, 0, 176);
        this.FortFloor1.addBox(-0.5F, -20F, -6F, 1, 8, 12);
        this.FortFloor1.setPos(0F, -16F, 10F);
        setRotation(this.FortFloor1, 1.570796F, 0F, 1.570796F);

        this.FortFloor2 = new ModelRenderer(this, 0, 176);
        this.FortFloor2.addBox(-0.5F, -12F, -6F, 1, 8, 12);
        this.FortFloor2.setPos(0F, -16F, 10F);
        setRotation(this.FortFloor2, 1.570796F, 0F, 1.570796F);

        this.FortFloor3 = new ModelRenderer(this, 0, 176);
        this.FortFloor3.addBox(-0.5F, -4F, -6F, 1, 8, 12);
        this.FortFloor3.setPos(0F, -16F, 10F);
        setRotation(this.FortFloor3, 1.570796F, 0F, 1.570796F);

        this.FortBackWall = new ModelRenderer(this, 0, 176);
        this.FortBackWall.addBox(-5F, -6.2F, -6F, 1, 8, 12);
        this.FortBackWall.setPos(0F, -16F, 10F);
        setRotation(this.FortBackWall, 0F, 1.570796F, 0F);

        this.FortBackLeftWall = new ModelRenderer(this, 0, 176);
        this.FortBackLeftWall.addBox(6F, -6F, -7F, 1, 8, 12);
        this.FortBackLeftWall.setPos(0F, -16F, 10F);

        this.FortBackRightWall = new ModelRenderer(this, 0, 176);
        this.FortBackRightWall.addBox(-7F, -6F, -7F, 1, 8, 12);
        this.FortBackRightWall.setPos(0F, -16F, 10F);

        this.StorageUpLeft = new ModelRenderer(this, 76, 226);
        this.StorageUpLeft.addBox(6.5F, 1F, -14F, 5, 8, 10);
        this.StorageUpLeft.setPos(0F, -16F, 10F);
        setRotation(this.StorageUpLeft, 0F, 0F, -0.3839724F);

        this.StorageUpRight = new ModelRenderer(this, 76, 208);
        this.StorageUpRight.addBox(-11.5F, 1F, -14F, 5, 8, 10);
        this.StorageUpRight.setPos(0F, -16F, 10F);
        setRotation(this.StorageUpRight, 0F, 0F, 0.3839724F);
    }

    @Override
    public void setupAnim(T entity, float v, float v1, float v2, float v3, float v4) {
        MoCEntityElephant elephant = (MoCEntityElephant) entity;
        this.tusks = elephant.getTusks();
        this.type = elephant.getSubType();
        this.tailCounter = elephant.tailCounter;
        this.earCounter = elephant.earCounter;
        this.trunkCounter = elephant.trunkCounter;
        this.harness = elephant.getArmorType();
        this.storage = elephant.getStorage();
        this.isSitting = (elephant.sitCounter != 0);
        this.age = elephant.getIsAdult();
        this.edad = entity.getEdad();
        //boolean moveTail = (elephant.tailCounter != 0);

        setRotationAngles(v, v1, v2, v3, v4);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    /**
     * Used to adjust the Y offset of the model cubes
     */
    private void AdjustY(float f) {
        float yOff = f;
        this.Head.y = yOff + -10F;
        this.Neck.y = yOff + -8F;
        this.HeadBump.y = yOff + -10F;
        this.Chin.y = yOff + -10F;
        this.LowerLip.y = yOff + -10F;
        this.Back.y = yOff + -4F;
        this.LeftSmallEar.y = yOff + -10F;
        this.LeftBigEar.y = yOff + -10F;
        this.RightSmallEar.y = yOff + -10F;
        this.RightBigEar.y = yOff + -10F;
        this.Hump.y = yOff + -13F;
        this.Body.y = yOff + -2F;
        this.Skirt.y = yOff + 8F;
        this.RightTuskA.y = yOff + -10F;
        this.RightTuskB.y = yOff + -10F;
        this.RightTuskC.y = yOff + -10F;
        this.RightTuskD.y = yOff + -10F;
        this.LeftTuskA.y = yOff + -10F;
        this.LeftTuskB.y = yOff + -10F;
        this.LeftTuskC.y = yOff + -10F;
        this.LeftTuskD.y = yOff + -10F;
        this.TrunkA.y = yOff + -3F;
        this.TrunkB.y = yOff + 5.5F;
        this.TrunkC.y = yOff + 13F;
        this.TrunkD.y = yOff + 16F;
        this.TrunkE.y = yOff + 19.5F;
        this.FrontRightUpperLeg.y = yOff + 4F;
        this.FrontRightLowerLeg.y = yOff + 14F;
        this.FrontLeftUpperLeg.y = yOff + 4F;
        this.FrontLeftLowerLeg.y = yOff + 14F;
        this.BackRightUpperLeg.y = yOff + 4F;
        this.BackRightLowerLeg.y = yOff + 14F;
        this.BackLeftUpperLeg.y = yOff + 4F;
        this.BackLeftLowerLeg.y = yOff + 14F;
        this.TailRoot.y = yOff + -8F;
        this.Tail.y = yOff + -8F;
        this.TailPlush.y = yOff + -8F;
        this.StorageRightBedroll.y = yOff + -10.2F;
        this.StorageLeftBedroll.y = yOff + -10.2F;
        this.StorageFrontRightChest.y = yOff + -1.2F;
        this.StorageBackRightChest.y = yOff + -1.2F;
        this.StorageFrontLeftChest.y = yOff + -1.2F;
        this.StorageBackLeftChest.y = yOff + -1.2F;
        this.StorageRightBlankets.y = yOff + -10.2F;
        this.StorageLeftBlankets.y = yOff + -10.2F;
        this.HarnessBlanket.y = yOff + -13.2F;
        this.HarnessUpperBelt.y = yOff + -2F;
        this.HarnessLowerBelt.y = yOff + -2F;
        this.CabinPillow.y = yOff + -16F;
        this.CabinLeftRail.y = yOff + -23F;
        this.Cabin.y = yOff + -35F;
        this.CabinRightRail.y = yOff + -23F;
        this.CabinBackRail.y = yOff + -23F;
        this.CabinRoof.y = yOff + -34F;
        this.FortBackRightWall.y = yOff + -16F;
        this.FortBackLeftWall.y = yOff + -16F;
        this.FortBackWall.y = yOff + -16F;
        this.FortNeckBeam.y = yOff + -16F;
        this.FortBackBeam.y = yOff + -16F;
        this.FortFloor1.y = yOff + -16F;
        this.FortFloor2.y = yOff + -16F;
        this.FortFloor3.y = yOff + -16F;

        this.StorageUpLeft.y = yOff + -16F;
        this.StorageUpRight.y = yOff + -16F;

        this.TuskLD1.y = yOff + -10F;
        this.TuskLD2.y = yOff + -10F;
        this.TuskLD3.y = yOff + -10F;
        this.TuskLD4.y = yOff + -10F;
        this.TuskLD5.y = yOff + -10F;
        this.TuskRD1.y = yOff + -10F;
        this.TuskRD2.y = yOff + -10F;
        this.TuskRD3.y = yOff + -10F;
        this.TuskRD4.y = yOff + -10F;
        this.TuskRD5.y = yOff + -10F;
        this.TuskLI1.y = yOff + -10F;
        this.TuskLI2.y = yOff + -10F;
        this.TuskLI3.y = yOff + -10F;
        this.TuskLI4.y = yOff + -10F;
        this.TuskLI5.y = yOff + -10F;
        this.TuskRI1.y = yOff + -10F;
        this.TuskRI2.y = yOff + -10F;
        this.TuskRI3.y = yOff + -10F;
        this.TuskRI4.y = yOff + -10F;
        this.TuskRI5.y = yOff + -10F;
        this.TuskLW1.y = yOff + -10F;
        this.TuskLW2.y = yOff + -10F;
        this.TuskLW3.y = yOff + -10F;
        this.TuskLW4.y = yOff + -10F;
        this.TuskLW5.y = yOff + -10F;
        this.TuskRW1.y = yOff + -10F;
        this.TuskRW2.y = yOff + -10F;
        this.TuskRW3.y = yOff + -10F;
        this.TuskRW4.y = yOff + -10F;
        this.TuskRW5.y = yOff + -10F;

    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4) {//, byte tusks, boolean sitting, boolean tail) {

        float RLegXRot = MathHelper.cos((f * 0.6662F) + 3.141593F) * 0.8F * f1;
        float LLegXRot = MathHelper.cos(f * 0.6662F) * 0.8F * f1;

        if (f4 < 0) {
            f4 = 0;
        }

        float HeadXRot = (f4 / 57.29578F);
        if (f3 > 20F) {
            f3 = 20F;
        }
        if (f3 < -20F) {
            f3 = -20F;
        }
        float HeadYRot = (f3 / 57.29578F);

        float f10 = 0F;
        if (isSitting) {
            f10 = 8F;
        }
        AdjustY(f10);

        /**
         * Random Trunk animation
         */
        float TrunkXRot = 0F;

        if (trunkCounter != 0) {
            HeadXRot = 0F;
            TrunkXRot = MathHelper.cos(this.trunkCounter * 0.2F) * 12F;
        }
        if (isSitting) {
            HeadXRot = 0F;
            TrunkXRot = 25F;
        }
        this.Head.xRot = (-10F / this.radianF) + HeadXRot;

        this.Head.yRot = HeadYRot;
        this.HeadBump.yRot = this.Head.yRot;
        this.HeadBump.xRot = this.Head.xRot;

        this.RightTuskA.yRot = HeadYRot;
        this.LeftTuskA.yRot = HeadYRot;
        this.RightTuskA.xRot = (70F / this.radianF) + HeadXRot;
        this.LeftTuskA.xRot = (70F / this.radianF) + HeadXRot;

        this.Chin.yRot = HeadYRot;
        this.Chin.xRot = (113F / this.radianF) + HeadXRot;
        this.LowerLip.yRot = HeadYRot;
        this.LowerLip.xRot = (85F / this.radianF) + HeadXRot;

        //ears
        /**
         * f = distance walked f1 = speed 0 - 1 f2 = timer
         */
        /**
         * Ear random animation
         */
        float EarF = 0F;

        /*float f2a = f2 % 100F;
        if (f2a > 60 & f2a < 90) {
            EarF = MathHelper.cos(f2 * 0.5F) * 0.35F;
        }*/

        if (this.earCounter != 0) {
            EarF = MathHelper.cos(this.earCounter * 0.5F) * 0.35F;
        }

        this.RightBigEar.yRot = (30F / this.radianF) + HeadYRot + EarF;
        this.RightSmallEar.yRot = (30F / this.radianF) + HeadYRot + EarF;
        this.LeftBigEar.yRot = (-30F / this.radianF) + HeadYRot - EarF;
        this.LeftSmallEar.yRot = (-30F / this.radianF) + HeadYRot - EarF;

        this.RightBigEar.xRot = (-10F / this.radianF) + HeadXRot;
        this.RightSmallEar.xRot = (-10F / this.radianF) + HeadXRot;
        this.LeftBigEar.xRot = (-10F / this.radianF) + HeadXRot;
        this.LeftSmallEar.xRot = (-10F / this.radianF) + HeadXRot;

        //TrunkA.rotateAngleX = -50F / radianF;

        //TrunkA.rotationPointY = -3F;
        this.TrunkA.z = -22.50F;
        adjustAllRotationPoints(this.TrunkA, this.Head);

        this.TrunkA.yRot = HeadYRot;
        float TrunkARotX = (90F - TrunkXRot);
        if (TrunkARotX < 85) {
            TrunkARotX = 85;
        }
        this.TrunkA.xRot = ((TrunkARotX) / this.radianF) + HeadXRot;

        //TrunkB.rotationPointY = 5.5F;
        this.TrunkB.z = -22.5F;
        //TrunkB.setRotationPoint(0F, 6.5F, -22.5F);
        adjustAllRotationPoints(this.TrunkB, this.TrunkA);
        this.TrunkB.yRot = HeadYRot;
        this.TrunkB.xRot = ((95F - TrunkXRot * 1.5F) / this.radianF) + HeadXRot;

        //TrunkC.setRotationPoint(0F, 13F, -22.0F);
        //TrunkC.rotationPointY = 13F;
        this.TrunkC.z = -22.5F;
        adjustAllRotationPoints(this.TrunkC, this.TrunkB);
        this.TrunkC.yRot = HeadYRot;
        this.TrunkC.xRot = ((110F - TrunkXRot * 3F) / this.radianF) + HeadXRot;

        //TrunkD.rotationPointY = 16F;
        this.TrunkD.z = -21.5F;
        adjustAllRotationPoints(this.TrunkD, this.TrunkC);
        this.TrunkD.yRot = HeadYRot;
        this.TrunkD.xRot = ((127F - TrunkXRot * 4.5F) / this.radianF) + HeadXRot;

        //TrunkE.rotationPointY = 19.5F;
        this.TrunkE.z = -19F;
        adjustAllRotationPoints(this.TrunkE, this.TrunkD);
        this.TrunkE.yRot = HeadYRot;
        this.TrunkE.xRot = ((145F - TrunkXRot * 6F) / this.radianF) + HeadXRot;

        //legs
        if (isSitting) {
            this.FrontRightUpperLeg.xRot = -30F / this.radianF;
            this.FrontLeftUpperLeg.xRot = -30F / this.radianF;
            this.BackLeftUpperLeg.xRot = -30F / this.radianF;
            this.BackRightUpperLeg.xRot = -30F / this.radianF;
        } else {
            this.FrontRightUpperLeg.xRot = RLegXRot;
            this.FrontLeftUpperLeg.xRot = LLegXRot;
            this.BackLeftUpperLeg.xRot = RLegXRot;
            this.BackRightUpperLeg.xRot = LLegXRot;
        }

        adjustXRotationPoints(this.FrontRightLowerLeg, this.FrontRightUpperLeg);
        adjustXRotationPoints(this.BackRightLowerLeg, this.BackRightUpperLeg);
        adjustXRotationPoints(this.FrontLeftLowerLeg, this.FrontLeftUpperLeg);
        adjustXRotationPoints(this.BackLeftLowerLeg, this.BackLeftUpperLeg);

        //To convert from degrees to radians, multiply by ((PI)/180o).
        //To convert from radians to degrees, multiply by (180o/(PI)).
        if (isSitting) {
            this.FrontLeftLowerLeg.xRot = 90F / this.radianF;
            this.FrontRightLowerLeg.xRot = 90F / this.radianF;
            this.BackLeftLowerLeg.xRot = 90F / this.radianF;
            this.BackRightLowerLeg.xRot = 90F / this.radianF;
        } else {
            float LLegXRotD = (LLegXRot * (float) (180 / Math.PI));
            float RLegXRotD = (RLegXRot * (float) (180 / Math.PI));

            if (LLegXRotD > 0F) {
                LLegXRotD *= 2F;
            }
            if (RLegXRotD > 0F) {
                RLegXRotD *= 2F;
            }

            this.FrontLeftLowerLeg.xRot = LLegXRotD / this.radianF;
            this.FrontRightLowerLeg.xRot = RLegXRotD / this.radianF;
            this.BackLeftLowerLeg.xRot = RLegXRotD / this.radianF;
            this.BackRightLowerLeg.xRot = LLegXRotD / this.radianF;
        }

        if (tusks == 0) {
            this.LeftTuskB.yRot = HeadYRot;
            this.LeftTuskC.yRot = HeadYRot;
            this.LeftTuskD.yRot = HeadYRot;
            this.RightTuskB.yRot = HeadYRot;
            this.RightTuskC.yRot = HeadYRot;
            this.RightTuskD.yRot = HeadYRot;

            this.LeftTuskB.xRot = (40F / this.radianF) + HeadXRot;
            this.LeftTuskC.xRot = (10F / this.radianF) + HeadXRot;
            this.LeftTuskD.xRot = (-20F / this.radianF) + HeadXRot;
            this.RightTuskB.xRot = (40F / this.radianF) + HeadXRot;
            this.RightTuskC.xRot = (10F / this.radianF) + HeadXRot;
            this.RightTuskD.xRot = (-20F / this.radianF) + HeadXRot;
        } else if (tusks == 1) {
            this.TuskLW1.yRot = HeadYRot;
            this.TuskLW2.yRot = HeadYRot;
            this.TuskLW3.yRot = HeadYRot;
            this.TuskLW4.yRot = HeadYRot;
            this.TuskLW5.yRot = HeadYRot;
            this.TuskRW1.yRot = HeadYRot;
            this.TuskRW2.yRot = HeadYRot;
            this.TuskRW3.yRot = HeadYRot;
            this.TuskRW4.yRot = HeadYRot;
            this.TuskRW5.yRot = HeadYRot;

            this.TuskLW1.xRot = (40F / this.radianF) + HeadXRot;
            this.TuskLW2.xRot = (10F / this.radianF) + HeadXRot;
            this.TuskLW3.xRot = (-20F / this.radianF) + HeadXRot;
            this.TuskLW4.xRot = (10F / this.radianF) + HeadXRot;
            this.TuskLW5.xRot = (-20F / this.radianF) + HeadXRot;
            this.TuskRW1.xRot = (40F / this.radianF) + HeadXRot;
            this.TuskRW2.xRot = (10F / this.radianF) + HeadXRot;
            this.TuskRW3.xRot = (-20F / this.radianF) + HeadXRot;
            this.TuskRW4.xRot = (10F / this.radianF) + HeadXRot;
            this.TuskRW5.xRot = (-20F / this.radianF) + HeadXRot;
        } else if (tusks == 2) {
            this.TuskLI1.yRot = HeadYRot;
            this.TuskLI2.yRot = HeadYRot;
            this.TuskLI3.yRot = HeadYRot;
            this.TuskLI4.yRot = HeadYRot;
            this.TuskLI5.yRot = HeadYRot;
            this.TuskRI1.yRot = HeadYRot;
            this.TuskRI2.yRot = HeadYRot;
            this.TuskRI3.yRot = HeadYRot;
            this.TuskRI4.yRot = HeadYRot;
            this.TuskRI5.yRot = HeadYRot;

            this.TuskLI1.xRot = (40F / this.radianF) + HeadXRot;
            this.TuskLI2.xRot = (10F / this.radianF) + HeadXRot;
            this.TuskLI3.xRot = (-20F / this.radianF) + HeadXRot;
            this.TuskLI4.xRot = (10F / this.radianF) + HeadXRot;
            this.TuskLI5.xRot = (-20F / this.radianF) + HeadXRot;
            this.TuskRI1.xRot = (40F / this.radianF) + HeadXRot;
            this.TuskRI2.xRot = (10F / this.radianF) + HeadXRot;
            this.TuskRI3.xRot = (-20F / this.radianF) + HeadXRot;
            this.TuskRI4.xRot = (10F / this.radianF) + HeadXRot;
            this.TuskRI5.xRot = (-20F / this.radianF) + HeadXRot;
        } else if (tusks == 3) {
            this.TuskLD1.yRot = HeadYRot;
            this.TuskLD2.yRot = HeadYRot;
            this.TuskLD3.yRot = HeadYRot;
            this.TuskLD4.yRot = HeadYRot;
            this.TuskLD5.yRot = HeadYRot;
            this.TuskRD1.yRot = HeadYRot;
            this.TuskRD2.yRot = HeadYRot;
            this.TuskRD3.yRot = HeadYRot;
            this.TuskRD4.yRot = HeadYRot;
            this.TuskRD5.yRot = HeadYRot;

            this.TuskLD1.xRot = (40F / this.radianF) + HeadXRot;
            this.TuskLD2.xRot = (10F / this.radianF) + HeadXRot;
            this.TuskLD3.xRot = (-20F / this.radianF) + HeadXRot;
            this.TuskLD4.xRot = (10F / this.radianF) + HeadXRot;
            this.TuskLD5.xRot = (-20F / this.radianF) + HeadXRot;
            this.TuskRD1.xRot = (40F / this.radianF) + HeadXRot;
            this.TuskRD2.xRot = (10F / this.radianF) + HeadXRot;
            this.TuskRD3.xRot = (-20F / this.radianF) + HeadXRot;
            this.TuskRD4.xRot = (10F / this.radianF) + HeadXRot;
            this.TuskRD5.xRot = (-20F / this.radianF) + HeadXRot;
        }

        //chest anim
        this.StorageLeftBedroll.xRot = LLegXRot / 10F;
        this.StorageFrontLeftChest.xRot = LLegXRot / 5F;
        this.StorageBackLeftChest.xRot = LLegXRot / 5F;

        this.StorageRightBedroll.xRot = RLegXRot / 10F;
        this.StorageFrontRightChest.xRot = RLegXRot / 5F;
        this.StorageBackRightChest.xRot = RLegXRot / 5F;

        this.FortNeckBeam.zRot = LLegXRot / 50F;
        this.FortBackBeam.zRot = LLegXRot / 50F;

        this.FortBackRightWall.zRot = (LLegXRot / 50F);
        this.FortBackLeftWall.zRot = (LLegXRot / 50F);
        this.FortBackWall.xRot = 0F - (LLegXRot / 50F);

        //f1 = movement speed!
        //f2 = timer!
        //tail
        float tailMov = (f1 * 0.9F);
        if (tailMov < 0) {
            tailMov = 0;
        }
        if (this.tailCounter != 0) {
            this.TailRoot.yRot = MathHelper.cos(f2 * 0.4F) * 1.3F;
            tailMov = 30F / this.radianF;
        } else {
            this.TailRoot.yRot = 0F;
        }
        this.TailRoot.xRot = (17F / this.radianF) + tailMov;
        this.TailPlush.xRot = this.Tail.xRot = (6.5F / this.radianF) + tailMov;
        this.TailPlush.yRot = this.TailRoot.yRot;
        this.Tail.yRot = this.TailPlush.yRot;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        //super.render(entity, f, f1, f2, f3, f4, f5);
        if (tusks == 0) {
            this.LeftTuskB.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.RightTuskB.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            if (this.age || this.edad > 70) {
                this.LeftTuskC.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.RightTuskC.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            }
            if (this.age || this.edad > 90) {
                this.LeftTuskD.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.RightTuskD.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            }
        } else if (tusks == 1) {
            this.TuskLW1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskLW2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskLW3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskLW4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskLW5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskRW1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskRW2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskRW3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskRW4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskRW5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        } else if (tusks == 2) {
            this.TuskLI1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskLI2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskLI3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskLI4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskLI5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskRI1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskRI2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskRI3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskRI4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskRI5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        } else if (tusks == 3) {
            this.TuskLD1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskLD2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskLD3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskLD4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskLD5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskRD1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskRD2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskRD3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskRD4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.TuskRD5.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        }

        if (type == 1) //african
        {
            this.LeftBigEar.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.RightBigEar.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        } else {
            this.LeftSmallEar.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.RightSmallEar.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        }

        if (type == 3 || type == 4) //mammoths
        {
            this.HeadBump.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.Skirt.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        }

        if (harness >= 1) {
            this.HarnessBlanket.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.HarnessUpperBelt.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.HarnessLowerBelt.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            if (type == 5) {
                this.Skirt.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            }
        }

        if (harness == 3) {
            if (type == 5) {
                this.CabinPillow.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.CabinLeftRail.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.Cabin.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.CabinRightRail.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.CabinBackRail.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.CabinRoof.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            }

            if (type == 4) {

                this.FortBackRightWall.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.FortBackLeftWall.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.FortBackWall.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.FortFloor1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.FortFloor2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.FortFloor3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.FortNeckBeam.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                this.FortBackBeam.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);

            }

        }

        if (storage >= 1) {
            this.StorageRightBedroll.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.StorageFrontRightChest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.StorageBackRightChest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.StorageRightBlankets.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);

        }
        if (storage >= 2) {
            this.StorageLeftBlankets.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.StorageLeftBedroll.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.StorageFrontLeftChest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.StorageBackLeftChest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);

        }
        if (storage >= 3) {
            this.StorageUpLeft.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        }

        if (storage >= 4) {
            this.StorageUpRight.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        }

        this.Head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Neck.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Chin.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.LowerLip.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Back.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);

        this.Hump.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);

        this.RightTuskA.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.LeftTuskA.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);

        this.TrunkA.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.TrunkB.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.TrunkC.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.TrunkD.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.TrunkE.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.FrontRightUpperLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.FrontRightLowerLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.FrontLeftUpperLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.FrontLeftLowerLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.BackRightUpperLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.BackRightLowerLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.BackLeftUpperLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.BackLeftLowerLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.TailRoot.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.Tail.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.TailPlush.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    /**
     * Used for leg adjustment - anteroposterior movement
     *
     * @param target
     * @param origin
     */
    private void adjustXRotationPoints(ModelRenderer target, ModelRenderer origin) {
        //rotation point Z and Y adjusted for legs =
        //Z rotation point = attached rotation point Z + sin(attached.rotateangleX) * distance
        //Y rotation point = attached rotation point Y + cos(attached.rotateangleX) * distance
        float distance = target.y - origin.y;
        if (distance < 0F) {
            distance *= -1F;
        }
        target.z = origin.z + (MathHelper.sin(origin.xRot) * distance);
        target.y = origin.y + (MathHelper.cos(origin.xRot) * distance);

    }

    /**
     * Used for trunk adjustment - lateral movement
     *
     * @param target : target model
     * @param origin : origin model
     */
    @SuppressWarnings("unused")
    private void adjustYRotationPoints(ModelRenderer target, ModelRenderer origin) {
        //rotation point Z and X adjusted for head =
        //Z rotation point = attached rotation point Z - cos(attached.rotateangleX) * distance
        //Y rotation point = attached rotation point Y - sin(attached.rotateangleX) * distance
        float distanceZ = 0F;
        if (target.z > origin.z) {
            distanceZ = target.z - origin.z;
        } else {
            distanceZ = origin.z - target.z;
        }

        target.z = origin.z - (MathHelper.cos(origin.yRot) * distanceZ);
        target.x = origin.x - (MathHelper.sin(origin.yRot) * distanceZ);
    }

    @SuppressWarnings("unused")
    private void adjustAllRotationPoints(ModelRenderer target, ModelRenderer origin) {

        float distanceY = 0F;
        if (target.y > origin.y) {
            distanceY = target.y - origin.y;
        } else {
            distanceY = origin.y - target.y;
        }

        float distanceZ = 0F;
        if (target.z > origin.z) {
            distanceZ = target.z - origin.z;
        } else {
            distanceZ = origin.z - target.z;
        }

        target.y = origin.y + MathHelper.sin(origin.xRot) * distanceY;
        target.z = origin.z - MathHelper.cos(origin.yRot) * (MathHelper.cos(origin.xRot) * distanceY);
        target.x = origin.x - MathHelper.sin(origin.yRot) * (MathHelper.cos(origin.xRot) * distanceY);

    }

}
