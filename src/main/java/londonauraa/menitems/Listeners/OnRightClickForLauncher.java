package londonauraa.menitems.Listeners;

import londonauraa.menitems.Main;
import londonauraa.menitems.scheduleds.clearEntity;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.List;

import static londonauraa.menitems.Main.plugin;

public class OnRightClickForLauncher implements Listener {

    private final Main plugin;
    Long despawnTime;
    public OnRightClickForLauncher(Main plugin){
        this.plugin = plugin;
        FileConfiguration config = plugin.getConfig();
        despawnTime = config.getLong("other.manlauncherdespawntime");
    }

    @EventHandler
    public void onRightClick (PlayerInteractEvent event){
        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && !(event.getPlayer().isSneaking())){
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains("Current Power Setting: 1") || event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains("Current Power Setting: 2") || event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains("Current Power Setting: 3")){
                World world = Bukkit.getWorld("world");
                ItemStack launcher = event.getPlayer().getInventory().getItemInMainHand();
                List<String> launcherlore = launcher.getItemMeta().getLore();
                Player player = event.getPlayer();

                Vector direction = player.getEyeLocation().getDirection();
                Entity spawnedVillager = world.spawnEntity(player.getLocation(), EntityType.VILLAGER);
                if (launcherlore.contains("Current Power Setting: 1")){
                    spawnedVillager.setVelocity(direction);
                } else if (launcherlore.contains("Current Power Setting: 2")){
                    spawnedVillager.setVelocity(direction.multiply(2));
                }else{
                    spawnedVillager.setVelocity(direction.multiply(3));
                }
                BukkitTask clearvillager = new clearEntity(this.plugin, spawnedVillager).runTaskLater(this.plugin, despawnTime);


            }
        }

    }
}
