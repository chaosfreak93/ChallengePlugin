/*
 * Created by Chaosfreak93
 */

package de.beyonddark.ChallengePlugin.inventorys.Spielregel;

import de.beyonddark.ChallengePlugin.files.SpielregelConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class SoupSettingsInv {
    private final Inventory inv;

    public SoupSettingsInv() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 27, "§6Einstellungen §8- §aSoup Settings");

        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        SpielregelConfig.reload();
        inv.setItem(0, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(1, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(2, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(3, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(4, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(5, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(6, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(7, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(8, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(9, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(10, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(11, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(12, createGuiItem(Material.GREEN_WOOL, "§a+1 HP"));
        inv.setItem(13, createGuiItem(Material.MUSHROOM_STEW, "§aSoup", "", " §9§nBeschreibung§r§8:", "  §7Heile dich mit §9Pilzsuppen§7,", "  §9Borschtsch §7und §9Kaninchenragout§7.", "", " §9§nEigenschaften§r§8:", "  §7Heilung durch Suppen§r§8: §2" + SpielregelConfig.get().getInt("SoupHeal") + "HP", "", "§a§oGrün§r§8: §9+1 HP", "§c§oRot§r§8: §9-1 HP"));
        inv.setItem(14, createGuiItem(Material.RED_WOOL, "§c-1 HP"));
        inv.setItem(15, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(16, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(17, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(18, createGuiItem(Material.BARRIER, "§4BACK"));
        inv.setItem(19, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(20, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(21, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(22, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(23, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(24, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(25, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(26, createGuiItem(Material.BARRIER, "§4BACK"));
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