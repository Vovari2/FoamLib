package me.vovari2.foamlib;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Text {
    public static TextColor red = TextColor.color(255, 85,85);
    public static TextColor yellow = TextColor.color(255, 255,85);
    public static TextColor green = TextColor.color(85, 255,85);

    public static void error(String message){
        error(message, Component.empty());
    }
    public static void error(String message, Component messageBegin){
        error(toComponent(message), messageBegin);
    }
    public static void error(Component message){
        error(message, Component.empty());
    }
    public static void error(Component message, Component messageBegin){
        message = message.color(red);
        FoamLib.getInstance().getServer().getConsoleSender().sendMessage(messageBegin.append(message));
    }

    public static void warning(String message){
        warning(message, Component.empty());
    }
    public static void warning(String message, Component messageBegin){
        warning(toComponent(message), messageBegin);
    }
    public static void warning(Component message){
        warning(message, Component.empty());
    }
    public static void warning(Component message, Component messageBegin){
        message = message.color(yellow);
        FoamLib.getInstance().getServer().getConsoleSender().sendMessage(messageBegin.append(message));
    }

    public static void info(String message){
        info(message, Component.empty());
    }
    public static void info(String message, Component messageBegin){
        info(toComponent(message), messageBegin);
    }
    public static void info(Component message){
        info(message, Component.empty());
    }
    public static void info(Component message, Component messageBegin){
        message = message.color(green);
        FoamLib.getInstance().getServer().getConsoleSender().sendMessage(messageBegin.append(message));
    }

    public static Component toComponent(String value){
        return MiniMessage.miniMessage().deserialize(value);
    }
}
