package com.ewyboy.blink.Blocks;

import com.ewyboy.blink.Loaders.CreativeTabLoader;
import com.ewyboy.blink.Main.Blink;
import com.ewyboy.blink.Textures.TexturePath;
import com.ewyboy.blink.TileEntities.TileEntitySwapper;
import com.ewyboy.blink.Utillity.StringMap;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class BlockSwapper extends BlockContainer {

    public BlockSwapper() {
        super(Material.iron);
        setHardness(1.0f);
        setCreativeTab(CreativeTabLoader.BlinkBlockTab);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            FMLNetworkHandler.openGui(player, Blink.instance, 0, world, x, y, z);
        }

        return true;
    }

    @Override
    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        if (!world.isRemote) {
            TileEntity te = world.getTileEntity(x, y, z);
            if (te != null && te instanceof TileEntitySwapper) {
                TileEntitySwapper machine = (TileEntitySwapper)te;
                spawnAnvil(world, machine, x, y + 20, z);
            }
        }
    }

    private void spawnAnvil(World world, IInventory inv, int x, int y, int z) {
        if (world.isAirBlock(x, y, z)) {
            for (int i = 0; i < inv.getSizeInventory(); i++) {
                ItemStack stack = inv.getStackInSlot(i);
                if (stack != null) {
                    inv.decrStackSize(i, 1);
                    world.setBlock(x, y, z, Blocks.anvil);
                    return;
                }
            }
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int par2, int par3, int par4) {
        float f = 0.05F;
        return AxisAlignedBB.getBoundingBox((double) par2, (double) par3, (double) par4, (double) (par2 + 1), (double) ((float) (par3 + 1) - f), (double) (par4 + 1));
    }

    public String posToString(int x, int y, int z) {
        return x + " " + y + " " + z;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if(entity instanceof EntityPlayer)
        {
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
                spawnEnderEffectsPlayer(world,player,x,y,z);
                spawnEnderEffectsEntity(world,entity,x,y,z);
            }
        }

        if(entity instanceof EntityItem){

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
            spawnEnderEffectsEntity(world,entity,x,y,z);
        }
    }

    private void spawnEnderEffectsPlayer(World world, EntityPlayer player, double x, double y, double z) {

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

    private void spawnEnderEffectsEntity(World world, Entity player, double x, double y, double z) {

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

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntitySwapper();
    }
}
