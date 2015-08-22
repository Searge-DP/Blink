package com.ewyboy.blink.Loaders;

import com.ewyboy.blink.Fluids.EnderLiquid;
import com.ewyboy.blink.Utillity.Logger;
import com.ewyboy.blink.Utillity.StringMap;
import com.google.common.base.Stopwatch;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraft.block.Block;

import java.util.concurrent.TimeUnit;

public class FluidLoader {

    public static Fluid EnderFluid;
    public static Block EnderLiquid;
    public static void logFluid(Fluid fluid) {Logger.info(fluid + " successfully loaded");}
    public static void logFluidBlock(Block block) {Logger.info(block + " successfully loaded");}

    public static void loadFluids() {
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("Loading blocks started");
                EnderFluid = new Fluid("enderFluid")
                    .setDensity(5000)
                    .setGaseous(true)
                    .setLuminosity(10)
                    .setTemperature(150)
                    .setViscosity(5000);
                FluidRegistry.registerFluid(EnderFluid);
                EnderFluid.setUnlocalizedName("enderFluid");
                    logFluid(EnderFluid);
                EnderLiquid = new EnderLiquid(EnderFluid, Material.water).setBlockName("enderLiquid");
                    GameRegistry.registerBlock(EnderLiquid, StringMap.BlockEnderFluid);
                logFluidBlock(EnderLiquid);
        Logger.info("Loading fluids finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
    }

}
