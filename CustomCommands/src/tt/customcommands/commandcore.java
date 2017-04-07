package tt.customcommands;

import org.bukkit.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class commandcore extends JavaPlugin{
  public void onEnable() {
	  getLogger().info(ChatColor.YELLOW + "[InputCore] Starting up...");
	  getConfig().options().copyDefaults();
	  saveConfig();
  }
  public void onDisable() {
	  getLogger().info(ChatColor.YELLOW + "[InputCore] Shutting down...");
	  }
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	  Player player = (Player) sender;
	  if(label.equalsIgnoreCase("ic")){
		  if(args[0].equalsIgnoreCase("test")){
				 String test = (ChatColor.BOLD + "" + ChatColor.GREEN + "All systems check! - GO!");
				 player.sendMessage(test);
		  }else if(args[0].equalsIgnoreCase("reload")){
			  reloadConfig();
			  player.sendMessage(ChatColor.GREEN + "Config reload done.");
		  }
	  }
	  if(label != null && label.equalsIgnoreCase("idek")){
		  Player p = player;
		  if(args[0] != null && args[0].equalsIgnoreCase("discord")){
			  String DISCORDSITE = getConfig().getString("DISCORD", "https://discord.gg/G9tvJSu");
			  p.sendMessage(ChatColor.BLUE + "Join our discord @ " + DISCORDSITE);			  
		  }else if(args[0] != null && args[0].equalsIgnoreCase("website")){
			  String WEBSITESITE = getConfig().getString("WEBSITE", "https://terramagnum.net");
			  p.sendMessage(ChatColor.YELLOW + "Our website is here: " + WEBSITESITE);
		  }else if(args[0] == null){
			  System.out.println("LOL");
			  p.sendMessage("Error");
		  }else{
			  System.out.println("P");
		  }
	  }
    return true;
  }
}