package io.github.antalafilip.ManhuntManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import io.github.antalafilip.CraftManager.CraftLogger;
import io.github.antalafilip.CraftManager.CraftManager;
import io.github.antalafilip.CraftManager.commands.CMD;
import io.github.antalafilip.CraftManager.enums.PrefixLevel;
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
import io.github.antalafilip.ManhuntManager.commands.AdminCMD;
import io.github.antalafilip.ManhuntManager.commands.UserCMD;

public class CmdHandler implements CommandExecutor {
	
	CraftManager craft = CraftManager.craft;
	ManhuntManager mhmgr = ManhuntManager.mhmgr;

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		CMD cmd = null;
		if (command.getName().equalsIgnoreCase("mh") || command.getName().equalsIgnoreCase("manhunt")) {
			cmd = new UserCMD(mhmgr, sender);
		}
		else if (command.getName().equalsIgnoreCase("mha") || command.getName().equalsIgnoreCase("manhuntadmin")) {
			cmd = new AdminCMD(mhmgr, sender);
		}

		try {
			cmd.run(sender, command, label, args);
			CraftLogger.LogCmd(sender, command, label, args);
		}
		catch (NeAException e) {
			sender.sendMessage(craft.getMessager().format(PrefixLevel.ERROR, "exception.nea"));
			cmd.sendUsage();
			CraftLogger.LogCmd("Not enough arguments", sender, command, label, args);
		}
		catch (TmAException e) {
			sender.sendMessage(craft.getMessager().format(PrefixLevel.ERROR, "exception.tma"));
			cmd.sendUsage();
			CraftLogger.LogCmd("Too many arguments", sender, command, label, args);
		}
		catch (NoPermException e) {
			sender.sendMessage(craft.getMessager().format(PrefixLevel.ERROR, "exception.noperm", cmd.getPermission(), cmd.getName()));
			CraftLogger.LogCmd("No permission", sender, command, label, args);
		}
		catch (NotPlayerException e) {
			sender.sendMessage(craft.getMessager().format(PrefixLevel.ERROR, "exception.notplayer"));
			CraftLogger.LogCmd("Not player", sender, command, label, args);
		}
		catch (PNOException e) {
			sender.sendMessage(craft.getMessager().format(PrefixLevel.ERROR, "exception.playernotonline", e.getMessage()));
			cmd.sendUsage();
			CraftLogger.LogCmd("Player not online", sender, command, label, args);
		}
		catch (PlayerImmuneException e) {
			sender.sendMessage(craft.getMessager().format(PrefixLevel.ERROR, "exception.playerimmune", e.getMessage()));
			CraftLogger.LogCmd("Player immune", sender, command, label, args);
		}
		catch (InvalidItemException e) {
			sender.sendMessage(craft.getMessager().format(PrefixLevel.ERROR, "exception.invaliditem", e.getMessage()));
			cmd.sendUsage();
			CraftLogger.LogCmd("Invalid item", sender, command, label, args);
		}
		catch (StrNotIntException e) {
			sender.sendMessage(craft.getMessager().format(PrefixLevel.ERROR, "exception.strnotint", e.getMessage()));
			cmd.sendUsage();
			CraftLogger.LogCmd("String not Integer", sender, command, label, args);
		}
		catch (InvalidModifierException e) {
			sender.sendMessage(craft.getMessager().format(PrefixLevel.ERROR, "exception.invalidmodifier", e.getMessage()));
			cmd.sendUsage();
			CraftLogger.LogCmd("Invalid modifier", sender, command, label, args);
		}
		catch (NullWorldException e) {
			sender.sendMessage(craft.getMessager().format(PrefixLevel.ERROR, "exception.nullworld", e.getMessage()));
			cmd.sendUsage();
			CraftLogger.LogCmd("Null world", sender, command, label, args);
		}
		catch (InvalidArgumentException e) {
			sender.sendMessage(craft.getMessager().format(PrefixLevel.ERROR, "exception.invalidargument", e.getMessage()));
			cmd.sendUsage();
			CraftLogger.LogCmd("Invalid argument", sender, command, label, args);
		}
		return true;
	}
	
}
