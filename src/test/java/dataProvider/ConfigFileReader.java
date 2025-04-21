package dataProvider;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    private static Properties properties;

    public ConfigFileReader() throws IOException {
        properties = new Properties();
        // Load the property file using ClassLoader
        // Path relative to the classpath
        String propertyFilePath = "configs/configuration.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFilePath);
        // Check if the file is found
        if (inputStream == null) {
            System.err.println("Property file '" + propertyFilePath + "' not found in the classpath.");
            throw new FileNotFoundException("Property file '" + propertyFilePath + "' not found in the classpath.");
        }
        // Load the properties file into the Properties object
        properties.load(inputStream);
        // Log success message
        System.out.println("Property file loaded successfully.");
    }

    public static String getApplicationUrl() {
        // Make sure the properties object is not null
        if (properties == null) {
            throw new RuntimeException("Properties object is null. Ensure that the configuration file is loaded.");
        }

        String url = properties.getProperty("url");
        if (url != null) {
            return url;
        } else {
            throw new RuntimeException("url not specified in the Configuration.properties file.");
        }
    }
}