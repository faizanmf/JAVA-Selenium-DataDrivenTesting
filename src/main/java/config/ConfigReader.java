package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop = new Properties();

    public static Properties initProperties() {
        try {
            FileInputStream fis = new FileInputStream("D:\\INTERVIEW TRAINING\\Automation\\Web - UI Automation\\Java selenium\\Data driven testing\\Excel and DB code\\DataFromExcelAndDB\\src\\resources\\configFile\\config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;

    }
}
