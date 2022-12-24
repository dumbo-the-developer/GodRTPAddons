package me.adarsh.GodRTPAddons;

import me.adarsh.BetterRTP.BetterRTP;
import me.adarsh.BetterRTP.player.commands.RTPCommand;
import me.adarsh.BetterRTP.references.helpers.HelperRTP_Command;
import me.adarsh.GodRTPAddons.addons.commands.AddonCommands;
import me.adarsh.GodRTPAddons.addons.extraEffects.AddonExtraEffects;
import me.adarsh.GodRTPAddons.addons.flashback.AddonFlashback;
import me.adarsh.GodRTPAddons.addons.logger.AddonLogger;
import me.adarsh.GodRTPAddons.addons.magicStick.AddonMagicStick;
import me.adarsh.GodRTPAddons.addons.parties.AddonParty;
import me.adarsh.GodRTPAddons.addons.portals.AddonPortals;
import me.adarsh.GodRTPAddons.addons.rtpmenu.AddonRTPMenu;

import java.util.ArrayList;
import java.util.List;

public class AddonsHandler {

    public List<Addons> addons = new ArrayList<>();
    AddonsCommand cmd = new AddonsCommand();

    public void load() {
        unload();
        //int addonCount = 0;
        for (Addons addon : Addons.values())
            if (addon.isEnabled()) {
                addon.load();
                addons.add(addon);
                //addonCount++;
            }
        //Main.getInstance().getLogger().log(Level.INFO, addonCount + "/" + Addons.values().length + " addons were enabled!");
        HelperRTP_Command.registerCommand(cmd, false);
    }

    public void unload() {
        for (Addons addon : addons)
            addon.disable();
        addons.clear();
    }

    public enum Addons {
        LOGGER(new AddonLogger()),              //Does this thing work?
        FLASH_BACK(new AddonFlashback()),       //Never get lost adventuring
        PORTALS(new AddonPortals()),            //Fancy walk-in portals
        //INTERFACES(new AddonInterface())
        MAGICSTICK(new AddonMagicStick()),      //Handy teleport want
        EXTRAEFFECTS(new AddonExtraEffects()),  //New cosmetica!
        COMMANDS(new AddonCommands()),          //Commands on rtp events
        PARTY_RTP(new AddonParty()),            //Adds parties!
        RTP_MENU(new AddonRTPMenu()),           //Adds /rtp menu
        ;

        final Addon addon;

        Addons(Addon addon) {
            this.addon = addon;
        }

        public boolean isEnabled() {
            return addon.isEnabled();
        }

        void load() {
            addon.load();
            BetterRTP.debug("Addon " + this.name() + " has been enabled!");
        }

        void disable() {
            addon.unload();
        }

        RTPCommand getCmd() {
            return addon.getCmd();
        }
    }

}
