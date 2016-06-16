package view;

import entities.TextComposite;

/**
 * Class View in MVC model.
 * Created by wookie on 6/12/16.
 */
public class View {
    public static final String MAX_REPEATS = "Count of sentences with max repeats of one word = ";
    public static final String TEXT = "Text: ";

    public void printText(TextComposite text) {
        System.out.println(text.getValue());
    }

    public void printMessage(String... message) {
        for(String m : message) {
            System.out.print(m);
        }
    }
}
