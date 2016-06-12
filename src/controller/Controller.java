package controller;

import model.File;
import model.Model;
import model.Parser;
import view.View;

import java.io.IOException;

/**
 * Created by wookie on 6/12/16.
 */
public class Controller {
    private View view;
    private Model model;

    public Controller(View view) {
        this.view = view;
    }

    public void processUser() {
        String str = "input.txt";

        File f = new File(str);
        Parser parser;
        try {
            parser = new Parser(f.readFile());
            parser.parse();
            Model m = new Model(parser.getText());
            int max_repeats = m.findMostRepeats();

            view.printText(parser.getText());
            view.printMessage(View.MAX_REPEATS,Integer.toString(max_repeats));
        } catch (IOException e) {

        }
    }
}
