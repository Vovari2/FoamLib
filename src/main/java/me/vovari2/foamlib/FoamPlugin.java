package me.vovari2.foamlib;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class FoamPlugin extends JavaPlugin {
    protected static FoamPlugin instance;
    public static FoamPlugin getInstance(){
        return instance;
    }

    public static String PLUGIN_NAME;
    public static String VERSION;
    public static String AUTHOR;

    protected static void load(FoamPlugin newInstance){
        instance = newInstance;

        PLUGIN_NAME = instance.getName();
        VERSION = instance.getPluginMeta().getVersion();
        AUTHOR = instance.getPluginMeta().getAuthors().get(0);
    }

    public abstract void onReload();
}
