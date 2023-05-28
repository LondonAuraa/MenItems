package londonauraa.menitems.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

import static londonauraa.menitems.Items.Items.manLauncher;

public class LauncherChangePower implements Listener {
    @EventHandler
    public void onRightClickAndShifting (PlayerInteractEvent event){

        if (event.getAction() == Action.RIGHT_CLICK_AIR && event.getPlayer().isSneaking() && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains("Use this item to launch a man")){
            List<String> launcherLore = event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore();
            Player player = event.getPlayer();
            if (launcherLore.contains("Current Power Setting: 1")){
                player.getInventory().remove(event.getPlayer().getInventory().getItemInMainHand());
                player.getInventory().addItem(ManLauncherSettings.createManLauncherPower2());
                player.sendMessage("Your Man Launcher's power has been set to 2");
            }else if(launcherLore.contains("Current Power Setting: 2")){
                player.getInventory().remove(event.getPlayer().getInventory().getItemInMainHand());
                player.getInventory().addItem(ManLauncherSettings.createManLauncherPower3());
                player.sendMessage("Your Man Launcher's power has been set to 3");
            }else{
                player.getInventory().remove(event.getPlayer().getInventory().getItemInMainHand());
                player.getInventory().addItem(manLauncher);
                player.sendMessage("Your Man Launcher's power has been set to 1");
            }

        }
    }
}
