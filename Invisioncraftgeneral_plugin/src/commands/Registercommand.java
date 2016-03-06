package commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import main.MainClass;
import methods.registerloginmethods;



public class Registercommand implements CommandExecutor {

	

	public Registercommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if (sender instanceof  ConsoleCommandSender) {
			sender.sendMessage("Du musst ein Spieler sein!");
			return true;
		}
		Player p = (Player) sender;
		
		if(args.length == 2) {  
			if(registerloginmethods.isRegistered(p)) {
				p.sendMessage("Du bist bereits registriert");
				return true;
			}
			String password1 = args[0];
			String password2 = args[1];
			if (password1.equals(password2)) {
				registerloginmethods.register(p, password1);
				p.sendMessage("ßaDu hast dich erfolgreich registriert!! Viel Spaﬂ!!!");
				p.sendMessage("ßeDu musst dich nun noch einloggen!");
			} else {
				
			}
					
		} else {
			p.sendMessage("ßcNutze /register <pw> <pw>");
		}
		return true;
	}
		
	
}
