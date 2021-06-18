package asia.ubb.tofu.framework;

import org.bukkit.plugin.java.JavaPlugin;

public class TaskService {

    private final JavaPlugin plugin;

    public TaskService(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public int scheduleTask(Runnable task, long delay, long interval) {
        return plugin.getServer().getScheduler().scheduleSyncRepeatingTask(
                plugin, task, delay, interval);
    }

}
