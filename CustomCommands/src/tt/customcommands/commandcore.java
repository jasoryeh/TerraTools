package tt.customcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tt.customcommands.tutil;

public class commandcore extends JavaPlugin{
  public void onEnable() {
	  getLogger().info("[TerraTools] Starting up...");
	  getConfig().options().copyDefaults();
	  saveConfig();
  }
  public void onDisable() {
	  getLogger().info("[TerraTools] Shutting down...");
  }
  @SuppressWarnings("deprecation")
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	  Player player = (Player) sender;
	  commands.message(player, label, args, this);
      return true;
  }
}