package me.adarsh.GodRTPAddons.addons.magicStick.cmds;

import me.adarsh.GodRTPAddons.addons.magicStick.AddonMagicStick;
import org.bukkit.command.CommandSender;

public interface MagicStickCommands {

    void execute(CommandSender sendi, String label, String[] args, AddonMagicStick addonPortals);

}
