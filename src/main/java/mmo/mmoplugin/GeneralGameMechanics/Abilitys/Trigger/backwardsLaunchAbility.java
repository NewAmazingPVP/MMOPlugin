package mmo.mmoplugin.GeneralGameMechanics.Abilitys.Trigger;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static mmo.mmoplugin.MMOPlugin.MMOPlugin;

public class backwardsLaunchAbility {


    public static BukkitRunnable backLaunchParticles;

    public static void backwardsLaunchAbilityTRIGGER(Location loc, Player player) {



        World world = loc.getWorld();
        if (world != null) {


            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.playSound(loc, Sound.ENTITY_BLAZE_SHOOT, 5.0f, 1.0f);
            }

            Vector direction = player.getLocation().toVector().subtract(loc.toVector()).normalize();
            Vector velocity = direction.multiply(1.5);
            if (velocity.getY() > 10.0) {
                velocity.setY(10.0);
            }

            player.setVelocity(velocity);

            loc.setY(loc.getY()+1);

            world.spawnParticle(Particle.CLOUD,loc,2);

            backLaunchParticles = new BukkitRunnable() {

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
                        loc.add(x,y,z);
                        world.spawnParticle(Particle.COMPOSTER,loc,0,0,0,0,1);
                        loc.subtract(x,y,z);
                    }




                    if(phi>Math.PI){
                        this.cancel();
                        return;
                    }




                }
            };
            backLaunchParticles.runTaskTimer(MMOPlugin, 0L, 0L);



        }

    }
}
