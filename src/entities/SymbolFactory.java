package entities;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Flyweight pattern for list of symbols.
 * Created by wookie on 6/12/16.
 */
public class SymbolFactory {
    private static Map<Character, Symbol> words = new HashMap<>();
    public SymbolFactory() {

    }

    public static Symbol getSymbol(char key) {
        if(!words.containsKey(key))
            addWord(key);

        return words.get(key);
    }

    private static void addWord(char key) {
        words.put(key, new Symbol(key));
    }

    public static Map<Character, Symbol> getWords() {
        return words;
    }
}
