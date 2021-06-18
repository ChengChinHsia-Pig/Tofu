package asia.ubb.tofu.framework;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class ConfigService {

    private final JavaPlugin plugin;
    private List<Runnable> reloadCallbacks;

    public ConfigService(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerReloadCallback(Runnable callback) {
        reloadCallbacks.add(callback);
    }

    public void reload() {
        plugin.reloadConfig();

        for (Runnable reloadCallback : reloadCallbacks)
            reloadCallback.run();
    }

    public FileConfiguration getConfig() {
        return plugin.getConfig();
    }

}
