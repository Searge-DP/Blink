package com.ewyboy.blink.Utillity;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class ParticleEngine {

    public static void playSound(String soundPath, World world, Entity entity, double x, double y, double z, float volume, float pitch) {
        world.playSound(x + 0.5D, y + 0.5D, z + 0.5D, soundPath, volume, pitch + (pitch - (pitch*(-1)) +(pitch*(-1))), false);
    }

    public static void spawnBlinkParticle(int x, int y, int z, World world) {
        for(double i = 0; i <= Math.PI; i +=0.010) {
            double adjustedX = i * Math.cos(i);
            double adjustedZ = i * Math.sin(i);

            world.spawnParticle("portal",x+0.5,y,z+0.5, adjustedX, i, adjustedZ);
            world.spawnParticle("portal",x+0.5,y,z+0.5, adjustedX*(-1), i, adjustedZ*(-1));
            world.spawnParticle("portal",x+0.5,y,z+0.5, adjustedX*(-1), i, adjustedZ);
            world.spawnParticle("portal",x+0.5,y,z+0.5, adjustedX, i, adjustedZ*(-1));

            world.spawnParticle("portal",x+0.5,y,z+0.5, adjustedZ, i, adjustedX);
            world.spawnParticle("portal",x+0.5,y,z+0.5, adjustedZ*(-1), i, adjustedX*(-1));
            world.spawnParticle("portal",x+0.5,y,z+0.5, adjustedZ*(-1), i, adjustedX);
            world.spawnParticle("portal",x+0.5,y,z+0.5, adjustedZ, i, adjustedX*(-1));
        }
    }
}
