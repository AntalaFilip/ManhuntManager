package io.github.antalafilip.ManhuntManager.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import io.github.antalafilip.CraftManager.commands.CMD;
import io.github.antalafilip.CraftManager.exceptions.NoPermException;
import io.github.antalafilip.ManhuntManager.ManhuntManager;

public class AdminCMD extends CMD {

	public static final String NAME = "Manhunt admin";
	public static final String DESC = "Opens the manhunt admin GUI";
	public static final String PERM = "manhunt.admincmd";
	public static final String USAGE = "/manhuntadmin | /mha [subcommand]";
	public static final String[] SUB;
	
	public AdminCMD(ManhuntManager mhmgr, final CommandSender sender) {
		super(sender, NAME, DESC, PERM, SUB, USAGE);
	}

	@Override
	public void run(CommandSender sender, Command cmd, String label, String[] args) throws NoPermException {
		if (!this.hasPerm()) throw new NoPermException();
	}
	
	static {
		SUB = new String[] {};
	}
	

}
