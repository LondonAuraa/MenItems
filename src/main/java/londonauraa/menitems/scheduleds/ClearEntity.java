package londonauraa.menitems.scheduleds;

import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;


public class ClearEntity extends BukkitRunnable {
    private final JavaPlugin plugin;
    public Entity villager;
    public clearEntity(JavaPlugin plugin, Entity entity){
        this.plugin = plugin;
        this.villager = entity;
    }

    public void run(){
        villager.remove();
    }
}
