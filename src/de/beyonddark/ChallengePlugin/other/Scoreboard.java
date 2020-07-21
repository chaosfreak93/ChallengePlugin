/*
 * Created by Chaosfreak93
 */

package de.beyonddark.ChallengePlugin.other;

import de.beyonddark.ChallengePlugin.files.MainConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.Objects;

public class Scoreboard {

    public static void setup(Player p) {
        System.out.println("Test");
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("Challenge")), () -> {
            assert manager != null;
            org.bukkit.scoreboard.Scoreboard scoreboard = manager.getNewScoreboard();
            Objective objective = scoreboard.registerNewObjective("title", "dummy", ChatColor.DARK_BLUE + "Challenge");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            if (MainConfig.get().getBoolean("timerPaused")) {
                Score timer = objective.getScore("  " + ChatColor.GOLD + "Timer: " + ChatColor.GRAY + "pausiert" + " ");
                timer.setScore(1);
            } else  {
                Score timer = objective.getScore("  " + ChatColor.GOLD + "Timer: " + ChatColor.GRAY + calculateTime() + " ");
                timer.setScore(1);
            }
            Score placeholder = objective.getScore("");
            placeholder.setScore(2);
            p.setScoreboard(scoreboard);
        }, 0, 20);

    }

    public static String calculateTime() {
        int second = MainConfig.get().getInt("timerTime");
        int seconds = second % 60;
        int minutes = (second % (60 * 60)) / 60;
        int hours = (second / (60 * 60));


        return  hours + "St, " + minutes + "Min, " + seconds + "Sek";
    }
}
