package utils;

import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Properties prop = new Properties();

    static {
        try {
            InputStream input = Config.class.getClassLoader()
                    .getResourceAsStream("config.properties");
            prop.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
