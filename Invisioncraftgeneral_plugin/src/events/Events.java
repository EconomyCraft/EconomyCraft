package events;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import commands.Logincommand;
import methods.registerloginmethods;



public class Events implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage("§e" + e.getPlayer().getName() + " §4hat das Spiel verlassen!");
		registerloginmethods.loginqueue.remove(p.getName());
		
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		Entity en = e.getEntity();
		
		if ( en instanceof Player) {
			
			Player p = (Player) en;
			if (registerloginmethods.loginqueue.contains(p.getName()) == true) {
			 e.setCancelled(false);
			} else {
			e.setCancelled(true);
			}
		}
	}	
	
	@EventHandler
	public void onDamageByEntity(EntityDamageByEntityEvent e) {
		Entity en = e.getDamager();
		Player p = (Player) en;
		
		if ( en instanceof Player) {
			if (registerloginmethods.loginqueue.contains(p.getName()) == true) {
				e.setCancelled(false);
			} else {
				e.setCancelled(true);
			}
			
					
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
	
		if (!registerloginmethods.loginqueue.contains(p.getName())) {
			Location locO =	e.getFrom();
			Location locN = e.getTo();
				if (locO != locN) {
					p.teleport(locO);
			
			
		} else {
			
		}
		}
		}
			
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage("§e" + p.getName() + " §2ist EconomyCraft beigetreten!");
		
		p.sendMessage("§6Bitte bewege dich nicht!");
		p.sendMessage("§6Nachdem einloggen kannst du dich bewegen!!!");
		p.sendMessage("§4Einloggen kannst du dich mit /login <pw>");
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onChat(PlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if (registerloginmethods.loginqueue.add(p.getName())) {
			e.setCancelled(false);
			
		} else {
			e.setCancelled(true);
		}
	}

	public void onChatAsyncPlayer(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if (registerloginmethods.loginqueue.add(p.getName())) {
			e.setCancelled(false);
			
		} else {
			e.setCancelled(true);
		}
	}
	
	public void onBlockBreak(BlockDamageEvent e) {
		Player p = e.getPlayer();
		
		if (registerloginmethods.loginqueue.add(p.getName())) {
			e.setCancelled(false);
			
		} else {
			e.setCancelled(true);
		}
	}
	
	
		
}
