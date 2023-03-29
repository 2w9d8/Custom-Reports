package me.sanhak.venixcoding.customreports.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

	@EventHandler
	public void onClickonMyFuckingInventory(InventoryClickEvent inventoryClickEvent) {
		if (inventoryClickEvent.getInventory().getTitle().equalsIgnoreCase("§cReasons")) {
			inventoryClickEvent.setCancelled(true);
		}
	}

}
