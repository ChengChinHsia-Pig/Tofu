package asia.ubb.tofu.framework.services;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogService {

    private final Logger logger;

    public LogService(JavaPlugin plugin) {
        logger = plugin.getLogger();
    }

    public void setLevel(Level level) {
        logger.setLevel(level);
    }

    public void info(String msg, Object... args) {
        logger.info(String.format(msg, args));
    }

    public void warning(String msg, Object... args) {
        logger.warning(String.format(msg, args));
    }

    public void error(String msg, Object... args) {
        logger.severe(String.format(msg, args));
    }

}
