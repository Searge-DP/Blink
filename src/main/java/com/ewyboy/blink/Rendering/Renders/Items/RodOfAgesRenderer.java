package com.ewyboy.blink.Rendering.Renders.Items;

import com.ewyboy.blink.Networking.ClientProxy;
import com.ewyboy.blink.Rendering.Models.Items.RodOfAgesModel;
import com.ewyboy.blink.Utillity.Logger;
import com.ewyboy.blink.Utillity.StringMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RodOfAgesRenderer implements IItemRenderer {

    protected RodOfAgesModel model;

    public RodOfAgesRenderer() {
        model = new RodOfAgesModel();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        if(type==type.EQUIPPED) {
            return true;
        } else if (type == type.EQUIPPED_FIRST_PERSON) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return helper != ItemRendererHelper.ENTITY_BOBBING && helper != ItemRendererHelper.ENTITY_ROTATION;
    }

    private float rotate = 0.0f;

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        ItemStack enderEye = new ItemStack(Items.ender_eye, 1, 0);
        EntityItem entity = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D, enderEye);

        if (type.equals(type.EQUIPPED_FIRST_PERSON)) {
            GL11.glPushMatrix();
            entity.hoverStart = -1.0F;
            RenderItem.renderInFrame = true;
            GL11.glScalef(1.0f,1.0f,1.0f);
            if(ClientProxy.shiftPressed()) {
                GL11.glTranslatef(-0.4f,2.375f,-0.4f);
            } else {
                GL11.glTranslatef(0.35f,2.25f,0.4f);
            }
            rotate+=0.1f;
            if (rotate>1) {rotate=-1;}
            GL11.glRotatef(180, rotate, 0, 1);
            GL11.glColor3f(0.0F,1.0F,0.0F);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 242, 242);
            RenderManager.instance.renderEntityWithPosYaw(entity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            RenderItem.renderInFrame = false;
            GL11.glPopMatrix();
        } else if (type.equals(type.EQUIPPED)) {
            //Render Third Person later when time
        }

        GL11.glPushMatrix();
        if(type.equals(type.EQUIPPED)) {
            GL11.glScalef(-2.5f,-2.5f,2.5f);
            GL11.glTranslatef(-0.15f,-0.45f,0.0f);
            GL11.glRotatef(-90.0f,-1.0f,1.0f,0.0f);
        } else if (type.equals(type.EQUIPPED_FIRST_PERSON)) {
            GL11.glScalef(-2.0f,-2.0f,2.0f);
            if(ClientProxy.shiftPressed()) {
                GL11.glRotatef(180.0f,0.0f,1.0f,0.0f);
            } else {
                GL11.glRotatef(15.0f,0.0f,0.0f,0.0f);
            }
            GL11.glTranslatef(-0.2f,-1.0f,0.2f);
        } else {

        }
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(StringMap.ID + ":" + "textures/models/RodOfAgesTexture.png"));
        this.model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }
}
