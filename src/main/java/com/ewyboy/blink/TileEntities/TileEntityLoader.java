package com.ewyboy.blink.TileEntities;

import com.ewyboy.blink.Utillity.Logger;
import com.google.common.base.Stopwatch;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;

import java.util.concurrent.TimeUnit;

public class TileEntityLoader {

    public static void log(TileEntity entity) {
        Logger.info(entity + " successfully loaded");}

    public static TileEntity Swapper;

    public static void loadTileEntitys() {
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("Loading tile entities started");
                Swapper = new TileEntitySwapper();
            GameRegistry.registerTileEntity(TileEntitySwapper.class, "TileEntityEMCBank");
        Logger.info("Loading tile entities finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

}
