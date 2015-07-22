package com.ewyboy.blink.TileEntities.Technical;

import com.ewyboy.blink.TileEntities.TileEntitySwapper;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntity {

    public static void Init() {
        registerTileEntityies();
        addTileEntityies();
    }

    private static void addTileEntityies() {
        GameRegistry.registerTileEntity(TileEntitySwapper.class, "SwapperKey");
    }

    private static void registerTileEntityies() {

    }
}
