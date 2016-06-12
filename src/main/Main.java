package main;

import controller.Controller;
import model.File;
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
        Controller controller = new Controller(view);
        controller.processUser();
    }
}
