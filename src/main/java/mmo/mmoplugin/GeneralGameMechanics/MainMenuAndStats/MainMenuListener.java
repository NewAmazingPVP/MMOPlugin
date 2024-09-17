package mmo.mmoplugin.GeneralGameMechanics.MainMenuAndStats;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static mmo.mmoplugin.GeneralGameMechanics.MainMenuAndStats.MenuItemStacks.mainMenuItem;

public class MainMenuListener implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        player.getInventory().setItem(0, mainMenuItem());

    }

    @EventHandler
    public void playerPlaceBlockEvent(BlockPlaceEvent e){

        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();


        if (meta.getDisplayName().toString().contains("§d§lMain Menu §e[Right Click]")) {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void inventoryInteract(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();

        if (meta.getDisplayName().toString().contains("§d§lMain Menu §e[Right Click]")) {
            e.setCancelled(true);
        }

    }

}
