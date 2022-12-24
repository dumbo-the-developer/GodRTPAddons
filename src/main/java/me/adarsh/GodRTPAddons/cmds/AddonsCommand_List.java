package me.adarsh.GodRTPAddons.cmds;

import me.adarsh.BetterRTP.player.commands.RTPCommandHelpable;
import me.adarsh.GodRTPAddons.AddonMessages;
import me.adarsh.GodRTPAddons.AddonsHandler;
import me.adarsh.GodRTPAddons.Main;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class AddonsCommand_List implements AddonsCommands, RTPCommandHelpable {

    @Override
    public void execute(CommandSender sendi, String label, String[] args) {
        AddonMessages msgs = Main.getInstance().msgs;
        List<String> list = new ArrayList<>();
        list.add(msgs.getListPrefix());
        for (AddonsHandler.Addons addon : AddonsHandler.Addons.values()) {
            String str = msgs.getListDisabled();
            if (addon.isEnabled())
                str = msgs.getListEnabled();
            list.add(str.replace("%addon%", addon.name()));
        }
        msgs.sms(sendi, list);
    }

    @Override
    public String getHelp() {
        return Main.getInstance().msgs.getBaseList();
    }
}
