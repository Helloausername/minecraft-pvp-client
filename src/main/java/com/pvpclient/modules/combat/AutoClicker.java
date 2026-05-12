package com.pvpclient.modules.combat;

import net.minecraft.client.MinecraftClient;
import com.pvpclient.modules.Module;
import com.pvpclient.modules.ModuleCategory;

/**
 * Auto Clicker - Automatically clicks at set intervals
 */
public class AutoClicker extends Module {
    private int clickCounter = 0;
    private float cps = 10.0f;

    public AutoClicker() {
        super("Auto Clicker", "Auto attack", ModuleCategory.COMBAT);
    }

    @Override
    public void onTick() {
        MinecraftClient client = getClient();
        if (client.player == null) return;

        clickCounter++;
        int ticksPerClick = (int) (20.0f / cps);

        if (clickCounter >= ticksPerClick) {
            clickCounter = 0;
            performClick(client);
        }
    }

    private void performClick(MinecraftClient client) {
        if (client.targetedEntity != null) {
            client.player.attack(client.targetedEntity);
        }
    }

    public void setCPS(float cps) {
        this.cps = Math.max(5.0f, Math.min(20.0f, cps));
    }

    public float getCPS() {
        return cps;
    }
}
