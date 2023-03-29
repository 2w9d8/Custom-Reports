package me.sanhak.venixcoding.customreports.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.sanhak.venixcoding.customreports.configuration.Configuration;
import me.sanhak.venixcoding.customreports.cooldown.Cooldown;

public class ReportCommand implements CommandExecutor {
	private Cooldown cd = new Cooldown();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		List<String> reasons = Configuration.getConfiguration().getStringList("Reasons-List");
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cThis command only for players , you can't perform this command from console !");
			return false;
		}
		Player player = (Player) sender;
		if (args.length != 2) {
			player.sendMessage("§cWrong use , please try to type /report <player> <reason>");
			return false;
		} else {

			Player targetPlayer = Bukkit.getPlayer(args[0]);
			String reason = args[1];
			if (cd.isOk(player)) {
				cd.setPlayerCooldown(player, 60);
				if (targetPlayer.isOnline() && targetPlayer != null) {
					if (player != targetPlayer) {
						if (Configuration.isExists(reason)) {
							for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
								if (!(onlinePlayers.hasPermission("reports.notify"))) {
									continue;
								} else {

									onlinePlayers.sendMessage("§9" + player.getName() + " §7has been reported §c"
											+ targetPlayer.getName() + " §7with this reason §6" + reason);
									onlinePlayers.playSound(onlinePlayers.getLocation(), Sound.BLAZE_DEATH, 11.5f,
											15.0f);
									player.sendMessage("§aYou have been reported §c" + targetPlayer.getName()
											+ " §asuccessfully !");

								}
							}
						} else {
							player.sendMessage("§cThe Reason not avaiable , the avaiable reasons : §f§l" + reasons);
							player.playSound(player.getLocation(), Sound.BAT_HURT, 0.5f, 5.0f);
						}
					} else {
						player.sendMessage("§cYou can't report your self !");
						player.playSound(player.getLocation(), Sound.DONKEY_ANGRY, 0.5f, 5.0f);
					}
				} else {
					player.sendMessage("§cSorry but player not online !");
					player.playSound(player.getLocation(), Sound.CAT_PURR, 0.5f, 5.0f);
				}

			} else {
				player.sendMessage("§cYou can report another once after §a" + cd.getRemainingTime(player) + " §cseconds !");
			}
		}
		return false;
	}

}
