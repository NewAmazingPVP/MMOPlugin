package mmo.mmoplugin.GeneralGameMechanics.Abilitys.Trigger;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class backwardsLaunchAbility {


    public static void backwardsLaunchAbilityTRIGGER(Location loc, Player player) {


        World world = loc.getWorld();
        if (world != null) {
            world.spawnParticle(Particle.EXPLOSION, loc, 10);

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.playSound(loc, Sound.ENTITY_BLAZE_SHOOT, 5.0f, 1.0f);
            }

            Vector direction = player.getLocation().toVector().subtract(loc.toVector()).normalize();
            Vector velocity = direction.multiply(3);
            if (velocity.getY() > 10.0) {
                velocity.setY(10.0);
            }



        }

    }
}
