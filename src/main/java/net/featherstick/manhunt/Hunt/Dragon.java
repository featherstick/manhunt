package net.featherstick.manhunt.Hunt;

import net.featherstick.manhunt.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.UUID;

public class Dragon implements Listener {
    @EventHandler
    public void onDragonDeath(EntityDeathEvent e){
        //Hier Code für den Dragon-Death-Event hinzufügen
        if (e.getEntity().getType().equals(EntityType.ENDER_DRAGON)){
            for (Player player: Bukkit.getOnlinePlayers()) {
                UUID Runner = UUID.fromString(main.getPlugin().getConfig().getString("Runner"));
                Player runner = Bukkit.getPlayer(Runner);
                player.sendTitle("§eDer Runner Hat Gewonnen", "§e " + runner.getName(), 2, 60, 2);
            }
        }
    }
}
