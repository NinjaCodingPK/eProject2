package view;

import entities.Component;
import entities.Composite;

/**
 * Created by wookie on 6/12/16.
 */
public class View {
    public static final String MAX_REPEATS = "Count of sentences with max repeats of one word = ";
    public static final String TEXT = "Text: ";

    public void printText(Composite text) {
        System.out.println(TEXT);
        for(Component paragraph : text.getComponents()) {
            for(Component sentence : ((Composite)paragraph).getComponents()) {
                for(Component word : ((Composite)sentence).getComponents()) {
                    System.out.print(" ");
                    System.out.print(word.getValue());
                }
                System.out.print(".");
            }
            System.out.println();
        }
    }

    public void printMessage(String... message) {
        for(String m : message) {
            System.out.print(m);
        }
    }
}