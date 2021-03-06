package drzhark.mocreatures.client.model;

import com.google.common.collect.ImmutableList;
import drzhark.mocreatures.entity.passive.MoCEntityDeer;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MoCModelDeer<T extends MoCEntityDeer> extends AgeableModel<T> {

    public MoCModelDeer() {
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-1.5F, -6F, -9.5F, 3, 3, 6, 0.0F);
        this.Head.setPos(1.0F, 11.5F, -4.5F);
        this.Neck = new ModelRenderer(this, 0, 9);
        this.Neck.addBox(-2F, -2F, -6F, 4, 4, 6, 0.0F);
        this.Neck.setPos(1.0F, 11.5F, -4.5F);
        this.Neck.xRot = -0.7853981F;
        this.LEar = new ModelRenderer(this, 0, 0);
        this.LEar.addBox(-4F, -7.5F, -5F, 2, 3, 1, 0.0F);
        this.LEar.setPos(1.0F, 11.5F, -4.5F);
        this.LEar.zRot = 0.7853981F;
        this.REar = new ModelRenderer(this, 0, 0);
        this.REar.addBox(2.0F, -7.5F, -5F, 2, 3, 1, 0.0F);
        this.REar.setPos(1.0F, 11.5F, -4.5F);
        this.REar.zRot = -0.7853981F;
        this.LeftAntler = new ModelRenderer(this, 54, 0);
        this.LeftAntler.addBox(0.0F, -14F, -7F, 1, 8, 4, 0.0F);
        this.LeftAntler.setPos(1.0F, 11.5F, -4.5F);
        this.LeftAntler.zRot = 0.2094395F;
        this.RightAntler = new ModelRenderer(this, 54, 0);
        this.RightAntler.addBox(0.0F, -14F, -7F, 1, 8, 4, 0.0F);
        this.RightAntler.setPos(1.0F, 11.5F, -4.5F);
        this.RightAntler.zRot = -0.2094395F;
        this.Body = new ModelRenderer(this, 24, 12);
        this.Body.addBox(-2F, -3F, -6F, 6, 6, 14, 0.0F);
        this.Body.setPos(0.0F, 13F, 0.0F);
        this.Leg1 = new ModelRenderer(this, 9, 20);
        this.Leg1.addBox(-1F, 0.0F, -1F, 2, 8, 2, 0.0F);
        this.Leg1.setPos(3F, 16F, -4F);
        this.Leg2 = new ModelRenderer(this, 0, 20);
        this.Leg2.addBox(-1F, 0.0F, -1F, 2, 8, 2, 0.0F);
        this.Leg2.setPos(-1F, 16F, -4F);
        this.Leg3 = new ModelRenderer(this, 9, 20);
        this.Leg3.addBox(-1F, 0.0F, -1F, 2, 8, 2, 0.0F);
        this.Leg3.setPos(3F, 16F, 6F);
        this.Leg4 = new ModelRenderer(this, 0, 20);
        this.Leg4.addBox(-1F, 0.0F, -1F, 2, 8, 2, 0.0F);
        this.Leg4.setPos(-1F, 16F, 6F);
        this.Tail = new ModelRenderer(this, 50, 20);
        this.Tail.addBox(-1.5F, -1F, 0.0F, 3, 2, 4, 0.0F);
        this.Tail.setPos(1.0F, 11F, 7F);
        this.Tail.xRot = 0.7854F;
    }

    @Override
    protected Iterable<ModelRenderer> headParts() {
        return ImmutableList.of(this.Head);
    }

    @Override
    protected Iterable<ModelRenderer> bodyParts() {
        return ImmutableList.of(this.Body, this.Neck, this.Leg1, this.Leg2, this.Leg3, this.Leg4,
                this.Tail, this.LEar, this. REar, this.LeftAntler, this.RightAntler);
    }

    @Override
    public void setupAnim(T t, float limbSwing, float limbSwingAmount, float time, float headPitch, float headYaw) {
        setRotationAngles(limbSwing, limbSwingAmount);
    }

    public void setRotationAngles(float f, float f1) {
        this.Leg1.xRot = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.Leg2.xRot = MathHelper.cos((f * 0.6662F) + 3.141593F) * 1.4F * f1;
        this.Leg3.xRot = MathHelper.cos((f * 0.6662F) + 3.141593F) * 1.4F * f1;
        this.Leg4.xRot = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    }

    public ModelRenderer Body;
    public ModelRenderer Neck;
    public ModelRenderer Head;
    public ModelRenderer Leg1;
    public ModelRenderer Leg2;
    public ModelRenderer Leg3;
    public ModelRenderer Leg4;
    public ModelRenderer Tail;
    public ModelRenderer LEar;
    public ModelRenderer REar;
    public ModelRenderer LeftAntler;
    public ModelRenderer RightAntler;

}
