package com.ewyboy.blink.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class BaseEnderPoweredItem extends BaseItem{

	public static final String NBTNAME = "blink-fuel";

	public boolean canUse(EntityPlayer player){
		InventoryPlayer inventory = player.inventory;
		ItemStack[] items = player.inventory.mainInventory;
		
		for(ItemStack itemstack : items){
			if(itemstack.getItem() instanceof ItemEnderCapsule){
				Item i = itemstack.getItem();
			}
		}
		return false;
	}


	public void use(EntityPlayer player ){

	}

}

class NBTHandler{
	public boolean hasNBT(ItemStack i){
		NBTTagCompound nbt = i.getTagCompound();
		return nbt != null ? true : false;
	}

	public Integer getNBTValue(ItemStack i){

		NBTTagCompound nbt;
		if(hasNBT(i))
			nbt = i.getTagCompound();
		else
			nbt = new NBTTagCompound();

		Integer fuel = nbt.getInteger(BaseEnderPoweredItem.NBTNAME);
		return fuel != null ? fuel : null;
	}

	public ItemStack add(ItemStack itemStack){
		//RETURN
		return null;
	}

	public boolean canRemove(ItemStack itemStack){
		//RETURN
		return false;
	}

	public ItemStack remove(ItemStack itemStack){
		//RETURN
		return null;
	}

}