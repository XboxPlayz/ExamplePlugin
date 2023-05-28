package me.zixxx.exampleplugin;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Constants {

    //The constants for the rod and cooked beef.
    @Getter private final ItemStack COOKED_BEEF = new ItemStack(Material.COOKED_BEEF, 16);
    @Getter private final ItemStack ROD = new ItemStack(Material.FISHING_ROD, 1);

}
