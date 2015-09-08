package com.ewyboy.blink.Utillity;

import net.minecraft.util.EnumChatFormatting;

public class StringMap {

    //Networking
    public static final String clientProxyPath = "com.ewyboy.blink.Networking.ClientProxy";
    public static final String serverProxyPath = "com.ewyboy.blink.Networking.CommonProxy";

    //Mod info
    public static final String ID = "blink";
    public static final String Name = "Blink";
    public static final String MinecraftVersion = "1.7.10";
    public static final String VersionMajor = "1";
    public static final String VersionMinor = "0";
    public static final String VersionPatch = "6";
    public static final String VersionBuildName = Name + "-" + MinecraftVersion + "-" + VersionMajor + "." + VersionMinor + "." + VersionPatch;

    //Blocks
    public static final String BlockSwapper = "Swapper";
    public static final String BlockMarker = "Marker";
    public static final String BlockEnderFluid = "EnderLiquid";

    //Fluids
    public static final String EnderFluid = "EnderFluid";

    //Items
    public static final String ItemBlitzer = "Blitzer";
    public static final String ItemRodOfAges = "RodOfAgesModel";
    public static final String ItemEnderCapsule = "EnderCapsule";

    //CreativeTabs
    public static final String CreativeTabItem = "Blink Items";
    public static final String CreativeTabBlock = "Blink Blocks";

    //RenderIDs
    public static int BlockSwapperRenderID;

    //Strings
    public static final String warn = EnumChatFormatting.RED + "Warning: " + EnumChatFormatting.WHITE;
    public static final String info = EnumChatFormatting.AQUA + "Info: " + EnumChatFormatting.WHITE;
}
