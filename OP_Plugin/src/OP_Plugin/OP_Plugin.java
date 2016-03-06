package OP_Plugin;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class OP_Plugin extends JavaPlugin implements Listener {

	public void onEnable() {
		System.out.println("[OP_Plugin wurde gestartet]");
		this.getServer().getPluginManager().registerEvents(this, this);
	}
		
	public void onDisable() {
		System.out.println("[OP_Plugin wurde gestartet]");
	}
	
	@SuppressWarnings("deprecated")
	public boolean onCommand(CommandSender sender, Command command, String lable, String[] args ) {
		
		Player p = (Player) sender;
		int x1 = 0, y1 = 0,z1 = 0;
		int x2 = 0,y2 = 0,z2 = 0;
		
		if(command.getName().equalsIgnoreCase("heal")) {
			if(p.isOp()) {
				if(args.length == 0) {
					p.setHealth(20);
					p.setFoodLevel(20);
					p.sendMessage("§2Du wurdest geheilt!");
				} //end if args == 0
				
				if(args.length == 1) {
					Player p2 = getServer().getPlayer(args[0]);
					p2.setHealth(20);
					p2.setFoodLevel(20);
					p.sendMessage("§2Du hast den Spieler " + ChatColor.DARK_GREEN + p2.getName() + "§2 erfolgreich geheilt!");
					p2.sendMessage("§2Der Spieler " + ChatColor.DARK_GREEN + p.getName() + ("§2 hat dich geheilt!"));
				} // end if args == 1
				return true;
			} // end if isOP
		} //end if /heal
		
		if(command.getName().equalsIgnoreCase("kill")) {
			if(p.isOp()) {
				if(args.length == 0) {
					p.setHealth(0);
					p.sendMessage("§4Du hast dich selbst umgebracht!");
					Bukkit.broadcastMessage("§6Der Spieler " + ChatColor.YELLOW + p.getName() +  "§6 hat den leichtesten Ausweg gewählt");
				} // end if args == 0 (kill)
				
				if(args.length == 1) {
					Player p2 = getServer().getPlayer(args[0]);
					p2.setHealth(0);
					p2.sendMessage("§6Du wurdest von dem Spieler " + ChatColor.YELLOW + p.getName() + "§6 getötet");
					p.sendMessage("§2Du hast " + ChatColor.DARK_GREEN + p2.getName() + "§2 getötet");
				} // end args == 1 (kill)
				return true;
			} // end if isOP (kill)	
		} // end if /kill
		
		if(command.getName().equalsIgnoreCase("tp")) {
			if(p.isOp()) {
				if(args.length == 1) {
					Player p2 = getServer().getPlayer(args[0]); 
						Location loc = p2.getLocation();
						p.teleport(loc);
						p.sendMessage("§2Du hast dich erfolgreich zu Spieler " + ChatColor.DARK_GREEN + p2.getName() + "§2 teleportiert!");
						p2.sendMessage("§6 Der Spieler " + ChatColor.YELLOW + p.getName() + "§6 hat sich zu dir teleportiert!");
				}
			} // end p.isOp()
			return true;
		} // end if /tp
		
		return false;
	} // end onCommand
} // end class OP_Plugin
 