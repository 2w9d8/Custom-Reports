package me.sanhak.venixcoding.customreports.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cThis command only for players , you can't perform this command from console !");
			return false;
		}
		Player player = (Player) sender;
		if (player.hasPermission("vcr.admin")) {
			if (args.length != 0) {
				player.sendMessage("§cWrong use , please try to type /crhelp");
				return false;
			} else {
				player.sendMessage("§8§l----------------------------------------");
				player.sendMessage(" ");
				player.sendMessage(" ");
				player.sendMessage(" §8» §6§l/cradd <reason> §fthis command to add reason !");
				player.sendMessage(" §8» §6§l/crremove <reason> §fthis command to remove reason !");
				player.sendMessage(" §8» §6§l/crlist §fthis command to list the reasons !");
				player.sendMessage(" §8» §6§l/report <player> <reason> §fthis command to report player !");
				player.sendMessage(" §8» §6§l/crreload §fthis command to reload plugin configuration !");
				player.sendMessage(" ");
				player.sendMessage(
						"§fThis plugin has been created by Sanhak from venix Coding if u wanna more plug-ins or support please join our discord server §9https://discord.gg/5yktaCZxQc");
				player.sendMessage(" ");
				player.sendMessage(" ");
				player.sendMessage("§8§l----------------------------------------");
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 0.5f, 5.0f);
			}
		} else {
			player.sendMessage("§cYou don't have enough permissions to perform this command !");
			player.playSound(player.getLocation(), Sound.ITEM_BREAK, 0.5f, 5.0f);
		}
		return false;
	}

}
