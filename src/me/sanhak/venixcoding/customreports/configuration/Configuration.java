package me.sanhak.venixcoding.customreports.configuration;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Configuration {

	private static File file;
	private static FileConfiguration fileConfiguration;

	public Configuration(JavaPlugin plugin, String configurationName , boolean saveDefault) {
		Configuration.file = new File(plugin.getDataFolder(), configurationName);
		Configuration.file.getParentFile().mkdirs();
		 if (!file.exists()) {
	            if (saveDefault) {
	                plugin.saveResource(configurationName, true);
	            } else {
	                try {
	                    file.createNewFile();
	                }
					catch (IOException var5) {
	                    var5.printStackTrace();
	                }
	            }
	        }
		Configuration.fileConfiguration = YamlConfiguration.loadConfiguration(file);
	}

	public static FileConfiguration getConfiguration() {
		return fileConfiguration;
	}

	public static void reload() {
		Configuration.fileConfiguration = YamlConfiguration.loadConfiguration(file);
	}

	public static void save() {
		try {
			fileConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addReason(String reason) {
		List<String> reasons = getConfiguration().getStringList("Reasons-List");
		reasons.add(reason);
		getConfiguration().set("Reasons-List", reasons);
		save();
	}

	public static void removeReason(String reason) {
		List<String> reasons = getConfiguration().getStringList("Reasons-List");
		reasons.remove(reason);
		getConfiguration().set("Reasons-List", reasons);
		save();
	}

	public static boolean isExists(String reason) {
		List<String> reasons = getConfiguration().getStringList("Reasons-List");
		if (reasons.contains(reason)) {
			return true;
		}
		return false;
	}

}
