package com.github.kqliber.pluginjam.user;

import com.github.kqliber.pluginjam.missions.Mission;
import org.bukkit.OfflinePlayer;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record User(UUID uuid, List<Mission> missions) {

    public User(UUID uuid, List<Mission> missions) {
        this.uuid = uuid;
        this.missions = missions;
    }

    public User(UUID uuid) {
        this(uuid, new ArrayList<>());
    }

    public OfflinePlayer getPlayer() {
        return Bukkit.getOfflinePlayer(uuid);
    }
}
