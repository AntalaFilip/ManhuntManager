package io.github.antalafilip.ManhuntManager.events;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ManhuntStartEvent extends Event implements Cancellable {
	private static final HandlerList handlers = new HandlerList();
	
	private boolean isCancelled = false;
	private CommandSender initiator;
	private List<Player> hunters;
	private List<Player> runners;
	
	public ManhuntStartEvent(CommandSender initiator, List<Player> hunters, List<Player> runners) {
		this.initiator = initiator;
		this.hunters = hunters;
		this.runners = runners;
	}

	public List<Player> getRunners() {
		return runners;
	}

	public List<Player> getHunters() {
		return hunters;
	}

	public CommandSender getInitiator() {
		return initiator;
	}

	@Override
	public boolean isCancelled() {
		return isCancelled;
	}

	@Override
	public void setCancelled(boolean cancel) {
		this.isCancelled = cancel;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	public static HandlerList getHandlerList() {
	    return handlers;
	}

}
