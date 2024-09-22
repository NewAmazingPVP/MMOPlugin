package mmo.mmoplugin;

import mmo.mmoplugin.GeneralGameMechanics.Abilitys.AbilityManagerShiftLeftClick;
import mmo.mmoplugin.GeneralGameMechanics.Commands.UserCommands.OpenAbilityMenuCMD;
import mmo.mmoplugin.GeneralGameMechanics.DeathMechanics.DeathMain;
import mmo.mmoplugin.GeneralGameMechanics.MainMenuAndStats.MainMenuListener;
import mmo.mmoplugin.YMLReading.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import static mmo.mmoplugin.RegisterEventsAndCMD.registerCommandsAndListeners;

//          $$\      $$\ $$\      $$\  $$$$$$\        $$$$$$$\  $$\      $$\   $$\  $$$$$$\  $$$$$$\ $$\   $$\
//          $$$\    $$$ |$$$\    $$$ |$$  __$$\       $$  __$$\ $$ |     $$ |  $$ |$$  __$$\ \_$$  _|$$$\  $$ |
//          $$$$\  $$$$ |$$$$\  $$$$ |$$ /  $$ |      $$ |  $$ |$$ |     $$ |  $$ |$$ /  \__|  $$ |  $$$$\ $$ |
//          $$\$$\$$ $$ |$$\$$\$$ $$ |$$ |  $$ |      $$$$$$$  |$$ |     $$ |  $$ |$$ |$$$$\   $$ |  $$ $$\$$ |
//          $$ \$$$  $$ |$$ \$$$  $$ |$$ |  $$ |      $$  ____/ $$ |     $$ |  $$ |$$ |\_$$ |  $$ |  $$ \$$$$ |
//          $$ |\$  /$$ |$$ |\$  /$$ |$$ |  $$ |      $$ |      $$ |     $$ |  $$ |$$ |  $$ |  $$ |  $$ |\$$$ |
//          $$ | \_/ $$ |$$ | \_/ $$ | $$$$$$  |      $$ |      $$$$$$$$\\$$$$$$  |\$$$$$$  |$$$$$$\ $$ | \$$ |
//          \__|     \__|\__|     \__| \______/       \__|      \________|\______/  \______/ \______|\__|  \__|



public final class MMOPlugin extends JavaPlugin {



    public static MMOPlugin MMOPlugin;
    public static ConfigManager configManager;
    public static World MMOworld = Bukkit.getWorld("world");
    public static final String PLUGIN_WATERMARK = "© 2024 [NewAmazingPVP & Comet99 & Lex] - [MMOPlugin]";
    @Override
    public void onEnable() {
        MMOPlugin = this;
        // server start up things below
        getLogger().info("Starting " + PLUGIN_WATERMARK);
        getLogger().info("DO NOT USE ANYTHING FROM THIS PLUGIN FOR MONETARY GAN!!!");
        getLogger().info("[WARNING] This plugin is very very and will have extremely bad bugs =D");



        //register events and commands

        getServer().getPluginManager().registerEvents(new DeathMain(), this);
        getServer().getPluginManager().registerEvents(new MainMenuListener(), this);
        getServer().getPluginManager().registerEvents(new AbilityManagerShiftLeftClick(), this);



        getCommand("abilities").setExecutor(new OpenAbilityMenuCMD());

        configManager = new ConfigManager(this.getDataFolder(), "stats.yml");
        configManager.addDefault("stats", "1");

        registerCommandsAndListeners();



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
