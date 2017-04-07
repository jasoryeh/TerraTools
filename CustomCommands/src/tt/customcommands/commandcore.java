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
	  getLogger().info(ChatColor.YELLOW + "[TerraTools] Starting up...");
	  getConfig().options().copyDefaults();
	  saveConfig();
  }
  public void onDisable() {
	  getLogger().info(ChatColor.YELLOW + "[TerraTools] Shutting down...");
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
	  if(label != null && label.equalsIgnoreCase("info")){
		  if(args.length == 0){
			  System.out.println("LOL");
			  player.sendMessage(ChatColor.RED + "Error - use /info discord, or website.");
		  }else if(args.length == 1){
			  if(args[0] != null && args[0].equalsIgnoreCase("discord")){
				  String DISCORDSITE = getConfig().getString("DISCORD", "https://discord.gg/G9tvJSu");
				  player.sendMessage(ChatColor.BLUE + "Join our discord @ " + DISCORDSITE);			  
			  }else if(args[0] != null && args[0].equalsIgnoreCase("website")){
				  String WEBSITESITE = getConfig().getString("WEBSITE", "https://terramagnum.net");
				  player.sendMessage(ChatColor.YELLOW + "Our website is here: " + WEBSITESITE);
			  }else if(args[0] == null){
				  getLogger().info("null string for args[0]");
			  }else{
				  getLogger().info(":P");
			  } 
		  }
	  }
	  if(label.equalsIgnoreCase("discord")){
		  String DISCORDSITE = getConfig().getString("DISCORD", "https://discord.gg/G9tvJSu");
		  player.sendMessage(ChatColor.BLUE + "Join our discord @ " + DISCORDSITE);
	  }
	  if(label.equalsIgnoreCase("website")){
		  String WEBSITESITE = getConfig().getString("WEBSITE", "https://terramagnum.net");
		  player.sendMessage(ChatColor.YELLOW + "Our website is here: " + WEBSITESITE);
	  }
	  if(label.equalsIgnoreCase("github")){
		  String GITHUBSITE = getConfig().getString("GITHUB", "https://github.com/TerraMagnum/");
		  player.sendMessage(ChatColor.AQUA + GITHUBSITE);
	  }
    return true;
  }
}