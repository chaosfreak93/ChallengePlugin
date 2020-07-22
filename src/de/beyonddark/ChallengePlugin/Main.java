/*
 * Created by Chaosfreak93
 */

package de.beyonddark.ChallengePlugin;

import de.beyonddark.ChallengePlugin.commands.SettingsCommand;
import de.beyonddark.ChallengePlugin.commands.TimerCommand;
import de.beyonddark.ChallengePlugin.commands.TimerTabCompletion;
import de.beyonddark.ChallengePlugin.events.EventListener;
import de.beyonddark.ChallengePlugin.files.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Objects;

public class Main extends JavaPlugin {

    @Override
    public void onLoad() {
        super.onLoad();
        try {
            MainConfig.setup();
            MainConfig.get().addDefault("timerTime", 0);
            MainConfig.get().addDefault("timerPaused", true);
            MainConfig.get().options().copyDefaults(true);
            MainConfig.save();

            FunktionConfig.setup();
            FunktionConfig.get().options().copyDefaults(true);
            FunktionConfig.save();

            HerausforderungConfig.setup();
            HerausforderungConfig.get().addDefault("Enderdragon", true);
            HerausforderungConfig.get().addDefault("Wither", false);
            HerausforderungConfig.get().addDefault("Tod", true);
            HerausforderungConfig.get().addDefault("BlockPlace", false);
            HerausforderungConfig.get().addDefault("Craft", false);
            HerausforderungConfig.get().addDefault("VillagerTrade", false);
            HerausforderungConfig.get().addDefault("BlockBreak", false);
            HerausforderungConfig.get().addDefault("NoXP", false);
            HerausforderungConfig.get().options().copyDefaults(true);
            HerausforderungConfig.save();

            SpielaenderungConfig.setup();
            SpielaenderungConfig.get().options().copyDefaults(true);
            SpielaenderungConfig.save();

            SpielregelConfig.setup();
            SpielregelConfig.get().addDefault("Soup", false);
            SpielregelConfig.get().addDefault("SoupHeal", 4);
            SpielregelConfig.get().addDefault("MaxLebenStatus", false);
            SpielregelConfig.get().addDefault("MaxLeben", 20);
            SpielregelConfig.get().addDefault("Schadensanzeige", false);
            SpielregelConfig.get().options().copyDefaults(true);
            SpielregelConfig.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEnable() {
        super.onEnable();
        Objects.requireNonNull(this.getCommand("timer")).setExecutor(new TimerCommand());
        Objects.requireNonNull(this.getCommand("timer")).setTabCompleter(new TimerTabCompletion());
        Objects.requireNonNull(this.getCommand("settings")).setExecutor(new SettingsCommand());
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
