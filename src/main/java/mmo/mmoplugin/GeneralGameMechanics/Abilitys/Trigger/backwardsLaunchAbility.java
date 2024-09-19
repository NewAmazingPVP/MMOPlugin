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

                    if(animationLoop > 50){
                        this.cancel();
                        return;
                    }

                    player.sendMessage("+++" + p1);

                    //p1.setY(p1.getY() + .1);
                    p1.setX(p1.getX() + .5);
                    p1.setZ(p1.getZ() + .2);

                    //p2.setY(p2.getY() + .1);
                    p2.setX(p2.getX() - .3);
                    p2.setZ(p2.getZ() - .3);

                    //p3.setY(p3.getY() + .1);
                    p3.setX(p3.getX() - .3);
                    p3.setZ(p3.getZ() + .3);

                    //p4.setY(p4.getY() + .1);
                    p4.setX(p4.getX() + .3);
                    p4.setZ(p4.getZ() - .3);



                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.getWorld().spawnParticle(Particle.DUST, p1, 0, new Particle.DustOptions(Color.AQUA, 2.0f));
                        //player.getWorld().spawnParticle(Particle.DUST, p2, 0, new Particle.DustOptions(Color.RED, 2.0f));
                        //player.getWorld().spawnParticle(Particle.DUST, p3, 0, new Particle.DustOptions(Color.GREEN, 2.0f));
                        //player.getWorld().spawnParticle(Particle.DUST, p4, 0, new Particle.DustOptions(Color.YELLOW, 2.0f));
                    }

                }
            };
            backLaunchParticles.runTaskTimer(MMOPlugin, 0L, 1L);



        }

    }
}
