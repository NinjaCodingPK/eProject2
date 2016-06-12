package main;

import model.File;
import model.Model;
import model.Parser;

import java.io.IOException;

/**
 * Created by wookie on 6/12/16.
 */
public class Main {
    public static void main(String[] args) {
        String str = "input.txt";

        File f = new File(str);
        Parser parser;
        try {
            parser = new Parser(f.readFile());
            parser.parse();
            Model m = new Model(parser.getText());
            System.out.println(m.findMostRepeats());
        } catch (IOException e) {

        }

    }
}
