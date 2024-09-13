package mmo.mmoplugin.GeneralGameMechanics.DeathMechanics;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DeathMain implements Listener {

    @EventHandler
    public void playerDeathEvent(PlayerDeathEvent e){

        Player player = e.getPlayer();

        e.setCancelled(true);

        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*4, 1));

        player.sendTitle(ChatColor.RED + "☠ " + ChatColor.BOLD +  "[YOU DIED]" + ChatColor.RED +  " ☠", ChatColor.YELLOW + "<Splash text>", 0, 80, 20);



    }

    @EventHandler
    public void test(BlockBreakEvent e){
        Player player = e.getPlayer();
        player.sendMessage("Success!!");
    }

}
