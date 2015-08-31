package com.ewyboy.blink.Loaders;

import com.ewyboy.blink.Utillity.StringMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabLoader {

    //BlockTab
    public static CreativeTabs BlinkBlockTab = new CreativeTabs (StringMap.CreativeTabBlock) {
        public ItemStack getIconItemStack() {return new ItemStack(BlockLoader.Swapper);}
        @Override
        public Item getTabIconItem() {return null;}
    };
    //ItemTab
    public static CreativeTabs BlinkItemTab = new CreativeTabs (StringMap.CreativeTabItem) {
        public ItemStack getIconItemStack() {return new ItemStack(ItemLoader.RodOfAges);}
        @Override
        public Item getTabIconItem() {return null;}
    };
}
