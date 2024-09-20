package mmo.mmoplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import java.util.ArrayList;
import java.util.List;
import static mmo.mmoplugin.MMOPlugin.MMOPlugin;

public class OnPluginStartupAndDisableLogic {

    public static List<Location> decrypterLocations  = new ArrayList<>(List.of(new Location(Bukkit.getWorld("world"), 913, 59, 677)));

    public static void startUpPluginSpawnEntitys(){

        for (Location loc : decrypterLocations) {
            ArmorStand armorStand = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
            armorStand.setVisible(true);
            armorStand.setSmall(false);
            armorStand.setInvulnerable(true);
            armorStand.setGravity(false);
            armorStand.setCustomName("§d§l[Decrypter]");

            String customTag = "MMO_Entity";
            MetadataValue customTagValue = new FixedMetadataValue(MMOPlugin, customTag);
            armorStand.setMetadata(customTag, customTagValue);


        }

    }

    public static void stopPluginSpawnEntitys(){

        

    }




}
