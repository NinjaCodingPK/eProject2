package src;

import entities.Symbol;
import entities.SymbolFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wookie on 6/12/16.
 */
public class WordFactoryTest {

    @Test
    public void testWordFactory() {
        char charA = 'a';
        char charB = 'b';
        Symbol wordA = SymbolFactory.getSymbol(charA);
        Symbol wordB = SymbolFactory.getSymbol(charB);
        Symbol test = SymbolFactory.getSymbol(charA);

        assertEquals("Word Factory test int", wordA.getValue(), test.getValue());
    }
}
