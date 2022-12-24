package me.adarsh.GodRTPAddons.cmds;


import me.adarsh.BetterRTP.player.commands.RTPCommandHelpable;
import me.adarsh.BetterRTP.references.messages.MessagesHelp;
import me.adarsh.GodRTPAddons.AddonsCommand;
import me.adarsh.GodRTPAddons.Main;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class AddonsCommand_Help implements AddonsCommands, RTPCommandHelpable {

    @Override
    public void execute(CommandSender sendi, String label, String[] args) {
        List<String> list = new ArrayList<>();
        list.add(MessagesHelp.PREFIX.get());
        for (AddonsCommand.AddonCmds cmds : AddonsCommand.AddonCmds.values()) {
            if (cmds.cmd instanceof RTPCommandHelpable)
                list.add(((RTPCommandHelpable) cmds.cmd).getHelp().replace("%command%", label));
        }
        Main.getInstance().msgs.sms(sendi, list);
    }

    @Override
    public String getHelp() {
        return Main.getInstance().msgs.getBaseHelp();
    }
}
