package io.github.antalafilip.ManhuntManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import io.github.antalafilip.ManhuntManager.events.ManhuntStartEvent;
import io.github.antalafilip.ManhuntManager.events.ManhuntStartedEvent;

public class Executor implements Listener {
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onGameStart(ManhuntStartEvent event) {
		if (event.isCancelled()) {
			event.getHunters().forEach((player) -> player.sendMessage("The game was forcibly cancelled by an administrator!"));
			event.getRunners().forEach((player) -> player.sendMessage("The game was forcibly cancelled by an administrator!"));
			event.getInitiator().sendMessage("The game was forcibly cancelled by an administrator!");
			return;
		}
		
		
	}
	
	@EventHandler
	public void onGameStarted(ManhuntStartedEvent event) {
		
	}
}
