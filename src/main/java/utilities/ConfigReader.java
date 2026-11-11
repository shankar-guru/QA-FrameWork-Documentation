package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	   private static final Properties prop = new Properties();
	 static {
	        String path = System.getProperty("user.dir")
	                + "/src/test/resources/config.properties";

	        try (FileInputStream fis = new FileInputStream(path)) {
	            prop.load(fis);
	        } catch (IOException e) {
	            throw new RuntimeException("Unable to load config.properties", e);
	        }
	    }

		public static String getValue(String key) {

			String value = prop.getProperty(key);

			if (value == null || value.isBlank()) {
				throw new IllegalArgumentException("Missing configuration: " + key);
			}

			return value.trim();
		}

		public static int getIntValue(String key) {
			return Integer.parseInt(getValue(key));
		}

		public static boolean getBooleanValue(String key) {
			return Boolean.parseBoolean(getValue(key));
		}
}