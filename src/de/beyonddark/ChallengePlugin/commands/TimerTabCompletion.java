/*
 * Created by Chaosfreak93
 */

package de.beyonddark.ChallengePlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TimerTabCompletion implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length == 1) {
            List<String> arguments = new ArrayList<>();

            arguments.add("resume");
            arguments.add("stop");
            arguments.add("reset");

            return arguments;
        }

        return null;
    }
}
