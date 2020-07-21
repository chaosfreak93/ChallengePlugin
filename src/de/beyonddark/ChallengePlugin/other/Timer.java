/*
 * Created by Chaosfreak93
 */

package de.beyonddark.ChallengePlugin.other;

import de.beyonddark.ChallengePlugin.files.MainConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.Objects;

public class Timer {

    public static int task = 0;

    public static void start(Player p) {
        if (task < 2) {
            task = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("Challenge")), new Runnable() {
                @Override
                public void run() {
                    int timer = MainConfig.get().getInt("timerTime");
                    MainConfig.get().set("timerTime", timer + 1);
                    try {
                        MainConfig.save();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }, 0, 20);
            MainConfig.get().set("timerPaused", false);
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage("§r§7§lDer Timer §r§a§lwurde gestartet§r§7§l.§r");
                player.sendTitle("§r§7§lDer Timer", "§r§a§lwurde gestartet§r§7§l.§r", 15,20, 15);
            }
        } else {
            p.sendMessage("§r§7§lDer Timer §r§a§lläuft bereits§r§7§l.§r");
        }
    }

    public static void stop(Player p) {
        if (task > 0) {
            Bukkit.getScheduler().cancelTask(task);
            MainConfig.get().set("timerPaused", true);
            try {
                MainConfig.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
            task = 0;
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage("§r§7§lDer Timer §r§a§lwurde pausiert§r§7§l.§r");
                player.sendTitle("§r§7§lDer Timer", "§r§a§lwurde pausiert§r§7§l.§r", 15,20, 15);
            }
        } else {
            p.sendMessage("§rEs läuft kein §r§6Timer§r§4!§r");
        }
    }

    public static void reset() {
        MainConfig.get().set("timerTime", 0);
        try {
            MainConfig.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage("§r§7§lDer Timer §r§a§lwurde zurückgesetzt§r§7§l.§r");
            player.sendTitle("§r§7§lDer Timer", "§r§a§lwurde zurückgesetzt§r§7§l.§r", 15,20, 15);
        }
    }
}
