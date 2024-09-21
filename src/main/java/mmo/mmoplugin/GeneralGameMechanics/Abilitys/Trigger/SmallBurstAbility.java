package mmo.mmoplugin.GeneralGameMechanics.Abilitys.Trigger;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static mmo.mmoplugin.MMOPlugin.MMOPlugin;

public class SmallBurstAbility {


    public static BukkitRunnable smallBurstAbilityAnimation;

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

                        smallBurstAbilityAnimation = new BukkitRunnable() {

                            double phi =0;

                            //int animationLoop =0;

                            @Override
                            public void run() {

                                phi += Math.PI/10; //<< 10 circles HIGHLY RECOMENED DO NOT SO MORE

                                for(double theta = 0; theta <= 2*Math.PI; theta += Math.PI/40){
                                    double r = 1.5;
                                    double x = r*cos(theta)*sin(phi);
                                    double y = r*cos(phi) + 1.5;
                                    double z = r*sin(theta) * sin(phi);
                                    location.add(x,y,z);
                                    world.spawnParticle(Particle.FLAME,location,0,0,0,0,1);
                                    location.subtract(x,y,z);
                                }




                                if(phi>Math.PI*2){
                                    this.cancel();
                                    return;
                                }




                            }
                        };
                        smallBurstAbilityAnimation.runTaskTimer(MMOPlugin, 0L, 0L);

                    }




                }
            }
        }


    }





}
