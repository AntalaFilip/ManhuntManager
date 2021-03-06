package io.github.antalafilip.ManhuntManager.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class QueueJoinEvent extends Event implements Cancellable {
	private static final HandlerList handlers = new HandlerList();
	private boolean isCancelled = false;
	private Player player;

	public QueueJoinEvent(Player player) {
		this.player = player;
	}
	
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	public static HandlerList getHandlerList() {
	    return handlers;
	}


	public Player getPlayer() {
		return player;
	}


	@Override
	public boolean isCancelled() {
		return isCancelled;
	}


	@Override
	public void setCancelled(boolean cancel) {
		this.isCancelled = cancel; 
	}
}
