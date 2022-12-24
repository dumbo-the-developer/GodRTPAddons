package me.adarsh.GodRTPAddons.util;

import me.adarsh.BetterRTP.player.commands.types.CmdReload;
import me.adarsh.BetterRTP.references.customEvents.RTP_CommandEvent_After;
import me.adarsh.GodRTPAddons.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ReloadListener implements Listener {

    @EventHandler
    void reload(RTP_CommandEvent_After e) {
        if (e.getCmd() instanceof CmdReload)
            Main.getInstance().load();
    }
}
