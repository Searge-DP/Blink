package com.ewyboy.blink.Loaders;

import com.ewyboy.blink.Items.ItemBlitzer;
import com.ewyboy.blink.Items.ItemEnderCapsule;
import com.ewyboy.blink.Items.ItemLauncher;
import com.ewyboy.blink.Items.ItemRodOfAges;
import com.ewyboy.blink.Utillity.Logger;
import com.ewyboy.blink.Utillity.StringMap;
import com.google.common.base.Stopwatch;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

import java.util.concurrent.TimeUnit;

public class ItemLoader {

    public static Item Blitzer, RodOfAges, EnderCapsule, Launcher;
    public static void log(Item item) {Logger.info(item + " successfully loaded");}

    public static void loadItems() {
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("Loading blocks started");
                Blitzer = new ItemBlitzer().setUnlocalizedName(StringMap.ItemBlitzer);
                    GameRegistry.registerItem(Blitzer,StringMap.ItemBlitzer);
                        log(Blitzer);
                RodOfAges = new ItemRodOfAges().setUnlocalizedName(StringMap.ItemRodOfAges);
                    GameRegistry.registerItem(RodOfAges,StringMap.ItemRodOfAges);
                        log(RodOfAges);
                EnderCapsule = new ItemEnderCapsule().setUnlocalizedName(StringMap.ItemEnderCapsule);
                    GameRegistry.registerItem(EnderCapsule,StringMap.ItemEnderCapsule);
                        log(EnderCapsule);
                Launcher = new ItemLauncher().setUnlocalizedName(StringMap.ItemLauncher);
                    GameRegistry.registerItem(Launcher, StringMap.ItemLauncher);
                        log(Launcher);
            Logger.info("Loading items finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
    }
}
