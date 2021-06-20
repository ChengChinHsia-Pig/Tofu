package asia.ubb.tofu.framework;

import org.bukkit.plugin.java.JavaPlugin;

public class CommandService {

    private final JavaPlugin plugin;

    public CommandService(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public DefaultCommandExecutor registerCommand(String alias, DefaultCommandExecutor executor) {
        plugin.getCommand(alias).setExecutor(executor);
        return executor;
    }

}
