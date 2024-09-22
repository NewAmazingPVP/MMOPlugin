package mmo.mmoplugin.NPCAndBlockGUIs;

import org.bukkit.Bukkit;
import org.bukkit.Location;
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

import java.awt.event.ContainerEvent;

public class CraftingMenu implements Listener {

    @EventHandler
    public void openCraftingTable(PlayerInteractEvent e){

        Player player = e.getPlayer();
        Block clickedBlock = e.getClickedBlock();

        if (e.getAction() == Action.LEFT_CLICK_BLOCK && clickedBlock.getType() == Material.CRAFTING_TABLE){
            e.setCancelled(true);

            openCustomCraftingMenu(player);

        }
    }

    @EventHandler
    public void closeMenu(InventoryCloseEvent e){

        Player player = (Player) e.getPlayer();
        Inventory inv = e.getInventory();

        if(e.getView().getTitle() == "§d§l[Crafter]"){
            player.playSound(player.getLocation(), Sound.BLOCK_COPPER_DOOR_CLOSE, 1.0f, 1.0f);
        }

    }


    public static void openCustomCraftingMenu(Player player){

        player.playSound(player.getLocation(), Sound.BLOCK_COPPER_DOOR_OPEN, 1.0f, 1.0f);
        Inventory customCraftingMenu = Bukkit.createInventory(player, 27, "§d§l[Crafter]");
        player.openInventory(customCraftingMenu);



    }




}
