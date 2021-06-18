package asia.ubb.tofu.joincooldown;

import asia.ubb.tofu.framework.TimeUtils;
import asia.ubb.tofu.joincooldown.listeners.PlayerJoinEventListener;
import asia.ubb.tofu.joincooldown.listeners.PlayerQuitEventListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class TofuJoinCooldownPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        FileConfiguration config = getConfig();
        String cooldownTimeString = config.getString("cooldown", "10s");
        long cooldownSecond = TimeUtils.parseSecond(cooldownTimeString);

        getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(cooldownSecond), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitEventListener(), this);
    }

}
