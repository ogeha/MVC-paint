package org.example.controller;

import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.fill.NoFill;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

// TODO: 24.10.2024 Сделать singleton класс
public class Controller {
    public static Controller instance;
    private Model model;
    private MyFrame frame;

    public static synchronized Controller getInstance(){
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    private MyPanel panel;

    private ActionDraw actionDraw;

    public Controller() {
        model = new Model();
        MyShape shape = new MyShape(new Rectangle2D.Double());
        shape.setFb(new NoFill());
        model.setMyShape(shape);

        panel = new MyPanel(this);
        // TODO: 25.10.2024 Поменять наблюдатель на более современную реализацию
        model.addObserver(panel);

        actionDraw = new ActionDraw(model);

        frame = new MyFrame();
        frame.setPanel(panel);
    }
    public void getPointOne(Point2D p){
        actionDraw.setFirstPoint(p);
    }
    public void getPointTwo(Point2D p){
        actionDraw.setSecondPoint(p);
        model.changeShape(actionDraw.getFirstPoint(), actionDraw.getSecondPoint());
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
}
