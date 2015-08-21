package com.ewyboy.blink.Blocks;

import com.ewyboy.blink.Utillity.Config;
import com.ewyboy.blink.Utillity.Logger;
import com.ewyboy.blink.Utillity.ParticleEngine;
import com.ewyboy.blink.TileEntities.TileEntitySwapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class BlockSwapper extends BaseBlock implements ITileEntityProvider {

    private int defaultFlag = 3;
    int fx = 3;

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        ArrayList<String> test = new ArrayList<String>();
        Random random = new Random();

        if(!world.isRemote) {
            if(world.isBlockIndirectlyGettingPowered(x, y, z)) {
                for(int i = 2; i<5; i++) {
                    if     (world.getBlock(x-i, y, z) == this){ test.add(posToString(x-i, y, z));}
                    else if(world.getBlock(x+i, y, z) == this){ test.add(posToString(x+i, y, z));}
                    else if(world.getBlock(x, y, z-i) == this){ test.add(posToString(x, y, z-i));}
                    else if(world.getBlock(x, y, z+i) == this){ test.add(posToString(x, y, z+i));}

                    else if(world.getBlock(x+i, y, z+i) == this){ test.add(posToString(x+i, y, z+i));}
                    else if(world.getBlock(x-i, y, z+i) == this){ test.add(posToString(x-i, y, z+i));}
                    else if(world.getBlock(x+i, y, z-i) == this){ test.add(posToString(x+i, y, z-i));}
                    else if(world.getBlock(x-i, y, z-i) == this){ test.add(posToString(x-i, y, z-i));}

                    else if(world.getBlock(x,y,z) == this) { test.add(posToString(x,y,z));}
                }

                int selection = random.nextInt(test.size());
                String posString = test.get(selection);
                String[] POS = posString.split(" ");
                String X = POS[0], Y = POS[1], Z = POS[2];
                int iX = Integer.parseInt(X), iY = Integer.parseInt(Y), iZ = Integer.parseInt(Z);

                Block block1 = world.getBlock(x,y+1,z);
                int block1meta = world.getBlockMetadata(x,y+1,z);
                Block block2 = world.getBlock(iX,iY+1,iZ);
                int block2meta = world.getBlockMetadata(iX,iY+1,iZ);

                world.setBlock(x,y+1,z,block2, block2meta, defaultFlag);
                world.setBlock(iX,iY+1,iZ,block1, block1meta, defaultFlag);
            }
        }
        ParticleEngine.playSound("mob.endermen.portal", world, player, x, y, z, 0.5F, 3.0F);
        for (int i = 0; i<1000; i++) {
            ParticleEngine.spawnParticleAtBlock("portal",world, x,y+1,z,fx,fx,0);
            ParticleEngine.spawnParticleAtBlock("portal",world, x,y+1,z,0,fx,fx);
            ParticleEngine.spawnParticleAtBlock("portal",world, x,y+1,z,-fx,fx,0);
            ParticleEngine.spawnParticleAtBlock("portal",world, x,y+1,z,0,fx,-fx);
            ParticleEngine.spawnParticleAtBlock("portal",world, x,y+1,z,0,fx,-fx);
            ParticleEngine.spawnParticleAtBlock("portal",world, x,y+1,z,fx,fx,-fx);
            ParticleEngine.spawnParticleAtBlock("portal",world, x,y+1,z,-fx,fx,fx);
            ParticleEngine.spawnParticleAtBlock("portal",world, x,y+1,z,-fx,fx,-fx);
            ParticleEngine.spawnParticleAtBlock("portal",world, x,y+1,z,fx,fx,fx);
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
        ArrayList<String> test = new ArrayList<String>();
        Random random = new Random();
            if (entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;

                if (player.isSneaking()) {
                    int direction = MathHelper.floor_double((double)((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;

                    if (direction==1 && (world.getBlock(x-2,y,z)==this)) {
                        test.add(posToString(x-2,y,z));
                    } else if (direction==2 && (world.getBlock(x,y,z-2)==this)) {
                        test.add(posToString(x,y,z-2));
                    } else if (direction==3 && (world.getBlock(x+2,y,z)==this)) {
                        test.add(posToString(x+2,y,z));
                    } else if (direction==0 && (world.getBlock(x,y,z+2)==this)) {
                        test.add(posToString(x,y,z+2));
                    } else {
                        if(world.getBlock(x,y,z)==this) {test.add(posToString(x,y,z));}
                    }
                    int selection = random.nextInt(test.size());
                    if (Config.debugMode) {Logger.info(test.get(selection));}
                    String posString = test.get(selection);
                    String[] POS = posString.split(" ");
                    String X=POS[0],Y=POS[1],Z=POS[2];
                    int iX = Integer.parseInt(X),iY = Integer.parseInt(Y), iZ = Integer.parseInt(Z);
                    ParticleEngine.spawnBlinkParticle(iX, iY+1, iZ, world);
                    if(!world.isRemote) {
                        boolean test1=false, test2=false, test3=false;
                        for (int i=1; i<=3;i++) {
                            if (world.getBlock(iX,iY+i,iZ)==Blocks.air) {
                                if(i==1) {
                                    test1=true;
                                }if(i==2) {
                                    test2=true;
                                }if(i==3) {
                                    test3=true;
                                }
                                if(test1&&test2&&test3) {
                                    player.setPositionAndUpdate(iX+0.5,iY+1.5,iZ+0.5);
                                    float max = 0.2f, min = 0.01f;
                                    float pitch = (float)Math.random()*(max-min)+min;
                                    world.playSoundAtEntity(player,"mob.endermen.portal",1.0f ,pitch);
                                }
                            }
                        }
                    }
                }
            }
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 0;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntitySwapper();
    }
}
