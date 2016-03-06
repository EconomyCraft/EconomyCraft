package main;

import org.bukkit.plugin.java.JavaPlugin;

import commands.Deletespawncommand;
import commands.Healcommand;
import commands.Icommand;
import commands.Rankaddcommand;
import commands.Rankmovedowncommand;
import commands.Rankmoveupcommand;
import commands.Rankremovecommand;
import commands.Setchatrankcommand;
import commands.Setspawncommand;
import commands.Spawncommand;
import commands.TPHerecommand;
import commands.TPcommand;


public class MainClass extends JavaPlugin{

	
	
	public void onEnabled() {
		System.out.println("Plugin enabled! Funktion voll funktionsfähig!");
		getCommand("tp").setExecutor(new TPcommand());
		getCommand("tphere").setExecutor(new TPHerecommand());
		getCommand("spawn").setExecutor(new Spawncommand());
		getCommand("setspawn").setExecutor(new Setspawncommand());
		getCommand("deletespawn").setExecutor(new Deletespawncommand());
		getCommand("heal").setExecutor(new Healcommand());
		getCommand("i").setExecutor(new Icommand());
		getCommand("rankmoveup").setExecutor(new Rankmoveupcommand());
		getCommand("rankmovedown").setExecutor(new Rankmovedowncommand());
		getCommand("rankadd").setExecutor(new Rankaddcommand());
		getCommand("rankremove").setExecutor(new Rankremovecommand());
		getCommand("setchatrank").setExecutor(new Setchatrankcommand());
	}
}
