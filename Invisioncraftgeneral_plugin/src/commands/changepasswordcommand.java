package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import main.MainClass;
import methods.registerloginmethods;

public class changepasswordcommand implements CommandExecutor {

	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		Player p = (Player) sender;
		String oldpassword = args[0];
		String npassword1 = args[1];
		String npassword2 = args[2];
		if (sender instanceof ConsoleCommandSender) {
			sender.sendMessage("Du musst ein Spieler sein!");
		} else {
			if (args.length == 3) {
				if (registerloginmethods.isRegistered(p) == true) {
					if (registerloginmethods.loginqueue.contains(p.getName()) == true) {
						if (oldpassword.equals(registerloginmethods.getPassword(p))) {
							if (npassword1.equals(npassword2)) {
								registerloginmethods.changepw(p, npassword1);
								p.sendMessage("§aDein Passwort wurde erfolgreich geändert!");
							} else {
								p.sendMessage("§cDeine neuen Passwörter stimmen nicht überein!");
							}
						} else {
							p.sendMessage("§cDein altes Password stimmt mit dem eingegebenen nicht überein!");
						}
					} else {
						p.sendMessage("§cDu bist noch nicht eingeloggt!");
						p.sendMessage("§cNutze: /login <pw>");
					}
				} else {
					p.sendMessage("§cDu bist noch nicht registriert!");
					p.sendMessage("§c Nutze: /register <pw> <pw>!");
				}
			} else {
				p.sendMessage("§cNutze bitte /changepassword <oldpw> <newpw> <newpw>!");
			}
		}
		return false;
	}

}
