package net.featherstick.core;

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
    }
    public static main getPlugin() {
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
