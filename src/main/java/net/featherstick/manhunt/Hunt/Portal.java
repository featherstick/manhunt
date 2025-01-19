package net.featherstick.manhunt.Hunt;

import net.featherstick.manhunt.main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

import java.util.UUID;

public class Portal implements Listener {
    @EventHandler
    public static void onPortal(PlayerPortalEvent e){
        if (e.getTo().getWorld().getEnvironment().equals(World.Environment.THE_END)){
            Location lok = e.getFrom();
            UUID Runner = UUID.fromString(main.getPlugin().getConfig().getString("Runner"));
            Player runner = Bukkit.getPlayer(Runner);
            if (e.getPlayer() == runner) {
                main.getPlugin().getConfig().set("portalLok", lok);
            }
        }
    }
}
