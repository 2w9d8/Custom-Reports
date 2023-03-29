package me.sanhak.venixcoding.customreports.cooldown;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

public class Cooldown {

	private HashMap<UUID, Double> cooldowns = new HashMap<UUID, Double>();

	
	public boolean isOk(Player player) {
		if (!cooldowns.containsKey(player.getUniqueId())
				|| cooldowns.get(player.getUniqueId()) <= System.currentTimeMillis()) {
			return true;
		}
		return false;
	}

	public void setPlayerCooldown(Player p, int seconds) {
		double delay = System.currentTimeMillis() + (seconds * 1000);
		cooldowns.put(p.getUniqueId(), delay);
	}

	public int getRemainingTime(Player p) {
		return Math.toIntExact(Math.round((cooldowns.get(p.getUniqueId()) - System.currentTimeMillis()) / 1000));
	}

}
