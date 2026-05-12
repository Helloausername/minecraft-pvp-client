package com.pvpclient.modules;

/**
 * Enum for organizing modules into categories
 */
public enum ModuleCategory {
    COMBAT("Combat"),
    RENDER("Render"),
    MOVEMENT("Movement"),
    MISC("Misc");

    private final String displayName;

    ModuleCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
