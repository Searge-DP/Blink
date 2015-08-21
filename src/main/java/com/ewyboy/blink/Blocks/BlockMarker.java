package com.ewyboy.blink.Blocks;

import com.ewyboy.blink.Textures.TexturePath;
import com.ewyboy.blink.Utillity.ParticleEngine;
import com.ewyboy.blink.Utillity.StringMap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMarker extends BaseBlock {

    public BlockMarker() {
        super(Material.circuits);
        setLightLevel(0.75F);
        setLightOpacity(1);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F);
        setBlockUnbreakable();
        setHardness(-1);
    }

    @Override
    public boolean canBlockStay(World world, int x, int y, int z) {
        if(world.getBlock(x,y-1,z)== Blocks.air) {
            world.setBlockToAir(x,y,z);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        canBlockStay(world,x,y,z);
    }

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        ParticleEngine.spawnBlinkParticle(x,y,z,world);
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        return null;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public int getRenderType() {
        return 0;
    }

    public boolean isCollidable() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    private IIcon TextureIcon;

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        TextureIcon = register.registerIcon(TexturePath.TextureLocation + ":" + StringMap.BlockMarker+"New1");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        if (side == 1) {
            return TextureIcon;
        }
        else if (side == 0) {
            return TextureIcon;
        }
        return TextureIcon;
    }
}
