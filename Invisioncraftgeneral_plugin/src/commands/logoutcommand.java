package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import methods.registerloginmethods;

public class logoutcommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alable, String[] args) {
		Player p = (Player) sender;
		if (sender instanceof ConsoleCommandSender) {
			sender.sendMessage("Du musst ein Spieler sein!");
		} else {
			if (registerloginmethods.isRegistered(p) == true) {
				if (registerloginmethods.loginqueue.contains(p.getName()) == true) {
					p.sendMessage("§aErfolgreich Ausgelogged!");
					registerloginmethods.loginqueue.remove(p.getName());
				} else {
					p.sendMessage("§cDu bist nicht eingeloggt!");
					p.sendMessage("§cNutze: /login <pw>");
				}
			} else {
				
				p.sendMessage("§cDu bist noch nicht registriert!");
				p.sendMessage("§cNutze: /register <pw> <pw>");
			}
		}
		return false;
	}

}
