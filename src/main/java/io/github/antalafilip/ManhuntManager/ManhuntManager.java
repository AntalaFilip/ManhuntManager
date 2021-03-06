package io.github.antalafilip.ManhuntManager;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.antalafilip.CraftManager.CraftManager;

public class ManhuntManager extends JavaPlugin {
	
	public static ManhuntManager mhmgr;
	private Executor executor;
	private Logger lgr = Bukkit.getLogger();
	
	public void onEnable() {
		CraftManager craft = (CraftManager) Bukkit.getPluginManager().getPlugin("CraftManager");
		if (craft == null || !craft.isEnabled()) {
			lgr.severe("CraftManager not found!");
			lgr.severe("This plugin requires CraftManager to function, disabling");
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
		mhmgr = this;
		executor = new Executor();
		this.saveDefaultConfig();
		lgr.info("Enabled ManhuntManager!");
		Bukkit.getPluginManager().registerEvents(executor, mhmgr);
	}
	
	public void onDisable() {
		mhmgr = null;
	}
	
	static {
		mhmgr = null;
	}
}
