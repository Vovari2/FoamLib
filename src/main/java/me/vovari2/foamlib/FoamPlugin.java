package me.vovari2.foamlib;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class FoamPlugin extends JavaPlugin {
    private static JavaPlugin instance;
    public static JavaPlugin getInstance(){
        return instance;
    }

    public String PLUGIN_NAME;
    public String VERSION;
    public String AUTHOR;

    protected void load(JavaPlugin newInstance){
        PLUGIN_NAME = instance.getName();
        VERSION = instance.getPluginMeta().getVersion();
        AUTHOR = instance.getPluginMeta().getAuthors().get(0);
        instance = newInstance;
    }
    protected void enable(){}
    protected void disable(){}

    protected abstract void onReload();
}
