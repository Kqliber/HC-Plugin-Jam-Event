package com.github.kqliber.pluginjam.listeners;

import com.github.kqliber.pluginjam.StorylinePlugin;
import com.github.kqliber.pluginjam.missions.BreakStoneMission;
import com.github.kqliber.pluginjam.missions.Mission;
import com.github.kqliber.pluginjam.user.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Optional;

public final class BreakStoneMissionListener implements Listener {

    private final StorylinePlugin plugin;

    public BreakStoneMissionListener(final StorylinePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreak(final BlockBreakEvent event) {
        if (event.getBlock().getBlockData().getMaterial() != Material.STONE) {
            return;
        }

        final Player player = event.getPlayer();
        final User user = plugin.getUserManager().getUser(player);
        final Optional<Mission> optional = user.missions().stream()
                .filter(m -> m instanceof BreakStoneMission)
                .findFirst();

        if (optional.isEmpty()) {
            return; // player doesn't have mission active
        }

        final Mission mission = optional.get();
        final int progress = mission.getProgress();
        if (progress >= mission.getCompletionAmount()) {
            mission.onComplete(user); // mission complete
            return;
        }
        mission.setProgress(progress + 1);
        player.sendMessage("advanced progress of mission to " + progress + "/" + mission.getCompletionAmount());
    }
}
