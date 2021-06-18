package asia.ubb.tofu.framework;

import org.bukkit.plugin.java.JavaPlugin;

public class CommandService {

    private final JavaPlugin plugin;

    public CommandService(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public Command registerCommand(String alias, Command command) {
        plugin.getCommand(alias).setExecutor(command);
        return command;
    }

}
