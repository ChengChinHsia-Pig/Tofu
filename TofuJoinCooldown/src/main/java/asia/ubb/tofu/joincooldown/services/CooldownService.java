package asia.ubb.tofu.joincooldown.services;

import org.bukkit.entity.Player;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownService {

    private static final Map<UUID, LocalDateTime> playerOfflineTimeMap = new HashMap<>();

    private CooldownService() {
    }

    public static void setPlayerOfflineTime(Player player, LocalDateTime dateTime) {
        playerOfflineTimeMap.put(player.getUniqueId(), dateTime);
    }

    public static LocalDateTime getPlayerOfflineTime(Player player) {
        return playerOfflineTimeMap.get(player.getUniqueId());
    }

    public static void removePlayerOfflineTime(Player player) {
        playerOfflineTimeMap.remove(player.getUniqueId());
    }

}
