package src;

import entities.*;
import model.File;
import model.Parser;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by wookie on 6/12/16.
 */
public class ParserTest {

    @Test
    public void testParse() throws IOException {
        File f = mock(File.class);
        when(f.readFile()).thenReturn("asd.");

        Parser p = new Parser(f.readFile());
        p.parse();

        TextComposite expText = new TextComposite();
        TextComposite paragraph = new TextComposite();
        TextComposite sentence = new TextComposite();
        TextComposite word = new TextComposite();
        word.addComponent(SymbolFactory.getSymbol('a'));
        word.addComponent(SymbolFactory.getSymbol('s'));
        word.addComponent(SymbolFactory.getSymbol('d'));
        sentence.addComponent(word);
        sentence.addComponent(SymbolFactory.getSymbol('.'));
        paragraph.addComponent(sentence);
        expText.addComponent(paragraph);

        assertEquals("Parse test", expText.getValue(), p.getText().getValue());
    }
}