package asia.ubb.tofu.whitelistcleaner;

import asia.ubb.tofu.framework.*;
import asia.ubb.tofu.whitelistcleaner.commands.TofuWhitelistCleanerCommand;
import asia.ubb.tofu.whitelistcleaner.subcommands.ReloadSubcommand;
import asia.ubb.tofu.whitelistcleaner.tasks.CleanTask;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class TofuWhitelistCleanerPlugin extends JavaPlugin {

    private final File logFile = new File(getDataFolder(), getConfig().getString("logging.file.filename", "log.txt"));
    private ConfigService configService;
    private CommandService commandService;
    private TaskService taskService;
    private LogService logService;
    private PluginService pluginService;

    private void saveLog() {
        try {
            if (!logFile.createNewFile())
                getLogger().warning("Could not save " + logFile.getName() + " because " + logFile.getName() + " already exists.");
        } catch (IOException e) {
            getLogger().log(Level.SEVERE, "Could not save " + logFile.getName() + ".", e);
        }
    }

    private void init() {
        pluginService.registerReloadCallback(() -> {
            taskService.cancelAllTasks();
            configService.reloadConfig(false);
            main();
        });

        configService.saveDefaultConfig();
        saveLog();
    }

    private void main() {
        // load clean interval in ticks because spigot api accept ticks
        long cleanInterval = TimeUtils.parseTicks(
                configService.getConfig().getString("cleaner.interval", "1d"));
        // load offline allowance in seconds because seconds is used in clean task
        long offlineAllowance = TimeUtils.parseSecond(
                configService.getConfig().getString("cleaner.offline-allowance", "3M"));

        logService.info("Clean Interval (Seconds):    %d", cleanInterval / 20);
        logService.info("Offline Allowance (Seconds): %d", offlineAllowance);

        taskService.scheduleTask(
                new CleanTask(this, offlineAllowance, logFile),
                0L, cleanInterval);

        configService.registerReloadConfigCallback(pluginService::reload);

        commandService.registerCommand(
                "tofuwhitelistcleaner",
                new TofuWhitelistCleanerCommand()
                        .registerSubcommand("reload", new ReloadSubcommand(pluginService)));
    }

    @Override
    public void onEnable() {
        configService = new ConfigService(this);
        commandService = new CommandService(this);
        taskService = new TaskService(this);
        logService = new LogService(this);
        pluginService = new PluginService();

        init();
        main();
    }

}
