package commands;



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import org.bukkit.entity.Player;

import main.MainClass;
import methods.registerloginmethods;



public class Logincommand implements CommandExecutor {
				

	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) {
			sender.sendMessage("Du musst ein Spieler sein");
			return true;
		}
		
		Player p = (Player) sender;
		
		if (args.length == 1) {
			if (registerloginmethods.isRegistered(p) == true) {
				if (registerloginmethods.loginqueue.contains(p.getName()) == false) {
					if (registerloginmethods.getPassword(p).equals(args[0])) {
						p.sendMessage("§aDu bist nun eingeloggt");
						registerloginmethods.loginqueue.add(p.getName());
						
					} else {
						p.sendMessage("§cFalsches Passwort! Zwei Versuche übrig!");
					}
				} else {
					p.sendMessage("§cDu bist bereits eingeloggt!");
				}
			} else {
				p.sendMessage("$cDu bist noch nicht registriert!");
			}
			
		} else {
			p.sendMessage("§cDu musst ein Passwort eingeben!");
		}
		return true;
	}

	
	}