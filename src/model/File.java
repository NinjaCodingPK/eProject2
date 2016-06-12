package model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class for working with outer files.
 * Created by wookie on 6/12/16.
 */
public class File {
    private String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Method returns text from file as String.
     * @return text from file.
     * @throws IOException
     */
    public String readFile() throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(fileName));
        return new String(encoded, Charset.forName("8859_1"));
    }
}
