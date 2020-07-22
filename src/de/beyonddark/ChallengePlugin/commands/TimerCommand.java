/*
 * Created by Chaosfreak93
 */

package de.beyonddark.ChallengePlugin.commands;

import de.beyonddark.ChallengePlugin.other.Timer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case "resume" -> {
                    Timer.resume((Player) sender);
                    return true;
                }
                case "stop" -> {
                    Timer.stop((Player) sender);
                    return true;
                }
                case "reset" -> {
                    Timer.stop((Player) sender);
                    Timer.reset();
                    return true;
                }
            }
        }
        return false;
    }
}
