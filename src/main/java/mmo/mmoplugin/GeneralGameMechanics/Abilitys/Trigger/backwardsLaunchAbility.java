package mmo.mmoplugin.GeneralGameMechanics.Abilitys.Trigger;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

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


            Location p1 = loc;
            Location p2 = loc;
            Location p3 = loc;
            Location p4 = loc;

            backLaunchParticles = new BukkitRunnable() {

                int animationLoop =0;

                @Override
                public void run() {

                    animationLoop +=1;

                    if(animationLoop > 10){
                        this.cancel();
                        return;
                    }
                    


                    p1.setY(p1.getY() + .2);
                    p1.setY(p1.getY() + .5);
                    p1.setY(p1.getY() + .5);

                    p2.setY(p2.getY() + .2);
                    p2.setY(p2.getY() - .5);
                    p2.setY(p2.getY() - .5);

                    p3.setY(p3.getY() + .2);
                    p3.setY(p3.getY() - .5);
                    p3.setY(p3.getY() + .5);

                    p4.setY(p4.getY() + .2);
                    p4.setY(p4.getY() + .5);
                    p4.setY(p4.getY() - .5);



                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.getWorld().spawnParticle(Particle.DUST, p1, 0, new Particle.DustOptions(Color.AQUA, 2.0f));
                        player.getWorld().spawnParticle(Particle.DUST, p2, 0, new Particle.DustOptions(Color.AQUA, 2.0f));
                        player.getWorld().spawnParticle(Particle.DUST, p3, 0, new Particle.DustOptions(Color.AQUA, 2.0f));
                        player.getWorld().spawnParticle(Particle.DUST, p4, 0, new Particle.DustOptions(Color.AQUA, 2.0f));
                    }

                }
            };
            backLaunchParticles.runTaskTimer(MMOPlugin, 0L, 5L);



        }

    }
}
