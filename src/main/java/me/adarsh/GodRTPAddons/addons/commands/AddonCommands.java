package me.adarsh.GodRTPAddons.addons.commands;

import me.adarsh.BetterRTP.player.commands.RTPCommand;
import me.adarsh.GodRTPAddons.Addon;
import me.adarsh.GodRTPAddons.util.Files;

public class AddonCommands implements Addon {

    private final String name = "Commands";
    private final CommandsLoader loader = new CommandsLoader();

    @Override
    public boolean isEnabled() {
        return getFile(Files.FILETYPE.CONFIG).getBoolean(name + ".Enabled");
    }

    @Override
    public void load() {
        loader.load();
    }

    @Override
    public void unload() {
        loader.unload();
    }

    @Override
    public RTPCommand getCmd() {
        return null;
    }
}
