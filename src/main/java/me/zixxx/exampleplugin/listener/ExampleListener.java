package me.zixxx.exampleplugin.listener;

import me.zixxx.exampleplugin.ExmaplePlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class ExampleListener implements Listener /* Always implement a listener so the server knows to register the events in this class. */ {

    //If you want your code to function, make sure to use '@EventHandler' above the method for the server to know it's an event.
    @EventHandler(priority = EventPriority.LOW)
    public void onJoin(PlayerJoinEvent event){
        //Want to change the join message for the server? simply do 'event.setJoinMessage("This is your join message!");
        event.setJoinMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "Connect " + ChatColor.GRAY + ">>" + ChatColor.YELLOW +
                event.getPlayer().getName() + " has joined the server.");

        //Make life simpler by making a player variable instead of doing 'event.getPlayer().getName()' all of the time!
        Player player = event.getPlayer();
        //Again, Make life easier by making a variable for the player's name being white in the broadcast message below.
        String playerDisplayNameColor = ChatColor.WHITE + event.getPlayer().getName();

        //if the player has not played before then execute this function.
        if(!player.hasPlayedBefore()) {
            //Getting the players inventory then placing the Cooked beef and Fishing rods from constants in their inventory.
            player.getInventory().addItem(ExmaplePlugin.getInstance().getConstants().getCOOKED_BEEF());
            player.getInventory().addItem(ExmaplePlugin.getInstance().getConstants().getROD());
            //You want to update the players inventory, so they will have the items.
            player.updateInventory();

            //You want to welcome the player to the server right? Broadcast a simple message to the entire server that they joined
            //for the first time.
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage(ChatColor.YELLOW + "Welcome " + playerDisplayNameColor + ChatColor.GREEN + " to the server!");
            Bukkit.broadcastMessage("");
            player.sendMessage(ChatColor.GREEN.toString() + "You have been given some basic essentials to help you begin life!");
            return;
        }

        //If the player that joins is not a server operator, and they're in the world named 'world'
        //set their gamemode to survival as a security precaution and send them a simple message.
        if(!player.isOp() && player.getWorld().getName().equalsIgnoreCase("world")) {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage(ChatColor.GREEN + "You have been placed back into the world in survival!");
            return;
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(ChatColor.RED + ChatColor.BOLD.toString() + "Quit" + ChatColor.GRAY + " >> " + event.getPlayer().getName() + " has left the server.");
    }

}
