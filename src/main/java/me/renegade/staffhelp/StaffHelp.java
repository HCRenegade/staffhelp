package me.renegade.staffhelp;

import me.renegade.staffhelp.commands.Command;
import me.renegade.staffhelp.manager.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffHelp extends JavaPlugin
{
    private static StaffHelp staffHelp;
    private static ConfigManager cfgManager;
    private Command command;

    public void onEnable()
    {
        staffHelp = this;
        cfgManager = new ConfigManager();
        this.command = new Command();
    }

    public void onDisable() {}

    public static StaffHelp getInstance()
    {
        return staffHelp;
    }

    public static ConfigManager getConfigManager()
    {
        return cfgManager;
    }
}