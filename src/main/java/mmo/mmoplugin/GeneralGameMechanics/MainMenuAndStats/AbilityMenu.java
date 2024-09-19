package mmo.mmoplugin.GeneralGameMechanics.MainMenuAndStats;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.util.ArrayList;
import java.util.List;

import static mmo.mmoplugin.Utils.ItemUtils.SkullUtils.getProfile;

public class AbilityMenu {

    public static void openAbilityMenu(Player player){

        Inventory abilityMenu = Bukkit.createInventory(player, 27, "§d§l[Select Abilities]");

        abilityMenu.setItem(0,purpleGUIGlass());
        abilityMenu.setItem(1,purpleGUIGlass());
        abilityMenu.setItem(2,purpleGUIGlass());
        abilityMenu.setItem(3,purpleGUIGlass());
        abilityMenu.setItem(4,purpleGUIGlass());
        abilityMenu.setItem(5,purpleGUIGlass());
        abilityMenu.setItem(6,purpleGUIGlass());
        abilityMenu.setItem(7,purpleGUIGlass());
        abilityMenu.setItem(8,purpleGUIGlass());

        abilityMenu.setItem(9,magentaGUIGlass());
        abilityMenu.setItem(10,magentaGUIGlass());
        //<<<<<<<<<<<<<<<<<<<<<<<<<<<
        abilityMenu.setItem(12,magentaGUIGlass());
        //<<<<<<<<<<<<<<<<<<<<<<<<<<<
        abilityMenu.setItem(14,magentaGUIGlass());
        //<<<<<<<<<<<<<<<<<<<<<<<<<<<
        abilityMenu.setItem(16,magentaGUIGlass());
        abilityMenu.setItem(17,magentaGUIGlass());

        abilityMenu.setItem(18,purpleGUIGlass());
        abilityMenu.setItem(19,purpleGUIGlass());
        abilityMenu.setItem(20,purpleGUIGlass());
        abilityMenu.setItem(21,purpleGUIGlass());
        abilityMenu.setItem(22,purpleGUIGlass());
        abilityMenu.setItem(23,purpleGUIGlass());
        abilityMenu.setItem(24,purpleGUIGlass());
        abilityMenu.setItem(25,purpleGUIGlass());
        abilityMenu.setItem(26,purpleGUIGlass());



        //variable itemstacks
        abilityMenu.setItem(11,abilitySlotCurrentlyLocked(10,"Right Click"));
        abilityMenu.setItem(13,abilitySlotCurrentlyLocked(50,"Shift Right Click"));
        abilityMenu.setItem(15,abilitySlotCurrentlyLocked(100,"Shift Left Click"));

        player.openInventory(abilityMenu);

    }




    public static ItemStack magentaGUIGlass() {
        ItemStack ITEM = new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE);
        ItemMeta META = ITEM.getItemMeta();
        META.setDisplayName(" ");
        ITEM.setItemMeta(META);
        return ITEM;
    }

    public static ItemStack purpleGUIGlass() {
        ItemStack ITEM = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemMeta META = ITEM.getItemMeta();
        META.setDisplayName(" ");
        ITEM.setItemMeta(META);
        return ITEM;
    }

    public static ItemStack abilitySlotCurrentlyLocked(int abilityLevel, String clickType) {
        ItemStack ITEM = new ItemStack(Material.BARRIER);
        ItemMeta meta = ITEM.getItemMeta();
        meta.setDisplayName("§4§lAbility Slot Locked! " + "§e[" + clickType + "]");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> LORE = new ArrayList<>();
        LORE.add(" ");
        LORE.add("§cUnlocked at level " + abilityLevel);
        meta.setLore(LORE);
        ITEM.setItemMeta(meta);
        return ITEM;
    }



}
