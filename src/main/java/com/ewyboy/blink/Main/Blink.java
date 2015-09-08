package com.ewyboy.blink.Main;

import com.ewyboy.blink.Files.Config;
import com.ewyboy.blink.Loaders.*;
import com.ewyboy.blink.Networking.ClientProxy;
import com.ewyboy.blink.Networking.CommonProxy;
import com.ewyboy.blink.Utillity.Logger;
import com.ewyboy.blink.Utillity.StringMap;
import com.google.common.base.Stopwatch;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.util.concurrent.TimeUnit;

@Mod (modid = StringMap.ID, name = StringMap.Name, version = StringMap.VersionBuildName, acceptedMinecraftVersions = "["+StringMap.MinecraftVersion+"]")

public final class Blink {

    @Mod.Instance(StringMap.ID)
    public static Blink instance;

    @SidedProxy(modId = StringMap.ID, clientSide = StringMap.clientProxyPath, serverSide = StringMap.serverProxyPath)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("PreInitialization started");
                Config.init(event.getSuggestedConfigurationFile());
                ItemLoader.loadItems();
                BlockLoader.loadBlocks();
                FluidLoader.loadFluids();
                TileEntityLoader.loadTileEntities();
                ClientProxy.init();
                CommonProxy.init();
            Logger.info("PreInitialization finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
            Logger.info("PreInitialization process successfully done");
    }

    @Mod.EventHandler
    public void init (FMLInitializationEvent event) {
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("Initialization started");
            Logger.info("Initialization finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
            Logger.info("Initialization process successfully done");
    }

    @Mod.EventHandler
    public void postInit (FMLPreInitializationEvent event){
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("PostInitialization started");
                RecipeLoader.loadRecipes();
            Logger.info("PostInitialization finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
            Logger.info("PostInitialization process successfully done");
    }

}

