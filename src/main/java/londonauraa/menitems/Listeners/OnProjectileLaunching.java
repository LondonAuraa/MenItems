package londonauraa.menitems.Listeners;

import londonauraa.menitems.Items.Items;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

import static londonauraa.menitems.Listeners.ManSwarmEggSwarm.eggs;

public class OnProjectileLaunching implements Listener {
    Items itemlists = new Items();
    ItemStack manSwarmEgg = itemlists.returnItem(0);
    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event){
        if(event.getEntity().getShooter() instanceof Player){
            Player player = (Player) event.getEntity().getShooter();
            if(player.getInventory().getItemInMainHand().isSimilar(manSwarmEgg)){
                eggs.add(event.getEntity());
            }
        }

    }
}

