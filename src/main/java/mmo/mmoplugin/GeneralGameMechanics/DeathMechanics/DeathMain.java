package mmo.mmoplugin.GeneralGameMechanics.DeathMechanics;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class DeathMain implements Listener{



    private final ArrayList<String> deathSplashMessages = new ArrayList<>();
    @EventHandler
    public void playerDeathEvent(PlayerDeathEvent e){

        Player player = e.getPlayer();

        e.setCancelled(true);

        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 20*4, 200,true));
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*4, 1,true));

        for(int i = 0; i<5; i++) {
            player.playSound(player.getLocation(), Sound.BLOCK_VAULT_OPEN_SHUTTER, 5.0f, 0.0f);
        }


        player.sendTitle(ChatColor.RED + "☠ " + ChatColor.BOLD +  "[YOU DIED]" + ChatColor.RED +  " ☠", ChatColor.YELLOW + "<Splash text>", 0, 60, 20);

        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[YOU DIED]");



    }


}
