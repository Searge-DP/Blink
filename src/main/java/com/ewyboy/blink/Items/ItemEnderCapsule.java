    package com.ewyboy.blink.Items;

    import com.ewyboy.blink.Networking.ClientProxy;
import com.ewyboy.blink.Textures.TexturePath;
import com.ewyboy.blink.Utillity.StringMap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

    public class ItemEnderCapsule extends BaseItem {

        @Override
        @SideOnly(Side.CLIENT)
        public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation) {
            if (ClientProxy.shiftPressed()) {
                info.add("A crafting component for the swapper");
            } else {
                info.add("Press shift to show info");
            }
        }

    @SideOnly(Side.CLIENT)
    private IIcon EnderCapsuleIcons;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        EnderCapsuleIcons = register.registerIcon(TexturePath.TextureLocation + ":" + StringMap.ItemEnderCapsule);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage (int dmg) {
        return EnderCapsuleIcons;
    }
}

