package org.example.model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

// TODO: 25.10.2024 Сделать singleton класс
public class Model extends Observable {
    private MyShape currentShape;

    private List<MyShape> shapeList = new ArrayList<>();

    public void setMyShape(MyShape myShape) {
        this.currentShape = myShape;
    }

    public void changeShape(Point2D x, Point2D y) {
        currentShape.setFrame(x, y);
        shapeList.add(currentShape);
        this.setChanged();
        this.notifyObservers();
    }

    public void draw(Graphics2D g) {
        for (MyShape shape : shapeList) {
            shape.draw(g);
        }
    }
    public void createCurrentShape(MyShape myShape){
        setMyShape(currentShape);
    }
}
