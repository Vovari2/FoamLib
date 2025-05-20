package me.vovari2.foamlib;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class Text {
    public static Component toComponent(String value){
        return MiniMessage.miniMessage().deserialize(value);
    }
}
