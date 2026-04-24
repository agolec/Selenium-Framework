package ag.framework.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            properties = new Properties();

            String configName = System.getProperty("env","config");

            InputStream file = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream(configName + ".properties");
            if(file == null){
                throw new RuntimeException("Error: Config file not found: " + configName + ".properties");
            }
            properties.load(file);
        } catch (FileNotFoundException e) {
            System.err.println("file not found in class: "+ ConfigReader.class.toString());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println("IOException in class: "+ ConfigReader.class.toString());
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
    public static int getExplicitWaitDuration(){
        return Integer.parseInt(System.getProperty("explicit.wait","10"));
    }
}
