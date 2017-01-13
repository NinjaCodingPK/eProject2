package main;

import controller.Controller;
import datasource.DataSource;
import datasource.impl.File;
import model.Model;
import model.Parser;
import view.View;

import java.io.IOException;

/**
 * Created by wookie on 6/12/16.
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        DataSource dataSource = new File();
        Controller controller = new Controller(view, dataSource);
        controller.processUser();
    }
}
