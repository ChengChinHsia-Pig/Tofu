package asia.ubb.tofu.whitelistcleaner.subcommands;

import asia.ubb.tofu.framework.Command;
import asia.ubb.tofu.framework.PluginService;
import org.bukkit.command.CommandSender;

public class ReloadSubcommand extends Command {

    private final PluginService pluginService;

    public ReloadSubcommand(PluginService pluginService) {
        this.pluginService = pluginService;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String alias, String[] args) {
        pluginService.reload();

        return true;
    }

}
