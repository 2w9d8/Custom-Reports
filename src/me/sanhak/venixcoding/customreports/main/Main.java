package me.sanhak.venixcoding.customreports.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.sanhak.venixcoding.customreports.commands.AddCommand;
import me.sanhak.venixcoding.customreports.commands.HelpCommand;
import me.sanhak.venixcoding.customreports.commands.ListCommand;
import me.sanhak.venixcoding.customreports.commands.ReloadCommand;
import me.sanhak.venixcoding.customreports.commands.RemoveCommand;
import me.sanhak.venixcoding.customreports.commands.ReportCommand;
import me.sanhak.venixcoding.customreports.configuration.Configuration;
import me.sanhak.venixcoding.customreports.listeners.InventoryClickListener;

public class Main extends JavaPlugin {

	public Configuration config;
	

	@Override
	public void onEnable() {
		
		this.config = new Configuration(this, "config.yml", true);
		Bukkit.getConsoleSender()
				.sendMessage("§b\n" + " _____           _                   ______                      _       \r\n"
						+ "/  __ \\         | |                  | ___ \\                    | |      \r\n"
						+ "| /  \\/_   _ ___| |_ ___  _ __ ___   | |_/ /___ _ __   ___  _ __| |_ ___ \r\n"
						+ "| |   | | | / __| __/ _ \\| '_ ` _ \\  |    // _ \\ '_ \\ / _ \\| '__| __/ __|\r\n"
						+ "| \\__/\\ |_| \\__ \\ || (_) | | | | | | | |\\ \\  __/ |_) | (_) | |  | |_\\__ \\\r\n"
						+ " \\____/\\__,_|___/\\__\\___/|_| |_| |_| \\_| \\_\\___| .__/ \\___/|_|   \\__|___/\r\n"
						+ "                                               | |                       \r\n"
						+ "                                               |_|            by Sanhak from Venix Coding");
		Bukkit.getConsoleSender().sendMessage("§aPlugin has been enabled §b[Beta 0.1 verison]");
		Bukkit.getConsoleSender().sendMessage("§9Support server discord.gg/VQGdE9jpKK");
		registerCommands();
		registerEvents();
	}

	@Override
	public void onDisable() {
		Bukkit.getConsoleSender()
				.sendMessage("§b\n" + " _____           _                   ______                      _       \r\n"
						+ "/  __ \\         | |                  | ___ \\                    | |      \r\n"
						+ "| /  \\/_   _ ___| |_ ___  _ __ ___   | |_/ /___ _ __   ___  _ __| |_ ___ \r\n"
						+ "| |   | | | / __| __/ _ \\| '_ ` _ \\  |    // _ \\ '_ \\ / _ \\| '__| __/ __|\r\n"
						+ "| \\__/\\ |_| \\__ \\ || (_) | | | | | | | |\\ \\  __/ |_) | (_) | |  | |_\\__ \\\r\n"
						+ " \\____/\\__,_|___/\\__\\___/|_| |_| |_| \\_| \\_\\___| .__/ \\___/|_|   \\__|___/\r\n"
						+ "                                               | |                       \r\n"
						+ "                                               |_|            by Sanhak from Venix Coding");
		Bukkit.getConsoleSender().sendMessage("§cPlugin has been disabled §b[Beta 0.1 verison]");
		Bukkit.getConsoleSender().sendMessage("§9Support server discord.gg/VQGdE9jpKK");
	}

	private void registerCommands() {
		getCommand("cradd").setExecutor(new AddCommand());
		getCommand("crremove").setExecutor(new RemoveCommand());
		getCommand("crlist").setExecutor(new ListCommand());
		getCommand("report").setExecutor(new ReportCommand());
		getCommand("crreload").setExecutor(new ReloadCommand());
		getCommand("crhelp").setExecutor(new HelpCommand());
		Bukkit.getConsoleSender().sendMessage("§aRegister the commands has been done");
	}

	private void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
		Bukkit.getConsoleSender().sendMessage("§aRegister the event/s has been done");
	}

}
