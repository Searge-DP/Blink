package com.ewyboy.blink.Interface;

import com.ewyboy.blink.TileEntities.TileEntitySwapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiSwapper extends GuiContainer {

    public GuiSwapper(InventoryPlayer invPlayer, TileEntitySwapper swapper) {
        super(new ContainerSwapper(invPlayer, swapper));
        xSize = 250;
        ySize = 200;
    }

    private static final ResourceLocation texture = new ResourceLocation("blink","textures/gui/swapper.png");

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
        GL11.glColor4f(1,1,1,1); //Rest Color

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        //2 First = Where to place GUI | 2 Next = Texture form GUI | 2 Last Size
        drawTexturedModalRect(guiLeft,guiTop,0,0, xSize,ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        fontRendererObj.drawString("BlockSwapper", 8, 6, 0x404040); //Text "String",x,y,color;
    }

    @Override
    public void initGui() {
        super.initGui();
        //buttonList.clear();
        //buttonList.add(new GuiButton(0,guiLeft + 100, guiTop +14, 60,20, "Disable")); //Button - ID, pos, pos, length, height, "String";
    }

    @Override
    protected void actionPerformed(GuiButton button) {
       /*if (button.id == 0) {
            System.out.println("Clicked");
        }*/
    }
}
