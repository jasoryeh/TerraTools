package tt.customcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.minecraft.server.v1_11_R1.CommandScoreboard;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import tt.customcommands.commandcore;

public class commands {
	@SuppressWarnings("deprecation")
	public static void message(Player sender, String label, String[] args, Plugin plugin){
		Player player = sender;
		if(label.equalsIgnoreCase("tc")){
			  if(args.length == 0){
				  player.sendMessage(ChatColor.RED + "Invalid argument! User /ic <args>");
			  }else if(args[0].equalsIgnoreCase("test")){
					 String test = (ChatColor.BOLD + "" + ChatColor.GREEN + "All systems check! - GO!");
					 player.sendMessage(test);
			  }else if(args[0].equalsIgnoreCase("reload")){
				  plugin.reloadConfig();
				  player.sendMessage(ChatColor.GREEN + "Config reload done.");
			  }
		}else if(label.equalsIgnoreCase("test")){
			String test = (ChatColor.BOLD + "" + ChatColor.GREEN + "All systems check! - GO!");
			 player.sendMessage(test);
		}
		  if(label != null && label.equalsIgnoreCase("info")){
			  if(args.length == 0){
				  System.out.println("LOL");
				  player.sendMessage(ChatColor.RED + "Error - use /info discord, or website.");
			  }else if(args.length == 1){
				  if(args[0] != null && args[0].equalsIgnoreCase("discord")){
					  String DISCORDSITE = plugin.getConfig().getString("DISCORD", "https://discord.gg/G9tvJSu");
					  player.sendMessage(ChatColor.BLUE + "Join our discord @ " + DISCORDSITE);			  
				  }else if(args[0] != null && args[0].equalsIgnoreCase("website")){
					  String WEBSITESITE = plugin.getConfig().getString("WEBSITE", "https://terramagnum.net");
					  player.sendMessage(ChatColor.YELLOW + "Our website is here: " + WEBSITESITE);
				  }else if(args[0] == null){
					  plugin.getLogger().info("null string for args[0]");
				  }else{
					  plugin.getLogger().info(":P");
				  } 
			  }
		  }
		  if(label.equalsIgnoreCase("discord")){
			  String DISCORDSITE = plugin.getConfig().getString("DISCORD", "https://discord.gg/G9tvJSu");
			  player.sendMessage(ChatColor.BLUE + "Join our discord @ " + DISCORDSITE);
		  }
		  if(label.equalsIgnoreCase("website")){
			  String WEBSITESITE = plugin.getConfig().getString("WEBSITE", "https://terramagnum.net");
			  player.sendMessage(ChatColor.YELLOW + "Our website is here: " + WEBSITESITE);
		  }
		  if(label.equalsIgnoreCase("github")){
			  String GITHUBSITE = plugin.getConfig().getString("GITHUB", "https://github.com/TerraMagnum/");
			  player.sendMessage(ChatColor.AQUA + "Our Github is here: " + GITHUBSITE);
		  }
		  if(label.equalsIgnoreCase("ss") || label.equalsIgnoreCase("freeze")){
			  if(args.length == 0){
				  player.sendMessage(ChatColor.RED + "You haven't chosen a player to freeze.");
			  }else if(args.length == 1){
				  boolean freezeToggle = true;
				  Player freeze = Bukkit.getPlayer(args[0]);
				  if(freeze.hasMetadata(freeze.getName())){
					  freezeToggle = false;
					  freeze.removeMetadata(freeze.getName(), plugin);
					  player.sendTitle("§aYou have been unfrozen.", "§eYou are free to go... for now...");
					  freeze.setFlySpeed(0.1f);
					  freeze.setWalkSpeed(0.2f);
					  freeze.removePotionEffect(PotionEffectType.SLOW);
					  freeze.setGravity(true);
					  freeze.setInvulnerable(false);
					  freeze.setFlying(false);
					  tutil.setStill(freeze, false);
				  }else{
					  player.sendTitle("§cYou have been frozen.", "§eDo not log out or you will be permanently banned.");
					  freeze.setMetadata(freeze.getName(), new FixedMetadataValue(plugin, true));
					  freeze.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,100000,254));
					  freeze.closeInventory();
					  freeze.setGravity(false);
					  freeze.setInvulnerable(true);
					  freeze.setFlying(true);
					  tutil.setStill(freeze, true);
					  System.out.println(freeze.getFlySpeed());
					  System.out.println(freeze.getWalkSpeed());
					  freeze.setFlySpeed(0.0f);
					  freeze.setWalkSpeed(0.0f);
	              }
			  }
		  }
	}
}
