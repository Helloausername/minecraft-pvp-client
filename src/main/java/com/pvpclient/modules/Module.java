package com.pvpclient.modules;

import net.minecraft.client.MinecraftClient;

/**
 * Base class for all modules
 * All feature modules extend this class
 */
public abstract class Module {
    protected String name;
    protected String description;
    protected ModuleCategory category;
    protected boolean enabled;
    protected int keyCode;

    public Module(String name, String description, ModuleCategory category) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.enabled = false;
        this.keyCode = -1;
    }

    /**
     * Called every client tick (20 times per second)
     */
    public void onTick() {
    }

    /**
     * Called every render frame
     */
    public void onRender() {
    }

    /**
     * Called when module is enabled
     */
    public void onEnable() {
    }

    /**
     * Called when module is disabled
     */
    public void onDisable() {
    }

    /**
     * Toggles the enabled state
     */
    public void toggle() {
        setEnabled(!enabled);
    }

    /**
     * Sets the enabled state and calls appropriate callbacks
     */
    public void setEnabled(boolean enabled) {
        if (this.enabled == enabled) return;

        this.enabled = enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ModuleCategory getCategory() {
        return category;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    /**
     * Gets the Minecraft client instance
     */
    public static MinecraftClient getClient() {
        return MinecraftClient.getInstance();
    }
}
