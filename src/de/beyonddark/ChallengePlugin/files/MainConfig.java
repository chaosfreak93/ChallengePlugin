/*
 * Created by Chaosfreak93
 */

package de.beyonddark.ChallengePlugin.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MainConfig {

    private static File file;
    private static FileConfiguration customFile;

    public static void setup() throws IOException {
        file = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("Challenge")).getDataFolder(), "config.yml");

        if (!file.exists()) {
            file.createNewFile();
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return customFile;
    }

    public static FileConfiguration set() {
        return customFile = customFile;
    }

    public static void save() throws IOException {
        customFile.save(file);
    }

    public static void reload() {
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}
