package controller;

import model.Model;
import model.Parser;
import view.View;

import java.io.IOException;

import datasource.DataSource;
import datasource.impl.File;

/**
 * Class Controller in MVC model.
 * Created by wookie on 6/12/16.
 */
public class Controller {
    private View view;
    private DataSource dataSource;

    public Controller(View view, DataSource dataSource) {
        this.view = view;
        this.dataSource = dataSource;
    }

    public void processUser() {
        Parser parser;

        parser = new Parser();
        parser.parse(dataSource.getText());
        Model m = new Model(parser.getText());
        int max_repeats = m.findMostRepeats();

        view.printText(parser.getText());
        view.printMessage(View.MAX_REPEATS,Integer.toString(max_repeats));
    }
}
