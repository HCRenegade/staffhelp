package me.renegade.staffhelp.manager;

import me.renegade.staffhelp.StaffHelp;

public class ConfigManager {

	private StaffHelp staffHelp = StaffHelp.getInstance();
	
	public ConfigManager() {
		staffHelp.getConfig().options().copyDefaults(true);
		staffHelp.saveConfig();
	}
	
	public void reloadConfig() {
		staffHelp.reloadConfig();
	}

}