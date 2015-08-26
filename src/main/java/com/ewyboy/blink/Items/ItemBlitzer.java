package com.ewyboy.blink.Items;

import com.ewyboy.blink.Networking.ClientProxy;
import com.ewyboy.blink.Textures.TexturePath;
import com.ewyboy.blink.Utillity.Config;
import com.ewyboy.blink.Utillity.Logger;
import com.ewyboy.blink.Utillity.ParticleEngine;
import com.ewyboy.blink.Utillity.StringMap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class ItemBlitzer extends BaseItem {

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation) {
        if (ClientProxy.shiftPressed()) {
            info.add("Teleport trough 1 block thick walls");
            info.add("Sneak to go down");
            info.add("Jump to go up");
            info.add("Sprinting to go trough 2 block thick walls");
        } else {
            info.add("Press shift to show info");
        }
    }

    private boolean canPlayerFitInTarget(EntityPlayer player,World world, double x, double y, double z) {
        if (world.isAirBlock((int)x,(int)y,(int)z) && world.isAirBlock((int)x,(int)y+1,(int)z)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        double posX = player.posX, posY = player.posY, posZ = player.posZ;
        int dir = MathHelper.floor_double((double) ((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if (Config.debugMode) {Logger.info("Side: " + side);}
        double blink = 1.75;

        if(!world.isRemote) {
            if (side==2 || side==3 || side==4 || side==5) {
                if (dir==0) {
                    if (!player.isSprinting()) {
                        posZ = posZ + blink;
                    } else {
                        posZ = posZ + blink * 2;
                    }
                }
                if (dir==1) {
                    if (!player.isSprinting()) {
                        posX = posX - blink;
                    } else {
                        posX = posX - blink * 2;
                    }
                }
                if (dir==2) {
                    if (!player.isSprinting()) {
                        posZ = posZ - blink;
                    } else {
                        posZ = posZ - blink * 2;
                    }
                }
                if (dir==3) {
                    if (!player.isSprinting()) {
                        posX = posX + blink;
                    } else {
                        posX = posX + blink * 2;
                    }
                }
            } else if (side==1) {
                posY = posY - blink * 2;
            } else if (side==0) {
                posY = posY + blink * 2;
            }
            float max = 0.875f, min = 0.325f;
            player.setPositionAndUpdate(posX, posY, posZ);
            float pitch = (float) Math.random() * (max - min) + min;
            world.playSoundAtEntity(player, "mob.endermen.portal", 1.0f, pitch);
            ParticleEngine.spawnBlinkParticle((int)posX,(int)posY,(int)posZ, world);
        }
        return false;
    }

    @SideOnly(Side.CLIENT)
    private IIcon BlitzerIcons;
    private IIcon BlitzerActiveIcons;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        BlitzerIcons = register.registerIcon(TexturePath.TextureLocation + ":" + StringMap.ItemBlitzer);
        BlitzerActiveIcons = register.registerIcon(TexturePath.TextureLocation + ":" + StringMap.ItemBlitzer + "Animation");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage (int dmg) {
        return BlitzerActiveIcons;
    }
}
