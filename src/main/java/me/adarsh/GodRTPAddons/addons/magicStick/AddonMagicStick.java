package me.adarsh.GodRTPAddons.addons.magicStick;

import me.adarsh.BetterRTP.player.commands.RTPCommand;
import me.adarsh.BetterRTP.references.helpers.HelperRTP_Command;
import me.adarsh.GodRTPAddons.Addon;
import me.adarsh.GodRTPAddons.Main;
import me.adarsh.GodRTPAddons.addons.magicStick.cmds.MagicStickCommand;
import me.adarsh.GodRTPAddons.util.Files;

public class AddonMagicStick implements Addon {

    public MagicStickMessages msgs = new MagicStickMessages();
    MagicStickCommand cmd = new MagicStickCommand(this);
    public MagicStickEvents events = new MagicStickEvents();

    @Override
    public boolean isEnabled() {
        return Main.getInstance().getFiles().getType(Files.FILETYPE.CONFIG).getBoolean("MagicStick.Enabled");
    }

    @Override
    public void load() {
        HelperRTP_Command.registerCommand(cmd, false);
        events.load();
    }

    @Override
    public void unload() {
        events.unload();
    }

    @Override
    public RTPCommand getCmd() {
        return cmd;
    }
}
