package com.pvpclient.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.render.GameRenderer;

import com.pvpclient.PvPClient;

/**
 * Mixin for render event
 */
@Mixin(GameRenderer.class)
public class RenderMixin {
    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(float tickDelta, long startTime, boolean tick, CallbackInfo ci) {
        if (PvPClient.moduleManager != null) {
            PvPClient.moduleManager.onRender();
        }
    }
}
