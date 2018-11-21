package me.renegade.staffhelp.commands;

import java.util.ArrayList;
import me.renegade.staffhelp.util.ChatUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandHelp
        extends SubCommand
{
    public void onCommand(CommandSender sender, ArrayList<String> args)
    {
        if (!sender.hasPermission("staffhelp.help")) {
            Command.showNoPermissionsMessage(sender);
            return;
        }
        if ((sender instanceof ConsoleCommandSender))
        {
            sendConsoleHelp(sender);
            return;
        }
        sendPlayerHelp((Player)sender);
    }

    private void sendConsoleHelp(CommandSender sender)
    {
        sender.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "----------------------------------------------");
        sender.sendMessage("");
        sender.sendMessage(ChatColor.AQUA + "             Staff" + ChatColor.GRAY + "Help Commands               ");
        sender.sendMessage("");
        sender.sendMessage("§6/staffhelp: §rDisplay the staff list.");
        sender.sendMessage("§6/staffhelp help: §rShows this commands list.");
        sender.sendMessage("§6/staffhelp reload: §rReloads staffhelp's config.");
        sender.sendMessage("");
        sender.sendMessage("§7StaffHelp by Renegade");
        sender.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "----------------------------------------------");
    }

    private void sendPlayerHelp(Player sender)
    {
        ChatUtil.sendCenteredMessage(sender, ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "-----------------------------------------------------");
        sender.sendMessage("");
        ChatUtil.sendCenteredMessage(sender, ChatColor.AQUA + "" + ChatColor.BOLD + "Staff" + ChatColor.GRAY + ChatColor.BOLD + "Help");
        sender.sendMessage("");
        sender.sendMessage("§6/staffhelp: §rDisplay the staff list.");
        sender.sendMessage("§6/staffhelp help: §rShows this commands list.");
        sender.sendMessage("§6/staffhelp reload: §rReloads staffhelp's config.");
        sender.sendMessage("");
        ChatUtil.sendCenteredMessage(sender, "§7§lStaffHelp §r§7by HC_Renegade");
        ChatUtil.sendCenteredMessage(sender, ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "-----------------------------------------------------");
    }

    public String getName()
    {
        return "help";
    }

    public String[] getAliases()
    {
        return new String[] { "h" };
    }
}
