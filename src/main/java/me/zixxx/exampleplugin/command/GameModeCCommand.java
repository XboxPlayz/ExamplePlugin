package me.zixxx.exampleplugin.command;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String message, String[] args) {

        /*
         Make sure to check and see if the sender is console
         If the sender is console, then cancel the command
         and send console an error message.
         */

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Error: This command is for players only!");
            return false;
        }

        /*
        Check if the player has permission for the command.
        If they do then update their game mode to creative.
         */
        Player player = (Player) sender;
        if(player.hasPermission("exampleplugin.gamemode.creative")) {
            player.sendMessage(ChatColor.GOLD + "Your gamemode has been set to " + ChatColor.WHITE + "creative" + ChatColor.GOLD + ".");
            player.setGameMode(GameMode.CREATIVE);
        }else{
            player.sendMessage(ChatColor.RED + "No permission.");
            return false;
        }
        return true;
    }
}
