package com.ewyboy.blink.Engines;

import com.ewyboy.blink.Files.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class ParticleEngine {

    public static String effectPortal = "portal";
    public static String effectEnder = "magicCrit";

    /** Determines amount of particles. 0 = All, 1 = Decreased, 2 = Minimal */
    public static int getParticleSettings() {
        if (Minecraft.getMinecraft().gameSettings.particleSetting == 0) {
            return 0;
        } else if (Minecraft.getMinecraft().gameSettings.particleSetting == 1) {
            return 1;
        } else if (Minecraft.getMinecraft().gameSettings.particleSetting == 0) {
            return 2;
        } else {
            return 0;
        }
    }

    public static void spawnParticle(World world, double x, double y, double z, String particleName, double vX, double vY, double vZ) {
        world.spawnParticle(particleName, x+0.5,y+0.5,z+0.5, vX, vY, vZ);
    }

    public static void spawnHelixEffect(World world, int x, int y, int z, String particleName, double duration) {
        if (getParticleSettings() == 0) {
            for(double i = 0; i <= Math.PI; i += duration / Config.masterParticlePercentage) {
                double adjustedX = i * Math.cos(i) / 2, adjustedZ = i * Math.sin(i) / 2;
                helixPattern(world,particleName,x,y,z,i,adjustedX,adjustedZ);
            }
        } else if (getParticleSettings() == 1) {
            for(double i = 0; i <= Math.PI; i += duration / (Config.masterParticlePercentage / 2)) {
                double adjustedX = i * Math.cos(i) / 2, adjustedZ = i * Math.sin(i) / 2;
                helixPattern(world, particleName, x, y, z, i, adjustedX, adjustedZ);
            }
        }
    }

    private static void helixPattern(World world, String particleName, double x, double y, double z, double i, double adjustedX, double adjustedZ) {
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedX,      i, adjustedZ);
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedX*(-1), i, adjustedZ*(-1));
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedX*(-1), i, adjustedZ);
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedX,      i, adjustedZ*(-1));
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedZ,      i, adjustedX);
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedZ*(-1), i, adjustedX*(-1));
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedZ*(-1), i, adjustedX);
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedZ,      i, adjustedX*(-1));
    }
}
