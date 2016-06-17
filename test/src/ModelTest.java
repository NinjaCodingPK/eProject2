package src;

import model.File;
import model.Model;
import model.Parser;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by wookie on 6/12/16.
 */
public class ModelTest {

    @Test
    public void testFindMostRepeats() throws IOException {
        File f = mock(File.class);
        when(f.readFile()).thenReturn("asd asd. asd asd.");

        Parser p = new Parser();
        p.parse(f.readFile());

        Model m = new Model(p.getText());
        int act = m.findMostRepeats();

        assertEquals("Repeats test", 2, act);
    }
}