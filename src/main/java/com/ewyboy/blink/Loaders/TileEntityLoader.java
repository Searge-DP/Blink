package com.ewyboy.blink.Loaders;

import com.ewyboy.blink.TileEntities.TileEntitySwapper;
import com.ewyboy.blink.Utillity.Logger;
import com.ewyboy.blink.Utillity.StringMap;
import com.google.common.base.Stopwatch;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;

import java.util.concurrent.TimeUnit;

@GameRegistry.ObjectHolder(StringMap.ID)
public class TileEntityLoader {

    public static void log(TileEntity entity) {
        Logger.info(entity + " successfully loaded");}

    public static TileEntity Swapper;

    public static void loadTileEntities() {
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("Loading tile entities started");
                Swapper = new TileEntitySwapper();
                    GameRegistry.registerTileEntity(TileEntitySwapper.class, "TileEntitySwapper");
                        log(Swapper);
        Logger.info("Loading tile entities finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }
}
