package com.ewyboy.blink.Items;

import com.ewyboy.blink.Loaders.BlockLoader;
import com.ewyboy.blink.Loaders.CreativeTabLoader;
import com.ewyboy.blink.Networking.ClientProxy;
import com.ewyboy.blink.Textures.TexturePath;
import com.ewyboy.blink.Utillity.StringMap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class ItemRodOfAges extends Item {

    public ItemRodOfAges() {
        super();
        setMaxStackSize(1);
        setCreativeTab(CreativeTabLoader.BlinkItemTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hit) {
        if (player.isSneaking() == true) {
            if (world.isAirBlock(x, y+1 ,z) && (world.isAirBlock(x, y+2 ,z))) {
                world.setBlock(x, y + 1 , z , BlockLoader.Marker);
            }
            if (world.getBlock(x, y, z) == BlockLoader.Marker) {
                world.setBlockToAir(x,y+1,z);
            }
        }
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation) {
        if (ClientProxy.shiftPressed()) {
            info.add("Work in progress");
        } else {
            info.add("Shift to show info");
        }
    }

    @SideOnly(Side.CLIENT)
    private IIcon RodIcons;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        RodIcons = register.registerIcon(TexturePath.TextureLocation + ":" + StringMap.ItemRodOfAges);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage (int dmg) {
        return RodIcons;
    }

}
