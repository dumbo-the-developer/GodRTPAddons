package me.adarsh.GodRTPAddons.addons.parties;

import me.adarsh.GodRTPAddons.AddonsMessages;
import org.bukkit.command.CommandSender;

public class PartyMessages implements AddonsMessages {
    private static final String preM = "Party.";

    public void getOnlyLeader(CommandSender sendi, String leader) {
        sms(sendi, getLang().getString(preM + "OnlyLeader").replace("%name%", leader));
    }

    public String getHelp() {
        return getLang().getString("Help.Party");
    }

    public void getNotInParty(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "NotInParty"));
    }

    public void getNotExist(CommandSender sendi, String name) {
        sms(sendi, getLang().getString(preM + "NotExist").replace("%name%", name));
    }
    //Invite

    public void getInvite_Invited(CommandSender sendi, String name) {
        sms(sendi, getLang().getString(preM + "Invite.Invited").replace("%name%", name));
    }

    public void getInvite_Notification(CommandSender sendi, String name) {
        sms(sendi, getLang().getString(preM + "Invite.Notification").replace("%name%", name));
    }

    public void getInvite_Already(CommandSender sendi, String name) {
        sms(sendi, getLang().getString(preM + "Invite.Already").replace("%name%", name));
    }

    //Usages

    public void usageBase(CommandSender sendi, String label) {
        sms(sendi, getLang().getString(preM + "Usage.Base").replace("%command%", label));
    }

    public void usageKick(CommandSender sendi, String label) {
        sms(sendi, getLang().getString(preM + "Usage.Kick").replace("%command%", label));
    }

    public void usageAccept(CommandSender sendi, String label) {
        sms(sendi, getLang().getString(preM + "Usage.Accept").replace("%command%", label));
    }

    public void usageInvite(CommandSender sendi, String label) {
        sms(sendi, getLang().getString(preM + "Usage.Invite").replace("%command%", label));
    }

    //Ready
    public void getReady_Readied(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "Ready.Readied"));
    }

    public void getReady_Already(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "Ready.Already"));
    }

    public void getReady_Leader(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "Ready.Leader"));
    }

    //Members
    public void getMembers_NotReady(CommandSender sendi, String members) {
        sms(sendi, getLang().getString(preM + "Members.NotReady").replace("%members%", members));
    }

    public void getMembers_NotInParty(CommandSender sendi, String name) {
        sms(sendi, getLang().getString(preM + "Members.NotInParty").replace("%name%", name));
    }

    public void getMembers_LeaderLeft(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "Members.LeaderLeft"));
    }

    public void getMembers_Leave(CommandSender sendi, String leader) {
        sms(sendi, getLang().getString(preM + "Members.Leave").replace("%name%", leader));
    }
    //Kick

    public void getKick_Kicked(CommandSender sendi, String kicked) {
        sms(sendi, getLang().getString(preM + "Kick.Kicked").replace("%name%", kicked));
    }

    public void getKick_Notification(CommandSender sendi, String leader) {
        sms(sendi, getLang().getString(preM + "Kick.Notification").replace("%name%", leader));
    }

    public void getKick_OnlyLeader(CommandSender sendi, String leader) {
        sms(sendi, getLang().getString(preM + "Kick.OnlyLeader").replace("%name%", leader));
    }
    //Accept
    public void getAccept_NoInvites(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "Accept.NoInvites"));
    }

    public void getAccept_Success(CommandSender sendi, String leader) {
        sms(sendi, getLang().getString(preM + "Accept.Success").replace("%name%", leader));
    }

    public void getAccept_Notification(CommandSender sendi, String member) {
        sms(sendi, getLang().getString(preM + "Accept.Notification").replace("%name%", member));
    }

    public void getAccept_InAParty(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "Accept.InAParty"));
    }

    //Teleporting
    public void getTeleporting(CommandSender sendi) {
        sms(sendi, getLang().getString(preM + "Teleport"));
    }
}
