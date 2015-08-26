package com.ewyboy.blink.Items;

import com.ewyboy.blink.Loaders.CreativeTabLoader;
import net.minecraft.item.Item;

public class BaseItem extends Item {

    public BaseItem () {
        this.setCreativeTab(CreativeTabLoader.BlinkItemTab);
        this.setNoRepair();
        this.setMaxStackSize(1);
    }
}
