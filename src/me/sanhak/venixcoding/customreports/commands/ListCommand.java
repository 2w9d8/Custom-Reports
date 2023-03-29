package me.sanhak.venixcoding.customreports.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.sanhak.venixcoding.customreports.configuration.Configuration;

public class ListCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cThis command only for players , you can't perform this command from console !");
			return false;
		}
		Player player = (Player) sender;
		if (player.hasPermission("vcr.admin")) {
			if (args.length != 0) {
				player.sendMessage("§cWrong use , please try to type /crlist");
				return false;
			} else {
				player.openInventory(createReasonsInventory());
				player.updateInventory();
				player.sendMessage("§aYou have been opened the reasons list successfully !");
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 0.5f, 5.0f);
			}
		} else {
			player.sendMessage("§cYou don't have enough permissions to perform this command !");
			player.playSound(player.getLocation(), Sound.ITEM_BREAK, 0.5f, 5.0f);
		}
		return false;
	}

	private Inventory createReasonsInventory() {
		List<String> reasons = Configuration.getConfiguration().getStringList("Reasons-List");
		Inventory inventory = Bukkit.createInventory(null, 9 * 6, "§cReasons");
		if (reasons.size() != 0 || !(reasons.isEmpty())) {
			for (String reason : reasons) {
				inventory.addItem(createSimpleFuckingItem(reason));
			}
		} else {
			inventory.addItem(addBarrier());
		}
		return inventory;
	}

	private ItemStack createSimpleFuckingItem(String fuckingDisplayName) {
		ItemStack itemStack = new ItemStack(Material.PAPER);
		ItemMeta itemMeta = itemStack.getItemMeta();
		itemMeta.setDisplayName("§6" + fuckingDisplayName);
		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}
	
	private ItemStack addBarrier() {
		ItemStack itemStack = new ItemStack(Material.PAPER);
		ItemMeta itemMeta = itemStack.getItemMeta();
		itemMeta.setDisplayName("§CNot found any reason");
		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}

}
