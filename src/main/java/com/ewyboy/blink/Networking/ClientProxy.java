package com.ewyboy.blink.Networking;

import com.ewyboy.blink.Loaders.ItemLoader;
import com.ewyboy.blink.Rendering.Models.Items.RodOfAgesModel;
import com.ewyboy.blink.Rendering.Renders.Items.RodOfAgesRenderer;
import com.ewyboy.blink.Utillity.Logger;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy {

    public static void init() {
        shiftPressed();
        loadModels();
    }

    public static boolean shiftPressed() {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
    }

    public static void loadModels() {
        RodOfAgesModel model = new RodOfAgesModel();
        MinecraftForgeClient.registerItemRenderer(ItemLoader.RodOfAges, (IItemRenderer) new RodOfAgesRenderer());
        for(int i = 0; i<50;i++) {
            Logger.info("ClientProxy Loads it at least");
        }
    }
}
