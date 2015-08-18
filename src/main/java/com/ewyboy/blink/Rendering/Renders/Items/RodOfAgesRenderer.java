package com.ewyboy.blink.Rendering.Renders.Items;

import com.ewyboy.blink.Rendering.Models.Items.RodOfAgesModel;
import com.ewyboy.blink.Utillity.StringMap;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

import java.lang.reflect.Type;

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

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
        if(type==type.EQUIPPED) {
            GL11.glScalef(-2.0f,-2.0f,2.0f);
            GL11.glTranslatef(0.0f,-1.0f,0.0f);
        } else if (type == type.EQUIPPED_FIRST_PERSON) {
            GL11.glScalef(-2.0f,-2.0f,2.0f);
            GL11.glTranslatef(0.0f,-1.0f,0.0f);
        } else {

        }
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(StringMap.ID + ":" + "textures/models/RodOfAgesTexture.png"));
        this.model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }
}
