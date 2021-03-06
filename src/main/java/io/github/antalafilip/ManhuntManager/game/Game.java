package io.github.antalafilip.ManhuntManager.game;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

import io.github.antalafilip.ManhuntManager.ManhuntManager;

public class Game {
	private World world;
	private Location startLoc;

	private Integer startGrace = 30;
	private Integer gracePeriod = 0;

	private ArrayList<Player> hunters;
	private ArrayList<Player> runners;
	
	private Date startedAt;
	private ArrayList<BukkitTask> tasks;

	private Runnable startHunters = new Runnable() {
		@Override
		public void run() {
			hunters.forEach((player) -> {
				player.teleport(world.getSpawnLocation());
				player.getInventory().clear();
				player.getInventory().addItem(new ItemStack(Material.COMPASS));
				player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, startGrace, 5));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, startGrace, 1));
				player.setMetadata("manhunt-ingame", new FixedMetadataValue(ManhuntManager.mhmgr, true));
				player.setMetadata("manhunt-runner", new FixedMetadataValue(ManhuntManager.mhmgr, false));
			});
		}
	};
	private Runnable startRunners = new Runnable() {
		@Override
		public void run() {
			runners.forEach((player) -> {
				player.teleport(world.getSpawnLocation());
				player.getInventory().clear();
				player.getInventory().addItem(new ItemStack(Material.COMPASS));
				player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, startGrace, 2));
				player.setMetadata("manhunt-ingame", new FixedMetadataValue(ManhuntManager.mhmgr, true));
				player.setMetadata("manhunt-runner", new FixedMetadataValue(ManhuntManager.mhmgr, true));
				player.setMetadata("manhunt-canmove", new FixedMetadataValue(ManhuntManager.mhmgr, false));
			});
		}
	};

	public Game(World world, ArrayList<Player> hunters, ArrayList<Player> runners) {
		this.world = world;
		this.hunters = hunters;
		this.runners = runners;
		Bukkit.getScheduler().runTask(ManhuntManager.mhmgr, startHunters);
		Bukkit.getScheduler().runTask(ManhuntManager.mhmgr, startRunners);
		//TODO send message after grace period ends.
	}

	public Date getStartedAt() {
		return startedAt;
	}

	public ArrayList<Player> getRunners() {
		return runners;
	}

	public ArrayList<Player> getHunters() {
		return hunters;
	}

	public World getWorld() {
		return world;
	}

	public ArrayList<BukkitTask> getTasks() {
		return tasks;
	}

	public void end() {
		//TODO end the game
	}


}
