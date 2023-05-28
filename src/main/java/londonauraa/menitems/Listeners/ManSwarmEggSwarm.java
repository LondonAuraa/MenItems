package londonauraa.menitems.Listeners;

import londonauraa.menitems.Main;
import londonauraa.menitems.scheduleds.clearEntity;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashSet;
import java.util.Set;

public class ManSwarmEggSwarm implements Listener {
    World world = Bukkit.getWorld("world");
    private final Main plugin;
    Long despawnTime;
    public static Set<Projectile> eggs = new HashSet<>();
    public ManSwarmEggSwarm(Main plugin){
        this.plugin = plugin;
        FileConfiguration config = plugin.getConfig();
        despawnTime = config.getLong("other.manswarmdespawntime");
    }
                            @EventHandler
    public void onEggHit(ProjectileHitEvent event){
        if(eggs.contains(event.getEntity())){
            for (int i = 0; i < 10; i++) {
                Entity spawnedVillager = world.spawnEntity(event.getHitBlock().getLocation(), EntityType.VILLAGER);
                Entity spawnedBat = world.spawnEntity(event.getHitBlock().getLocation(), EntityType.BAT);
                spawnedBat.addPassenger(spawnedVillager);
                BukkitTask clearvillager = new clearEntity(this.plugin, spawnedVillager).runTaskLater(this.plugin, despawnTime);
                BukkitTask clearbat = new clearEntity(this.plugin, spawnedBat).runTaskLater(this.plugin, despawnTime);
            }
        }
    }
}
