package asia.ubb.tofu.whitelistcleaner;

import asia.ubb.tofu.framework.ConfigService;
import asia.ubb.tofu.framework.TaskService;
import asia.ubb.tofu.framework.TimeUtils;
import asia.ubb.tofu.whitelistcleaner.tasks.CleanTask;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class TofuWhitelistCleanerPlugin extends JavaPlugin {

    private final File logFile = new File(getDataFolder(), getConfig().getString("logging.file.filename", "log.txt"));

    private void saveLog() {
        try {
            if (!logFile.createNewFile())
                getLogger().warning("Could not save " + logFile.getName() + " because " + logFile.getName() + " already exists.");
        } catch (IOException e) {
            getLogger().log(Level.SEVERE, "Could not save " + logFile.getName() + ".", e);
        }
    }

    @Override
    public void onEnable() {
        // save default config
        saveDefaultConfig();
        // save cleaner log file
        saveLog();

        ConfigService configService = new ConfigService(this);
        long cleanInterval = TimeUtils.parseTicks(
                configService.getConfig().getString("cleaner.interval", "1d"));
        long offlineAllowance = TimeUtils.parseTicks(
                configService.getConfig().getString("cleaner.offline-allowance", "3M"));

        // print clean interval and offline allowance to console
        getLogger().info("Clean Interval (Seconds):         " + cleanInterval / 20);
        getLogger().info("Offline Before Clean (Seconds):   " + offlineAllowance / 20);

        TaskService taskService = new TaskService(this);
        taskService.scheduleTask(
                new CleanTask(this, offlineAllowance, logFile),
                0L, cleanInterval);
    }

}
