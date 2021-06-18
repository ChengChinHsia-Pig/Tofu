package asia.ubb.tofu.framework;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Command implements CommandExecutor {

    private final Map<String, Command> subcommands = new HashMap<>();

    public Command registerSubcommand(String alias, Command subcommand) {
        subcommands.put(alias, subcommand);
        return subcommand;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String alias, String[] args) {
        if (args.length < 1)
            return false;

        Command subcommand = subcommands.get(CommandUtils.formatCommandAlias(args[0]));
        if (subcommand == null)
            return false;

        return subcommand.onCommand(sender, cmd, alias, Arrays.copyOfRange(args, 1, args.length));
    }

}
