package com.ewyboy.blink.Rendering.Renders.Blocks;

import com.ewyboy.blink.Rendering.Models.Blocks.SwapperModel;
import com.ewyboy.blink.Utillity.StringMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class SwapperRenderer extends TileEntitySpecialRenderer {

    private final SwapperModel model;

    public SwapperRenderer() {
        this.model = new SwapperModel();
    }

    @Override
    public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float scale) {
        GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(StringMap.ID + ":" + "textures/models/SwapperTexture.png"));
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 242, 242);
            GL11.glPushMatrix();
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
                this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
