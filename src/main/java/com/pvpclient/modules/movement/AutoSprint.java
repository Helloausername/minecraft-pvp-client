package com.pvpclient.modules.movement;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import com.pvpclient.modules.Module;
import com.pvpclient.modules.ModuleCategory;

/**
 * Auto Sprint - Automatically sprints when moving
 */
public class AutoSprint extends Module {
    public AutoSprint() {
        super("Auto Sprint", "Sprint auto", ModuleCategory.MOVEMENT);
    }

    @Override
    public void onTick() {
        MinecraftClient client = getClient();
        PlayerEntity player = client.player;

        if (player == null) return;

        boolean isMoving = player.input.movementForward > 0 || player.input.movementSideways != 0;

        if (isMoving && !player.isSprinting() && player.getFoodLevel() > 6) {
            player.setSprinting(true);
        }
    }
}
