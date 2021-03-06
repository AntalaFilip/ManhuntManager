package io.github.antalafilip.ManhuntManager;


import java.util.List;

import org.bukkit.entity.Player;

public class QueueManager {
	private final ManhuntManager mhmgr = ManhuntManager.mhmgr;
	
	private List<Player> queue;
	
	public void addToQueue(Player player) {
		if (queue.contains(player)) return;
		else queue.add(player);
		player.sendMessage("You have joined the queue!");
		player.sendMessage("Currently, there are " + (queue.size() - 1) + " more players in the queue");
		queue.forEach((qpl) -> qpl.sendMessage(player.getName() + " has joined the queue. There are " + queue.size() + " players (incl. you) in the queue"));
	}
	
	public void removeFromQueue(Player player) {
		if (!queue.remove(player)) return;
		player.sendMessage("You have left the queue!");
		queue.forEach((qpl) -> qpl.sendMessage(player.getName() + " has left the queue. There are " + queue.size() + " players (incl. you) in the queue"));
	}
	
	public List<Player> getQueue() {
		return this.queue;
	}
}
