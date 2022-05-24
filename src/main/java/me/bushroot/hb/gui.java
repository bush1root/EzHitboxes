package me.bushroot.hb;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.awt.*;

public class gui {
    public static boolean show = true;

    @SubscribeEvent
    public void drawText(RenderGameOverlayEvent.Post event) {
        switch (event.getType()) {
            case TEXT:
                if (show) {
                    Minecraft.getInstance().font.drawShadow(event.getMatrixStack(), "Created by @bush1root [TELEGRAM]", 10, 10, rainbow(300));
                }
                break;
            default:
                break;
        }
    }

    public static int rainbow(int delay) {
        double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
        rainbowState %= 360;
        return Color.getHSBColor((float) (rainbowState / 360.0f), 0.5f, 1f).getRGB();
    }
}
