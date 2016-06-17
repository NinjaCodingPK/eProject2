package controller;

import model.File;
import model.Model;
import model.Parser;
import view.View;

import java.io.IOException;

/**
 * Class Controller in MVC model.
 * Created by wookie on 6/12/16.
 */
public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void processUser() {
        File f = new File();
        Parser parser;

        try {
            f.initConfig();
            parser = new Parser();
            parser.parse(f.readFile());
            Model m = new Model(parser.getText());
            int max_repeats = m.findMostRepeats();

            view.printText(parser.getText());
            view.printMessage(View.MAX_REPEATS,Integer.toString(max_repeats));
        } catch (IOException e) {

        }
    }
}
