/*
 * Created by Chaosfreak93
 */

package de.beyonddark.ChallengePlugin.inventorys;

import de.beyonddark.ChallengePlugin.files.SpielregelConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class SpielregelInv {
    private final Inventory inv;

    public SpielregelInv() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 36, "§6Einstellungen §8- §aSpielregeln");

        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        SpielregelConfig.reload();
        inv.setItem(0,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(1,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(2,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(3,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(4,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(5,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(6,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(7,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(8,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(9,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        if (SpielregelConfig.get().getBoolean("Soup")) {
            inv.setItem(10,createGuiItem(Material.MUSHROOM_STEW, "§aSoup", "", " §9§nBeschreibung§r§8:", "  §7Heile dich mit §9Pilzsuppen§7,", "  §9Borschtsch §7und §9Kaninchenragout§7.", "", " §9§nEigenschaften§r§8:", "  §7Type§r§8: §aSpielregel", "  §7Status§r§8: §2aktiviert", "  §7Heilung durch Suppen§r§8: §2" + SpielregelConfig.get().getInt("SoupHeal") + "HP", "", "§a§oLinksklick§r§8: §9Status ändern", "§a§oRechtsklick§r§8: §9Einstellungen"));
        } else if (!SpielregelConfig.get().getBoolean("Soup")) {
            inv.setItem(10,createGuiItem(Material.MUSHROOM_STEW, "§aSoup", "", " §9§nBeschreibung§r§8:", "  §7Heile dich mit §9Pilzsuppen§7,", "  §9Borschtsch §7und §9Kaninchenragout§7.", "", " §9§nEigenschaften§r§8:", "  §7Type§r§8: §aSpielregel", "  §7Status§r§8: §4deaktiviert", "  §7Heilung durch Suppen§r§8: §2" + SpielregelConfig.get().getInt("SoupHeal") + "HP", "", "§a§oLinksklick§r§8: §9Status ändern", "§a§oRechtsklick§r§8: §9Einstellungen"));
        }
        inv.setItem(11,createGuiItem(Material.MELON_SLICE, " "));
        inv.setItem(12,createGuiItem(Material.RED_TULIP, " "));
        inv.setItem(13,createGuiItem(Material.GOLDEN_APPLE, " "));
        inv.setItem(14,createGuiItem(Material.REDSTONE, " "));
        inv.setItem(15,createGuiItem(Material.IRON_SWORD, " "));
        inv.setItem(16,createGuiItem(Material.REDSTONE, " "));
        inv.setItem(17,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(18,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        if (SpielregelConfig.get().getBoolean("Schadensanzeige")) {
            inv.setItem(19, createGuiItem(Material.REDSTONE_LAMP, "§aSchadensanzeige", "", " §9§nBeschreibung§r§8:", "  §7Teile deine §9Leben§7,", "  §7mit anderen §9Spielern§7.", "", " §9§nEigenschaften§r§8:", "  §7Type§r§8: §aSpielregel", "  §7Status§r§8: §2aktiviert", "", "§a§oKlick§r§8: §9Status ändern"));
        } else if (!SpielregelConfig.get().getBoolean("Schadensanzeige")) {
            inv.setItem(19,createGuiItem(Material.REDSTONE_LAMP, "§aSchadensanzeige", "", " §9§nBeschreibung§r§8:", "  §7Teile deine §9Leben§7,", "  §7mit anderen §9Spielern§7.", "", " §9§nEigenschaften§r§8:", "  §7Type§r§8: §aSpielregel", "  §7Status§r§8: §4deaktiviert", "", "§a§oKlick§r§8: §9Status ändern"));
        }
        inv.setItem(20,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(21,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(22,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(23,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(24,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(25,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(26, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(27, createGuiItem(Material.BARRIER, "§4BACK"));
        inv.setItem(28,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(29,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(30,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(31,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(32,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(33,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(34,createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(35, createGuiItem(Material.BARRIER, "§4BACK"));
    }

    // Nice little method to create a gui item with a custom name, and description
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        assert meta != null;
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

    // You can open the inventory with this
    public void openInventory(final Player player) {
        player.openInventory(inv);
    }
}
