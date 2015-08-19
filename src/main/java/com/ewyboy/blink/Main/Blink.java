package com.ewyboy.blink.Main;

import com.ewyboy.blink.Loaders.BlockLoader;
import com.ewyboy.blink.Loaders.ItemLoader;
import com.ewyboy.blink.Loaders.RecipeLoader;
import com.ewyboy.blink.Networking.ClientProxy;
import com.ewyboy.blink.Networking.CommonProxy;
import com.ewyboy.blink.TileEntities.TileEntityLoader;
import com.ewyboy.blink.Utillity.Config;
import com.ewyboy.blink.Utillity.Logger;
import com.ewyboy.blink.Utillity.StringMap;
import com.google.common.base.Stopwatch;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.util.concurrent.TimeUnit;

@Mod (modid = StringMap.ID, name = StringMap.Name, version = StringMap.Version, acceptedMinecraftVersions = "["+StringMap.MinecraftVersion+"]")

public final class Blink {

    @Mod.Instance(StringMap.ID)
    public static Blink instance;

    @SidedProxy(modId = StringMap.ID, clientSide = StringMap.clientProxyPath, serverSide = StringMap.serverProxyPath)
    public static CommonProxy proxy;

    @Mod.EventHandler
    void preInit (FMLPreInitializationEvent event) {
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("PreInitialization started");
                Config.init(event.getSuggestedConfigurationFile());
                ItemLoader.loadItems();
                BlockLoader.loadBlocks();
                TileEntityLoader.loadTileEntitys();
                ClientProxy.loadModels();
            Logger.info("PreInitialization finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
            Logger.info("PreInitialization process successfully done");
    }

    @Mod.EventHandler
    void init (FMLInitializationEvent event) {
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("Initialization started");
            Logger.info("Initialization finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
            Logger.info("Initialization process successfully done");
    }

    @Mod.EventHandler
    void postInit (FMLPreInitializationEvent event){
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("PostInitialization started");
                RecipeLoader.loadRecipes();
            Logger.info("PostInitialization finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
            Logger.info("PostInitialization process successfully done");
    }

}

