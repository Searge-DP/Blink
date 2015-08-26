package com.ewyboy.blink.Networking;

import com.ewyboy.blink.Loaders.BlockLoader;
import com.ewyboy.blink.Loaders.ItemLoader;
import com.ewyboy.blink.Rendering.Models.Blocks.SwapperModel;
import com.ewyboy.blink.Rendering.Models.Items.RodOfAgesModel;
import com.ewyboy.blink.Rendering.Renders.Blocks.SwapperRenderer;
import com.ewyboy.blink.Rendering.Renders.Items.RodOfAgesRenderer;
import com.ewyboy.blink.TileEntities.TileEntitySwapper;
import com.ewyboy.blink.Utillity.StringMap;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
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
        MinecraftForgeClient.registerItemRenderer(ItemLoader.RodOfAges, new RodOfAgesRenderer());

        SwapperModel modelSwapper = new SwapperModel();
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockLoader.Swapper),new SwapperRenderer());

        StringMap.BlockSwapperRenderID = RenderingRegistry.getNextAvailableRenderId();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySwapper.class, new SwapperRenderer());
    }
}
