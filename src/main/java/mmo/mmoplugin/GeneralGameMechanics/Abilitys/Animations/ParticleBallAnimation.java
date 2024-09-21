package mmo.mmoplugin.GeneralGameMechanics.Abilitys.Animations;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static mmo.mmoplugin.MMOPlugin.MMOPlugin;

public class ParticleBallAnimation {

    public static BukkitRunnable smallBurstAbilityAnimation;

    public static void ballParticleAnimation(Location loc, Player player, Particle particle, int burstTimes) {

        World world = loc.getWorld();
        smallBurstAbilityAnimation = new BukkitRunnable() {

            double phi = 0;

            //int animationLoop =0;

            @Override
            public void run() {

                phi += Math.PI / 10; //<< 10 circles HIGHLY RECOMENED DO NOT SO MORE

                for (double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / 40) {
                    double r = 1.5;
                    double x = r * cos(theta) * sin(phi);
                    double y = r * cos(phi) + 1.5;
                    double z = r * sin(theta) * sin(phi);
                    loc.add(x, y, z);
                    world.spawnParticle(particle, loc, 0, 0, 0, 0, 1);
                    loc.subtract(x, y, z);
                }


                if (phi > Math.PI * burstTimes) {
                    this.cancel();
                    return;
                }


            }
        };
        smallBurstAbilityAnimation.runTaskTimer(MMOPlugin, 0L, 0L);

    }
}

