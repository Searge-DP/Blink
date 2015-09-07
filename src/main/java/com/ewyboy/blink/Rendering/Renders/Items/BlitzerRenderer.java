package com.ewyboy.blink.Rendering.Renders.Items;

import com.ewyboy.blink.Rendering.Models.Items.BlitzerModel;
import com.ewyboy.blink.Utillity.StringMap;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class BlitzerRenderer implements IItemRenderer {

    protected BlitzerModel model;

    public BlitzerRenderer() {
        model = new BlitzerModel();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        if(type.equals(type.EQUIPPED)) {
            return true;
        } else if (type.equals(type.EQUIPPED_FIRST_PERSON)) {
            return true;
        } else if (type.equals(type.INVENTORY)){
            return true;
        } else if (type.equals(type.ENTITY)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return helper != ItemRendererHelper.ENTITY_BOBBING && helper != ItemRendererHelper.ENTITY_ROTATION;
        //return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
            if(type.equals(type.EQUIPPED)) {
                GL11.glScaled(3.5f, 3.5f, 3.5f);
                GL11.glTranslatef(-0.125f, 1.425f, 0.25f);
                GL11.glRotatef(180.0f, 1.0f, 0.0f, 1.0f);
            } else if (type.equals(type.EQUIPPED_FIRST_PERSON)) {
                GL11.glScaled(2.5f, 2.5f, 2.5f);
                GL11.glTranslatef(0.0f, 1.625f, 0.0f);
                GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
            } else if (type.equals(type.INVENTORY)){
                GL11.glScaled(2.25f, 2.25f, 2.25f);
                GL11.glTranslatef(0.0f, 1.25f, -0.125f);
                GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
            } else if (type.equals(type.ENTITY)) {
                GL11.glScaled(2.5f, 2.5f, 2.5f);
                GL11.glTranslatef(0.0f, 1.5f, 0.0f);
                GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
            }
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(StringMap.ID + ":" + "textures/models/BlitzerTexture.png"));
            this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }
}
