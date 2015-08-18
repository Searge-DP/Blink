package com.ewyboy.blink.Utillity;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static int rodOfAgesRange;

    public static void init(File file) {

        Configuration config = new Configuration(file);

        config.load();
            rodOfAgesRange = config.getInt("Rod of Ages - Range", "Blink Configs", 16, -1, Integer.MAX_VALUE, "Set teleportation range for Rod Of Ages- Default: 16 block - Min: 1 - Max: " + Integer.MAX_VALUE + " or set -1 for infinite range");
        config.save();
    }
}
