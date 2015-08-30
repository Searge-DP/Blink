package com.ewyboy.blink.Rendering.Models.Blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class SwapperModel extends ModelBase {
    public ModelRenderer Main;
    public ModelRenderer Bottom;
    public ModelRenderer TopSide1;
    public ModelRenderer TopSide2;
    public ModelRenderer Top1;
    public ModelRenderer Top2;
    public ModelRenderer Top3;
    public ModelRenderer Top4;
    public ModelRenderer Bot1;
    public ModelRenderer Bot2;
    public ModelRenderer TopSide3;
    public ModelRenderer TopSide4;
    public ModelRenderer Bot3;
    public ModelRenderer Bot4;
    public ModelRenderer Plate1;
    public ModelRenderer Plate2;
    public ModelRenderer Plate3;
    public ModelRenderer Plate4;
    public ModelRenderer Plate5;
    public ModelRenderer Plate6;
    public ModelRenderer Plate7;
    public ModelRenderer Plate8;

    public SwapperModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Top1 = new ModelRenderer(this, 0, 32);
        this.Top1.setRotationPoint(-6.5F, 8.5F, 0.0F);
        this.Top1.addBox(-1.5F, -0.5F, -8.0F, 3, 1, 16, 0.0F);
        this.setRotateAngle(Top1, 0.0F, 0.0F, 0.008901179185171082F);
        this.Plate8 = new ModelRenderer(this, 52, 53);
        this.Plate8.setRotationPoint(4.5F, 16.0F, -7.5F);
        this.Plate8.addBox(-2.5F, -5.0F, -0.5F, 5, 10, 1, 0.0F);
        this.Plate7 = new ModelRenderer(this, 52, 53);
        this.Plate7.setRotationPoint(4.5F, 16.0F, 7.5F);
        this.Plate7.addBox(-2.5F, -5.0F, -0.5F, 5, 10, 1, 0.0F);
        this.Bot4 = new ModelRenderer(this, 0, 46);
        this.Bot4.setRotationPoint(0.0F, 22.0F, -7.5F);
        this.Bot4.addBox(-7.0F, -1.0F, -0.5F, 14, 2, 1, 0.0F);
        this.Plate4 = new ModelRenderer(this, 52, 49);
        this.Plate4.setRotationPoint(7.5F, 16.0F, -4.5F);
        this.Plate4.addBox(-0.5F, -5.0F, -2.5F, 1, 10, 5, 0.0F);
        this.Main = new ModelRenderer(this, 0, 0);
        this.Main.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.Main.addBox(-7.0F, -7.0F, -7.0F, 14, 14, 14, 0.0F);
        this.Plate1 = new ModelRenderer(this, 52, 49);
        this.Plate1.setRotationPoint(7.5F, 16.0F, 4.5F);
        this.Plate1.addBox(-0.5F, -5.0F, -2.5F, 1, 10, 5, 0.0F);
        this.TopSide4 = new ModelRenderer(this, 0, 46);
        this.TopSide4.setRotationPoint(0.0F, 10.0F, -7.5F);
        this.TopSide4.addBox(-7.0F, -1.0F, -0.5F, 14, 2, 1, 0.0F);
        this.Top2 = new ModelRenderer(this, 0, 32);
        this.Top2.setRotationPoint(6.5F, 8.5F, 0.0F);
        this.Top2.addBox(-1.5F, -0.5F, -8.0F, 3, 1, 16, 0.0F);
        this.setRotateAngle(Top2, 0.0F, 0.0F, 0.008901179185171082F);
        this.TopSide2 = new ModelRenderer(this, 0, 31);
        this.TopSide2.setRotationPoint(7.5F, 10.0F, 0.0F);
        this.TopSide2.addBox(-0.5F, -1.0F, -8.0F, 1, 2, 16, 0.0F);
        this.Top3 = new ModelRenderer(this, 25, 45);
        this.Top3.setRotationPoint(0.0F, 8.5F, -6.5F);
        this.Top3.addBox(-5.0F, -0.5F, -1.5F, 10, 1, 3, 0.0F);
        this.TopSide1 = new ModelRenderer(this, 0, 31);
        this.TopSide1.setRotationPoint(-7.5F, 10.0F, 0.0F);
        this.TopSide1.addBox(-0.5F, -1.0F, -8.0F, 1, 2, 16, 0.0F);
        this.Top4 = new ModelRenderer(this, 25, 45);
        this.Top4.setRotationPoint(0.0F, 8.5F, 6.5F);
        this.Top4.addBox(-5.0F, -0.5F, -1.5F, 10, 1, 3, 0.0F);
        this.TopSide3 = new ModelRenderer(this, 0, 46);
        this.TopSide3.setRotationPoint(0.0F, 10.0F, 7.5F);
        this.TopSide3.addBox(-7.0F, -1.0F, -0.5F, 14, 2, 1, 0.0F);
        this.Bottom = new ModelRenderer(this, 0, 32);
        this.Bottom.setRotationPoint(0.0F, 23.5F, 0.0F);
        this.Bottom.addBox(-8.0F, -0.5F, -8.0F, 16, 1, 16, 0.0F);
        this.Plate5 = new ModelRenderer(this, 52, 53);
        this.Plate5.setRotationPoint(-4.5F, 16.0F, -7.5F);
        this.Plate5.addBox(-2.5F, -5.0F, -0.5F, 5, 10, 1, 0.0F);
        this.Bot2 = new ModelRenderer(this, 0, 32);
        this.Bot2.setRotationPoint(7.5F, 22.0F, 0.0F);
        this.Bot2.addBox(-0.5F, -1.0F, -8.0F, 1, 2, 16, 0.0F);
        this.Plate2 = new ModelRenderer(this, 52, 49);
        this.Plate2.setRotationPoint(-7.5F, 16.0F, 4.5F);
        this.Plate2.addBox(-0.5F, -5.0F, -2.5F, 1, 10, 5, 0.0F);
        this.Plate3 = new ModelRenderer(this, 52, 49);
        this.Plate3.setRotationPoint(-7.5F, 16.0F, -4.5F);
        this.Plate3.addBox(-0.5F, -5.0F, -2.5F, 1, 10, 5, 0.0F);
        this.Bot1 = new ModelRenderer(this, 0, 31);
        this.Bot1.setRotationPoint(-7.5F, 22.0F, 0.0F);
        this.Bot1.addBox(-0.5F, -1.0F, -8.0F, 1, 2, 16, 0.0F);
        this.Plate6 = new ModelRenderer(this, 52, 53);
        this.Plate6.setRotationPoint(-4.5F, 16.0F, 7.5F);
        this.Plate6.addBox(-2.5F, -5.0F, -0.5F, 5, 10, 1, 0.0F);
        this.Bot3 = new ModelRenderer(this, 0, 46);
        this.Bot3.setRotationPoint(0.0F, 22.0F, 7.5F);
        this.Bot3.addBox(-7.0F, -1.0F, -0.5F, 14, 2, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Top1.render(f5);
        this.Plate8.render(f5);
        this.Plate7.render(f5);
        this.Bot4.render(f5);
        this.Plate4.render(f5);
        this.Plate1.render(f5);
        this.TopSide4.render(f5);
        this.Top2.render(f5);
        this.TopSide2.render(f5);
        this.Top3.render(f5);
        this.TopSide1.render(f5);
        this.Top4.render(f5);
        this.TopSide3.render(f5);
        this.Bottom.render(f5);
        this.Plate5.render(f5);
        this.Bot2.render(f5);
        this.Plate2.render(f5);
        this.Plate3.render(f5);
        this.Bot1.render(f5);
        this.Plate6.render(f5);
        this.Bot3.render(f5);

        GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 242, 242);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.Main.render(f5);
        GL11.glDisable(GL11.GL_BLEND);
    }
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
