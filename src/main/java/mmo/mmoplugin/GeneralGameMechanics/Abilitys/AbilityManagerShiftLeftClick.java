package mmo.mmoplugin.GeneralGameMechanics.Abilitys;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class AbilityManagerShiftLeftClick implements Listener {

    @EventHandler
    public void event(PlayerInteractEvent e){

        Player player = e.getPlayer();
        Block clickedBlock = e.getClickedBlock();
        assert clickedBlock != null;
        Location loc = clickedBlock.getLocation();


        if (e.getAction() == Action.RIGHT_CLICK_AIR){
            if(player.isSneaking()){


                player.sendMessage("Click detected at" + loc);


            }


        }

    }

}
