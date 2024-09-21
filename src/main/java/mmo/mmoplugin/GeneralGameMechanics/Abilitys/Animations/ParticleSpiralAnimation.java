package mmo.mmoplugin.GeneralGameMechanics.Abilitys.Animations;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static mmo.mmoplugin.MMOPlugin.MMOPlugin;

public class ParticleSpiralAnimation {

    public static BukkitRunnable smallCircleAnimation;

    public static void setSpiralAnimation(Location loc, Particle particle, int burstTimes) {

        World world = loc.getWorld();

        int radius = 2;
        for(double y = 0; y <= 50; y+=0.05) {
            double x = radius * Math.cos(y);
            double z = radius * Math.sin(y);
            world.spawnParticle(particle, loc, 0, 0, 0, 0, 1);

        }


    }


}
