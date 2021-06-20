package asia.ubb.tofu.whitelistcleaner.commands;

import asia.ubb.tofu.framework.DefaultCommandExecutor;
import asia.ubb.tofu.framework.PluginService;
import asia.ubb.tofu.framework.Subcommand;
import org.bukkit.command.CommandSender;

public class TofuWhitelistCleanerCommand extends DefaultCommandExecutor {

    private final PluginService pluginService;

    public TofuWhitelistCleanerCommand(PluginService pluginService) {
        this.pluginService = pluginService;

        setSubcommandExecutor("reload", this::runReload);
    }

    private boolean runReload(CommandSender sender, Subcommand subcmd, String alias, String[] args) {
        pluginService.reload();

        return true;
    }

}
