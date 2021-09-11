package com.github.kqliber.pluginjam.user;

import org.bukkit.OfflinePlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class UserManager {

    private final Map<UUID, User> users = new HashMap<>();

    public User getUser(UUID uuid) {
        final User value = users.get(uuid);
        if (value == null) {
            return users.put(uuid, new User(uuid));
        }
        return value;
    }

    public User getUser(OfflinePlayer player) {
        return getUser(player.getUniqueId());
    }
}
