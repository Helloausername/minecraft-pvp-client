package com.pvpclient;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;

import com.pvpclient.modules.ModuleManager;
import com.pvpclient.config.KeyBindings;

/**
 * PvP Client - Main mod entry point
 * Initializes all modules and sets up event listeners
 */
@Environment(EnvType.CLIENT)
public class PvPClient implements ClientModInitializer {
    public static final String MOD_ID = "pvpclient";
    public static ModuleManager moduleManager;
    public static KeyBindings keyBindings;

    @Override
    public void onInitializeClient() {
        moduleManager = new ModuleManager();
        keyBindings = new KeyBindings();

        // Initialize all modules
        moduleManager.registerModules();

        // Register tick event for module ticking
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                moduleManager.onTick();
            }
        });

        // Register client startup event
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            keyBindings.registerKeyBindings();
        });

        System.out.println("[PvP Client] Initialized successfully!");
    }
}
