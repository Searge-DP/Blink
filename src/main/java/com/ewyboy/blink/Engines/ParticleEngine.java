package com.ewyboy.blink.Engines;

import net.minecraft.world.World;

public class ParticleEngine {

    public static String effectPortal = "portal";
    public static String effectEnder = "magicCrit";

    public static void spawnParticle(World world, double x, double y, double z, String particleName, double vX, double vY, double vZ) {
        world.spawnParticle(particleName, x+0.5,y+0.5,z+0.5, vX, vY, vZ);
    }

    public static void spawnHelixEffect(World world, int x, int y, int z, String particleName, double duration) {
        for(double i = 0; i <= Math.PI; i += duration / 100) {
            double adjustedX = i * Math.cos(i) / 2, adjustedZ = i * Math.sin(i) / 2;

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
}
