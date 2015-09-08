package com.ewyboy.blink.Blocks;

import com.ewyboy.blink.TileEntities.TileEntitySwapper;
import com.ewyboy.blink.Files.Config;
import com.ewyboy.blink.Utillity.Logger;
import com.ewyboy.blink.Engines.ParticleEngine;
import com.ewyboy.blink.Engines.SoundEngine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class BlockSwapper extends BaseBlock implements ITileEntityProvider {

    public BlockSwapper() {
        super(Material.iron);
        setHardness(3.0f);
    }

    private int defaultFlag = 3;

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        ArrayList<String> test = new ArrayList<String>();
        Random random = new Random();

        if (Config.debugMode) {Logger.info("Side: " + side);}
        int north = 3, south = 2, east = 4, west = 5;

        if (side==west && (world.getBlock(x-2,y,z)==this)) {
            test.add(posToString(x-2,y,z));
        } else if (side==north && (world.getBlock(x,y,z-2)==this)) {
            test.add(posToString(x,y,z-2));
        } else if (side==east && (world.getBlock(x+2,y,z)==this)) {
            test.add(posToString(x+2,y,z));
        } else if (side==south && (world.getBlock(x,y,z+2)==this)) {
            test.add(posToString(x,y,z+2));
        } else {
            if(world.getBlock(x,y,z)==this) {test.add(posToString(x,y,z));}
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

        ParticleEngine.spawnHelixEffect(world,iX,iY+1,iZ,ParticleEngine.effectEnder, 1);
        ParticleEngine.spawnHelixEffect(world,z,y+1,x,ParticleEngine.effectEnder, 1);

        world.setBlock(x,y+1,z,block2,block2meta,defaultFlag);
        world.setBlock(iX,iY+1,iZ,block1,block1meta,defaultFlag);

        SoundEngine.playSound(world,iX,iY,iZ, SoundEngine.teleportSound, 0.2f,0.6f);
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        return Blocks.stone.getBlockTextureFromSide(1);
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
                ParticleEngine.spawnParticle(world,iX,iY+0.5,iZ,ParticleEngine.effectEnder,0f,0.35f,0f);
            if (player.isSneaking()) {
                ParticleEngine.spawnHelixEffect(world,iX,iY+1,iZ,ParticleEngine.effectEnder,1);
                ParticleEngine.spawnHelixEffect(world,iX,iY+1,iZ,ParticleEngine.effectEnder,1);
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
                                SoundEngine.playSoundAtEntity(SoundEngine.teleportSound, world, player, 0.01f, 0.2f);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public int getRenderType() {
        return (-1);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public boolean canRenderInPass(int pass) {
        return true;
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
