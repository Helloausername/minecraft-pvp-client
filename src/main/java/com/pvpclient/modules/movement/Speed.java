package com.pvpclient.modules.movement;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import com.pvpclient.modules.Module;
import com.pvpclient.modules.ModuleCategory;

/**
 * Speed - Increases movement speed
 */
public class Speed extends Module {
    private float speedMultiplier = 1.5f;

    public Speed() {
        super("Speed", "Move faster", ModuleCategory.MOVEMENT);
    }

    @Override
    public void onTick() {
        MinecraftClient client = getClient();
        PlayerEntity player = client.player;

        if (player == null) return;

        Vec3d velocity = player.getVelocity();

        if (player.isOnGround()) {
            player.setVelocity(
                    velocity.x * speedMultiplier,
                    velocity.y,
                    velocity.z * speedMultiplier
            );
        }
    }

    public void setSpeedMultiplier(float multiplier) {
        this.speedMultiplier = Math.max(1.0f, Math.min(3.0f, multiplier));
    }

    public float getSpeedMultiplier() {
        return speedMultiplier;
    }
}
