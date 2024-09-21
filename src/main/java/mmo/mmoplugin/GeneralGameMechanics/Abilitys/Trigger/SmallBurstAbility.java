package mmo.mmoplugin.GeneralGameMechanics.Abilitys.Trigger;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static mmo.mmoplugin.GeneralGameMechanics.Abilitys.Animations.ParticleBallAnimation.ballParticleAnimation;
import static mmo.mmoplugin.MMOPlugin.MMOPlugin;

public class SmallBurstAbility {




    public static void smallBurstAbilityTRIGGER(Location location, Player player) {

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 2.0f, 1.0f);
        }

        World world = location.getWorld();
        if (world != null) {

            ballParticleAnimation(location, player, Particle.FLAME, 1);

            for (Entity onlineEntity : world.getEntities()) {

                List<Entity> nearbyEntitys = (List<Entity>) world.getNearbyEntities(location, 3, 3, 3);
                for (Entity nearbyEntity : nearbyEntitys) {

                    if (!(nearbyEntity instanceof Player) && !(nearbyEntity.isDead())) {
                        Vector direction = nearbyEntity.getLocation().toVector().subtract(location.toVector()).normalize();
                        Vector velocity = direction.multiply(5);
                        if (velocity.getY() > 1.0) {
                            velocity.setY(1.0);
                        }
                        nearbyEntity.setVelocity(velocity);


                    }
                }
            }


        }
    }
}
