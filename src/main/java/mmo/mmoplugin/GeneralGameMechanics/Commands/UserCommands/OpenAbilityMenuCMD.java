package mmo.mmoplugin.GeneralGameMechanics.Commands.UserCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static mmo.mmoplugin.GeneralGameMechanics.MainMenuAndStats.AbilityMenu.openAbilityMenu;

public class OpenAbilityMenuCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        openAbilityMenu(player);

        return true;
    }



}
