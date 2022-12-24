package me.adarsh.GodRTPAddons.addons.extraEffects;

import me.adarsh.BetterRTP.player.commands.RTPCommand;
import me.adarsh.GodRTPAddons.Addon;
import me.adarsh.GodRTPAddons.util.Files;

import java.util.ArrayList;
import java.util.List;

public class AddonExtraEffects implements Addon {

    private final String name = "ExtraEffects";
    private final List<Effects> effects = new ArrayList<>(); //List of enabled effects

    @Override
    public boolean isEnabled() {
        return getFile(Files.FILETYPE.CONFIG).getBoolean(name + ".Enabled");
    }

    @Override
    public void load() {
        this.effects.clear();
        for (Effects effect : Effects.values())
            if (effect.isEnabled()) {
                effect.load();
                this.effects.add(effect);
            }
    }

    @Override
    public void unload() {
        for (Effects effect : this.effects)
            effect.unload();
        this.effects.clear();
    }

    @Override
    public RTPCommand getCmd() {
        return null;
    }

    enum Effects {
        SKYHIGH(new ExtraEffectsEffect_Skyhigh());

        private final ExtraEffectsEffect effect;

        Effects(ExtraEffectsEffect effect) {
            this.effect = effect;
        }

        boolean isEnabled() {
            return effect.isEnabled();
        }

        void load() {
            effect.load();
        }

        void unload() {
            effect.unload();
        }
    }
}
