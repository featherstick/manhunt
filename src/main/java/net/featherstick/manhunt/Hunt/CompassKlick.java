package net.featherstick.manhunt.Hunt;

import net.featherstick.manhunt.main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;

import java.util.UUID;

public class CompassKlick implements Listener {
    @EventHandler
    public void handle(PlayerInteractEvent e){
        Player player = e.getPlayer();
        ItemStack item = player.getItemInHand();
        if(item.getType() == Material.COMPASS){
            UUID Runner = UUID.fromString(main.getPlugin().getConfig().getString("Runner"));
            Player runner = Bukkit.getPlayer(Runner);
            CompassMeta cm = (CompassMeta) item.getItemMeta();
            Location lok = runner.getLocation();
            if (lok.getWorld().getEnvironment().equals(World.Environment.NETHER)){
                if (player.getWorld().getEnvironment().equals(World.Environment.NORMAL)) {
                    int x = lok.getBlockX() * 8;
                    int z = lok.getBlockX() * 8;
                    int y = lok.getBlockX();
                    Location lok2 = new Location(player.getWorld(), x,y,z);
                    cm.setLodestoneTracked(false);
                    cm.setLodestone(lok2);
                }else {
                    cm.setLodestoneTracked(false);
                    cm.setLodestone(lok);
                }
            }else if (lok.getWorld().getEnvironment().equals(World.Environment.THE_END)){
                if (player.getWorld().getEnvironment().equals(World.Environment.NORMAL)) {
                    Location lok2 = main.getPlugin().getConfig().getLocation("portalLok");
                    cm.setLodestoneTracked(false);
                    cm.setLodestone(lok2);
                }else {
                    cm.setLodestoneTracked(false);
                    cm.setLodestone(lok);
                }
            }else {
                cm.setLodestoneTracked(false);
                cm.setLodestone(lok);
            }
            item.setItemMeta(cm);
        }
    }
}
