package me.vovari2.foamlib;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class FoamPlugin extends JavaPlugin {
    private static JavaPlugin instance;
    public static JavaPlugin getInstance(){
        return instance;
    }

    public static String PLUGIN_NAME;
    public static String VERSION;
    public static String AUTHOR;

    protected static void load(JavaPlugin newInstance){
        instance = newInstance;

        PLUGIN_NAME = instance.getName();
        VERSION = instance.getPluginMeta().getVersion();
        AUTHOR = instance.getPluginMeta().getAuthors().get(0);
    }
    protected static void enable(){}
    protected static void disable(){}

    protected abstract void onReload();
}
