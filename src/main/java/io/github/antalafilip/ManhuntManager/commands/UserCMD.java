package io.github.antalafilip.ManhuntManager.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import io.github.antalafilip.CraftManager.commands.CMD;
import io.github.antalafilip.CraftManager.exceptions.InvalidArgumentException;
import io.github.antalafilip.CraftManager.exceptions.InvalidItemException;
import io.github.antalafilip.CraftManager.exceptions.InvalidModifierException;
import io.github.antalafilip.CraftManager.exceptions.NeAException;
import io.github.antalafilip.CraftManager.exceptions.NoPermException;
import io.github.antalafilip.CraftManager.exceptions.NotPlayerException;
import io.github.antalafilip.CraftManager.exceptions.NullWorldException;
import io.github.antalafilip.CraftManager.exceptions.PNOException;
import io.github.antalafilip.CraftManager.exceptions.PlayerImmuneException;
import io.github.antalafilip.CraftManager.exceptions.StrNotIntException;
import io.github.antalafilip.CraftManager.exceptions.TmAException;
import io.github.antalafilip.ManhuntManager.ManhuntManager;
import io.github.antalafilip.ManhuntManager.events.QueueJoinEvent;

public class UserCMD extends CMD {

	public static final String NAME = "Manhunt";
	public static final String DESC = "Opens the manhunt GUI";
	public static final String PERM = "manhunt.usercmd";
	public static final String USAGE = "/manhunt | /mh [subcommand]";
	public static final String[] SUB;
	
	public UserCMD(ManhuntManager mhmgr, final CommandSender sender) {
		super(sender, NAME, DESC, PERM, SUB, USAGE);
	}

	@Override
	public void run(CommandSender sender, Command cmd, String label, String[] args) throws NoPermException, NotPlayerException {
		if (!this.hasPerm()) throw new NoPermException();
		if (args.length == 0) {
			// TODO open gui
		}
		if (args.length == 1) {
			switch(args[0].toLowerCase()) {
			case "join":
				if (!this.isPlayer()) throw new NotPlayerException();
				
				break;
			case "leave":
				// TODO leave queue
				break;
			}
		}
	}
	
	static {
		SUB = new String[] {};
	}
}
