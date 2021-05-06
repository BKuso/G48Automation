package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private static final Logger log = LogManager.getLogger("Загрузчик настроек");

    public static String loadProperty(String name){
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir")
                    + "/src/test/resources/config/app.properties"));
        } catch (IOException e) {
           log.error(e);
        }
        return prop.getProperty(name);
    }

}
