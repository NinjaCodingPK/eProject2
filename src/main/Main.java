package main;

import model.Model;
import model.Parser;

import java.io.IOException;

/**
 * Created by wookie on 6/12/16.
 */
public class Main {
    public static void main(String[] args) {
        String str = "input.txt";


        Parser parser = new Parser(str);
        try {
            parser.parse1();
        } catch (IOException e) {

        }

        Model m = new Model(parser.getText());
        System.out.println(m.findMostRepeats());
    }
}
