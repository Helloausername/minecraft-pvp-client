package com.pvpclient.modules.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

import com.pvpclient.modules.Module;
import com.pvpclient.modules.ModuleCategory;

/**
 * ESP - Highlights nearby entities with boxes
 */
public class ESP extends Module {
    private float maxDistance = 64.0f;

    public ESP() {
        super("ESP", "Entity esp", ModuleCategory.RENDER);
    }

    @Override
    public void onRender() {
        MinecraftClient client = getClient();
        if (client.player == null || client.world == null) return;

        for (Entity entity : client.world.getEntities()) {
            if (entity instanceof LivingEntity && entity != client.player) {
                double distance = client.player.distanceTo(entity);
                if (distance > maxDistance) continue;

                boolean isPlayer = entity instanceof PlayerEntity;
                drawEntityOutline(entity, isPlayer);
            }
        }
    }

    private void drawEntityOutline(Entity entity, boolean isPlayer) {
        // Rendering logic for entity outline
    }

    public void setMaxDistance(float distance) {
        this.maxDistance = Math.max(10.0f, Math.min(256.0f, distance));
    }
}
