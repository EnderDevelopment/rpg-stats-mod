package com.agatsumazenitsu51000.levellmod.event;

import com.agatsumazenitsu51000.levellmod.capability.PlayerStats;
import com.agatsumazenitsu51000.levellmod.capability.PlayerStatsProvider;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public
class PlayerEvents {
    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        player.getCapability(PlayerStatsProvider.PLAYER_STATS_CAPABILITY).ifPresent(stats -> {
            if (stats.getLevel() == 0) {
                stats.setLevel(1);
                stats.setStatPoints(5);
            }
        });
    }
}
