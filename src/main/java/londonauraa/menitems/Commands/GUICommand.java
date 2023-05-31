package londonauraa.menitems.Commands;

import londonauraa.menitems.Items.Items;
import londonauraa.menitems.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;

import static londonauraa.menitems.Items.Items.*;
import static londonauraa.menitems.Main.plugin;
import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class GUICommand implements CommandExecutor {
    public static Inventory gui;
    Items itemlists = new Items();
    ItemStack manLauncherGUI = itemlists.returnItem(2);
    ItemStack manRodGUI = itemlists.returnItem(1);
    ItemStack manSwarmEggGUI = itemlists.returnItem(0);
    ItemStack infobook = itemlists.returnItem(3);
    ItemStack grayfiller = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
    ItemStack bluefiller = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
    Integer[] bluespots = {0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,37,38,39,40,41,42,43,44};
    Integer[] grayspots = {10,11,12,14,15,16,19,20,21,22,23,24,25,28,30,32,34,35};

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("manitems.mangui")){
                FileConfiguration config = plugin.getConfig();
                gui = Bukkit.createInventory(player, 45, "Man GUI");

                ItemMeta manLauncherMeta = manLauncherGUI.getItemMeta();
                ItemMeta manRodMeta = manRodGUI.getItemMeta();
                ItemMeta manSwarmEggMeta = manSwarmEggGUI.getItemMeta();

                List<String> manLauncherLore = manLauncherMeta.getLore();
                List<String> manRodLore = manRodMeta.getLore();
                List<String> manSwarmEggLore = manSwarmEggMeta.getLore();

                manLauncherLore.add("This item costs: " + config.get("prices.manlauncher"));
                manRodLore.add("This item costs: " + config.get("prices.manrod"));
                manSwarmEggLore.add("This item costs: " + config.get("prices.manswarmegg"));

                manLauncherMeta.setLore(manLauncherLore);
                manRodMeta.setLore(manRodLore);
                manSwarmEggMeta.setLore(manSwarmEggLore);

                manLauncherGUI.setItemMeta(manLauncherMeta);
                manRodGUI.setItemMeta(manRodMeta);
                manSwarmEggGUI.setItemMeta(manSwarmEggMeta);

                gui.setItem(31, manLauncherGUI);
                gui.setItem(29,manRodGUI);
                gui.setItem(33,manSwarmEggGUI);
                gui.setItem(13,infobook);
                for (Integer spot : grayspots){
                    gui.setItem(spot, grayfiller);
                }
                for (Integer spot : bluespots){
                    gui.setItem(spot, bluefiller);
                }

                player.openInventory(gui);
                return true;
            }else{

                player.sendMessage("You don't have permission to run this command!");
            }
        }else{
            sender.sendMessage("Only players can run this command");
        }
        return true;
    }

}
