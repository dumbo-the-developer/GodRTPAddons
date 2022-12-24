package me.adarsh.GodRTPAddons;

public class AddonMessages implements AddonsMessages {
    private static final String preM = "Addons.";

    public String getBaseHelp() {
        return getLang().getString("Help.Base.Help");
    }

    public String getBaseList() {
        return getLang().getString("Help.Base.List");
    }

    public String getListPrefix() {
        return getLang().getString(preM + "List.Prefix");
    }

    public String getListDisabled() {
        return getLang().getString(preM + "List.Disabled");
    }

    public String getListEnabled() {
        return getLang().getString(preM + "List.Enabled");
    }

    public String getHelp() {
        return getLang().getString("Help.Addons");
    }
}
