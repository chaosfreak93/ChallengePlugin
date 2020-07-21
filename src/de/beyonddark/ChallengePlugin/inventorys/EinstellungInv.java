/*
 * Created by Chaosfreak93
 */

package de.beyonddark.ChallengePlugin.inventorys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class EinstellungInv {
    private final Inventory inv;

    public EinstellungInv() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 27, "§6Einstellungen §8- §1Übersicht");

        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
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
        inv.setItem(11, createGuiItem(Material.DRAGON_HEAD, "§cHerausforderung", "", " §cHerausfoderungen §7geben denn §cSinn", " §7und das §cEnde §7der §cRunde §7vor.", "", "§c§oKlick§r§c: Übersicht", ""));
        inv.setItem(12, createGuiItem(Material.GRASS_BLOCK, "§bSpieländerung §4SOON...", "", " §7Spieländerungen §bverändern", " §7das §bSpielgeschehen §7auf", " §7vielen Art und Weisen.", "", "§b§oKlick§r§b: Übersicht", ""));
        inv.setItem(13, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(14, createGuiItem(Material.IRON_PICKAXE, "§6Funktion"));
        inv.setItem(15, createGuiItem(Material.MAP, "§2Spielregel"));
        inv.setItem(16, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(17, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(18, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(19, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(20, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(21, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(22, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(23, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(24, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(25, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(26, createGuiItem(Material.GRAY_STAINED_GLASS_PANE, " "));
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
