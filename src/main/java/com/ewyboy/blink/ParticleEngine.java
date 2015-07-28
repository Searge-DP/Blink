package com.ewyboy.blink;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ParticleEngine {

    public static void spawnParticleAtEntity(String particleFX, World world,EntityItem item, double x, double y, double z,double vX, double vY, double vZ) {
        world.spawnParticle(particleFX, x = item.posX, y = item.posY, z = item.posZ, Math.random() * (vX - (vX*(-1)) +(vX*(-1))), Math.random() * (vY - (vY*(-1)) +(vY*(-1))), Math.random() * (vZ - (vZ*(-1)) +(vZ*(-1))));
    }

    public static void spawnParticleAtPlayer(String particleFX, World world, EntityPlayer player,double x, double y, double z, double vX, double vY, double vZ) {
        world.spawnParticle(particleFX, x = player.posX, y = player.posY, z = player.posZ, Math.random() * (vX - (vX*(-1)) +(vX*(-1))), Math.random() * (vY - (vY*(-1)) +(vY*(-1))), Math.random() * (vZ - (vZ*(-1)) +(vZ*(-1))));
    }

    public static void spawnParticleAtBlock(String particleFX, World world, double x, double y, double z, double vX, double vY, double vZ) {
        world.spawnParticle(particleFX, x,y,z, Math.random() * (vX - (vX*(-1)) +(vX*(-1))), Math.random() * (vY - (vY*(-1)) +(vY*(-1))), Math.random() * (vZ - (vZ*(-1)) +(vZ*(-1))));
    }

    public static void playSound(String soundPath, World world, Entity entity, double x, double y, double z, float volume, float pitch) {
        world.playSound(x + 0.5D, y + 0.5D, z + 0.5D, soundPath, volume, pitch + (pitch - (pitch*(-1)) +(pitch*(-1))), false);
    }
}
