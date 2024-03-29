package com.ewyboy.blink.Loaders;

import com.ewyboy.blink.Utillity.Logger;
import com.ewyboy.blink.Utillity.StringMap;
import com.google.common.base.Stopwatch;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.concurrent.TimeUnit;

@GameRegistry.ObjectHolder(StringMap.ID)
public class RecipeLoader {

    public static void loadRecipes() {
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("Loading recipes started");
                GameRegistry.addRecipe(new ItemStack(ItemLoader.Blitzer),
                        new Object[]{"XAX", "IOI", "XAX",
                                'X', new ItemStack(Items.ender_pearl),
                                'O', new ItemStack(Items.clock),
                                'A', new ItemStack(Items.blaze_rod),
                                'I', new ItemStack(Items.blaze_powder)});

                GameRegistry.addRecipe(new ItemStack(ItemLoader.EnderCapsule, 2),
                        new Object[] {" X ","XOX"," X ",
                                'X', new ItemStack(Items.gold_ingot),
                                'O', new ItemStack(Items.ender_pearl),
                        });

                GameRegistry.addRecipe(new ItemStack(BlockLoader.Swapper),
                        new Object[] {"XAX","XOX","XXX",
                                'A', new ItemStack(Blocks.glass_pane),
                                'O', new ItemStack(ItemLoader.EnderCapsule),
                                'X', new ItemStack(Blocks.stone)
                        });
                GameRegistry.addRecipe(new ItemStack(ItemLoader.RodOfAges),
                        new Object[] {" WO"," IW","I  ",
                                'W', new ItemStack(Items.ender_eye),
                                'O', new ItemStack(ItemLoader.EnderCapsule),
                                'I', new ItemStack(Items.stick)
                        });
            Logger.info("Loading recipes finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
    }
}
