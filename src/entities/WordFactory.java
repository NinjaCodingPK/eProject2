package entities;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Flyweight pattern for list of words.
 * Created by wookie on 6/12/16.
 */
public class WordFactory {//implements FlyWeight{
    private static Map<Integer, String> words = new HashMap<>();
    public WordFactory() {

    }

    public static String get(int id) {
        return words.get(id);
    }

    public static int getId(String value) {
        if(!words.containsValue(value)) {
            addWord(value);
            return words.size() - 1;
        }
        else {
            return  findByValue(value);
        }
    }

    private static void addWord(String word) {
        words.put(words.size(), word);
    }

    private static int findByValue(String value) {
        return words.entrySet().stream().filter(w -> w.getValue().equals(value))
                .collect(Collectors.toList()).get(0).getKey();
//        for(Map.Entry<Integer, String> e : words.entrySet()) {
//
//        }
    }

    public static Map<Integer, String> getWords() {
        return words;
    }
}
