package com.pvpclient.modules.render;

import net.minecraft.client.MinecraftClient;
import com.pvpclient.modules.Module;
import com.pvpclient.modules.ModuleCategory;

/**
 * Keystrokes - Displays currently pressed keys
 */
public class Keystrokes extends Module {
    private int x = 10;
    private int y = 10;

    public Keystrokes() {
        super("Keystrokes", "Key display", ModuleCategory.RENDER);
    }

    @Override
    public void onRender() {
        MinecraftClient client = getClient();
        if (client.player == null) return;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
