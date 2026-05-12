package com.pvpclient.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity utility functions
 */
public class EntityUtils {
    public static List<LivingEntity> getNearbyEntities(Entity from, double radius) {
        List<LivingEntity> entities = new ArrayList<>();
        
        if (from.getWorld() == null) return entities;

        for (Entity entity : from.getWorld().getEntities()) {
            if (entity instanceof LivingEntity && entity != from && !entity.isInvisible()) {
                if (from.distanceTo(entity) <= radius) {
                    entities.add((LivingEntity) entity);
                }
            }
        }

        return entities;
    }

    public static LivingEntity getClosestEntity(Entity from, double radius) {
        List<LivingEntity> entities = getNearbyEntities(from, radius);
        LivingEntity closest = null;
        double closestDistance = radius;

        for (LivingEntity entity : entities) {
            double distance = from.distanceTo(entity);
            if (distance < closestDistance) {
                closest = entity;
                closestDistance = distance;
            }
        }

        return closest;
    }

    public static Vec3d getEyePosition(LivingEntity entity) {
        return entity.getEyePos();
    }

    public static Vec3d getCenterPosition(Entity entity) {
        return entity.getPos().add(0, entity.getHeight() / 2, 0);
    }
}
