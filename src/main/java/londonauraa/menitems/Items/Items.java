package londonauraa.menitems.Items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Items {
    public static ItemStack manSwarmEgg;
    public static ItemStack manRod;
    public static ItemStack manLauncher;
    public static ItemStack infobook;


    public static void init(){
        createManSwarmEgg();
        createManRod();
        createManLauncher();
        createInfoBook();
    }
    public static ItemStack createManSwarmEgg(){
        ItemStack item = new ItemStack(Material.EGG, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Man Swarm Egg");
        List<String> lore = new ArrayList<>();
        lore.add("Throw this egg to create a swarm");
        lore.add("of flying men....");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack createManRod(){
        ItemStack rod = new ItemStack(Material.FISHING_ROD,1);
        ItemMeta rodmeta = rod.getItemMeta();
        rodmeta.setDisplayName("Merman Rod");
        List<String> rodlore = new ArrayList<>();
        rodlore.add("Use this rod to catch a merman,");
        rodlore.add("try to catch the glowing merman!");
        rodmeta.setLore(rodlore);
        rod.setItemMeta(rodmeta);
        return rod;
    }
    public static ItemStack createManLauncher(){
        ItemStack launcher = new ItemStack(Material.STICK,1);
        ItemMeta rodmeta = launcher.getItemMeta();
        rodmeta.setDisplayName("Man Launcher");
        List<String> launcherlore = new ArrayList<>();
        launcherlore.add("Use this item to launch a man");
        launcherlore.add("Shift and right click to change power setting");
        launcherlore.add("Current Power Setting: 1");
        rodmeta.setLore(launcherlore);
        launcher.setItemMeta(rodmeta);
        return launcher;
    }

    public static void createInfoBook(){
        ItemStack book = new ItemStack(Material.BOOK, 1);
        ItemMeta bookmeta = book.getItemMeta();
        bookmeta.setDisplayName("Information");
        List<String> booklore = new ArrayList<>();
        booklore.add("Click an item to receive it!");
        bookmeta.setLore(booklore);
        bookmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bookmeta.addEnchant(Enchantment.LUCK, 1, true);
        book.setItemMeta(bookmeta);

        infobook = book;
    }
}
