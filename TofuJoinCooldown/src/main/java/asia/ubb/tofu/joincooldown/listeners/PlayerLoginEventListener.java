package asia.ubb.tofu.joincooldown.listeners;

import asia.ubb.tofu.joincooldown.services.CooldownService;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PlayerLoginEventListener implements Listener {

    private final long cooldownSecond;

    public PlayerLoginEventListener(long cooldownSecond) {
        this.cooldownSecond = cooldownSecond;
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        LocalDateTime playerOfflineTime = CooldownService.getPlayerOfflineTime(player);
        if (playerOfflineTime != null) {
            if (playerOfflineTime.until(LocalDateTime.now(), ChronoUnit.SECONDS) >= cooldownSecond) {
                CooldownService.removePlayerOfflineTime(event.getPlayer());
            } else {
                event.disallow(PlayerLoginEvent.Result.KICK_OTHER, String.format("Please wait %d seconds before joining the server again!", cooldownSecond));
            }
        }
    }

}
