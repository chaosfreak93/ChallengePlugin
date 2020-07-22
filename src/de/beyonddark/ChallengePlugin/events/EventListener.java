/*
 * Created by Chaosfreak93
 */

package de.beyonddark.ChallengePlugin.events;

import de.beyonddark.ChallengePlugin.files.MainConfig;
import de.beyonddark.ChallengePlugin.files.SpielregelConfig;
import de.beyonddark.ChallengePlugin.inventorys.EinstellungInv;
import de.beyonddark.ChallengePlugin.inventorys.HerausforderungInv;
import de.beyonddark.ChallengePlugin.inventorys.Spielregel.SoupSettingsInv;
import de.beyonddark.ChallengePlugin.inventorys.SpielregelInv;
import de.beyonddark.ChallengePlugin.other.Scoreboard;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.Objects;

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
    public void onEntityDamage(EntityDamageEvent e) {
        e.setCancelled(MainConfig.get().getBoolean("timerPaused"));
    }

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent e) {
        e.setCancelled(MainConfig.get().getBoolean("timerPaused"));
    }

    @EventHandler
    public void onItemConsume(PlayerItemConsumeEvent e) {
        e.setCancelled(MainConfig.get().getBoolean("timerPaused"));
        if (!MainConfig.get().getBoolean("timerPaused")) {
            if (MainConfig.get().getBoolean("Soup")) {
                Material item = e.getItem().getType();
                Player p = e.getPlayer();
                int heal = SpielregelConfig.get().getInt("SoupHeal");
                if (item == Material.MUSHROOM_STEW || item == Material.BEETROOT_SOUP || item == Material.RABBIT_STEW) {
                    if (p.getHealth() + heal > 20) {
                        p.setHealth(20);
                    } else {
                        p.setHealth(p.getHealth() + heal);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) throws IOException {
        ItemStack whatWasClicked = e.getCurrentItem();
        Player p = (Player) e.getWhoClicked();
        ClickType clickType = e.getClick();
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
                SpielregelInv inv = new SpielregelInv();
                inv.openInventory(p);
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
        if (e.getView().getTitle().equals("§6Einstellungen §8- §aSpielregeln")) {
            if (whatWasClicked.getType().equals(Material.MUSHROOM_STEW)) {
                p.closeInventory();
                if (clickType.equals(ClickType.LEFT)) {
                    if (SpielregelConfig.set().getBoolean("Soup")) {
                        SpielregelConfig.set().set("Soup", false);
                    } else if (!SpielregelConfig.get().getBoolean("Soup")) {
                        SpielregelConfig.set().set("Soup", true);
                    }
                    SpielregelConfig.save();
                    SpielregelInv inv = new SpielregelInv();
                    inv.openInventory(p);
                } else if (clickType.equals(ClickType.RIGHT)) {
                    SoupSettingsInv inv = new SoupSettingsInv();
                    inv.openInventory(p);
                }
            } else if (whatWasClicked.getType() == Material.MELON_SLICE) {
                p.closeInventory();
                SpielregelInv inv = new SpielregelInv();
                inv.openInventory(p);
            } else if (whatWasClicked.getType() == Material.RED_TULIP) {
                p.closeInventory();
                SpielregelInv inv = new SpielregelInv();
                inv.openInventory(p);
            } else if (whatWasClicked.getType() == Material.GOLDEN_APPLE) {
                p.closeInventory();
                SpielregelInv inv = new SpielregelInv();
                inv.openInventory(p);
            } else if (Objects.requireNonNull(whatWasClicked.getItemMeta()).getDisplayName().equals("")) {
                p.closeInventory();
                SpielregelInv inv = new SpielregelInv();
                inv.openInventory(p);
            } else if (whatWasClicked.getType() == Material.IRON_SWORD) {
                p.closeInventory();
                SpielregelInv inv = new SpielregelInv();
                inv.openInventory(p);
            } else if (Objects.requireNonNull(whatWasClicked.getItemMeta()).getDisplayName().equals("§aMaximale Leben")) {
                p.closeInventory();
                SpielregelInv inv = new SpielregelInv();
                inv.openInventory(p);
            } else if (whatWasClicked.getType() == Material.REDSTONE_LAMP) {
                p.closeInventory();
                if (SpielregelConfig.get().getBoolean("Schadensanzeige")) {
                    SpielregelConfig.set().set("Schadensanzeige", false);
                } else if (!SpielregelConfig.get().getBoolean("Schadensanzeige")) {
                    SpielregelConfig.set().set("Schadensanzeige", true);
                }
                SpielregelConfig.save();
                SpielregelInv inv = new SpielregelInv();
                inv.openInventory(p);
            } else if (whatWasClicked.getType() == Material.BARRIER) {
                p.closeInventory();
                EinstellungInv inv = new EinstellungInv();
                inv.openInventory(p);
            }
            e.setCancelled(true);
        }
        if (e.getView().getTitle().equals("§6Einstellungen §8- §aSoup Settings")) {
            if (whatWasClicked.getType().equals(Material.GREEN_WOOL)) {
                int soupHeal = SpielregelConfig.get().getInt("SoupHeal");
                if (soupHeal <= 9) {
                    SpielregelConfig.set().set("SoupHeal", soupHeal + 1);
                    SpielregelConfig.save();
                    SpielregelConfig.reload();
                    SoupSettingsInv inv = new SoupSettingsInv();
                    inv.openInventory(p);
                }
            } else if (whatWasClicked.getType().equals(Material.RED_WOOL)) {
                int soupHeal = SpielregelConfig.get().getInt("SoupHeal");
                if (soupHeal >= 1) {
                    SpielregelConfig.set().set("SoupHeal", soupHeal - 1);
                    SpielregelConfig.save();
                    SpielregelConfig.reload();
                    SoupSettingsInv inv = new SoupSettingsInv();
                    inv.openInventory(p);
                }
            } else if (whatWasClicked.getType().equals(Material.BARRIER)) {
                p.closeInventory();
                SpielregelInv inv = new SpielregelInv();
                inv.openInventory(p);
            }
            e.setCancelled(true);
        }
    }
}
