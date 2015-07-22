package com.ewyboy.blink.Interface;

import com.ewyboy.blink.TileEntities.TileEntitySwapper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerSwapper extends Container {

    private TileEntitySwapper swapper;

    public ContainerSwapper(InventoryPlayer invPlayer, TileEntitySwapper swapper) {
        this.swapper = swapper;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return swapper.isUseableByPlayer(player);
    }
}
