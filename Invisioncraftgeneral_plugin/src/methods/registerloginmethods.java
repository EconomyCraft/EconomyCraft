package methods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;


public class registerloginmethods {
	
	static boolean isloggedIn ;
	public static ArrayList<String> loginqueue = new ArrayList<String>();
	
 	public static boolean isRegistered(Player p) {
		boolean isRegistered = false;
		
		File dir = new File("plugins//EconomyCraftLogin");
		File file = new File("plugins//EconomyCraftLogin//Passwords");
		
		if (!(dir.exists())) {
			dir.mkdir();
		}
		
		if (!(file.exists())) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (cfg.contains(p.getName())) {
			isRegistered = true;
		}
		return isRegistered;
	}
	
	public static void register(Player p, String password) {
		File dir = new File("plugins//EconomyCraftLogin");
		File file = new File("plugins//EconomyCraftLogin//Passwords");
		
		if (!(dir.exists())) {
			dir.mkdir();
		}
		
		if (!(file.exists())) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		cfg.set(p.getName() +".Password", password);
		cfg.set(p.getName() +".Registriert", true);
		try {
			cfg.save(file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
			
	public static String getPassword(Player p) {

		
		File dir  = new File("plugins//EconomyCraftLogin");
		File file = new File("plugins//EconomyCraftLogin//Passwords");
		String password = "";
		if (!(dir.exists())) {
			dir.mkdir();
		}
		
		if (!(file.exists())) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (isRegistered(p) == true) {
			password = cfg.getString(p.getName() +".Password");
			
		}
		return password;
		
		
		}
	
	public static void left(Player p) {
		loginqueue.remove(p);
	}

	public static void changepw(Player p, String newpassword) {
		
		File dir = new File("plugins//EconomyCraftLogin");
		File file = new File("plugins//EconomyCraftLogin//Passwords");
		
		if (!(dir.exists())) {
			dir.mkdir();
		}
		
		if (!(file.exists())) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		cfg.set(p.getName() +".Password", newpassword);
		cfg.set(p.getName() +".Registriert", true);
		try {
			cfg.save(file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
