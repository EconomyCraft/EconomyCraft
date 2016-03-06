package main;



import org.bukkit.Bukkit;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import commands.Logincommand;
import commands.Registercommand;
import commands.changepasswordcommand;
import commands.logoutcommand;
import events.Events;


public class MainClass extends JavaPlugin {

	
	
	public void onEnable() {
		
		System.out.println("Plugin enabled! Hauptfunktionen funktionieren");
		
		Bukkit.getPluginManager().registerEvents(new Events(), this);
		
		PluginManager pm = this.getServer().getPluginManager();
		getCommand("register").setExecutor(new Registercommand());
		getCommand("login").setExecutor(new Logincommand());
		getCommand("changepassword").setExecutor(new changepasswordcommand());
		getCommand("logout").setExecutor(new logoutcommand());
	}
	
	
	
	public void onDisable() {
		
		System.out.println("Plugin disabled");
		
	}
	
	
	
}
