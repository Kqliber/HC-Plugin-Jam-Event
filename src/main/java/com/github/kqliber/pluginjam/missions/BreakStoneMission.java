package com.github.kqliber.pluginjam.missions;

import com.github.kqliber.pluginjam.user.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class BreakStoneMission implements Mission {

    private int progress = 0;
    private final int completionAmount;

    public BreakStoneMission(final int completionAmount) {
        this.completionAmount = completionAmount;
    }

    @Override
    public int getProgress() {
        return progress;
    }

    @Override
    public void setProgress(final int progress) {
        this.progress += progress;
    }

    @Override
    public int getCompletionAmount() {
        return completionAmount;
    }

    @Override
    public void onComplete(final User user) {
        user.missions().remove(this);
        final Player player = (Player) user.getPlayer();
        player.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 3));
    }
}
