/*
 * Created by Chaosfreak93
 */

package de.beyonddark.ChallengePlugin.commands;

import de.beyonddark.ChallengePlugin.inventorys.EinstellungInv;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class SettingsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            EinstellungInv inv = new EinstellungInv();
            inv.openInventory(Objects.requireNonNull((Player) sender));
        }
        return true;
    }
}
