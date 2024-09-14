package mmo.mmoplugin.GeneralGameMechanics.DeathMechanics;

import org.bukkit.*;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

import static mmo.mmoplugin.MMOPlugin.MMOPlugin;

public class DeathMain implements Listener{



    private final List<String> deathSplashMessages = List.of("lol","L Bozo","Bro... Get Good","LLLLLLLL","Pro tip: DON'T DIE","Get Good Bro...","Next time... don't do that...","Get used to it, this will happen IRL one day.","It's just a game...");
    @EventHandler
    public void playerDeathEvent(PlayerDeathEvent e){

        Random random = new Random();
        int randomIndex = random.nextInt(deathSplashMessages.size());
        String splashText = deathSplashMessages.get(randomIndex);

        Player player = e.getPlayer();

        e.setCancelled(true);

        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 20*4, 200,false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 20*4, 1,false));

        for(int i = 0; i<5; i++) {
            player.playSound(player.getLocation(), Sound.BLOCK_VAULT_OPEN_SHUTTER, 5.0f, 0.0f);
        }

        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[YOU DIED]");

        player.sendTitle("§4☠ §l[YOU DIED] §4☠", "§e<Splash text>", 0, 60, 20);

        Bukkit.getScheduler().runTaskLater(MMOPlugin, () -> player.sendTitle("§c☠ §4§l[YOU DIED] §4☠", "§e" + splashText, 0, 60, 20), 5);
        Bukkit.getScheduler().runTaskLater(MMOPlugin, () -> player.sendTitle("§4☠ §c§l[§4§lYOU DIED] §4☠", "§e" + splashText, 0, 60, 20), 10);
        Bukkit.getScheduler().runTaskLater(MMOPlugin, () -> player.sendTitle("§4☠ §l[§c§lY§4§lOU DIED] §4☠", "§" + splashText, 0, 60, 20), 15);
        Bukkit.getScheduler().runTaskLater(MMOPlugin, () -> player.sendTitle("§4☠ §l[Y§c§lO§4§lU DIED] §4☠", "§e" + splashText, 0, 60, 20), 20);
        Bukkit.getScheduler().runTaskLater(MMOPlugin, () -> player.sendTitle("§4☠ §l[YO§c§lU§4§l DIED] §4☠", "§e" + splashText, 0, 60, 20), 25);
        Bukkit.getScheduler().runTaskLater(MMOPlugin, () -> player.sendTitle("§4☠ §l[YOU §c§lD§4§lIED] §4☠", "§e" + splashText, 0, 60, 20), 30);
        Bukkit.getScheduler().runTaskLater(MMOPlugin, () -> player.sendTitle("§4☠ §l[YOU D§c§lI§4§lED] §4☠", "§e" + splashText, 0, 60, 20), 35);
        Bukkit.getScheduler().runTaskLater(MMOPlugin, () -> player.sendTitle("§4☠ §l[YOU DI§c§lE§4§lD] §4☠", "§e" + splashText, 0, 60, 20), 40);
        Bukkit.getScheduler().runTaskLater(MMOPlugin, () -> player.sendTitle("§4☠ §l[YOU DIE§c§lD§4§l] §4☠", "§e" + splashText, 0, 60, 20), 45);
        Bukkit.getScheduler().runTaskLater(MMOPlugin, () -> player.sendTitle("§4☠ §l[YOU DIED§c§l] §4☠", "§e" + splashText, 0, 60, 20), 50);



        Bukkit.getScheduler().runTaskLater(MMOPlugin, () -> player.playSound(player.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_AMBIENT, 5.0f, 3.0f), 20*3);
        Bukkit.getScheduler().runTaskLater(MMOPlugin, () -> player.playSound(player.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_AMBIENT, 5.0f, 3.0f), 20*3);
        Bukkit.getScheduler().runTaskLater(MMOPlugin, () -> player.playSound(player.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_AMBIENT, 5.0f, 3.0f), 20*3);








    }


}
