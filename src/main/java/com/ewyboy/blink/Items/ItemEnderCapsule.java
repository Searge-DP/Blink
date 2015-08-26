package com.ewyboy.blink.Items;

import com.ewyboy.blink.Items.NBTHandlers.NBTHandler;
import com.ewyboy.blink.Networking.ClientProxy;
import com.ewyboy.blink.Textures.TexturePath;
import com.ewyboy.blink.Utillity.StringMap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class ItemEnderCapsule extends BaseItem {

    public ItemEnderCapsule() {
        setMaxDamage(10);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation) {
        if (ClientProxy.shiftPressed()) {
            info.add(NBTHandler.getNBTValue(itemstack) +" MB of " + StringMap.EnderFluid);
        } else {
            info.add("Press shift to show info");
        }
    }

    @Override
    public void onCreated(ItemStack item, World world, EntityPlayer player) {
        item = NBTHandler.create(item);
        super.onCreated(item,world,player);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    private IIcon EnderCapsuleIcons;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        EnderCapsuleIcons = register.registerIcon(TexturePath.TextureLocation + ":" + StringMap.ItemEnderCapsule);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger(BaseEnderPoweredItem.NBTNAME , 1000);
        return NBTHandler.updateAndChange(itemStack, nbt);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage (int dmg) {
        return EnderCapsuleIcons;
    }
}

