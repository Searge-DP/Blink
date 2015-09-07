package com.ewyboy.blink.Rendering.Renders.Blocks;

import com.ewyboy.blink.Rendering.Models.Blocks.SwapperModel;
import com.ewyboy.blink.Utillity.StringMap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class SwapperRenderer extends TileEntitySpecialRenderer implements IItemRenderer {

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

    //Set the lighting stuff, so it changes it's brightness properly.
    public static void adjustLightFixture(World world, int x, int y, int z, Block block) {
        Tessellator tess = Tessellator.instance;
        float brightness = block.getLightValue(world, x, y, z);
        int skyLight = world.getLightBrightnessForSkyBlocks(x, y, z, 0);
        int modulousModifier = skyLight % 65536;
        int divModifier = skyLight / 65536;
        tess.setColorOpaque_F(brightness, brightness, brightness);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) modulousModifier, divModifier);
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
        GL11.glScalef(1.0f,1.0f,1.0f);
        if(type.equals(type.EQUIPPED)) {
            GL11.glRotatef(180,0f,0f,0f);
            GL11.glTranslatef(-1.0f,-0.65f,-1.0f);
        }else if (type.equals(type.INVENTORY)) {
            GL11.glRotatef(180,1f,0f,1f);
            GL11.glTranslatef(0.5f,-1.425f,0.5f);
        } else {
            GL11.glRotatef(180,1f,0f,1f);
            GL11.glTranslatef(0.5f,-1.5f,0.5f);
        }
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(StringMap.ID + ":" + "textures/models/SwapperTexture.png"));
        this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }
}
