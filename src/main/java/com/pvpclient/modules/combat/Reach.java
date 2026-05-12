package com.pvpclient.modules.combat;

import net.minecraft.client.MinecraftClient;
import com.pvpclient.modules.Module;
import com.pvpclient.modules.ModuleCategory;

/**
 * Reach - Displays attack reach distance
 */
public class Reach extends Module {
    private float currentReach = 3.0f;

    public Reach() {
        super("Reach", "Show reach", ModuleCategory.COMBAT);
    }

    @Override
    public void onTick() {
        MinecraftClient client = getClient();
        if (client.player == null) return;

        if (client.targetedEntity != null) {
            currentReach = (float) client.player.distanceTo(client.targetedEntity);
        } else {
            currentReach = 3.0f;
        }
    }

    public float getCurrentReach() {
        return currentReach;
    }
}
