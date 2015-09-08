package com.ewyboy.blink.Files;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static int rodOfAgesRange;
    public static float masterSoundVolume;
    public static boolean debugMode;

    public static void init(File file) {
        Configuration config = new Configuration(file);

        config.load();
            rodOfAgesRange = config.getInt("Rod of Ages - Range", "Blink Configs", 16, -1, Integer.MAX_VALUE, "Set teleportation range for Rod Of Ages- Default: 16 block - Min: 1 - Max: " + Integer.MAX_VALUE + " or set -1 for infinite range");
            masterSoundVolume = config.getFloat("Master Sound Volume", "Blink Configs", 0.75f, 0.0f, 1.0f, "Controls the master sound volume for all blink sound effects [Use a decimal between 0-1 [1 = 100% | 0 = 0%]]");
            debugMode = config.getBoolean("Debug Mode","Blink Configs",false,"Set true to turn on developer debug mode for debugging info in console");
        config.save();
    }
}
