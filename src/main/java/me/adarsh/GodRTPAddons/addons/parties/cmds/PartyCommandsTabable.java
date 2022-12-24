package me.adarsh.GodRTPAddons.addons.parties.cmds;

import me.adarsh.GodRTPAddons.addons.parties.AddonParty;
import org.bukkit.command.CommandSender;

import java.util.List;

public interface PartyCommandsTabable {

    List<String> tabComplete(CommandSender sendi, String[] args, AddonParty addon);

}
