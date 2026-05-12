package com.pvpclient.modules.render;

import com.pvpclient.modules.Module;
import com.pvpclient.modules.ModuleCategory;

/**
 * Custom Crosshair - Renders a custom crosshair
 */
public class Crosshair extends Module {
    private int color = 0xFFFFFF;
    private float size = 10.0f;

    public Crosshair() {
        super("Crosshair", "Custom crosshair", ModuleCategory.RENDER);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setSize(float size) {
        this.size = Math.max(5.0f, Math.min(30.0f, size));
    }

    public int getColor() {
        return color;
    }

    public float getSize() {
        return size;
    }
}
