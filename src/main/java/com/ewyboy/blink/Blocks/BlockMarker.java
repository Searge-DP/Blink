package com.ewyboy.blink.Blocks;

import com.ewyboy.blink.Textures.TexturePath;
import com.ewyboy.blink.Utillity.StringMap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockMarker extends BaseBlock {

    public BlockMarker() {
        super(Material.circuits);
        setLightLevel(0.75F);
        setLightOpacity(1);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F);
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public Block setBlockUnbreakable()
    {
        this.setHardness(-1.0F);
        return this;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderType()
    {
        return 0;
    }

    public boolean isCollidable()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    private IIcon TextureIcon;

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        TextureIcon = register.registerIcon(TexturePath.TextureLocation + ":" + StringMap.BlockMarker);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta)
    {
        if (side == 1)
        {
            return TextureIcon;
        }
        else if (side == 0)
        {
            return TextureIcon;
        }
        return TextureIcon;
    }
}
