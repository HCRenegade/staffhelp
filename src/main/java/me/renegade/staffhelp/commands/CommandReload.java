package me.renegade.staffhelp.commands;

import me.renegade.staffhelp.StaffHelp;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class CommandReload extends SubCommand{

    @Override
    public void onCommand(CommandSender sender, ArrayList<String> args) {
        if (!sender.hasPermission("staffhelp.reload")) {
            Command.showNoPermissionsMessage(sender);
            return;
        }

        StaffHelp.getConfigManager().reloadConfig();
        sender.sendMessage(Command.TAG + ChatColor.GREEN+" Config reloaded.");
    }

    @Override
    public String getName() {
        return Command.RELOAD;
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }
}
