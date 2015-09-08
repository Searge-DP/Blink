package com.ewyboy.blink.Items;

import com.ewyboy.blink.Files.Config;
import com.ewyboy.blink.Loaders.BlockLoader;
import com.ewyboy.blink.Networking.ClientProxy;
import com.ewyboy.blink.Utillity.Logger;
import com.ewyboy.blink.Engines.ParticleEngine;
import com.ewyboy.blink.Engines.SoundEngine;
import com.ewyboy.blink.Utillity.StringMap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;

public class ItemRodOfAges extends BaseEnderPoweredItem {

    public ItemRodOfAges() {
        setFull3D();
    }

    public String[] toolInfo = {};

    public static HashMap<EntityPlayer, Boolean> hasMarker = new HashMap<EntityPlayer, Boolean>();

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation) {
        if (ClientProxy.shiftPressed()) {
            for (String i : toolInfo) {
                info.add(i);
            }
            int x = 0, y = 0, z = 0, dim = 0;
            if (hasNBTSaved(itemstack)) {
                NBTTagCompound nbt = itemstack.getTagCompound();
                x = nbt.getInteger("posX");
                y = nbt.getInteger("posY");
                z = nbt.getInteger("posZ");
                dim = nbt.getInteger("dim");
            }
            String dimName;
            if (dim == 0) {
                dimName = EnumChatFormatting.GREEN + "Overworld";
            } else if (dim == -1) {
                dimName = EnumChatFormatting.RED + "Nether";
            } else if (dim == 1) {
                dimName = EnumChatFormatting.DARK_PURPLE + "End";
            } else {
                dimName = String.valueOf(dim);
            }

            if (x != 0 && y != 0 && z != 0) {
                info.add("Target:" +
                    " X: " + EnumChatFormatting.AQUA + x + EnumChatFormatting.WHITE +
                    " Y: " + EnumChatFormatting.AQUA + y + EnumChatFormatting.WHITE +
                    " Z: " + EnumChatFormatting.AQUA + z + EnumChatFormatting.WHITE +
                    " Dimension: " + dimName);
                }
            } else {
                info.add("Press shift to show info.");
            }
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return false;
    }

    @Override
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (player.isSneaking()) {
            if (world.getBlock(x, y + 1, z) == Blocks.air && world.getBlock(x, y + 2, z) == Blocks.air && side == 1) {
                world.setBlock(x, y + 1, z, BlockLoader.Marker);
                SoundEngine.playSoundAtEntity(SoundEngine.dingSound, world, player, 0.01f, 1.0f);
                ParticleEngine.spawnHelixEffect(world, x, y + 1, z, ParticleEngine.effectPortal, 1);
            }
        }
        if (!world.isRemote) {
            //creates nbt
            NBTTagCompound nbt;
            //checks if the item has nbt, if so set nbt to item's nbt. ELSE make a new nbt
            if (hasNBTSaved(item)) {
                nbt = item.getTagCompound();
            } else {
                nbt = new NBTTagCompound();
            }
            if (player.isSneaking() && side == 1) {
                ItemStack i = setPos(item, x, y + 1, z, player.dimension);
                player.setItemInUse(i, i.getMaxDamage());
            }
        }
        return false;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        int range = Config.rodOfAgesRange;
        boolean isPlayerInRange;
        if (!world.isRemote)
            if (!player.isSneaking()) {
                if (hasNBTSaved(item)) {
                    //if (canUse(player)) {
                        int x, y, z, dim;
                        NBTTagCompound nbt = item.getTagCompound();
                        //sets pos vars from nbt;
                        x = nbt.getInteger("posX");
                        y = nbt.getInteger("posY");
                        z = nbt.getInteger("posZ");
                        dim = nbt.getInteger("dim");

                        if (range == (-1) || Minecraft.getMinecraft().playerController.isInCreativeMode()) {
                            isPlayerInRange = true;
                        } else if ((player.posX - x) <= (range) &&
                                (player.posX - x) >= (-range) &&
                                (player.posY - y) <= (range) &&
                                (player.posY - y) >= (-range) &&
                                (player.posZ - z) <= (range) &&
                                (player.posZ - z) >= (-range)) {
                            isPlayerInRange = true;
                        } else {
                            isPlayerInRange = false;
                        }
                        if (Config.debugMode) {
                            Logger.info(isPlayerInRange);
                            Logger.info("X:" + (player.posX - x) + " Y:" + (player.posY - y) + " Z:" + (player.posZ - z));
                        }
                        if (isPlayerInRange && player.dimension == dim && world.getBlock(x,y,z) == BlockLoader.Marker) {
                            player.fallDistance = 0;
                            player.setPositionAndUpdate(x + 0.5, y + 0.05, z + 0.5);
                            SoundEngine.playSoundAtEntity(SoundEngine.teleportSound, world, player, 0.01f, 0.2f);
                            //use(player);
                        }
                        if (!isPlayerInRange && player.dimension == dim) {
                            player.addChatComponentMessage(new ChatComponentText(StringMap.warn + "You are to far away"));
                        }
                        if (world.getBlock(x,y,z) != BlockLoader.Marker && player.dimension == dim) {
                            player.addChatComponentMessage(new ChatComponentText(StringMap.warn + "Marker not found"));
                        }
                        if (player.dimension != dim) {
                            player.addChatComponentMessage(new ChatComponentText(StringMap.warn + "You are not in the same dimension as target"));
                        }
                    }
                }
            //}
        return super.onItemRightClick(item, world, player);
    }

    public static ItemStack setPos(ItemStack item, int x, int y, int z, int dim) {
        //creates nbt
        NBTTagCompound nbt;
        //checks if the item has nbt, if so set nbt to item's nbt. ELSE make a new nbt
        if (hasNBTSaved(item)) {
            nbt = item.getTagCompound();
        } else {
            nbt = new NBTTagCompound();
        }
        //sets the int with key to value
        nbt.setInteger("posX", x);
        nbt.setInteger("posY", y);
        nbt.setInteger("posZ", z);
        nbt.setInteger("dim", dim);
        item.setTagCompound(nbt);

        return item;
    }

    public static boolean hasNBTSaved(ItemStack item) {
        return item.getTagCompound() != null ? true : false;
    }
}