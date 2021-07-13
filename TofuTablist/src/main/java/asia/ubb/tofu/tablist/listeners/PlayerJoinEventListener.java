package asia.ubb.tofu.tablist.listeners;

import asia.ubb.tofu.tablist.utils.LuckPermsUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEventListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        StringBuilder prefixBuilder = new StringBuilder();
        for (String prefix : LuckPermsUtils.getUserPrefixes(player.getUniqueId()).values())
            prefixBuilder.append(prefix);

        player.setPlayerListName(
                ChatColor.translateAlternateColorCodes(
                        '$', prefixBuilder + player.getName()));
    }

}
