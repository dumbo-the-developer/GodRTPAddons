package me.adarsh.GodRTPAddons.addons.parties;

import me.adarsh.BetterRTP.player.commands.RTPCommand;
import me.adarsh.BetterRTP.references.helpers.HelperRTP_Command;
import me.adarsh.GodRTPAddons.Addon;
import me.adarsh.GodRTPAddons.Main;
import me.adarsh.GodRTPAddons.addons.parties.cmds.PartyCommand;
import me.adarsh.GodRTPAddons.util.Files;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;

import java.util.ArrayList;
import java.util.List;

public class AddonParty implements Addon {

    private static AddonParty instance;
    private final String name = "Parties";
    private final PartyCommand cmd = new PartyCommand(this);
    public PartyMessages msgs = new PartyMessages();
    public List<PartyData> parties = new ArrayList<>();
    private final PartyHandler handler = new PartyHandler();

    @Override
    public boolean isEnabled() {
        return getFile(Files.FILETYPE.CONFIG).getBoolean(name + ".Enabled");
    }

    @Override
    public void load() {
        instance = this;
        PluginManager pm = Main.getInstance().getServer().getPluginManager();
        pm.registerEvents(handler, Main.getInstance());
        HelperRTP_Command.registerCommand(cmd, false);
    }

    @Override
    public void unload() {
        HandlerList.unregisterAll(handler);
    }

    public static AddonParty getInstance() {
        return instance;
    }

    @Override
    public RTPCommand getCmd() {
        return cmd;
    }
}
