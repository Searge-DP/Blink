package com.ewyboy.blink.Rendering.Models.Items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class BlitzerModel extends ModelBase {

    public ModelRenderer barrel1;
    public ModelRenderer barrel2;
    public ModelRenderer barrel3;
    public ModelRenderer barrel4;
    public ModelRenderer barrel5;
    public ModelRenderer barrel6;
    public ModelRenderer barrel7;
    public ModelRenderer barrel8;
    public ModelRenderer barrel9;

    public ModelRenderer shape10;
    public ModelRenderer shape11;
    public ModelRenderer shape12;
    public ModelRenderer shape13;
    public ModelRenderer shape14;
    public ModelRenderer shape15;

    public ModelRenderer shape16;
    public ModelRenderer shape17;
    public ModelRenderer shape18;

    public BlitzerModel() {
        this.textureWidth = 32;
        this.textureHeight = 32;

        this.barrel7 = new ModelRenderer(this, 0, 0);
        this.barrel7.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.barrel7.addBox(-1.5F, -0.5F, -3.0F, 3, 1, 6, 0.0F);
        this.setRotateAngle(barrel7, 0.0F, 0.0F, 1.5707963267948966F);

        this.shape18 = new ModelRenderer(this, 25, 14);
        this.shape18.setRotationPoint(0.0F, 20.0F, -3.5F);
        this.shape18.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape18, 0.7853981633974483F, 0.0F, 0.0F);

        this.shape10 = new ModelRenderer(this, 0, 28);
        this.shape10.setRotationPoint(0.0F, 20.0F, 3.5F);
        this.shape10.addBox(-2.0F, -1.5F, -0.5F, 4, 3, 1, 0.0F);
        this.barrel5 = new ModelRenderer(this, 0, 0);
        this.barrel5.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.barrel5.addBox(-1.5F, -0.5F, -3.0F, 3, 1, 6, 0.0F);
        this.setRotateAngle(barrel5, 0.0F, 0.0F, 2.748893571891069F);

        this.barrel8 = new ModelRenderer(this, 0, 0);
        this.barrel8.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.barrel8.addBox(-1.5F, -0.5F, -3.0F, 3, 1, 6, 0.0F);
        this.setRotateAngle(barrel8, 0.0F, 0.0F, 1.9634954084936207F);

        this.shape13 = new ModelRenderer(this, 7, 28);
        this.shape13.setRotationPoint(1.0F, 20.0F, 4.0F);
        this.shape13.addBox(0.0F, -1.0F, 0.0F, 1, 2, 2, 0.0F);
        this.barrel1 = new ModelRenderer(this, 0, 0);
        this.barrel1.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.barrel1.addBox(-1.5F, -0.5F, -3.0F, 3, 1, 6, 0.0F);
        this.setRotateAngle(barrel1, 0.0F, 0.0F, 0.7853981633974483F);

        this.barrel4 = new ModelRenderer(this, 0, 0);
        this.barrel4.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.barrel4.addBox(-1.5F, -0.5F, -3.0F, 3, 1, 6, 0.0F);
        this.shape11 = new ModelRenderer(this, 6, 28);
        this.shape11.setRotationPoint(-2.0F, 20.0F, 4.0F);
        this.shape11.addBox(0.0F, -1.0F, 0.0F, 1, 2, 2, 0.0F);
        this.barrel3 = new ModelRenderer(this, 0, 0);
        this.barrel3.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.barrel3.addBox(-1.5F, -0.5F, -3.0F, 3, 1, 6, 0.0F);
        this.setRotateAngle(barrel3, 0.0F, 0.0F, 1.1780972450961724F);

        this.shape14 = new ModelRenderer(this, 29, 24);
        this.shape14.setRotationPoint(0.0F, 18.0F, 3.0F);
        this.shape14.addBox(-0.5F, -0.5F, 0.25F, 1, 1, 0, 0.0F);
        this.barrel6 = new ModelRenderer(this, 0, 0);
        this.barrel6.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.barrel6.addBox(-1.5F, -0.5F, -3.0F, 3, 1, 6, 0.0F);
        this.shape17 = new ModelRenderer(this, 25, 14);
        this.shape17.setRotationPoint(0.0F, 20.0F, -3.5F);
        this.shape17.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape17, 0.7853981633974483F, 0.0F, 1.5707963267948966F);

        this.barrel9 = new ModelRenderer(this, 0, 0);
        this.barrel9.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.barrel9.addBox(-1.5F, -0.5F, -3.0F, 3, 1, 6, 0.0F);
        this.setRotateAngle(barrel9, 0.0F, 0.0F, 2.356194490192345F);

        this.shape12 = new ModelRenderer(this, 17, 24);
        this.shape12.setRotationPoint(1.0F, 20.0F, 6.0F);
        this.shape12.addBox(-3.0F, -0.5F, 0.0F, 4, 1, 1, 0.0F);
        this.shape15 = new ModelRenderer(this, 9, 25);
        this.shape15.setRotationPoint(0.0F, 20.0F, -3.0F);
        this.shape15.addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
        this.shape16 = new ModelRenderer(this, 14, 27);
        this.shape16.setRotationPoint(0.0F, 20.0F, -3.0F);
        this.shape16.addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(shape16, 0.0F, 0.0F, 0.7853981633974483F);

        this.barrel2 = new ModelRenderer(this, 0, 0);
        this.barrel2.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.barrel2.addBox(-1.5F, -0.5F, -3.0F, 3, 1, 6, 0.0F);
        this.setRotateAngle(barrel2, 0.0F, 0.0F, 0.39269908169872414F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {


        this.barrel1.render(f5);
        this.barrel2.render(f5);
        this.barrel3.render(f5);
        this.barrel4.render(f5);
        this.barrel5.render(f5);
        this.barrel6.render(f5);
        this.barrel7.render(f5);
        this.barrel8.render(f5);
        this.barrel9.render(f5);

        this.shape10.render(f5);
        this.shape11.render(f5);
        this.shape12.render(f5);
        this.shape13.render(f5);
        this.shape15.render(f5);
        this.shape16.render(f5);
        this.shape17.render(f5);
        this.shape18.render(f5);

        rotate01+=0.005f;
        rotate02-=0.005f;

        setRotateAngle(this.shape15,0,0,rotate01);
        setRotateAngle(this.shape16,0,0,rotate02);
        setRotateAngle(this.shape17,0,0,rotate02);
        setRotateAngle(this.shape18,0,0,rotate01);

        /*setRotateAngle(this.barrel1,0,0,rotate01);
        setRotateAngle(this.barrel2,0,0,rotate01);
        setRotateAngle(this.barrel3,0,0,rotate02);
        setRotateAngle(this.barrel4,0,0,rotate01);
        setRotateAngle(this.barrel5,0,0,rotate02);
        setRotateAngle(this.barrel6,0,0,rotate01);
        setRotateAngle(this.barrel7,0,0,rotate02);
        setRotateAngle(this.barrel8,0,0,rotate01);
        setRotateAngle(this.barrel9,0,0,rotate02);*/

        GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
            this.shape14.render(f5);
        GL11.glDisable(GL11.GL_BLEND);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    private float rotate01 = 0.0f, rotate02 = 0.0f;

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
