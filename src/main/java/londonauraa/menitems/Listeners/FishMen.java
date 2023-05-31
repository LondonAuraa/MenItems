package londonauraa.menitems.Listeners;

import londonauraa.menitems.Items.Items;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FishMen implements Listener {
    Items itemlists = new Items();
    ItemStack manRod = itemlists.returnItem(2);
    public static List<Entity> glowingVillagers= new ArrayList<>();
    World world = Bukkit.getWorld("world");
    @EventHandler
    public void onFishCatch (PlayerFishEvent event){
        Location playerlocation = event.getPlayer().getLocation();
        Location hooklocation = event.getHook().getLocation();
        if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH){
            if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().equals(manRod.getItemMeta().getLore())){
                Random getglowingmerman = new Random();
                int didgetglowingmerman = getglowingmerman.nextInt(30);
                Entity spawnedVillager = world.spawnEntity((event.getHook().getLocation()), EntityType.VILLAGER);
                spawnedVillager.setCustomName("Merman");
                if (didgetglowingmerman <= 5){
                    spawnedVillager.setGlowing(true);
                    spawnedVillager.setCustomName("Glowing Merman");
                    glowingVillagers.add(spawnedVillager);
                }
                event.getCaught().remove();
                Vector direction = new Vector( (playerlocation.getX() - hooklocation.getX()) * 1.3/playerlocation.distance(hooklocation), (playerlocation.getY() - hooklocation.getY())*1.3/playerlocation.distance(hooklocation), (playerlocation.getZ() - hooklocation.getZ())*1.3/playerlocation.distance(hooklocation));
                spawnedVillager.setVelocity(direction);

            }
        }
    }
}
