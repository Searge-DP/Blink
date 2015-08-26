package com.ewyboy.blink.Items;

import com.ewyboy.blink.Items.NBTHandlers.NBTHandler;
import com.ewyboy.blink.Utillity.StringMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import scala.tools.cmd.gen.AnyVals;

public class BaseEnderPoweredItem extends BaseItem {

    public static final String NBTNAME = "blink-fuel";

    public boolean canUse(EntityPlayer player) {
        InventoryPlayer inventory = player.inventory;
        ItemStack[] items = player.inventory.mainInventory;

        for (ItemStack itemstack : items) {
            if (itemstack != null) {
                if (itemstack.getItem() instanceof ItemEnderCapsule) {
                    if (NBTHandler.canRemove(itemstack)) {
                        return true;
                    }
                }
            }
        }
        player.addChatComponentMessage(new ChatComponentText(StringMap.warn + "not enough MB of " + StringMap.EnderFluid));
        return false;
    }

    public void use(EntityPlayer player) {
        InventoryPlayer inventory = player.inventory;
        ItemStack[] items = inventory.mainInventory;

        for (int i = 0; i < items.length; i++) {
            ItemStack itemstack = items[i];
            if (itemstack != null) {
                if (itemstack.getItem() instanceof ItemEnderCapsule) {
                    if (NBTHandler.canRemove(itemstack)) {
                        NBTHandler.remove(itemstack);
                        inventory.setInventorySlotContents(i,itemstack);
                        return;
                    }
                }
            }
        }
    }
}
