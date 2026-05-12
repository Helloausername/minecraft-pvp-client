package com.pvpclient.modules.movement;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import com.pvpclient.modules.Module;
import com.pvpclient.modules.ModuleCategory;

/**
 * No Fall - Negates fall damage
 */
public class NoFall extends Module {
    public NoFall() {
        super("No Fall", "No fall dmg", ModuleCategory.MOVEMENT);
    }

    @Override
    public void onTick() {
        MinecraftClient client = getClient();
        PlayerEntity player = client.player;

        if (player == null) return;

        if (player.fallDistance > 3) {
            player.setOnGround(true);
            player.fallDistance = 0;
        }
    }
}
