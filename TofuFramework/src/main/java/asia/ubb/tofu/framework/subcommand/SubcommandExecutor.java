package asia.ubb.tofu.framework.subcommand;

import org.bukkit.command.CommandSender;

public interface SubcommandExecutor {

    boolean onSubcommand(CommandSender sender, Subcommand subcmd, String alias, String[] args);

}
