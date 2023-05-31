package londonauraa.menitems.Commands;

import londonauraa.menitems.Items.Items;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static londonauraa.menitems.Items.Items.*;

public class ManGiveCommands implements CommandExecutor {
    Items itemlists = new Items();
    ItemStack manRod = itemlists.returnItem(1);
    ItemStack manLauncher = itemlists.returnItem(2);
    ItemStack manSwarmEgg = itemlists.returnItem(0);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("manitems.mangive")){
                if(args[0].equalsIgnoreCase("MermanRod")){
                    player.getInventory().addItem(manRod);

                }else if (args[0].equalsIgnoreCase("manswarmegg")){
                    player.getInventory().addItem(manSwarmEgg);

                }else if(args[0].equalsIgnoreCase("manlauncher")){
                    player.getInventory().addItem(manLauncher);
                }else{
                    return false;
                }
            }else{
                player.sendMessage("You don't have permission to run this command!");
            }
        }else{
            sender.sendMessage("Only players can do this command");
        }
        return false;
    }

}
