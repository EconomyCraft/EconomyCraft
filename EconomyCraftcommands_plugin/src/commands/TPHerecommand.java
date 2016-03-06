package commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public  class TPHerecommand implements CommandExecutor {

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		Player p = (Player) sender;
		if (sender instanceof ConsoleCommandSender) {
			if (args.length == 1) {
				if(!args[0].equals(p.getName())) {
					@SuppressWarnings("deprecation")
					Player p2 = Bukkit.getPlayer(args[0]);
					Location loc = p.getLocation();
					p2.teleport(loc);
					p.sendMessage("§2Der Spieler §e" + p2.getName() + "§2wurde erfolgreich zu dir teleportiert!");
					p2.sendMessage("Du §2wurdest erfolgreich zu §e" + p.getName() + "teleportiert!");
				}
			} else {
				p.sendMessage("§cDu musst einen Spielernamen eingeben!");
			}
		} else {
			p.sendMessage("§cDu musst ein Spieler sein!");
		}
		return false;
	}

}
