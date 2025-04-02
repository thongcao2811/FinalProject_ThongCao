package thongcao_main.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


        private static final Properties properties;

        static {
            try {
                // Read file config.properties
                FileInputStream fileInputStream = new FileInputStream("src/test/resources/configs/configs.properties");
                properties = new Properties();
                properties.load(fileInputStream);
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Cannot load file config.properties");
            }
        }

        // Method to load value from properties file
        public static String getProperty(String key) {
            return properties.getProperty(key);
        }


        // Method to load integer value ( Ex: timeout,..)
        public static int getIntProperty(String key) {
            return Integer.parseInt(properties.getProperty(key));
        }
    }



