package londonauraa.menitems.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import static londonauraa.menitems.Listeners.FishMen.glowingVillagers;

public class OnMermanKill implements Listener {
    @EventHandler
    public void onMermanKill (EntityDeathEvent event){
        if (glowingVillagers.contains(event.getEntity())){
            if (event.getEntity().getKiller() instanceof Player){
                Player player = event.getEntity().getKiller();
                player.getInventory().addItem(new ItemStack(Material.HEART_OF_THE_SEA, 1));
                player.sendMessage("§7You killed a §bGlowing Merman §7and got a §9Heart of the Sea!");
            }else{

            }

        }else{

        }
    }

}
