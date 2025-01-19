package net.featherstick.manhunt.Commands;

import net.featherstick.manhunt.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setRunner implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1){
            if (sender.hasPermission("manhunt.runner")){
                Player player = Bukkit.getPlayer(args[0]);
                if (player!= null){
                    main.getPlugin().getConfig().set("Runner", player.getUniqueId().toString());
                    main.getPlugin().saveConfig();
                    sender.sendMessage("§aDer Runner wurde erfolgreich gesetzt!");
                } else {
                    sender.sendMessage("§cDer Spieler ist offline!");
                }
            } else {
                sender.sendMessage("§cDu hast keine Rechte für diesen Befehl!");
            }

        }else {
            sender.sendMessage("Usage: /setRunner <Player>");
            return true;
        }
        return false;
    }
}
