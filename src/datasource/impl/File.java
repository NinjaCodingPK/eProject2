package datasource.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import datasource.DataSource;

/**
 * Class for working with outer files.
 * Created by wookie on 6/12/16.
 */
public class File implements DataSource {
    public static final String FILE_NAME_BUNDLE = "file.name";
    public static final String CONFIG_FILE_NAME = "config/config.properties";
    private Properties prop = new Properties();

    public File() {
    	initConfig();
    }

    /**
     * Method initialize configuration file.
     * @throws IOException
     */
    public void initConfig() {
        String propFileName = CONFIG_FILE_NAME;

        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {
			prop.load(inputStream);
		} catch (IOException e) {

		}
   
    }

    /**
     * Get property from property file by key.
     * @param key in property file.
     * @return property from property file.
     */
    public String getProperty(String key) {
        return prop.getProperty(key);
    }

    /**
     * Method returns text from file as String.
     * @return text from file.
     */
	@Override
	public String getText() {
		byte[] encoded;
		try {
			encoded = Files.readAllBytes(Paths.get(getProperty(FILE_NAME_BUNDLE)));
			return new String(encoded);
		} catch (IOException e) {
			return null;
		}
        
	}
}
