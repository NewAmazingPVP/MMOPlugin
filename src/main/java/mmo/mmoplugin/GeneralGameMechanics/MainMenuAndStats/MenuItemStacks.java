package mmo.mmoplugin.GeneralGameMechanics.MainMenuAndStats;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.util.ArrayList;
import java.util.List;

import static mmo.mmoplugin.Utils.ItemUtils.SkullUtils.getProfile;

public class MenuItemStacks {

    public static ItemStack mainMenuItem() {


        PlayerProfile profile = getProfile("http://textures.minecraft.net/texture/189928b58a87ec184f168691544b78bc62c9af4df7faea21944bb321e5af612");
        ItemStack info = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) info.getItemMeta();
        meta.setDisplayName("§d§lMain Menu §e[Right Click]");

        List<String> lore = new ArrayList<>();

        //nothing here for now

        meta.setLore(lore);


        meta.setOwnerProfile(profile);
        info.setItemMeta(meta);

        return info;
    }


}
