package londonauraa.menitems.Listeners;

import londonauraa.menitems.Items.Items;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import static londonauraa.menitems.Items.Items.manSwarmEgg;
import static londonauraa.menitems.Listeners.ManSwarmEggSwarm.eggs;

public class OnProjectileLaunching implements Listener {

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event){
        if(event.getEntity().getShooter() instanceof Player){
            Player player = (Player) event.getEntity().getShooter();
            if(player.getInventory().getItemInMainHand().isSimilar(Items.createManSwarmEgg())){
                eggs.add(event.getEntity());
            }
        }

    }
}
