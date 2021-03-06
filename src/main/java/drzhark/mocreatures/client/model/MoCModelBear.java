package drzhark.mocreatures.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import drzhark.mocreatures.entity.passive.MoCEntityBear;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MoCModelBear<T extends MoCEntityBear> extends EntityModel<T> {

    public ModelRenderer Saddle;
    public ModelRenderer SaddleBack;
    public ModelRenderer SaddleFront;
    public ModelRenderer Bag;
    public ModelRenderer SaddleSitted;
    public ModelRenderer SaddleBackSitted;
    public ModelRenderer SaddleFrontSitted;
    public ModelRenderer BagSitted;


    ModelRenderer Head;
    ModelRenderer Mouth;
    ModelRenderer LEar;
    ModelRenderer Snout;
    ModelRenderer REar;
    ModelRenderer MouthOpen;


    ModelRenderer Neck;
    ModelRenderer Tail;
    ModelRenderer LegFR1;
    ModelRenderer Abdomen;
    ModelRenderer Torso;
    ModelRenderer LegRR3;
    ModelRenderer LegRR1;
    ModelRenderer LegRR2;
    ModelRenderer LegFR2;
    ModelRenderer LegFR3;
    ModelRenderer LegFL1;
    ModelRenderer LegFL3;
    ModelRenderer LegFL2;
    ModelRenderer LegRL1;
    ModelRenderer LegRL2;
    ModelRenderer LegRL3;

    ModelRenderer BHead;
    ModelRenderer BSnout;
    ModelRenderer BMouth;
    ModelRenderer BMouthOpen;
    ModelRenderer BNeck;
    ModelRenderer BLEar;
    ModelRenderer BREar;
    ModelRenderer BTorso;
    ModelRenderer BAbdomen;
    ModelRenderer BTail;
    ModelRenderer BLegFL1;
    ModelRenderer BLegFL2;
    ModelRenderer BLegFL3;
    ModelRenderer BLegFR1;
    ModelRenderer BLegFR2;
    ModelRenderer BLegFR3;
    ModelRenderer BLegRL1;
    ModelRenderer BLegRL2;
    ModelRenderer BLegRL3;
    ModelRenderer BLegRR1;
    ModelRenderer BLegRR2;
    ModelRenderer BLegRR3;

    ModelRenderer CHead;
    ModelRenderer CSnout;
    ModelRenderer CMouth;
    ModelRenderer CMouthOpen;
    ModelRenderer CLEar;
    ModelRenderer CREar;
    ModelRenderer CNeck;
    ModelRenderer CTorso;
    ModelRenderer CAbdomen;
    ModelRenderer CTail;
    ModelRenderer CLegFL1;
    ModelRenderer CLegFL2;
    ModelRenderer CLegFL3;
    ModelRenderer CLegFR1;
    ModelRenderer CLegFR2;
    ModelRenderer CLegFR3;
    ModelRenderer CLegRL1;
    ModelRenderer CLegRL2;
    ModelRenderer CLegRL3;
    ModelRenderer CLegRR1;
    ModelRenderer CLegRR2;
    ModelRenderer CLegRR3;

    private int bearstate;
    private float attackSwing;
    boolean openMouth;
    boolean chested;
    boolean saddled;

    public MoCModelBear() {
        this.texWidth = 128;
        this.texHeight = 128;

        this.Head = new ModelRenderer(this, 19, 0);
        this.Head.addBox(-4F, 0F, -4F, 8, 8, 5);
        this.Head.setPos(0F, 6F, -10F);
        setRotation(this.Head, 0.1502636F, 0F, 0F);

        this.Mouth = new ModelRenderer(this, 24, 21);
        this.Mouth.addBox(-1.5F, 6F, -6.8F, 3, 2, 5);
        this.Mouth.setPos(0F, 6F, -10F);
        setRotation(this.Mouth, -0.0068161F, 0F, 0F);

        this.MouthOpen = new ModelRenderer(this, 24, 21);
        this.MouthOpen.addBox(-1.5F, 4F, -9.5F, 3, 2, 5);
        this.MouthOpen.setPos(0F, 6F, -10F);
        setRotation(this.MouthOpen, 0.534236F, 0F, 0F);

        this.LEar = new ModelRenderer(this, 40, 0);
        this.LEar.addBox(2F, -2F, -2F, 3, 3, 1);
        this.LEar.setPos(0F, 6F, -10F);
        setRotation(this.LEar, 0.1502636F, -0.3490659F, 0.1396263F);

        this.REar = new ModelRenderer(this, 16, 0);
        this.REar.addBox(-5F, -2F, -2F, 3, 3, 1);
        this.REar.setPos(0F, 6F, -10F);
        setRotation(this.REar, 0.1502636F, 0.3490659F, -0.1396263F);

        this.Snout = new ModelRenderer(this, 23, 13);
        this.Snout.addBox(-2F, 3F, -8F, 4, 3, 5);
        this.Snout.setPos(0F, 6F, -10F);
        setRotation(this.Snout, 0.1502636F, 0F, 0F);

        this.Neck = new ModelRenderer(this, 18, 28);
        this.Neck.addBox(-3.5F, 0F, -7F, 7, 7, 7);
        this.Neck.setPos(0F, 5F, -5F);
        setRotation(this.Neck, 0.2617994F, 0F, 0F);

        this.Abdomen = new ModelRenderer(this, 13, 62);
        this.Abdomen.addBox(-4.5F, 0F, 0F, 9, 11, 10);
        this.Abdomen.setPos(0F, 5F, 5F);
        setRotation(this.Abdomen, -0.4363323F, 0F, 0F);

        this.Torso = new ModelRenderer(this, 12, 42);
        this.Torso.addBox(-5F, 0F, 0F, 10, 10, 10);
        this.Torso.setPos(0F, 5F, -5F);

        this.Tail = new ModelRenderer(this, 26, 83);
        this.Tail.addBox(-1.5F, 0F, 0F, 3, 3, 3);
        this.Tail.setPos(0F, 8.466666F, 12F);
        setRotation(this.Tail, 0.4363323F, 0F, 0F);

        this.LegFL1 = new ModelRenderer(this, 40, 22);
        this.LegFL1.addBox(-2.5F, 0F, -2.5F, 5, 8, 5);
        this.LegFL1.setPos(4F, 10F, -4F);
        setRotation(this.LegFL1, 0.2617994F, 0F, 0F);

        this.LegFL2 = new ModelRenderer(this, 46, 35);
        this.LegFL2.addBox(-2F, 7F, 0F, 4, 6, 4);
        this.LegFL2.setPos(4F, 10F, -4F);

        this.LegFL3 = new ModelRenderer(this, 46, 45);
        this.LegFL3.addBox(-2F, 12F, -1F, 4, 2, 5);
        this.LegFL3.setPos(4F, 10F, -4F);

        this.LegFR1 = new ModelRenderer(this, 4, 22);
        this.LegFR1.addBox(-2.5F, 0F, -2.5F, 5, 8, 5);
        this.LegFR1.setPos(-4F, 10F, -4F);
        setRotation(this.LegFR1, 0.2617994F, 0F, 0F);

        this.LegFR2 = new ModelRenderer(this, 2, 35);
        this.LegFR2.addBox(-2F, 7F, 0F, 4, 6, 4);
        this.LegFR2.setPos(-4F, 10F, -4F);

        this.LegFR3 = new ModelRenderer(this, 0, 45);
        this.LegFR3.addBox(-2F, 12F, -1F, 4, 2, 5);
        this.LegFR3.setPos(-4F, 10F, -4F);

        this.LegRL1 = new ModelRenderer(this, 34, 83);
        this.LegRL1.addBox(-1.5F, 0F, -2.5F, 4, 8, 6);
        this.LegRL1.setPos(3.5F, 11F, 9F);
        setRotation(this.LegRL1, -0.1745329F, 0F, 0F);

        this.LegRL2 = new ModelRenderer(this, 41, 97);
        this.LegRL2.addBox(-2F, 6F, -1F, 4, 6, 4);
        this.LegRL2.setPos(3.5F, 11F, 9F);

        this.LegRL3 = new ModelRenderer(this, 44, 107);
        this.LegRL3.addBox(-2F, 11F, -2F, 4, 2, 5);
        this.LegRL3.setPos(3.5F, 11F, 9F);

        this.LegRR1 = new ModelRenderer(this, 10, 83);
        this.LegRR1.addBox(-2.5F, 0F, -2.5F, 4, 8, 6);
        this.LegRR1.setPos(-3.5F, 11F, 9F);
        setRotation(this.LegRR1, -0.1745329F, 0F, 0F);

        this.LegRR2 = new ModelRenderer(this, 7, 97);
        this.LegRR2.addBox(-2F, 6F, -1F, 4, 6, 4);
        this.LegRR2.setPos(-3.5F, 11F, 9F);

        this.LegRR3 = new ModelRenderer(this, 2, 107);
        this.LegRR3.addBox(-2F, 11F, -2F, 4, 2, 5);
        this.LegRR3.setPos(-3.5F, 11F, 9F);

        //---standing

        this.BHead = new ModelRenderer(this, 19, 0);
        this.BHead.addBox(-4F, 0F, -4F, 8, 8, 5);
        this.BHead.setPos(0F, -12F, 5F);
        setRotation(this.BHead, -0.0242694F, 0F, 0F);

        this.BSnout = new ModelRenderer(this, 23, 13);
        this.BSnout.addBox(-2F, 2.5F, -8.5F, 4, 3, 5);
        this.BSnout.setPos(0F, -12F, 5F);
        setRotation(this.BSnout, -0.0242694F, 0F, 0F);

        this.BMouth = new ModelRenderer(this, 24, 21);
        this.BMouth.addBox(-1.5F, 5.5F, -8.0F, 3, 2, 5);
        this.BMouth.setPos(0F, -12F, 5F);
        setRotation(this.BMouth, -0.08726F, 0F, 0F);

        this.BMouthOpen = new ModelRenderer(this, 24, 21);
        this.BMouthOpen.addBox(-1.5F, 3.5F, -11F, 3, 2, 5);
        this.BMouthOpen.setPos(0F, -12F, 5F);
        setRotation(this.BMouthOpen, 0.5235988F, 0F, 0F);

        this.BNeck = new ModelRenderer(this, 18, 28);
        this.BNeck.addBox(-3.5F, 0F, -7F, 7, 6, 7);
        this.BNeck.setPos(0F, -3F, 11F);
        setRotation(this.BNeck, -1.336881F, 0F, 0F);

        this.BLEar = new ModelRenderer(this, 40, 0);
        this.BLEar.addBox(2F, -2F, -2F, 3, 3, 1);
        this.BLEar.setPos(0F, -12F, 5F);
        setRotation(this.BLEar, -0.0242694F, -0.3490659F, 0.1396263F);

        this.BREar = new ModelRenderer(this, 16, 0);
        this.BREar.addBox(-5F, -2F, -2F, 3, 3, 1);
        this.BREar.setPos(0F, -12F, 5F);
        setRotation(this.BREar, -0.0242694F, 0.3490659F, -0.1396263F);

        this.BTorso = new ModelRenderer(this, 12, 42);
        this.BTorso.addBox(-5F, 0F, 0F, 10, 10, 10);
        this.BTorso.setPos(0F, -3.5F, 12.3F);
        setRotation(this.BTorso, -1.396263F, 0F, 0F);

        this.BAbdomen = new ModelRenderer(this, 13, 62);
        this.BAbdomen.addBox(-4.5F, 0F, 0F, 9, 11, 10);
        this.BAbdomen.setPos(0F, 6F, 14F);
        setRotation(this.BAbdomen, -1.570796F, 0F, 0F);

        this.BTail = new ModelRenderer(this, 26, 83);
        this.BTail.addBox(-1.5F, 0F, 0F, 3, 3, 3);
        this.BTail.setPos(0F, 12.46667F, 12.6F);
        setRotation(this.BTail, 0.3619751F, 0F, 0F);

        this.BLegFL1 = new ModelRenderer(this, 40, 22);
        this.BLegFL1.addBox(-2.5F, 0F, -2.5F, 5, 8, 5);
        this.BLegFL1.setPos(5F, -1F, 6F);
        setRotation(this.BLegFL1, 0.2617994F, 0F, -0.2617994F);

        this.BLegFL2 = new ModelRenderer(this, 46, 35);
        this.BLegFL2.addBox(0F, 5F, 3F, 4, 6, 4);
        this.BLegFL2.setPos(5F, -1F, 6F);
        setRotation(this.BLegFL2, -0.5576792F, 0F, 0F);

        this.BLegFL3 = new ModelRenderer(this, 46, 45);
        this.BLegFL3.addBox(0.1F, -7F, -14F, 4, 2, 5);
        this.BLegFL3.setPos(5F, -1F, 6F);
        setRotation(this.BLegFL3, 2.007645F, 0F, 0F);

        this.BLegFR1 = new ModelRenderer(this, 4, 22);
        this.BLegFR1.addBox(-2.5F, 0F, -2.5F, 5, 8, 5);
        this.BLegFR1.setPos(-5F, -1F, 6F);
        setRotation(this.BLegFR1, 0.2617994F, 0F, 0.2617994F);

        this.BLegFR2 = new ModelRenderer(this, 2, 35);
        this.BLegFR2.addBox(-4F, 5F, 3F, 4, 6, 4);
        this.BLegFR2.setPos(-5F, -1F, 6F);
        setRotation(this.BLegFR2, -0.5576792F, 0F, 0F);

        this.BLegFR3 = new ModelRenderer(this, 0, 45);
        this.BLegFR3.addBox(-4.1F, -7F, -14F, 4, 2, 5);
        this.BLegFR3.setPos(-5F, -1F, 6F);
        setRotation(this.BLegFR3, 2.007129F, 0F, 0F);

        this.BLegRL1 = new ModelRenderer(this, 34, 83);
        this.BLegRL1.addBox(-1.5F, 0F, -2.5F, 4, 8, 6);
        this.BLegRL1.setPos(3F, 11F, 9F);
        setRotation(this.BLegRL1, -0.5235988F, -0.2617994F, 0F);

        this.BLegRL2 = new ModelRenderer(this, 41, 97);
        this.BLegRL2.addBox(-1.3F, 6F, -3F, 4, 6, 4);
        this.BLegRL2.setPos(3F, 11F, 9F);
        setRotation(this.BLegRL2, 0F, -0.2617994F, 0F);

        this.BLegRL3 = new ModelRenderer(this, 44, 107);
        this.BLegRL3.addBox(-1.2F, 11F, -4F, 4, 2, 5);
        this.BLegRL3.setPos(3F, 11F, 9F);
        setRotation(this.BLegRL3, 0F, -0.2617994F, 0F);

        this.BLegRR1 = new ModelRenderer(this, 10, 83);
        this.BLegRR1.addBox(-2.5F, 0F, -2.5F, 4, 8, 6);
        this.BLegRR1.setPos(-3F, 11F, 9F);
        setRotation(this.BLegRR1, -0.1745329F, 0.2617994F, 0F);

        this.BLegRR2 = new ModelRenderer(this, 7, 97);
        this.BLegRR2.addBox(-2.4F, 6F, -1F, 4, 6, 4);
        this.BLegRR2.setPos(-3F, 11F, 9F);
        setRotation(this.BLegRR2, 0F, 0.2617994F, 0F);

        this.BLegRR3 = new ModelRenderer(this, 2, 107);
        this.BLegRR3.addBox(-2.5F, 11F, -2F, 4, 2, 5);
        this.BLegRR3.setPos(-3F, 11F, 9F);
        setRotation(this.BLegRR3, 0F, 0.2617994F, 0F);

        //---Sitting
        this.CHead = new ModelRenderer(this, 19, 0);
        this.CHead.addBox(-4F, 0F, -4F, 8, 8, 5);
        this.CHead.setPos(0F, 3F, -3.5F);
        setRotation(this.CHead, 0.1502636F, 0F, 0F);

        this.CSnout = new ModelRenderer(this, 23, 13);
        this.CSnout.addBox(-2F, 3F, -8.5F, 4, 3, 5);
        this.CSnout.setPos(0F, 3F, -3.5F);
        setRotation(this.CSnout, 0.1502636F, 0F, 0F);

        this.CMouth = new ModelRenderer(this, 24, 21);
        this.CMouth.addBox(-1.5F, 6F, -7F, 3, 2, 5);
        this.CMouth.setPos(0F, 3F, -3.5F);
        setRotation(this.CMouth, -0.0068161F, 0F, 0F);

        this.CMouthOpen = new ModelRenderer(this, 24, 21);
        this.CMouthOpen.addBox(-1.5F, 5.5F, -9F, 3, 2, 5);
        this.CMouthOpen.setPos(0F, 3F, -3.5F);
        setRotation(this.CMouthOpen, 0.3665191F, 0F, 0F);

        this.CLEar = new ModelRenderer(this, 40, 0);
        this.CLEar.addBox(2F, -2F, -2F, 3, 3, 1);
        this.CLEar.setPos(0F, 3F, -3.5F);
        setRotation(this.CLEar, 0.1502636F, -0.3490659F, 0.1396263F);

        this.CREar = new ModelRenderer(this, 16, 0);
        this.CREar.addBox(-5F, -2F, -2F, 3, 3, 1);
        this.CREar.setPos(0F, 3F, -3.5F);
        setRotation(this.CREar, 0.1502636F, 0.3490659F, -0.1396263F);

        this.CNeck = new ModelRenderer(this, 18, 28);
        this.CNeck.addBox(-3.5F, 0F, -7F, 7, 7, 7);
        this.CNeck.setPos(0F, 5.8F, 3.4F);
        setRotation(this.CNeck, -0.3316126F, 0F, 0F);

        this.CTorso = new ModelRenderer(this, 12, 42);
        this.CTorso.addBox(-5F, 0F, 0F, 10, 10, 10);
        this.CTorso.setPos(0F, 5.8F, 3.4F);
        setRotation(this.CTorso, -0.9712912F, 0F, 0F);

        this.CAbdomen = new ModelRenderer(this, 13, 62);
        this.CAbdomen.addBox(-4.5F, 0F, 0F, 9, 11, 10);
        this.CAbdomen.setPos(0F, 14F, 9F);
        setRotation(this.CAbdomen, -1.570796F, 0F, 0F);

        this.CTail = new ModelRenderer(this, 26, 83);
        this.CTail.addBox(-1.5F, 0F, 0F, 3, 3, 3);
        this.CTail.setPos(0F, 21.46667F, 8F);
        setRotation(this.CTail, 0.4363323F, 0F, 0F);

        this.CLegFL1 = new ModelRenderer(this, 40, 22);
        this.CLegFL1.addBox(-2.5F, 0F, -1.5F, 5, 8, 5);
        this.CLegFL1.setPos(4F, 10F, 0F);
        setRotation(this.CLegFL1, -0.2617994F, 0F, 0F);

        this.CLegFL2 = new ModelRenderer(this, 46, 35);
        this.CLegFL2.addBox(-2F, 0F, -1.2F, 4, 6, 4);
        this.CLegFL2.setPos(4F, 17F, -2F);
        setRotation(this.CLegFL2, -0.3490659F, 0F, 0.2617994F);

        this.CLegFL3 = new ModelRenderer(this, 46, 45);
        this.CLegFL3.addBox(-2F, 0F, -3F, 4, 2, 5);
        this.CLegFL3.setPos(2.5F, 22F, -4F);
        setRotation(this.CLegFL3, 0F, 0.1745329F, 0F);

        this.CLegFR1 = new ModelRenderer(this, 4, 22);
        this.CLegFR1.addBox(-2.5F, 0F, -1.5F, 5, 8, 5);
        this.CLegFR1.setPos(-4F, 10F, 0F);
        setRotation(this.CLegFR1, -0.2617994F, 0F, 0F);

        this.CLegFR2 = new ModelRenderer(this, 2, 35);
        this.CLegFR2.addBox(-2F, 0F, -1.2F, 4, 6, 4);
        this.CLegFR2.setPos(-4F, 17F, -2F);
        setRotation(this.CLegFR2, -0.3490659F, 0F, -0.2617994F);

        this.CLegFR3 = new ModelRenderer(this, 0, 45);
        this.CLegFR3.addBox(-2F, 0F, -3F, 4, 2, 5);
        this.CLegFR3.setPos(-2.5F, 22F, -4F);
        setRotation(this.CLegFR3, 0F, -0.1745329F, 0F);

        this.CLegRL1 = new ModelRenderer(this, 34, 83);
        this.CLegRL1.addBox(-1.5F, 0F, -2.5F, 4, 8, 6);
        this.CLegRL1.setPos(3F, 21F, 5F);
        setRotation(this.CLegRL1, -1.396263F, -0.3490659F, 0.3490659F);

        this.CLegRL2 = new ModelRenderer(this, 41, 97);
        this.CLegRL2.addBox(-2F, 0F, -2F, 4, 6, 4);
        this.CLegRL2.setPos(5.2F, 22.5F, -1F);
        setRotation(this.CLegRL2, -1.570796F, 0F, 0.3490659F);

        this.CLegRL3 = new ModelRenderer(this, 44, 107);
        this.CLegRL3.addBox(-2F, 0F, -3F, 4, 2, 5);
        this.CLegRL3.setPos(5.5F, 22F, -6F);
        setRotation(this.CLegRL3, -1.375609F, 0F, 0.3490659F);

        this.CLegRR1 = new ModelRenderer(this, 10, 83);
        this.CLegRR1.addBox(-2.5F, 0F, -2.5F, 4, 8, 6);
        this.CLegRR1.setPos(-3F, 21F, 5F);
        setRotation(this.CLegRR1, -1.396263F, 0.3490659F, -0.3490659F);

        this.CLegRR2 = new ModelRenderer(this, 7, 97);
        this.CLegRR2.addBox(-2F, 0F, -2F, 4, 6, 4);
        this.CLegRR2.setPos(-5.2F, 22.5F, -1F);
        setRotation(this.CLegRR2, -1.570796F, 0F, -0.3490659F);

        this.CLegRR3 = new ModelRenderer(this, 2, 107);
        this.CLegRR3.addBox(-2F, 0F, -3F, 4, 2, 5);
        this.CLegRR3.setPos(-5.5F, 22F, -6F);
        setRotation(this.CLegRR3, -1.375609F, 0F, -0.3490659F);
        
        Saddle = new ModelRenderer(this, 36, 114);
        Saddle.addBox(-4F, -0.5F, -3F, 8, 2, 6, 0F);
        Saddle.setPos(0F, 4F, -2F);
        
        SaddleBack = new ModelRenderer(this, 20, 108);
        SaddleBack.addBox(-4F, -0.2F, 2.9F, 8, 2, 4, 0F);
        SaddleBack.setPos(0F, 4F, -2F);
        SaddleBack.xRot = 0.10088F;
        
        SaddleFront = new ModelRenderer(this, 36, 122);
        SaddleFront.addBox(-2.5F, -1F, -3F, 5, 2, 3, 0F);
        SaddleFront.setPos(0F, 4F, -2F);
        SaddleFront.xRot = -0.1850049F;
        
        Bag = new ModelRenderer(this, 0, 114);
        Bag.addBox(-5F, -3F, -2.5F, 10, 2, 5, 0F);
        Bag.setPos(0F, 7F, 7F);
        Bag.xRot = -0.4363323F;
        
        BagSitted = new ModelRenderer(this, 0, 114);
        BagSitted.addBox(-5F, -3F, -2.5F, 10, 2, 5, 0F);
        BagSitted.setPos(0F, 17F, 8F);
        BagSitted.xRot = -1.570796F;
        
        SaddleSitted = new ModelRenderer(this, 36, 114);
        SaddleSitted.addBox(-4F, -0.5F, -3F, 8, 2, 6, 0F);
        SaddleSitted.setPos(0F, 7.5F, 6.5F);
        SaddleSitted.xRot = -0.9686577F;
        
        SaddleBackSitted = new ModelRenderer(this, 20, 108);
        SaddleBackSitted.addBox(-4F, -0.3F, 2.9F, 8, 2, 4, 0F);
        SaddleBackSitted.setPos(0F, 7.5F, 6.5F);
        SaddleBackSitted.xRot = -0.9162979F;

        SaddleFrontSitted = new ModelRenderer(this, 36, 122);
        SaddleFrontSitted.addBox(-2.5F, -1F, -3F, 5, 2, 3, 0F);
        SaddleFrontSitted.setPos(0F, 7.5F, 6.5F);
        SaddleFrontSitted.xRot = -1.151917F;
    }

    @Override
    public void setupAnim(T entity, float v, float v1, float v2, float v3, float v4) {
        MoCEntityBear entitybear = (MoCEntityBear) entity;
        this.bearstate = entitybear.getBearState();
        this.openMouth = (entitybear.mouthCounter != 0);
        this.attackSwing = entitybear.getAttackSwing();
        setRotationAngles(v, v1, v2, v3, v4);
        this.chested = entitybear.getIsChested();
        this.saddled = entitybear.getIsRideable();

    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {

        if (bearstate == 0) { //in fours
            if (openMouth) {
                this.MouthOpen.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            } else {
                this.Mouth.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            }
            if (saddled)
            {
                Saddle.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                SaddleBack.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                SaddleFront.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            }
            if (chested)
            {
                Bag.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            }
            this.LegFR1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.Neck.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.LEar.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.Snout.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.Head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.REar.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.Abdomen.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.Torso.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.LegRR3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.LegRR1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.LegRR2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.LegFR2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.LegFR3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.LegFL1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.LegFL3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.LegFL2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.LegRL1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.LegRL2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.LegRL3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.Tail.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        } else if (bearstate == 1) {
            this.BHead.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BSnout.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            if (openMouth) {
                this.BMouthOpen.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            } else {
                this.BMouth.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            }

            this.BNeck.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BLEar.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BREar.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BTorso.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BAbdomen.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BTail.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BLegFL1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BLegFL2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BLegFL3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BLegFR1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BLegFR2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BLegFR3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BLegRL1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BLegRL2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BLegRL3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BLegRR1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BLegRR2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.BLegRR3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        } else if (bearstate == 2) { //sited
            if (openMouth) {
                this.CMouthOpen.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            } else {
                this.CMouth.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            }
            if (saddled)
            {
                SaddleSitted.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                SaddleBackSitted.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
                SaddleFrontSitted.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            }
            if (chested)
            {
                BagSitted.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            }
            this.CHead.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CSnout.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CLEar.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CREar.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CNeck.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CTorso.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CAbdomen.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CTail.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CLegFL1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CLegFL2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CLegFL3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CLegFR1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CLegFR2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CLegFR3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CLegRL1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CLegRL2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CLegRL3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CLegRR1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CLegRR2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
            this.CLegRR3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        }

//        this.Tail.rotateAngleZ = LLegRotX * 0.2F;
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4) {
        float LLegRotX = MathHelper.cos(f * 0.6662F) * 0.8F * f1;
        float RLegRotX = MathHelper.cos((f * 0.6662F) + 3.141593F) * 0.8F * f1;
        float XAngle = (f4 / 57.29578F);
        float YAngle = f3 / 57.29578F;

        if (this.bearstate == 0) {
            this.Head.xRot = 0.1502636F + XAngle;
            this.Head.yRot = YAngle;

            this.Snout.xRot = 0.1502636F + XAngle;
            this.Snout.yRot = YAngle;

            this.Mouth.xRot = -0.0068161F + XAngle;
            this.Mouth.yRot = YAngle;

            this.MouthOpen.xRot = 0.534236F + XAngle;
            this.MouthOpen.yRot = YAngle;

            this.LEar.xRot = 0.1502636F + XAngle;
            this.LEar.yRot = -0.3490659F + YAngle;

            this.REar.xRot = 0.1502636F + XAngle;
            this.REar.yRot = 0.3490659F + YAngle;

            this.LegFL1.xRot = 0.2617994F + LLegRotX;
            this.LegFL2.xRot = LLegRotX;
            this.LegFL3.xRot = LLegRotX;

            this.LegRR1.xRot = -0.1745329F + LLegRotX;
            this.LegRR2.xRot = LLegRotX;
            this.LegRR3.xRot = LLegRotX;

            this.LegFR1.xRot = 0.2617994F + RLegRotX;
            this.LegFR2.xRot = RLegRotX;
            this.LegFR3.xRot = RLegRotX;

            this.LegRL1.xRot = -0.1745329F + RLegRotX;
            this.LegRL2.xRot = RLegRotX;
            this.LegRL3.xRot = RLegRotX;
        } else if (this.bearstate == 1) {

            this.BHead.xRot = -0.0242694F - XAngle;
            this.BHead.yRot = YAngle;

            this.BSnout.xRot = -0.0242694F - XAngle;
            this.BSnout.yRot = YAngle;

            this.BMouth.xRot = -0.08726F - XAngle;
            this.BMouth.yRot = YAngle;

            this.BMouthOpen.xRot = 0.5235988F - XAngle;
            this.BMouthOpen.yRot = YAngle;

            this.BLEar.xRot = -0.0242694F - XAngle;
            this.BLEar.yRot = -0.3490659F + YAngle;

            this.BREar.xRot = -0.0242694F - XAngle;
            this.BREar.yRot = 0.3490659F + YAngle;

            /**
             * Arm breathing movement
             */
            float breathing = MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
            this.BLegFR1.zRot = 0.2617994F + breathing;
            this.BLegFR2.zRot = breathing;
            this.BLegFR3.zRot = breathing;
            this.BLegFL1.zRot = -0.2617994F - breathing;
            this.BLegFL2.zRot = -breathing;
            this.BLegFL3.zRot = -breathing;

            this.BLegFL1.xRot = 0.2617994F + attackSwing;
            this.BLegFL2.xRot = -0.5576792F + attackSwing;
            this.BLegFL3.xRot = 2.007645F + attackSwing;

            this.BLegFR1.xRot = 0.2617994F + attackSwing;
            this.BLegFR2.xRot = -0.5576792F + attackSwing;
            this.BLegFR3.xRot = 2.007645F + attackSwing;

            this.BLegRR1.xRot = -0.1745329F + LLegRotX;
            this.BLegRR2.xRot = LLegRotX;
            this.BLegRR3.xRot = LLegRotX;

            this.BLegRL1.xRot = -0.5235988F + RLegRotX;
            this.BLegRL2.xRot = RLegRotX;
            this.BLegRL3.xRot = RLegRotX;
        } else if (this.bearstate == 2) {
            this.CHead.xRot = 0.1502636F + XAngle;
            this.CHead.yRot = YAngle;

            this.CSnout.xRot = 0.1502636F + XAngle;
            this.CSnout.yRot = YAngle;

            this.CMouth.xRot = -0.0068161F + XAngle;
            this.CMouth.yRot = YAngle;

            this.CMouthOpen.xRot = 0.3665191F + XAngle;
            this.CMouthOpen.yRot = YAngle;

            this.CLEar.xRot = 0.1502636F + XAngle;
            this.CLEar.yRot = -0.3490659F + YAngle;

            this.CREar.xRot = 0.1502636F + XAngle;
            this.CREar.yRot = 0.3490659F + YAngle;
        }
    }
}
