package com.ewyboy.blink.Rendering.Models.Items;

import com.ewyboy.blink.Utillity.Logger;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class RodOfAgesModel extends ModelBase {

    public ModelRenderer MainRod;
    public ModelRenderer TopHat;
    public ModelRenderer HatPipe01;
    public ModelRenderer HatPipe02;
    public ModelRenderer HatPipe03;
    public ModelRenderer HatPipe04;
    public ModelRenderer HatBottom;
    public ModelRenderer HatUp;
    public ModelRenderer HatDown;
    public ModelRenderer RodEndHat;
    public ModelRenderer Core01;
    public ModelRenderer Core02;

    public RodOfAgesModel() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.HatBottom = new ModelRenderer(this, 15, 0);
        this.HatBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HatBottom.addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3, 0.0F);
        this.Core02 = new ModelRenderer(this, 5, 10);
        this.Core02.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.Core02.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.HatUp = new ModelRenderer(this, 5, 0);
        this.HatUp.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.HatUp.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2, 0.0F);
        this.Core01 = new ModelRenderer(this, 5, 10);
        this.Core01.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.Core01.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.RodEndHat = new ModelRenderer(this, 5, 0);
        this.RodEndHat.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.RodEndHat.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2, 0.0F);
        this.HatPipe01 = new ModelRenderer(this, 0, 0);
        this.HatPipe01.setRotationPoint(0.0F, -2.0F, 2.0F);
        this.HatPipe01.addBox(-0.5F, -3.0F, -0.5F, 1, 6, 1, 0.0F);
        this.HatPipe03 = new ModelRenderer(this, 0, 0);
        this.HatPipe03.setRotationPoint(-2.0F, -3.0F, 0.0F);
        this.HatPipe03.addBox(-0.5F, -2.0F, -0.5F, 1, 6, 1, 0.0F);
        this.MainRod = new ModelRenderer(this, 28, 0);
        this.MainRod.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.MainRod.addBox(-0.5F, -12.0F, -0.5F, 1, 24, 1, 0.0F);
        this.HatDown = new ModelRenderer(this, 5, 0);
        this.HatDown.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.HatDown.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2, 0.0F);
        this.HatPipe04 = new ModelRenderer(this, 0, 0);
        this.HatPipe04.setRotationPoint(2.0F, -2.0F, 0.0F);
        this.HatPipe04.addBox(-0.5F, -3.0F, -0.5F, 1, 6, 1, 0.0F);
        this.HatPipe02 = new ModelRenderer(this, 0, 0);
        this.HatPipe02.setRotationPoint(0.0F, -2.0F, -2.0F);
        this.HatPipe02.addBox(-0.5F, -3.0F, -0.5F, 1, 6, 1, 0.0F);
        this.TopHat = new ModelRenderer(this, 15, 0);
        this.TopHat.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.TopHat.addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.HatBottom.render(f5);
        //this.Core02.render(f5);
        this.HatUp.render(f5);
        //this.Core01.render(f5);
        this.RodEndHat.render(f5);
        this.HatPipe01.render(f5);
        this.HatPipe03.render(f5);
        this.MainRod.render(f5);
        this.HatDown.render(f5);
        this.HatPipe04.render(f5);
        this.HatPipe02.render(f5);
        this.TopHat.render(f5);

        rotate01+=0.5f;
        rotate02-=0.5f;

        setRotateAngle(this.Core01,rotate01,rotate01,rotate01);
        setRotateAngle(this.Core02,rotate02,rotate02,rotate02);
    }

    private float rotate01 = 0.0f, rotate02 = 0.0f;

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
