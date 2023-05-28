package me.zixxx.exampleplugin;

import lombok.Getter;
import me.zixxx.exampleplugin.command.GameModeCCommand;
import me.zixxx.exampleplugin.listener.ExampleListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ExmaplePlugin extends JavaPlugin {

    /*
    You want to be able to grab anything from the plugin using an 'getInstance'
    Example: ExamplePlugin.getInstance().getConstants().getCOOKED_BEEF;

    So having an instance of your main class is crucial, If you're new to development in Bukkit.
    You can also make getting your main class or any other handler easier by using lombok as a
    dependency in your project / plugin.
     */
    @Getter private static ExmaplePlugin instance;
    @Getter private Constants constants;

    @Override
    public void onEnable() {
        //set your instance to 'this' your main class.
        instance = this;

        /*
        'setupCommands();' and 'setupListeners();' have no real function besides
        setting up commands and listeners. You don't have to do this but if you're
        crazy about having organized classes in your project than this method is for you.
         */
        setupCommands();
        setupListeners();

    }

    @Override
    public void onDisable() {
        //Save your players and disable the plugin.
        Bukkit.savePlayers();
        Bukkit.getPluginManager().disablePlugin(this);
    }

    //Setup your commands!
    public void setupCommands() {
        this.getCommand("gamemodec").setExecutor(new GameModeCCommand());
    }

    //Setup your listeners!
    public void setupListeners() {
        //Make life easier and using a variable to make this process easier.
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new ExampleListener(), this);
    }

}
