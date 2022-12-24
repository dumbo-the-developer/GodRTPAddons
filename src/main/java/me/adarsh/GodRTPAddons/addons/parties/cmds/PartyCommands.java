package me.adarsh.GodRTPAddons.addons.parties.cmds;

import me.adarsh.GodRTPAddons.addons.parties.AddonParty;
import org.bukkit.command.CommandSender;

public interface PartyCommands {

    void execute(CommandSender sendi, String label, String[] args, AddonParty addonPortals);

}
