package londonauraa.menitems.Commands;

import londonauraa.menitems.Items.Items;
import londonauraa.menitems.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

import static londonauraa.menitems.Items.Items.*;
import static londonauraa.menitems.Main.plugin;
import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class GUICommand implements CommandExecutor {
    public static Inventory gui;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("manitems.mangui")){
                FileConfiguration config = plugin.getConfig();
                gui = Bukkit.createInventory(player, 36, "Man GUI");
                ItemStack manLauncherGUI = Items.createManLauncher();
                ItemStack manRodGUI = Items.createManRod();
                ItemStack manSwarmEggGUI = Items.createManSwarmEgg();

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

                gui.setItem(22, manLauncherGUI);
                gui.setItem(20,manRodGUI);
                gui.setItem(24,manSwarmEggGUI);
                gui.setItem(4,infobook);
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
