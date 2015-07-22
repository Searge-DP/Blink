package com.ewyboy.blink.Networking;

import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy {

    public static boolean shiftPressed() {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
    }

}
