package asia.ubb.tofu.tablist;

import asia.ubb.tofu.tablist.listeners.PlayerJoinEventListener;
import org.bukkit.plugin.java.JavaPlugin;

public class TofuTablistPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(this), this);
    }

}
