package me.vovari2.foamlib;

import org.bukkit.plugin.java.JavaPlugin;

final class FoamLib extends JavaPlugin {
    private static FoamLib instance;
    public static FoamLib getInstance(){
        return instance;
    }

    @Override
    public void onLoad(){instance = this;}

    @Override
    public void onEnable() {}

    @Override
    public void onDisable() {}
}
