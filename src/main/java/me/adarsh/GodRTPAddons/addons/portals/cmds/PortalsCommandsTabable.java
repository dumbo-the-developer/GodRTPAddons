package me.adarsh.GodRTPAddons.addons.portals.cmds;

import me.adarsh.GodRTPAddons.addons.portals.AddonPortals;
import org.bukkit.command.CommandSender;

import java.util.List;

public interface PortalsCommandsTabable {

    List<String> tabComplete(CommandSender sendi, String[] args, AddonPortals addonPortals);

}
