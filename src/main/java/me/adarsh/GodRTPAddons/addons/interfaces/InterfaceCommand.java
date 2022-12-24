package me.adarsh.GodRTPAddons.addons.interfaces;

import me.adarsh.BetterRTP.BetterRTP;
import me.adarsh.BetterRTP.player.commands.RTPCommand;
import me.adarsh.BetterRTP.player.commands.RTPCommandHelpable;
import org.bukkit.command.CommandSender;

import java.util.List;

public class InterfaceCommand implements RTPCommand, RTPCommandHelpable {
    AddonInterface pl;

    InterfaceCommand(AddonInterface pl) {
        this.pl = pl;
    }

    public String getName() {
        return "interface";
    }

    @Override
    public void execute(CommandSender sendi, String label, String[] args) {
        sendi.sendMessage("Interface command!");
    }

    @Override
    public List<String> tabComplete(CommandSender sendi, String[] args) {
        return null;
    }

    @Override
    public boolean permission(CommandSender sendi) {
        return BetterRTP.getInstance().getPerms().checkPerm("betterrtp.addon.portals", sendi);
    }

    @Override
    public String getHelp() {
        return null;//pl.msgs.getHelp();
    }
}
