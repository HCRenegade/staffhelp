package me.renegade.staffhelp.commands;

import me.renegade.staffhelp.StaffHelp;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandList extends SubCommand
{
    public String getName()
    {
        return "list";
    }

    public String[] getAliases()
    {
        return new String[] { "" };
    }

    public void onCommand(CommandSender sender, ArrayList<String> args)
    {
        if (!(sender.hasPermission("staffhelp.list"))) {
            Command.showNoPermissionsMessage(sender);
            return;
        }

        if (!(sender instanceof Player))
        {
            sender.sendMessage(ChatColor.RED + "Only ingame players may use this command.");
            return;
        }
        Player player = (Player)sender;
        ArrayList<Player> staffPlayers = new ArrayList();
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.hasPermission("staffhelp.staffplayer")) {
                staffPlayers.add(p);
            }
        }
        for (String s : StaffHelp.getInstance().getConfig().getStringList("list-message")) {
            if (s.contains("%staffplayers%")) {
                for (Player p : staffPlayers)
                {
                    String cmd = StaffHelp.getInstance().getConfig().getString("on-click-command").replace("%playername%", p.getName());
                    TextComponent staffPlayer = new TextComponent("§7- §6" + p.getName());
                    staffPlayer.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(cmd).color(ChatColor.GOLD).create()));
                    staffPlayer.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, StringUtils.replace(cmd, "%playername%", p.getName())));
                    p.spigot().sendMessage(staffPlayer);
                }
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
            }
        }
    }
}
