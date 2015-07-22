package com.ewyboy.blink.Items;

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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class ItemLauncher extends Item {

    public ItemLauncher() {
        super();
        setCreativeTab(CreativeTabLoader.BlinkItemTab);
    }

    private void spawnEffectsForClock(World world, EntityPlayer player, double x, double y, double z) {

        world.spawnParticle("portal", player.posX + Math.random(), player.posY -0.5 + Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 + Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY -0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY -0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY -0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX + Math.random(), player.posY -0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX + Math.random(), player.posY -0.5 + Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 + Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY -0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY -0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY -0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX + Math.random(), player.posY -0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX + Math.random(), player.posY -0.5 + Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 + Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY -0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY -0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY -0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX + Math.random(), player.posY -0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY -0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());


        world.spawnParticle("portal", player.posX + Math.random(), player.posY +0.5 + Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 + Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY +0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY +0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY +0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX + Math.random(), player.posY +0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX + Math.random(), player.posY +0.5 + Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 + Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY +0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY +0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY +0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX + Math.random(), player.posY +0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX + Math.random(), player.posY +0.5 + Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 + Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY +0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY +0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX + Math.random(), player.posY +0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());

        world.spawnParticle("portal", player.posX + Math.random(), player.posY +0.5 - Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 + Math.random(), player.posZ - Math.random(), Math.random(), Math.random(), Math.random());
        world.spawnParticle("portal", player.posX - Math.random(), player.posY +0.5 - Math.random(), player.posZ + Math.random(), Math.random(), Math.random(), Math.random());

        world.playSound(x + 0.5D, y + 0.5D, z + 0.5D, "mob.endermen.portal", 0.5F, 0.4F + 0.8F, false);
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hit) {

        double leap = 0.175;

        int test = MathHelper.floor_double((double) ((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;

        if (world.isRemote) {
            Item equipped = player.getCurrentEquippedItem() != null ? player.getCurrentEquippedItem().getItem() : null;
            if (equipped instanceof ItemLauncher){
                ItemLauncher itemLauncher = (ItemLauncher) equipped;
                if(itemLauncher.getStaffTypeID(player.getHeldItem()) == 1){
                    if(player.isSprinting() == true) {
                        if (test == 1) {
                            player.addVelocity(-1.5 * leap, 0,0);
                        }
                        if (test == 3) {
                            player.addVelocity(1.5 * leap, 0,0);
                        }
                        if (test == 2) {
                            player.addVelocity(0,0,-1.5 * leap);
                        }
                        if (test == 0) {
                            player.addVelocity(0,0,1.5 * leap);
                        }
                    }else{
                        if (test == 1) {
                            player.addVelocity(-1* leap, 0,0);
                        }
                        if (test == 3) {
                            player.addVelocity(leap, 0,0);
                        }
                        if (test == 2) {
                            player.addVelocity(0,0,-1*leap);
                        }
                        if (test == 0) {
                            player.addVelocity(0,0,leap);
                        }
                    }
                    player.jump();
                    spawnEffectsForClock(world,player,x,y,z);
                }
                if(itemLauncher.getStaffTypeID(player.getHeldItem()) == 2){
                    player.jump();
                    spawnEffectsForClock(world,player,x,y,z);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public int ModeDeactivated = 0;
    public int ModeVertical = 1;
    public int ModeHorizontal = 2;

    public String getStaffType(ItemStack item) {
        if(item.getTagCompound() == null){
            item.setTagCompound(new NBTTagCompound());
        }
        return item.getTagCompound().getString("staffType");
    }

    public int getStaffTypeID(ItemStack item) {
        if(item.getTagCompound() == null){
            item.setTagCompound(new NBTTagCompound());
        }
        return item.getTagCompound().getInteger("staffTypeID");
    }

    public void setStaffType(String type, ItemStack item){
        if(item.getTagCompound() == null){
            item.setTagCompound(new NBTTagCompound());
        }
        item.getTagCompound().setString("staffType", type);
    }

    private void setStaffTypeID(int type, ItemStack item) {
        if(item.getTagCompound() == null){
            item.setTagCompound(new NBTTagCompound());
        }
        item.getTagCompound().setInteger("staffTypeID", type);
        this.setDamage(item, type);
    }

    private void playSoundEffect(World world, EntityPlayer player) {
        world.playSound(player.posX, player.posY, player.posZ, "mob.endermen.portal", 0.5F, 0.4F + 0.8F, false);
    }

    public void changeStaff(World world, EntityPlayer player, ItemStack item) {
        if(getStaffTypeID(item) == 0) {
            setStaffType("§2§nVertical Mode", item);
            setStaffTypeID(ModeVertical, item);
            playSoundEffect(world, player);
        } else if (getStaffTypeID(item) == 1) {
            setStaffType("§3§nHorizontal Mode", item);
            setStaffTypeID(ModeHorizontal, item);
            playSoundEffect(world, player);

        }else if (getStaffTypeID(item) == 2) {
            setStaffType("§7§nDeactivated", item);
            setStaffTypeID(ModeDeactivated, item);
            playSoundEffect(world, player);

        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        if (item == null) {
        } else
        if (player.isSneaking() == true) {
            changeStaff(world, player, item);
        }
        return item;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation)
    {
        info.add("Press shift to show info");

        if (ClientProxy.shiftPressed()) {
            info.add("Launches you up in the air");
            info.add("Scales on the players jump-height");
        }
    }

    @SideOnly(Side.CLIENT)
    private IIcon OffTaker0Icons;
    private IIcon OffTaker1Icons;
    private IIcon OffTaker2Icons;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        OffTaker0Icons = register.registerIcon(TexturePath.TextureLocation + ":" + StringMap.ItemLauncher + 0);
        OffTaker1Icons = register.registerIcon(TexturePath.TextureLocation + ":" + StringMap.ItemLauncher + 1);
        OffTaker2Icons = register.registerIcon(TexturePath.TextureLocation + ":" + StringMap.ItemLauncher + 2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int idk) {

        if(idk == ModeVertical) {
            return OffTaker1Icons;
        } else if (idk == ModeHorizontal) {
            return OffTaker2Icons;
        }
        return OffTaker0Icons;
    }
}
