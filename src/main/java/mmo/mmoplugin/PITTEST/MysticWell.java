package mmo.mmoplugin.PITTEST;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import static mmo.mmoplugin.MMOPlugin.MMOPlugin;

public class MysticWell implements Listener {

    public static BukkitRunnable mysticWellIdleRunnable;

    @EventHandler
    public void openCraftingTable(PlayerInteractEvent e) {

        Player player = e.getPlayer();
        Block clickedBlock = e.getClickedBlock();

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && clickedBlock.getType() == Material.ENCHANTING_TABLE) {
            e.setCancelled(true);

            openCustomWellMenu(player);

        }
    }
    
    @EventHandler
    public void closeMenu(InventoryCloseEvent e) {

        Player player = (Player) e.getPlayer();
        Inventory inv = e.getInventory();

        if (e.getView().getTitle() == "§d§l[Mystic Well]") {
            player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_CLOSE, 1.0f, 1.0f);
        }

    }


    public static void openCustomWellMenu(Player player) {

        player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, 1.0f, 1.0f);
        Inventory customCraftingMenu = Bukkit.createInventory(player, 27, "§d§l[Mystic Well]");

        mysticWellIdleRunnable = new BukkitRunnable() {

            @Override
            public void run() {



            }
        };
        mysticWellIdleRunnable.runTaskTimer(MMOPlugin, 20L, 0L);

        player.openInventory(customCraftingMenu);


    }

    public static void updateMysticWellMenuIDLE(int frame, Inventory inv){


        



    }



}

