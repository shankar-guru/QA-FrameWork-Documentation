package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

public class ConfigReader {
	   private static Properties prop;

	 	    static {
	        prop = new Properties();

	        String platform = System.getProperty("platform", "android");

	        String filePath = "src/test/resources/config/"
	                + platform.toLowerCase() + ".properties";

	        try (FileInputStream fis = new FileInputStream(filePath)) {

	            prop.load(fis);

	        } catch (IOException e) {

	            throw new RuntimeException(
	                "Unable to load configuration file: " + filePath, e
	            );
	        }
	    }

	    // Read mandatory property
	    public static String getProperty(String key) {

	        String value = System.getProperty(key);

	        if (value == null || value.isBlank()) {
	            value = prop.getProperty(key);
	        }

	        if (value == null || value.isBlank()) {
	            throw new RuntimeException("Property not found: " + key);
	        }

	        return value.trim();
	    }

	    // Read property with default value
	    public static String getProperty(String key, String defaultValue) {

	        String value = System.getProperty(key);

	        if (value == null || value.isBlank()) {
	            value = prop.getProperty(key);
	        }

	        return value == null || value.isBlank()
	                ? defaultValue : value.trim();
	    }

	    // Read Boolean property
	    public static boolean getBooleanProperty(String key) {
	        return Boolean.parseBoolean(getProperty(key, "false"));
	    }
}
