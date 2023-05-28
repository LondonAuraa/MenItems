package londonauraa.menitems;

import londonauraa.menitems.Commands.CommandMan;
import londonauraa.menitems.Commands.GUICommand;
import londonauraa.menitems.Commands.ManGiveCommands;
import londonauraa.menitems.Items.Items;
import londonauraa.menitems.Listeners.*;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {
    private static Economy econ = null;
    private static final Logger log = Logger.getLogger("Minecraft");
    public static Main plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        saveDefaultConfig();
        this.getCommand("mangui").setExecutor(new GUICommand());
        this.getCommand("man").setExecutor(new CommandMan());
        this.getCommand("giveman").setExecutor(new ManGiveCommands());
        getServer().getPluginManager().registerEvents(new ManSwarmEggSwarm(plugin), this);
        getServer().getPluginManager().registerEvents(new OnGUIClick(), this);
        getServer().getPluginManager().registerEvents(new LauncherChangePower(), this);
        getServer().getPluginManager().registerEvents(new OnRightClickForLauncher(plugin), this);
        getServer().getPluginManager().registerEvents(new OnProjectileLaunching(), this);
        getServer().getPluginManager().registerEvents(new FishMen(), this);
        getServer().getPluginManager().registerEvents(new OnMermanKill(), this);
        Items.init();
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

    }
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
