import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


    public class ConfigMain {



       private static final String CONFIG_FILE = "config.properties";

        public static Properties loadProperties() {
            Properties props = new Properties();

            try (InputStream propstream = ConfigMain.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
                props.load(propstream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return props;
        }
    }
