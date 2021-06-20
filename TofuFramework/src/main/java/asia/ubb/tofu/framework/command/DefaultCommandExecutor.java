package asia.ubb.tofu.framework.command;

import asia.ubb.tofu.framework.utils.CommandUtils;
import asia.ubb.tofu.framework.subcommand.Subcommand;
import asia.ubb.tofu.framework.subcommand.SubcommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DefaultCommandExecutor implements CommandExecutor {

    private final Map<String, SubcommandExecutor> subcommandExecutors = new HashMap<>();

    public void setSubcommandExecutor(String alias, SubcommandExecutor executor) {
        subcommandExecutors.put(CommandUtils.formatCommandAlias(alias), executor);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
        if (args.length < 1)
            return false;

        SubcommandExecutor executor = subcommandExecutors.get(CommandUtils.formatCommandAlias(args[0]));
        if (executor == null)
            return false;

        return executor.onSubcommand(sender, new Subcommand(), args[1], Arrays.copyOfRange(args, 1, args.length));
    }

}
