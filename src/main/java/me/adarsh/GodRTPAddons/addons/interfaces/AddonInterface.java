package me.adarsh.GodRTPAddons.addons.interfaces;

import me.adarsh.BetterRTP.player.commands.RTPCommand;
import me.adarsh.GodRTPAddons.Addon;
import me.adarsh.GodRTPAddons.util.Files;

public class AddonInterface implements Addon {

    private String name = "Interface";

    @Override
    public boolean isEnabled() {
        return getFile(Files.FILETYPE.CONFIG).getBoolean(name + "Enabled");
    }

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }

    @Override
    public RTPCommand getCmd() {
        return null;
    }
}
