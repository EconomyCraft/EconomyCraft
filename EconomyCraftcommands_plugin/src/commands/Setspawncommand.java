package commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Setspawncommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		Player p = (Player) sender;
		if (!(sender instanceof ConsoleCommandSender)) {
			if (args.length == 1) {
				String name = args[0];
				if (isSpawned(name, p) == false) {
					int blockX = p.getLocation().getBlockX();
					int blockY = p.getLocation().getBlockY();
					int blockZ = p.getLocation().getBlockZ();
					
					setspawn(blockX, blockY, blockZ, name, p);	
				} else {
					p.sendMessage("Der Name ist schon vergeben!");
				}
						
			} else {
				p.sendMessage("§cDu hast keinen Spawnnamen gewählt");
			}
		} else {
			sender.sendMessage("Du musst ein Spieler sein!");
		}
		return false;
	}
	
	public void setspawn(int blockX, int blockY, int blockZ, String name, Player p) {
		File dir = new File("plugins//EconomyCraftCommands");
		File file = new File("plugins//EconomyCraftCommands//Spawns");
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set(name, blockX + blockZ + blockY);
			
	
		
	}
	
	public boolean isSpawned(String name, Player p) {
		boolean isListed = false;
		File dir = new File("plugins//EconomyCraftCommands");
		File file = new File("plugins//EconomyCraftCommands//Spawns");
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (cfg.contains(name)) {
			
			isListed = true;
		} else {
			isListed = false;
		}
		
		return isListed;
	}
}
