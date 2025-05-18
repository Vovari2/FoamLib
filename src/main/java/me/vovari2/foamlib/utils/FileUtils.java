package me.vovari2.foamlib.utils;

import me.vovari2.foamlib.Console;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils {
    public static final FilenameFilter FILENAME_FILTER_YAML = (directory, fileName) -> fileName.endsWith(".yml");
    public static final FilenameFilter FILENAME_FILTER_JSON = (directory, fileName) -> fileName.endsWith(".json");

    public static File getPluginFolder(JavaPlugin instance){
        return instance.getDataFolder();
    }
    private static File createPluginFolder(JavaPlugin instance){
        File dataFolder = instance.getDataFolder();
        try{boolean ignored = dataFolder.mkdir();}
        catch(Exception e){ Console.error("Error when creating a folder \"%s\"!".formatted(dataFolder.getName())); }
        return dataFolder;
    }

    public static void createFolder(File folder){
        boolean ignored = folder.mkdir();
    }
    public static @NotNull File createFolder(File parentFolder, String folderName){
        File folder = new File(parentFolder, folderName);
        boolean ignored = folder.mkdir();
        return folder;
    }

    public static File createFileInFolder(File folder, String fileName){
        File file = new File(folder, fileName);
        try { if (!file.exists()) Files.createFile(file.toPath());}
        catch(IOException e){ Console.error("Error when creating a file \"%s\" in folder \"%s\"!".formatted(fileName, folder.getName()));}
        return file;
    }
    public static void createResourceFileInFolder(JavaPlugin instance, String resourcePath){
        File pluginFolder = createPluginFolder(instance);
        File file = new File(pluginFolder, resourcePath);

        if (!file.exists())
            instance.saveResource(resourcePath, false);
    }

    public static String getContentFromFile(File file){
        try{
            return Files.readString(file.toPath());
        } catch(IOException e){
            Console.error("Error when loading data from a file \"%s\"!".formatted(file.getName()));}
        return null;
    }
    public static void setContentFromFile(File file, String content){
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.append(content);
        } catch(IOException e){ Console.error("Error when saving data in a file \"%s\"!".formatted(file.getName()));}
    }
    public static FileConfiguration getContentFromYamlFile(File folder, String fileName){
        return YamlConfiguration.loadConfiguration(new File(folder, fileName));
    }
    public static void setContentFromYamlFile(File folder, String fileName, FileConfiguration configuration){
        try{configuration.save(new File(folder, fileName));}
        catch(Exception e){ Console.error("Error when saving data in a file \"%s\"!".formatted(fileName));}
    }
}
