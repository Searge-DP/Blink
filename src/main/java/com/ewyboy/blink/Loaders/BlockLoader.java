package com.ewyboy.blink.Loaders;

import com.ewyboy.blink.Blocks.BlockMarker;
import com.ewyboy.blink.Blocks.BlockSwapper;
import com.ewyboy.blink.Utillity.Logger;
import com.ewyboy.blink.Utillity.StringMap;
import com.google.common.base.Stopwatch;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

import java.util.concurrent.TimeUnit;

@GameRegistry.ObjectHolder(StringMap.ID)
public class BlockLoader {

    public static Block Swapper, Marker;
    public static void log(Block block) {Logger.info(block + " successfully loaded");}

    public static void loadBlocks() {
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("Loading blocks started");
                Swapper = new BlockSwapper().setBlockName(StringMap.BlockSwapper);
                    GameRegistry.registerBlock(Swapper, StringMap.BlockSwapper);
                        log(Swapper);
                Marker = new BlockMarker().setBlockName(StringMap.BlockMarker);
                    GameRegistry.registerBlock(Marker, StringMap.BlockMarker);
                        log(Marker);
        Logger.info("Loading blocks finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
    }
}
