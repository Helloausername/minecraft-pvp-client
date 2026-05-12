package com.pvpclient.modules.misc;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import com.pvpclient.modules.Module;
import com.pvpclient.modules.ModuleCategory;

/**
 * Auto Log - Automatically disconnects when health is low
 */
public class AutoLog extends Module {
    private float triggerHealth = 5.0f;
    private int cooldown = 0;

    public AutoLog() {
        super("Auto Log", "Disconnect low", ModuleCategory.MISC);
    }

    @Override
    public void onTick() {
        MinecraftClient client = getClient();
        PlayerEntity player = client.player;

        if (player == null) return;

        cooldown--;

        if (player.getHealth() <= triggerHealth && cooldown <= 0) {
            client.disconnect();
            cooldown = 100;
        }
    }

    public void setTriggerHealth(float health) {
        this.triggerHealth = Math.max(0.5f, Math.min(10.0f, health));
    }

    public float getTriggerHealth() {
        return triggerHealth;
    }
}
