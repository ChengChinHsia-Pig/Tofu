package asia.ubb.tofu.framework;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;

public class TaskService {

    private final JavaPlugin plugin;

    public TaskService(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public int scheduleTask(Runnable task, long delay, long interval) {
        return plugin.getServer().getScheduler().scheduleSyncRepeatingTask(
                plugin, task, delay, interval);
    }

    public void cancelTask(int id) {
        plugin.getServer().getScheduler().cancelTask(id);
    }

    public void cancelAllTasks() {
        List<BukkitTask> tasks = getPendingTasks();
        for (BukkitTask task : tasks) {
            task.cancel();
        }
    }

    public List<BukkitTask> getPendingTasks() {
        return plugin.getServer().getScheduler().getPendingTasks();
    }

}
