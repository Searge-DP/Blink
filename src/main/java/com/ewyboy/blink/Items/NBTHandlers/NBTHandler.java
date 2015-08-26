package com.ewyboy.blink.Items.NBTHandlers;

import com.ewyboy.blink.Items.BaseEnderPoweredItem;
import com.ewyboy.blink.Utillity.Logger;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public  class NBTHandler {
    public static boolean hasNBT(ItemStack i) {
        NBTTagCompound nbt = i.getTagCompound();
        return nbt != null ? true : false;
    }

    public static Integer getNBTValue(ItemStack i) {
        NBTTagCompound nbt;
        if (hasNBT(i))
            nbt = i.getTagCompound();
        else
            nbt = new NBTTagCompound();

        Integer fuel = nbt.getInteger(BaseEnderPoweredItem.NBTNAME);
        return fuel;
    }


    public static  boolean canAdd(ItemStack itemStack) {
        Integer MAX = 2000;
        NBTTagCompound nbt;
        if (hasNBT(itemStack))
            nbt = itemStack.getTagCompound();
        else
            nbt = new NBTTagCompound();

        Integer fuel = getNBTValue(itemStack);
        if (fuel != null)
            if (fuel < MAX)
                return true;

        return false;
    }

    public static ItemStack add(ItemStack itemStack) {
        if (itemStack != null) {
            if (canAdd(itemStack)) {
                NBTTagCompound nbt;
                if (hasNBT(itemStack))
                    nbt = itemStack.getTagCompound();
                else
                    nbt = new NBTTagCompound();

                Integer fuel = nbt.getInteger(BaseEnderPoweredItem.NBTNAME);
                if (fuel != null) {
                    fuel++;
                    nbt.setInteger(BaseEnderPoweredItem.NBTNAME, fuel);
                    return updateAndChange(itemStack, nbt);
                }
            }
        }
        return itemStack;
    }

    public static boolean canRemove(ItemStack itemStack) {
        Integer MIN = 0;
        NBTTagCompound nbt;
        if (hasNBT(itemStack))
            nbt = itemStack.getTagCompound();
        else
            nbt = new NBTTagCompound();

        Integer fuel = getNBTValue(itemStack);
        System.out.println(">>> Fuel: " + fuel);
        if (fuel != null)
            if (fuel > MIN)
                return true;

        return false;
    }

    public static ItemStack remove(ItemStack itemStack) {
        if (itemStack != null) {
            if (canRemove(itemStack)) {
                NBTTagCompound nbt;
                if (hasNBT(itemStack))
                    nbt = itemStack.getTagCompound();
                else
                    nbt = new NBTTagCompound();

                Integer fuel = nbt.getInteger(BaseEnderPoweredItem.NBTNAME);
                if (fuel != null) {
                    fuel-=50;
                    nbt.setInteger(BaseEnderPoweredItem.NBTNAME, fuel);
                    System.out.println(">>> Remove");
                    return updateAndChange(itemStack, nbt);
                }
            }
        }
        return itemStack;
    }

    //Create the basic nbt
    public static ItemStack create(ItemStack itemStack) {
        NBTTagCompound nbt;
        if (hasNBT(itemStack))
            nbt = itemStack.getTagCompound();
        else
            nbt = new NBTTagCompound();
        //FIXME use config and edit
        nbt.setInteger(BaseEnderPoweredItem.NBTNAME, 2000);
        return updateAndChange(itemStack, nbt);
    }

    public static ItemStack updateAndChange(ItemStack item, NBTTagCompound nbt) {
        item.setTagCompound(nbt);
        return item;
    }
}
