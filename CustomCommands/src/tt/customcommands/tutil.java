package tt.customcommands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class tutil {
    @SuppressWarnings("deprecation")
	public static void setStill(Player p, Boolean freezeToggle){
    	Location location = p.getLocation();
    	Entity player = p;
    	Entity e = p.getWorld().spawnEntity(location, EntityType.ARROW);
    	if(freezeToggle == true){
        	e.setPassenger(player);
        	e.setInvulnerable(true);
        	((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW,100000,254));
    	}else if(freezeToggle == false){
    		p.eject();
    		e.remove();
    		player.getWorld().getNearbyEntities(location, 3, 3, 3).clear();
    		
    	}
    }
}
