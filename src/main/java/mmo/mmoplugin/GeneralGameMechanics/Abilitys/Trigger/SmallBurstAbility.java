package mmo.mmoplugin.GeneralGameMechanics.Abilitys.Trigger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;

public class SmallBurstAbility {



    public static void smallBurstAbilityTRIGGER(Location location, Player player) {

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 2.0f, 1.0f);
        }

        World world = location.getWorld();
        if (world != null) {

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
