package com.ewyboy.blink.Blocks;

import com.ewyboy.blink.ParticleEngine;
import com.ewyboy.blink.Textures.TexturePath;
import com.ewyboy.blink.Utillity.Logger;
import com.ewyboy.blink.Utillity.StringMap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.Random;

public class BlockSwapper extends BaseBlock {

    /**@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            FMLNetworkHandler.openGui(player, Blink.instance, 0, world, x, y, z);
        }
        return true;
    }*/

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        ArrayList<String> test = new ArrayList<String>();
        Random random = new Random();

        if(!world.isRemote) {
            if(world.isBlockIndirectlyGettingPowered(x, y, z)) {
                if     (world.getBlock(x - 2, y, z) == this){ test.add(posToString(x - 2, y, z));}
                else if(world.getBlock(x + 2, y, z) == this){ test.add(posToString       (x+2, y, z));}
                else if(world.getBlock(x, y, z - 2) == this){ test.add(posToString       (x, y, z-2));}
                else if(world.getBlock(x, y, z + 2) == this){ test.add(posToString       (x, y, z+2));}

                else if(world.getBlock(x + 2, y, z + 2) == this){ test.add(posToString   (x+2, y, z+2));}
                else if(world.getBlock(x - 2, y, z + 2) == this){  test.add(posToString  (x-2, y, z+2));}
                else if(world.getBlock(x + 2, y, z - 2) == this){  test.add(posToString  (x+2, y, z-2));}
                else if(world.getBlock(x - 2, y, z - 2) == this){  test.add(posToString  (x-2, y, z-2));}

                else if(world.getBlock(x,y,z) == this) { test.add(posToString(x,y,z));}

                int selection = random.nextInt(test.size());
                String posString = test.get(selection);
                String[] POS = posString.split(" ");
                String X = POS[0], Y = POS[1], Z = POS[2];
                int iX = Integer.parseInt(X), iY = Integer.parseInt(Y), iZ = Integer.parseInt(Z);

                Block block1 = world.getBlock(x,y+1,z);
                Block block2 = world.getBlock(iX,iY+1,iZ);

                world.setBlock(x,y+1,z,block2);
                world.setBlock(iX,iY+1,iZ,block1);

                for (int i = 0; i<5000; i++) {
                    ParticleEngine.spawnParticleAtBlock("portal",world, x,y+1,z,1.0D,1.0D,1.0D);
                    ParticleEngine.spawnParticleAtBlock("portal",world, iX,iY+1,iZ,3.0D,3.0D,3.0D);
                }
                ParticleEngine.playSound("mob.endermen.portal", world, player, x, y, z, 0.5F, 3.0F);
            }
        }
        return true;
    }

    @Override
    public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side) {
        if(side != -1) {
            return true;
        }
        return false;
    }


    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int par2, int par3, int par4) {
        float f = 0.05F;
        return AxisAlignedBB.getBoundingBox((double) par2, (double) par3, (double) par4, (double) (par2 + 1), (double) ((float) (par3 + 1) - f), (double) (par4 + 1));
    }

    public String posToString(int x, int y, int z) {
        return x + " " + y + " " + z;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if(entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;

            ArrayList<String> test = new ArrayList<String>();
            Random random = new Random();

            if (player.isSneaking() == true) {
                if (!world.isRemote) {
                    if     (world.getBlock(x - 2, y, z) == this){ test.add(posToString       (x-2, y, z));}
                    else if(world.getBlock(x + 2, y, z) == this){ test.add(posToString       (x+2, y, z));}
                    else if(world.getBlock(x, y, z - 2) == this){ test.add(posToString       (x, y, z-2));}
                    else if(world.getBlock(x, y, z + 2) == this){ test.add(posToString       (x, y, z+2));}

                    else if(world.getBlock(x + 2, y, z + 2) == this){ test.add(posToString   (x+2, y, z+2));}
                    else if(world.getBlock(x - 2, y, z + 2) == this){  test.add(posToString  (x-2, y, z+2));}
                    else if(world.getBlock(x + 2, y, z - 2) == this){  test.add(posToString  (x+2, y, z-2));}
                    else if(world.getBlock(x - 2, y, z - 2) == this){  test.add(posToString  (x-2, y, z-2));}

                    else if(world.getBlock(x,y,z) == this) { test.add(posToString(x,y,z));}

                    int selection = random.nextInt(test.size());
                    String posString = test.get(selection);
                    String[] POS = posString.split(" ");
                    String X = POS[0], Y = POS[1], Z = POS[2];
                    int iX = Integer.parseInt(X), iY = Integer.parseInt(Y), iZ = Integer.parseInt(Z);
                    player.setPositionAndUpdate(iX + 0.5, iY + 1.5, iZ + 0.5);
                }
                for(int i = 0; i < 5000; i++) {
                    double fx = 3D;
                    ParticleEngine.spawnParticleAtPlayer("portal",world, player,x + 0.5,y,z + 0.5, fx,-1,0);
                    ParticleEngine.spawnParticleAtPlayer("portal",world, player,x + 0.5,y,z + 0.5, 0,-1,fx);
                    ParticleEngine.spawnParticleAtPlayer("portal",world, player,x + 0.5,y,z + 0.5, -fx,-1,0);
                    ParticleEngine.spawnParticleAtPlayer("portal",world, player,x + 0.5,y,z + 0.5, 0,-1,-fx);
                    ParticleEngine.spawnParticleAtPlayer("portal",world, player,x + 0.5,y,z + 0.5, 0,-1,-fx);
                    ParticleEngine.spawnParticleAtPlayer("portal",world, player,x + 0.5,y,z + 0.5, fx,-1,-fx);
                    ParticleEngine.spawnParticleAtPlayer("portal",world, player,x + 0.5,y,z + 0.5, -fx,-1,fx);
                    ParticleEngine.spawnParticleAtPlayer("portal",world, player,x + 0.5,y,z + 0.5, -fx,-1,-fx);
                    ParticleEngine.spawnParticleAtPlayer("portal",world, player,x + 0.5,y,z + 0.5, fx,-1,fx);
                }
                ParticleEngine.playSound("mob.endermen.portal", world, player, x, y, z, 0.5F, 3.0F);
            }
        }

        if(entity instanceof EntityItem) {

            ArrayList<String> test = new ArrayList<String>();
            Random random = new Random();

            if     (world.getBlock(x - 2, y, z) == this){ test.add(posToString(x-3, y, z));}
            else if(world.getBlock(x + 2, y, z) == this){ test.add(posToString(x+3, y, z));}
            else if(world.getBlock(x, y, z - 2) == this){ test.add(posToString(x, y, z-3));}
            else if(world.getBlock(x, y, z + 2) == this){ test.add(posToString(x, y, z+3));}

            else if(world.getBlock(x + 2, y, z + 2) == this){  test.add(posToString(x+3, y, z+3));}
            else if(world.getBlock(x - 2, y, z + 2) == this){  test.add(posToString(x-3, y, z+3));}
            else if(world.getBlock(x + 2, y, z - 2) == this){  test.add(posToString(x+3, y, z-3));}
            else if(world.getBlock(x - 2, y, z - 2) == this){  test.add(posToString(x-3, y, z-3));}

            else if(world.getBlock(x,y,z) == this) { test.add(posToString(x,y,z));}

            int selection = random.nextInt(test.size());
            String posString = test.get(selection);
            String[] POS = posString.split(" ");
            String X = POS[0], Y = POS[1], Z = POS[2];
            int iX = Integer.parseInt(X), iY = Integer.parseInt(Y), iZ = Integer.parseInt(Z);
            entity.setPosition(iX + 0.5, iY + 1.5, iZ + 0.5);
            ParticleEngine.playSound("mob.endermen.portal",world, (EntityItem) entity, x,y,z, 1.0F, 1.0F);

            for (int i = 0; i < 1000; i++) {
                double fx = 3;
                ParticleEngine.spawnParticleAtEntity("portal",world, (EntityItem) entity,x + 0.5,y,z + 0.5, fx,-1,0);
                ParticleEngine.spawnParticleAtEntity("portal",world, (EntityItem) entity,x + 0.5,y,z + 0.5, 0,-1,fx);
                ParticleEngine.spawnParticleAtEntity("portal",world, (EntityItem) entity,x + 0.5,y,z + 0.5, -fx,-1,0);
                ParticleEngine.spawnParticleAtEntity("portal",world, (EntityItem) entity,x + 0.5,y,z + 0.5, 0,-1,-fx);
                ParticleEngine.spawnParticleAtEntity("portal",world, (EntityItem) entity,x + 0.5,y,z + 0.5, 0,-1,-fx);
                ParticleEngine.spawnParticleAtEntity("portal",world, (EntityItem) entity,x + 0.5,y,z + 0.5, fx,-1,-fx);
                ParticleEngine.spawnParticleAtEntity("portal",world, (EntityItem) entity,x + 0.5,y,z + 0.5, -fx,-1,fx);
                ParticleEngine.spawnParticleAtEntity("portal",world, (EntityItem) entity,x + 0.5,y,z + 0.5, -fx,-1,-fx);
                ParticleEngine.spawnParticleAtEntity("portal",world, (EntityItem) entity,x + 0.5,y,z + 0.5, fx,-1,fx);
            }
        }
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @SideOnly(Side.CLIENT)
    private IIcon TopIcon;

    @SideOnly(Side.CLIENT)
    private IIcon SidesIcon;

    @SideOnly(Side.CLIENT)
    private IIcon BotIcon;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        TopIcon = register.registerIcon(TexturePath.TextureLocation + ":" + StringMap.BlockSwapper + "Top");
        SidesIcon = register.registerIcon(TexturePath.TextureLocation + ":" +  StringMap.BlockSwapper + "Sides");
        BotIcon = register.registerIcon(TexturePath.TextureLocation + ":" +  StringMap.BlockSwapper + "Bot");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side == 1) {
            return TopIcon;
        }
        else if (side == 0) {
            return BotIcon;
        }
        return SidesIcon;
    }
}
