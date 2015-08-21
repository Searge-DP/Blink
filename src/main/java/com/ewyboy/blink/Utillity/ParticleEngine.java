package com.ewyboy.blink.Utillity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ParticleEngine {

    public static void spawnParticleAtEntity(String particleFX, World world,EntityItem item, double x, double y, double z,double vX, double vY, double vZ) {
        world.spawnParticle(particleFX, x = item.posX + 0.5, y = item.posY, z = item.posZ + 0.5, Math.random() * (vX - (vX*(-1)) +(vX*(-1))), Math.random() * (vY - (vY*(-1)) +(vY*(-1))), Math.random() * (vZ - (vZ*(-1)) +(vZ*(-1))));
    }

    public static void spawnParticleAtPlayer(String particleFX, World world, EntityPlayer player,double x, double y, double z, double vX, double vY, double vZ) {
        world.spawnParticle(particleFX, x = player.posX + 0.5, y = player.posY, z = player.posZ + 0.5, Math.random() * (vX - (vX*(-1)) +(vX*(-1))), Math.random() * (vY - (vY*(-1)) +(vY*(-1))), Math.random() * (vZ - (vZ*(-1)) +(vZ*(-1))));
    }

    public static void spawnParticleAtBlock(String particleFX, World world, double x, double y, double z, double vX, double vY, double vZ) {
        world.spawnParticle(particleFX, x + 0.5,y,z + 0.5, Math.random() * (vX - (vX*(-1)) +(vX*(-1))), Math.random() * (vY - (vY*(-1)) +(vY*(-1))), Math.random() * (vZ - (vZ*(-1)) +(vZ*(-1))));
    }

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
