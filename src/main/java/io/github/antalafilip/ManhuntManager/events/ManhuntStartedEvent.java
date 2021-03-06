package io.github.antalafilip.ManhuntManager.events;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ManhuntStartedEvent extends Event {
	private static final HandlerList handlers = new HandlerList();
	
	private CommandSender initiator;
	private List<Player> hunters;
	private List<Player> runners;
	
	public ManhuntStartedEvent(CommandSender initiator, List<Player> hunters, List<Player> runners) {
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
	public HandlerList getHandlers() {
		return handlers;
	}
	public static HandlerList getHandlerList() {
	    return handlers;
	}

}
