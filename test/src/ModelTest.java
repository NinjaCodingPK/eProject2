package src;

import model.Model;
import model.Parser;
import org.junit.Test;

import datasource.impl.File;

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
        when(f.getText()).thenReturn("asd asd. asd asd.");

        Parser p = new Parser();
        p.parse(f.getText());

        Model m = new Model(p.getText());
        int act = m.findMostRepeats();

        assertEquals("Repeats test", 2, act);
    }
}