package com.pvpclient.modules.misc;

import net.minecraft.client.MinecraftClient;
import com.pvpclient.modules.Module;
import com.pvpclient.modules.ModuleCategory;

/**
 * Toggle Sprint - Sprint mode persists without holding key
 */
public class ToggleSprint extends Module {
    private boolean toggleActive = false;

    public ToggleSprint() {
        super("Toggle Sprint", "Sprint toggle", ModuleCategory.MISC);
    }

    @Override
    public void onTick() {
        MinecraftClient client = getClient();
        if (client.player == null) return;

        if (client.options.sprintKey.wasPressed()) {
            toggleActive = !toggleActive;
        }

        if (toggleActive && client.player.getFoodLevel() > 6) {
            client.player.setSprinting(true);
        }
    }

    @Override
    public void onDisable() {
        toggleActive = false;
    }
}
