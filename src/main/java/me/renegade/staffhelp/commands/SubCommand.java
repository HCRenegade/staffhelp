package me.renegade.staffhelp.commands;

import java.util.ArrayList;
import org.bukkit.command.CommandSender;

public abstract class SubCommand
{
    public abstract void onCommand(CommandSender paramCommandSender, ArrayList<String> paramArrayList);

    public abstract String getName();

    public abstract String[] getAliases();
}
