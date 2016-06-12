package entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wookie on 6/12/16.
 */
public interface FlyWeight {
    Map<Integer, String> words = new HashMap<>();

    String get(int id);

    int getId(String value);

    void addWord(String word);
}
