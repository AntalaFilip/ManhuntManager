package io.github.antalafilip.ManhuntManager.game.events;

import org.bukkit.command.CommandSender;

import io.github.antalafilip.ManhuntManager.game.Game;

public abstract class GameEvent {
	
	private String NAME;
	private String DESC;
	
	public GameEvent(String name, String description) {
		this.NAME = name;
		this.DESC = description;
	}
	
	public abstract void run(Game game, CommandSender initiator);
	
}