/*
 * Created by Chaosfreak93
 */

package de.beyonddark.ChallengePlugin.events;

import de.beyonddark.ChallengePlugin.inventorys.EinstellungInv;
import de.beyonddark.ChallengePlugin.inventorys.HerausforderungInv;
import de.beyonddark.ChallengePlugin.other.Scoreboard;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        Scoreboard.setup(p);
        e.setJoinMessage(ChatColor.GREEN + ">> " + ChatColor.GRAY + p.getName());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(ChatColor.RED + "<< " + ChatColor.GRAY + p.getName());
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        ItemStack whatWasClicked = e.getCurrentItem();
        Player p = (Player) e.getWhoClicked();
        InventoryAction clickType = e.getAction();
        assert whatWasClicked != null;
        if (e.getView().getTitle().equals("§6Einstellungen §8- §1Übersicht")) {
            if (whatWasClicked.getType() == Material.DRAGON_HEAD) {
                p.closeInventory();
                HerausforderungInv inv = new HerausforderungInv();
                inv.openInventory(p);
            } else if (whatWasClicked.getType() == Material.GRASS_BLOCK) {
                p.closeInventory();
                p.sendTitle("§4SOON...", "", 10,15, 10);
            } else if (whatWasClicked.getType() == Material.IRON_PICKAXE) {
                p.closeInventory();
            } else if (whatWasClicked.getType() == Material.MAP) {
                p.closeInventory();
            }
            e.setCancelled(true);
        }
        if (e.getView().getTitle().equals("§6Einstellungen §8- §cHerausforderung")) {
            if (whatWasClicked.getType() == Material.DRAGON_HEAD) {
                p.closeInventory();
                HerausforderungInv inv = new HerausforderungInv();
                inv.openInventory(p);
            } else if (whatWasClicked.getType() == Material.WITHER_SKELETON_SKULL) {
                p.closeInventory();
                HerausforderungInv inv = new HerausforderungInv();
                inv.openInventory(p);
            } else if (whatWasClicked.getType() == Material.SKELETON_SKULL) {
                p.closeInventory();
                HerausforderungInv inv = new HerausforderungInv();
                inv.openInventory(p);
            } else if (whatWasClicked.getType() == Material.GRASS_BLOCK) {
                p.closeInventory();
                HerausforderungInv inv = new HerausforderungInv();
                inv.openInventory(p);
            } else if (whatWasClicked.getType() == Material.CRAFTING_TABLE) {
                p.closeInventory();
                HerausforderungInv inv = new HerausforderungInv();
                inv.openInventory(p);
            } else if (whatWasClicked.getType() == Material.VILLAGER_SPAWN_EGG) {
                p.closeInventory();
                HerausforderungInv inv = new HerausforderungInv();
                inv.openInventory(p);
            } else if (whatWasClicked.getType() == Material.STONE_PICKAXE) {
                p.closeInventory();
                HerausforderungInv inv = new HerausforderungInv();
                inv.openInventory(p);
            } else if (whatWasClicked.getType() == Material.EXPERIENCE_BOTTLE) {
                p.closeInventory();
                HerausforderungInv inv = new HerausforderungInv();
                inv.openInventory(p);
            } else if (whatWasClicked.getType() == Material.BARRIER) {
                p.closeInventory();
                EinstellungInv inv = new EinstellungInv();
                inv.openInventory(p);
            }
            e.setCancelled(true);
        }
    }
}
