package me.adarsh.GodRTPAddons.addons.portals.cmds;

import me.adarsh.GodRTPAddons.addons.portals.AddonPortals;
import org.bukkit.command.CommandSender;

public interface PortalsCommands {

    void execute(CommandSender sendi, String label, String[] args, AddonPortals addonPortals);

}
