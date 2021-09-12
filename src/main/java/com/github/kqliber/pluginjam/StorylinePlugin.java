package com.github.kqliber.pluginjam;

import com.github.kqliber.pluginjam.listeners.BreakStoneMissionListener;
import com.github.kqliber.pluginjam.user.UserManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class StorylinePlugin extends JavaPlugin {

    private final UserManager userManager = new UserManager();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BreakStoneMissionListener(this), this);
    }

    public UserManager getUserManager() {
        return userManager;
    }
}
