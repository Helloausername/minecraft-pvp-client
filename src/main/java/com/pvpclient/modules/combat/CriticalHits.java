package com.pvpclient.modules.combat;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import com.pvpclient.modules.Module;
import com.pvpclient.modules.ModuleCategory;

/**
 * Critical Hits - Forces critical hits on attacks
 */
public class CriticalHits extends Module {
    private int critCounter = 0;

    public CriticalHits() {
        super("Criticals", "Force crits", ModuleCategory.COMBAT);
    }

    @Override
    public void onTick() {
        MinecraftClient client = getClient();
        if (client.player == null) return;

        PlayerEntity player = client.player;

        if (player.isAttacking() && player.isOnGround() && !player.isInLava() && !player.isInWater()) {
            player.jump();
            critCounter++;
        }
    }

    public int getCritCount() {
        return critCounter;
    }
}
