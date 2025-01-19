package net.featherstick.manhunt;

import net.featherstick.manhunt.Commands.compass;
import net.featherstick.manhunt.Commands.setRunner;
import net.featherstick.manhunt.Hunt.CompassKlick;
import net.featherstick.manhunt.Hunt.Dragon;
import net.featherstick.manhunt.Hunt.Join;
import net.featherstick.manhunt.Hunt.Portal;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {
    private static main plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        main.getPlugin().saveConfig();
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new CompassKlick(), this);
        pluginManager.registerEvents(new Join(), this);
        pluginManager.registerEvents(new Portal(), this);
        pluginManager.registerEvents(new Dragon(), this);
        getCommand("compass").setExecutor(new compass());
        getCommand("setrunner").setExecutor(new setRunner());

    }
    public static main getPlugin() {
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
