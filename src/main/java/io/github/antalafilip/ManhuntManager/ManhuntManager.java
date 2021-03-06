package io.github.antalafilip.ManhuntManager;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ManhuntManager extends JavaPlugin {
	
	private ManhuntManager mhmgr;
	private Executor executor;
	private Logger lgr = Bukkit.getLogger();
	
	public void onEnable() {
		mhmgr = this;
		executor = new Executor();
		this.saveDefaultConfig();
		lgr.info("Enabled ManhuntManager!");
		Bukkit.getPluginManager().registerEvents(executor, mhmgr);
	}
	
	public void onDisable() {
		mhmgr = null;
	}
}
