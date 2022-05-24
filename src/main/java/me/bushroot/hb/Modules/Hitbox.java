package me.bushroot.hb.Modules;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.client.Minecraft;

import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.RenderPlayerEvent;

public class Hitbox {
    public static double size = 0.4;

    @SubscribeEvent
    public void onUpdate(RenderPlayerEvent e) {
        Entity player = e.getEntity();

        if (player != Minecraft.getInstance().player) {
            player.setBoundingBox(new AxisAlignedBB(
                            player.getX() - size,
                            player.getBoundingBox().minY,
                            player.getZ() - size,
                            player.getX() + size,
                            player.getBoundingBox().maxY,
                            player.getZ() + size
                    )
            );
        }
    }

    public static double getSize() {
        return size;
    }

    public static void setSize(double size) {
        Hitbox.size = size;
    }
}
