package me.vovari2.foamlib;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;

import java.util.List;

public abstract class Config {
    protected FileConfiguration fileConfig;
    protected Config(){}

    private final List<String> booleanList = List.of("True", "False", "true", "false");
    protected boolean getBoolean(String path) throws Exception{
        String value = getString(path, true);
        if (!booleanList.contains(value))
            throw new Exception("<red>Value %s is not an boolean!".formatted(path));
        return Boolean.parseBoolean(getString(path));
    }
    protected boolean getBoolean(String path, boolean def) throws Exception{
        String value = getString(path, true);
        if (!booleanList.contains(value))
            return def;
        return Boolean.parseBoolean(getString(path));
    }
    protected int getInt(String path) throws Exception{
        String value = getString(path, true);
        if (!value.matches("^([+-]?[0-9]\\d*|0)$"))
            throw new Exception("<red>Value %s is not an integer!".formatted(path));
        return Integer.parseInt(getString(path));
    }
    protected int getInt(String path, int min) throws Exception{
        int value = getInt(path);
        if (value < min)
            throw new Exception("<red>Value %s must be greater than %s!".formatted(path, min));
        return value;
    }
    protected int getInt(String path, int min, int max) throws Exception{
        int value = getInt(path);
        if (value < min && value > max)
            throw new Exception("<red>Value %s must be greater than %s!".formatted(path, min));
        return value;
    }
    protected int getInt(String path, int min, int max, int def) throws Exception{
        int value = getInt(path);
        if (value < min && value > max)
            return def;
        return value;
    }

    protected double getDouble(String path) throws Exception{
        String value = getString(path, true);
        if (!value.matches("^-?(?:0|[1-9][0-9]*)\\.?[0-9]+([e|E][+-]?[0-9]+)?$"))
            throw new Exception("<red>Value %s is not an double!".formatted(path));
        return Double.parseDouble(getString(path));
    }
    protected double getDouble(String path, double min) throws Exception{
        double value = getDouble(path);
        if (value < min)
            throw new Exception("<red>Value %s must be greater than %s!".formatted(path, min));
        return value;
    }
    protected double getDouble(String path, double min, double max) throws Exception{
        double value = getDouble(path);
        if (value < min && value > max)
            throw new Exception("<red>Value %s must be greater than %s!".formatted(path, min));
        return value;
    }
    protected double getDouble(String path, double min, double max, double def) throws Exception{
        double value = getDouble(path);
        if (value < min && value > max)
            return def;
        return value;
    }

    protected String getString(String path) throws Exception{
        String value = fileConfig.getString(path);
        if (value == null)
            throw new Exception("<red>Value %s is not an string!".formatted(path));

        return value;
    }
    protected String getString(String path, boolean canBeEmpty) throws Exception{
        String value = getString(path);
        if (!canBeEmpty && value.isEmpty())
            throw new Exception("<red>Value %s cannot be empty!".formatted(path));
        return value;
    }

    protected List<String> getStringList(String path) {
        return fileConfig.getStringList(path);
    }
    protected List<String> getStringList(String path, boolean canBeEmpty) throws Exception {
        List<String> list = getStringList(path);
        if (!canBeEmpty && list.isEmpty())
            throw new Exception("<red>Value %s cannot be empty!".formatted(path));

        return list;
    }

    protected Material getMaterial(String path) throws Exception {
        String strValue = getString(path);
        return getMaterial(strValue, path);
    }
    protected Material getMaterial(String value, String path) throws Exception {
        try{ return Material.valueOf(value.toUpperCase());}
        catch(IllegalArgumentException e){ throw new Exception("<red>The value %s is not a material!".formatted(path));}
    }

    protected EntityType getEntityType(String path) throws Exception {
        String strValue = getString(path);
        return getEntityType(strValue, path);
    }
    protected EntityType getEntityType(String value, String path) throws Exception {
        try{ return EntityType.valueOf(value.toUpperCase());}
        catch(IllegalArgumentException e){ throw new Exception("<red>Value %s is not a entityType!".formatted(path));}
    }
}
