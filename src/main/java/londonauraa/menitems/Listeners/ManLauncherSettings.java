package londonauraa.menitems.Listeners;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ManLauncherSettings {
    public static ItemStack createManLauncherPower2(){
        ItemStack launcher = new ItemStack(Material.STICK,1);
        ItemMeta rodmeta = launcher.getItemMeta();
        rodmeta.setDisplayName("Man Launcher");
        List<String> launcherlore = new ArrayList<>();
        launcherlore.add("Use this item to launch a man");
        launcherlore.add("Shift and right click to change power setting");
        launcherlore.add("Current Power Setting: 2");
        rodmeta.setLore(launcherlore);
        launcher.setItemMeta(rodmeta);
        return launcher;
    }
    public static ItemStack createManLauncherPower3(){
        ItemStack launcher = new ItemStack(Material.STICK,1);
        ItemMeta rodmeta = launcher.getItemMeta();
        rodmeta.setDisplayName("Man Launcher");
        List<String> launcherlore = new ArrayList<>();
        launcherlore.add("Use this item to launch a man");
        launcherlore.add("Shift and right click to change power setting");
        launcherlore.add("Current Power Setting: 3");
        rodmeta.setLore(launcherlore);
        launcher.setItemMeta(rodmeta);
        return launcher;
    }
}

