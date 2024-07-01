package thongcao_main.configs;

import thongcao_main.helpers.PropertiesHelper;

public class ConfigData {
    public static String URL = PropertiesHelper.getValue("URL");
    public static String EMAIL = PropertiesHelper.getValue("EMAIL");
    public static String PASSWORD = PropertiesHelper.getValue("PASSWORD");
}
