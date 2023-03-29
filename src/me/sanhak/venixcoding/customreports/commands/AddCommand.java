package me.sanhak.venixcoding.customreports.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.sanhak.venixcoding.customreports.configuration.Configuration;

public class AddCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cThis command only for players , you can't perform this command from console !");
			return false;
		}
		Player player = (Player) sender;
		if (player.hasPermission("vcr.admin")) {
			if (args.length != 1) {
				player.sendMessage("§cWrong use , please try to type /cradd <reason>");
				return false;
			} else {
				String reason = args[0];
				if (!(Configuration.isExists(reason))) {
					Configuration.addReason(reason);
					player.sendMessage("§aYou have been added this §6" + reason + " §areason successfully !");
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 0.5f, 5.0f);
					Configuration.save();
				} else {
					player.sendMessage("§cThis §f" + reason + "§c reason already exists !");
					player.playSound(player.getLocation(), Sound.ITEM_BREAK, 0.5f, 5.0f);
				}
			}
		} else {
			player.sendMessage("§cYou don't have enough permissions to perform this command !");
			player.playSound(player.getLocation(), Sound.ITEM_BREAK, 0.5f, 5.0f);
		}
		return false;
	}

}
