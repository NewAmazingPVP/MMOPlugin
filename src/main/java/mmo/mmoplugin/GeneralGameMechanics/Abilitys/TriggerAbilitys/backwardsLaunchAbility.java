package mmo.mmoplugin.GeneralGameMechanics.Abilitys.TriggerAbilitys;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import static mmo.mmoplugin.GeneralGameMechanics.Abilitys.Animations.ParticleSmallCircleAnimation.setSmallCircleAnimation;

public class backwardsLaunchAbility {




    public static void backwardsLaunchAbilityTRIGGER(Location loc, Player player) {



        World world = loc.getWorld();
        if (world != null) {


            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.playSound(loc, Sound.ENTITY_BLAZE_SHOOT, 5.0f, 1.0f);
            }

            Vector direction = player.getLocation().toVector().subtract(loc.toVector()).normalize();
            Vector velocity = direction.multiply(1.5);
            if (velocity.getY() > 1) {
                velocity.setY(1);
            }

            player.setVelocity(velocity);

            loc.setY(loc.getY()+1);

            world.spawnParticle(Particle.CLOUD,loc,20);


            setSmallCircleAnimation(loc, Particle.COMPOSTER, 1);



        }

    }
}
