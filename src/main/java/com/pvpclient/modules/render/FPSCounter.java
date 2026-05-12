package com.pvpclient.modules.render;

import com.pvpclient.modules.Module;
import com.pvpclient.modules.ModuleCategory;

/**
 * FPS Counter - Displays current FPS
 */
public class FPSCounter extends Module {
    private int fps = 0;
    private long lastUpdateTime = 0;
    private int frameCount = 0;

    public FPSCounter() {
        super("FPS", "Show fps", ModuleCategory.RENDER);
    }

    @Override
    public void onRender() {
        long currentTime = System.currentTimeMillis();
        frameCount++;

        if (currentTime - lastUpdateTime >= 1000) {
            fps = frameCount;
            frameCount = 0;
            lastUpdateTime = currentTime;
        }
    }

    public int getFPS() {
        return fps;
    }
}
