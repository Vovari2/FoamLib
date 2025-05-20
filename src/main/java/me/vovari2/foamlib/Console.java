package me.vovari2.foamlib;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;

public abstract class Console {

    public static void error(String message){
        error(Text.toComponent(message));
    }
    public static void error(Component message){
        message = message.color(TextColor.color(255, 85,85));
        FoamPlugin.getInstance().getServer().getConsoleSender().sendMessage(getMessageBegin().append(message));
    }

    public static void warning(String message){
        warning(Text.toComponent(message));
    }
    public static void warning(Component message){
        message = message.color(TextColor.color(255, 255,85));
        FoamPlugin.getInstance().getServer().getConsoleSender().sendMessage(getMessageBegin().append(message));
    }
    
    public static void info(String message){
        info(Text.toComponent(message));
    }
    public static void info(Component message){
        message = message.color(TextColor.color(85, 255,85));
        FoamPlugin.getInstance().getServer().getConsoleSender().sendMessage(getMessageBegin().append(message));
    }

    public static Component getMessageBegin(){
        return Text.toComponent("<gray>[%s]<reset> ".formatted(FoamPlugin.PLUGIN_NAME));
    }
}
