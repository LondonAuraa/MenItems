package londonauraa.menitems.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Objects;

public class CommandMan implements CommandExecutor {

    // This method is called, when somebody uses our command

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("manitems.spawnman")){
                World world = Bukkit.getWorld("world");
                Double x = player.getLocation().getX();
                Double y = player.getLocation().getY();
                Double z = player.getLocation().getZ();
                Location spawnLocation = new Location(world, x, y, z);
                if(args.length == 0){
                    Entity spawnedVillager = world.spawnEntity(spawnLocation, EntityType.VILLAGER);
                }else if(args.length == 1){
                    if(Objects.equals(args[0], "true")){
                        Entity spawnedVillager = world.spawnEntity(spawnLocation, EntityType.VILLAGER);
                        Entity spawnedBat = world.spawnEntity(spawnLocation, EntityType.BAT);
                        spawnedBat.addPassenger(spawnedVillager);
                    }else{
                        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                            Entity spawnedVillager = world.spawnEntity(spawnLocation, EntityType.VILLAGER);
                        }
                    }

                }else{
                    if (Objects.equals(args[1], "true")){
                        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                            Entity spawnedVillager = world.spawnEntity(spawnLocation, EntityType.VILLAGER);
                            Entity spawnedBat = world.spawnEntity(spawnLocation, EntityType.BAT);
                            spawnedBat.addPassenger(spawnedVillager);
                        }

                    }else{
                        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                            Entity spawnedVillager = world.spawnEntity(spawnLocation, EntityType.VILLAGER);
                        }
                    }
                }
            }else{
                player.sendMessage("You don't have permission to run this command!");
            }
        }else{
            sender.sendMessage("Only players can run this command");
        }


        return true;
    }
}
