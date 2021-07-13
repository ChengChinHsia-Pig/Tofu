package asia.ubb.tofu.tablist.listeners;

import asia.ubb.tofu.tablist.utils.LuckPermsUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoinEventListener implements Listener {

    private final String format;

    public PlayerJoinEventListener(Plugin plugin) {
        format = plugin.getConfig().getString("format", "{prefixes}&r {name}");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        StringBuilder prefixBuilder = new StringBuilder();
        for (String prefix : LuckPermsUtils.getUserPrefixes(player.getUniqueId()).values())
            prefixBuilder.append(prefix);

        String result = format
                .replace("{prefixes}", prefixBuilder.toString())
                .replace("{name}", player.getName());

        player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', result));
    }

}
