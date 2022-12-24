package me.adarsh.GodRTPAddons.addons.portals;

import me.adarsh.GodRTPAddons.AddonsMessages;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;

public class PortalsMessages implements AddonsMessages {
    private static final String preM = "Portals.";

    public void getWarning(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "Warning"));
    }

    public String getHelp() {
        return getLang().getString("Help.Portals");
    }

    //Create

    public void getCreateConfirm(CommandSender sendi, String name) {
        sms(sendi, getLang().getString(preM + "Created.Confirmation.Default").replace("%name%", name));
    }

    public void getCreateConfirmWorld(CommandSender sendi, String name, String world) {
        sms(sendi, getLang().getString(preM + "Created.Confirmation.Destination").replace("%name%", name).replace("%world%", world));
    }

    public void getCreateInvalid(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "Created.Invalid"));
    }

    public void getCreateName(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "Created.Name"));
    }

    public void getCreateDuplicate(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "Created.Duplicate"));
    }

    //Location

    public void getLocation_1(CommandSender sendi, Location loc) {
        sms(sendi, getLang().getString(preM + "Location.1")
                .replace("%location%", "x:" + loc.getBlockX() + ", y:" + loc.getBlockY() + ", z:" + loc.getBlockZ()));
    }

    public void getLocation_2(CommandSender sendi, Location loc) {
        sms(sendi, getLang().getString(preM + "Location.2")
                .replace("%location%", "x:" + loc.getBlockX() + ", y:" + loc.getBlockY() + ", z:" + loc.getBlockZ()));
    }

    public void getLocation_Look(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "Location.Look"));
    }

    public void getLocation_Ready(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "Location.Ready").replace("%command%", "rtp"));
    }

    //Remove

    public void getRemoveConfirm(CommandSender sendi, String name) {
        sms(sendi, getLang().getString(preM + "Remove.Confirm").replace("%name%", name));
    }

    public void getRemoveNone(CommandSender sendi, String name) {
        sms(sendi, getLang().getString(preM + "Remove.None").replace("%name%", name));
    }

    //List

    public String getListPrefix() {
        return getLang().getString(preM + "List.Prefix");
    }

    public String getListPortal() {
        return getLang().getString(preM + "List.Portal");
    }

    public void getListNone(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "List.None"));
    }

    //Usages

    public void usageRemove(CommandSender sendi, String label) {
        sms(sendi, getLang().getString(preM + "Usage.Remove").replace("%command%", label));
    }

    public void usageBase(CommandSender sendi, String label) {
        sms(sendi, getLang().getString(preM + "Usage.Base").replace("%command%", label));
    }
}
