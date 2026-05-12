package com.pvpclient.utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

/**
 * Player utility functions
 */
public class PlayerUtils {
    public static boolean canAttack(PlayerEntity player) {
        return player != null && !player.isDead() && player.getHealth() > 0;
    }

    public static boolean isMoving(PlayerEntity player) {
        if (player == null) return false;
        return player.input.movementForward != 0 || player.input.movementSideways != 0;
    }

    public static double getHorizontalDistance(PlayerEntity player, double x, double z) {
        double dx = player.getX() - x;
        double dz = player.getZ() - z;
        return Math.sqrt(dx * dx + dz * dz);
    }

    public static Vec3d getVelocity(PlayerEntity player) {
        return player.getVelocity();
    }

    public static float getRotationDifference(float from, float to) {
        float diff = to - from;
        while (diff > 180) diff -= 360;
        while (diff < -180) diff += 360;
        return diff;
    }

    public static boolean hasEnoughFood(PlayerEntity player) {
        return player.getFoodLevel() >= 6;
    }
}
