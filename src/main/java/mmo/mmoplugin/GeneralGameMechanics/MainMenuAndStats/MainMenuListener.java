package mmo.mmoplugin.GeneralGameMechanics.MainMenuAndStats;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static mmo.mmoplugin.GeneralGameMechanics.MainMenuAndStats.MenuItemStacks.mainMenuItem;

public class MainMenuListener implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        player.getInventory().setItem(8, mainMenuItem());

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

    @EventHandler
    public void onBlockPlace(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        if (!event.hasItem()) return;
        if (!event.getItem().hasItemMeta()) return;
        ItemMeta meta = event.getItem().getItemMeta();
        ItemStack item = player.getInventory().getItemInMainHand();

        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                event.hasItem() && event.getItem().getType() == Material.NOTE_BLOCK) {
            if (item.hasItemMeta() && item.getItemMeta().hasDisplayName() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("§d§lMain Menu §e[Right Click]")) {
                if (meta.getLore() == null) return;

                player.sendMessage("Does nothing rn");

                //openMainMenu(player);

            }
        }
    }

    public static void openMainMenu(Player player){

        Inventory mainMenu = Bukkit.createInventory(player, 27, "§d§l[Main Menu]");


        player.openInventory(mainMenu);

    }



}
