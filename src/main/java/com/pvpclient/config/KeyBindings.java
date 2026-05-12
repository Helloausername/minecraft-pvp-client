package com.pvpclient.config;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

/**
 * Manages all keybindings for the client
 */
public class KeyBindings {
    public static KeyBinding toggleGUI;
    public static KeyBinding toggleModule;

    public void registerKeyBindings() {
        toggleGUI = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.pvpclient.toggle_gui",
                InputUtil.Type.KEYSYM,
                InputUtil.GLFW_KEY_RIGHT_SHIFT,
                "category.pvpclient.main"
        ));

        toggleModule = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.pvpclient.toggle_module",
                InputUtil.Type.KEYSYM,
                InputUtil.GLFW_KEY_M,
                "category.pvpclient.main"
        ));
    }

    public KeyBinding getToggleGUIBinding() {
        return toggleGUI;
    }

    public KeyBinding getToggleModuleBinding() {
        return toggleModule;
    }
}
