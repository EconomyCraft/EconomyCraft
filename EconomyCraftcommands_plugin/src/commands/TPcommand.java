package commands;

import org.bukkit.Location;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;


public class TPcommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		Player p = (Player) sender;
		
		if (sender instanceof ConsoleCommandSender) {
			if (args.length == 1) {
				if (!args[0].equals(p.getName())) {
					@SuppressWarnings("deprecation")
					Player p2 = Bukkit.getServer().getPlayer(args[0]) ;
					if (p2.isOnline()) {
						Location loc = p2.getLocation();
					} else {
						p.sendMessage("Der Spieler ist offline");
					}
				} else {
					p.sendMessage("§cDu kannst dich nicht zu dir selber teleportieren");
				}
			} else {
				p.sendMessage("§cDu musst einen Spielernamen eingeben");
			}
		}
		
		return false;
	}

}
