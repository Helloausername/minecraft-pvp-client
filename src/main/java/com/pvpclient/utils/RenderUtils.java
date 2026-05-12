package com.pvpclient.utils;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

/**
 * Utility class for rendering boxes and shapes
 */
public class RenderUtils {
    public static void drawEntityBox(LivingEntity entity, float r, float g, float b, float a) {
        Box box = entity.getBoundingBox();
        drawBox(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ, r, g, b, a);
    }

    public static void drawBox(double minX, double minY, double minZ, double maxX, double maxY, double maxZ,
                               float r, float g, float b, float a) {
        // Box rendering would be done via WorldRenderer mixin
    }

    public static void drawLine(Vec3d start, Vec3d end, float r, float g, float b, float a) {
        // Line rendering would be done via WorldRenderer mixin
    }
}
