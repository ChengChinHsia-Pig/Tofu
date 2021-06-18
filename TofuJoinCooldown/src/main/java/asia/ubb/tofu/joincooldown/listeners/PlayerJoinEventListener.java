package asia.ubb.tofu.joincooldown.listeners;

import asia.ubb.tofu.joincooldown.services.CooldownService;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PlayerJoinEventListener implements Listener {

    private final long cooldownSecond;

    public PlayerJoinEventListener(long cooldownSecond) {
        this.cooldownSecond = cooldownSecond;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        LocalDateTime playerOfflineTime = CooldownService.getPlayerOfflineTime(player);
        if (playerOfflineTime != null) {
            if (playerOfflineTime.until(LocalDateTime.now(), ChronoUnit.SECONDS) >= cooldownSecond) {
                CooldownService.removePlayerOfflineTime(event.getPlayer());
            } else {
                player.kickPlayer(String.format("Please wait %d seconds before joining the server again!", cooldownSecond));
            }
        }
    }

}
