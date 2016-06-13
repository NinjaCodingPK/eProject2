package model;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Class for working with outer files.
 * Created by wookie on 6/12/16.
 */
public class File {
    public static final String FILE_NAME_BUNDLE = "file.name";
    public static final String CONFIG_FILE_NAME = "config/config.properties";
    private Properties prop = new Properties();

    public File() {

    }

    /**
     * Method returns text from file as String.
     * @return text from file.
     * @throws IOException
     */
    public String readFile() throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(getProperty(FILE_NAME_BUNDLE)));
        return new String(encoded);
    }

    /**
     * Method initialize config file.
     * @throws IOException
     */
    public void initConfig() throws IOException {
        String propFileName = CONFIG_FILE_NAME;

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        prop.load(inputStream);
        inputStream.close();
    }

    /**
     * Get property from property file by key.
     * @param key in property file.
     * @return property from property file.
     */
    public String getProperty(String key) {
        return prop.getProperty(key);
    }
}
