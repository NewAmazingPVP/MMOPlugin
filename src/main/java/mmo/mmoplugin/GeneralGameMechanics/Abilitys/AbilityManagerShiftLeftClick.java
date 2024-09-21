package mmo.mmoplugin.GeneralGameMechanics.Abilitys;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static mmo.mmoplugin.GeneralGameMechanics.Abilitys.Trigger.SmallBurstAbility.smallBurstAbilityTRIGGER;
import static mmo.mmoplugin.GeneralGameMechanics.Abilitys.Trigger.backwardsLaunchAbility.backwardsLaunchAbilityTRIGGER;

public class AbilityManagerShiftLeftClick implements Listener {

    @EventHandler
    public void event(PlayerInteractEvent e){

        Player player = e.getPlayer();
        Location playerLoc = player.getLocation();
        Block clickedBlock = e.getClickedBlock();
        assert clickedBlock != null;
        Location loc = clickedBlock.getLocation();


        if (e.getAction() == Action.LEFT_CLICK_BLOCK){
            if(player.isSneaking()){


                //backwardsLaunchAbilityTRIGGER(loc,player);

                smallBurstAbilityTRIGGER(playerLoc,player);

            }


        }

    }

}
