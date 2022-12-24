package me.adarsh.GodRTPAddons;

import me.adarsh.BetterRTP.player.commands.RTPCommand;
import me.adarsh.GodRTPAddons.util.Files;

public interface Addon {

    //Addon will check if it can be enabled
    boolean isEnabled();

    //Load the addon if enabled
    void load();

    //Unload the addon if enabled
    void unload();

    RTPCommand getCmd();

    //Ability to grab a file
    default Files.FILETYPE getFile(Files.FILETYPE filetype) {
        return Main.getInstance().getFiles().getType(filetype);
    }

}
