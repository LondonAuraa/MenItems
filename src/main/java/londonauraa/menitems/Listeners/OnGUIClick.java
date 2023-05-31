package londonauraa.menitems.Listeners;

import londonauraa.menitems.Items.Items;
import londonauraa.menitems.Main;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static londonauraa.menitems.Commands.GUICommand.gui;
import static londonauraa.menitems.Main.plugin;

public class OnGUIClick implements Listener {
    Items itemlists = new Items();
    ItemStack manRod = itemlists.returnItem(1);
    ItemStack manLauncher = itemlists.returnItem(2);
    ItemStack manSwarmEgg = itemlists.returnItem(0);

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if (event.getInventory() == gui){
            int slot = event.getSlot();
            Player player = (Player) event.getWhoClicked();
            Economy economy = Main.getEconomy();
            FileConfiguration config = plugin.getConfig();
            Double manrodprice = Double.valueOf(config.get("prices.manrod").toString());
            Double manlauncherprice = Double.valueOf(config.get("prices.manlauncher").toString());
            Double manswarmeggprice = Double.valueOf(config.get("prices.manswarmegg").toString());
            if (slot == 29){
                if (economy.has(player, manrodprice)){
                    player.getInventory().addItem(manRod);
                    player.sendMessage("You have bought the "+ChatColor.RED+  "man rod for "+ ChatColor.GOLD + config.get("prices.manrod"));
                    economy.withdrawPlayer(player, (Double) config.get("prices.manrod"));
                }else{
                    player.sendMessage("You don't have enough money for this!");
                }

            }else if(slot == 31){
                if (economy.has(player, manlauncherprice)){
                    player.getInventory().addItem(manLauncher);
                    player.sendMessage("You have bought the "+ChatColor.RED+  "man launcher for "+ ChatColor.GOLD + config.get("prices.manlauncher"));
                    economy.withdrawPlayer(player, (Double) config.get("prices.manlauncher"));
                }else{
                    player.sendMessage("You don't have enough money for this!");
                }
            }else if (slot == 33){
                if (economy.has(player, manswarmeggprice)){
                    player.getInventory().addItem(manSwarmEgg);
                    player.sendMessage("You have bought a "+ChatColor.RED+  "man swarm egg for "+ ChatColor.GOLD + config.get("prices.manswarmegg"));
                    economy.withdrawPlayer(player, (Double) config.get("prices.manswarmegg"));
                }else{
                    player.sendMessage("You don't have enough money for this!");
                }
            }
            event.setCancelled(true);
        }else{
            return;
        }
    }
}
