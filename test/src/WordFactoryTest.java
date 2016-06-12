package src;

import entities.Word;
import entities.WordFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wookie on 6/12/16.
 */
public class WordFactoryTest {

    @Test
    public void testWordFactory() {
        String strA = "a";
        String strB = "b";
        int intA = WordFactory.getId(strA);
        int intB = WordFactory.getId(strB);
        int test = WordFactory.getId(strA);

        assertEquals("Word Factory test int", intA, test);
        assertEquals("Word Factory test string", WordFactory.get(intA), WordFactory.get(test));
    }
}
