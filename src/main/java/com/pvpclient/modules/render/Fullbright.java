package com.pvpclient.modules.render;

import net.minecraft.client.MinecraftClient;
import com.pvpclient.modules.Module;
import com.pvpclient.modules.ModuleCategory;

/**
 * Fullbright - Increases gamma/brightness to see in darkness
 */
public class Fullbright extends Module {
    private double originalGamma;

    public Fullbright() {
        super("Fullbright", "Max brightness", ModuleCategory.RENDER);
    }

    @Override
    public void onEnable() {
        MinecraftClient client = getClient();
        originalGamma = client.options.getGamma().getValue();
        client.options.getGamma().setValue(16.0);
    }

    @Override
    public void onDisable() {
        MinecraftClient client = getClient();
        client.options.getGamma().setValue(originalGamma);
    }

    @Override
    public void onTick() {
        MinecraftClient client = getClient();
        if (client.options.getGamma().getValue() < 15.0) {
            client.options.getGamma().setValue(16.0);
        }
    }
}
