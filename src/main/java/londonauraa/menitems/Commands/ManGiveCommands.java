package londonauraa.menitems.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static londonauraa.menitems.Items.Items.*;

public class ManGiveCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("manitems.mangive")){
                if(args[0].equalsIgnoreCase("MermanRod")){
                    player.getInventory().addItem(createManRod());

                }else if (args[0].equalsIgnoreCase("manswarmegg")){
                    player.getInventory().addItem(createManSwarmEgg());

                }else if(args[0].equalsIgnoreCase("manlauncher")){
                    player.getInventory().addItem(createManLauncher());
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
