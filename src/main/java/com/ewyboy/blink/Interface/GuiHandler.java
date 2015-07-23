package com.ewyboy.blink.Interface;

import com.ewyboy.blink.Main.Blink;
import com.ewyboy.blink.TileEntities.TileEntitySwapper;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    public GuiHandler() {
        NetworkRegistry.INSTANCE.registerGuiHandler(Blink.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case 0:
                TileEntity te = world.getTileEntity(x,y,z);
                if(te != null && te instanceof TileEntitySwapper) {
                    return new ContainerSwapper(player.inventory, (TileEntitySwapper)te);
                }
                break;
            }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case 0:
                TileEntity te = world.getTileEntity(x,y,z);
                if (te != null && te instanceof TileEntitySwapper) {
                    return new GuiSwapper(player.inventory, (TileEntitySwapper)te);
                }
                break;
        }
        return null;
    }
}
