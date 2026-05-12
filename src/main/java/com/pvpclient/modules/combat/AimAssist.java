package com.pvpclient.modules.combat;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

import com.pvpclient.modules.Module;
import com.pvpclient.modules.ModuleCategory;

/**
 * Aim Assist - Smoothly adjusts player view towards nearby enemies
 * Subtle and configurable to avoid detection
 */
public class AimAssist extends Module {
    private float rotationSpeed = 3.0f;
    private float maxDistance = 20.0f;

    public AimAssist() {
        super("Aim Assist", "Smoothly aim at targets", ModuleCategory.COMBAT);
    }

    @Override
    public void onTick() {
        MinecraftClient client = getClient();
        if (client.player == null || client.world == null) return;

        PlayerEntity player = client.player;
        LivingEntity target = getClosestEntity(player);

        if (target != null && !target.isInvisible()) {
            aimAtEntity(player, target);
        }
    }

    private void aimAtEntity(PlayerEntity player, LivingEntity target) {
        Vec3d playerEye = player.getEyePos();
        Vec3d targetPos = target.getPos().add(0, target.getHeight() / 2, 0);
        Vec3d direction = targetPos.subtract(playerEye);

        double distance = direction.length();
        if (distance < 0.1) return;

        double yaw = Math.atan2(direction.z, direction.x) * 180 / Math.PI - 90;
        double pitch = -Math.asin(direction.y / distance) * 180 / Math.PI;

        float currentYaw = player.getYaw();
        float currentPitch = player.getPitch();

        float newYaw = lerp(currentYaw, (float) yaw, rotationSpeed * 0.01f);
        float newPitch = lerp(currentPitch, (float) pitch, rotationSpeed * 0.01f);

        player.setYaw(newYaw);
        player.setPitch(newPitch);
    }

    private LivingEntity getClosestEntity(PlayerEntity player) {
        LivingEntity closest = null;
        double closestDistance = maxDistance;

        for (Entity entity : player.getWorld().getEntities()) {
            if (entity instanceof LivingEntity && entity != player && !entity.isInvisible()) {
                LivingEntity living = (LivingEntity) entity;
                if (!living.isDead()) {
                    double distance = player.distanceTo(entity);
                    if (distance < closestDistance) {
                        closest = living;
                        closestDistance = distance;
                    }
                }
            }
        }
        return closest;
    }

    private float lerp(float a, float b, float t) {
        return a + (b - a) * Math.min(1.0f, t);
    }

    public void setRotationSpeed(float speed) {
        this.rotationSpeed = Math.max(0.1f, Math.min(10.0f, speed));
    }

    public float getRotationSpeed() {
        return rotationSpeed;
    }
}
