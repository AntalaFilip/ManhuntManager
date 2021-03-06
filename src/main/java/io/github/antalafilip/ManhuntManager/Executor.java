package io.github.antalafilip.ManhuntManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
		
		//TODO Start game
	}
	
	@EventHandler
	public void onGameStarted(ManhuntStartedEvent event) {
		//TODO actions after the game has started
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		//TODO check if was in an ongoing game
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		//TODO remove player from queue or remove from game if in one
	}
}
