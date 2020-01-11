package me.renegade.staffhelp.commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.renegade.staffhelp.StaffHelp;

public class Command implements CommandExecutor
{
	private StaffHelp plugin = StaffHelp.getInstance();

	public static final String TAG = "§6[§b§lStaff§7§lHelp§6]";

	public static final String PL_COMMAND = "staffhelp";
	public static final String HELP = "help";
	public static final String LIST = "list";
	public static final String RELOAD = "reload";

	private ArrayList<SubCommand> commands = new ArrayList<>();

	public Command() {
		plugin.getCommand(PL_COMMAND).setExecutor(this);
		this.commands.add(new CommandList());
		this.commands.add(new CommandHelp());
		this.commands.add(new CommandReload());
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
	    if (args.length == 0) {
            this.get(LIST).onCommand(sender, new ArrayList<String>());
        } else {
            if (this.get(args[0]) != null) {
                ArrayList<String> arguments = new ArrayList<>();
                arguments.addAll(Arrays.asList(args));
                arguments.remove(0);
                this.get(args[0]).onCommand(sender, arguments);
            } else {
                sender.sendMessage(TAG+" "+ChatColor.RED+"Command not found");
                sender.sendMessage(TAG+" "+ChatColor.RED+"Try "+ChatColor.GRAY+"/"+PL_COMMAND+" "+ChatColor.YELLOW+HELP);
            }
        }

		return true;
	}

	private SubCommand get(String cmd) {

		for (SubCommand command : this.commands) {
			if (command.getName().equalsIgnoreCase(cmd))
				return command;

			for (int i = 0; i < command.getAliases().length; i++) {
				if (cmd.equalsIgnoreCase(command.getAliases()[i]))
					return command;
			}
		}
		return null;
	}

	public static void showNoPermissionsMessage(CommandSender sender) {
		final String noPermissions = ChatColor.translateAlternateColorCodes('&', StaffHelp.getInstance().getConfig().getString("messages.no-permissions"));
		sender.sendMessage(noPermissions.replace("%player%", sender.getName()));
	}
}
