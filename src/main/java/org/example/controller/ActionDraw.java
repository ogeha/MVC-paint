package org.example.controller;

import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.geom.Point2D;

public class ActionDraw {
    private Model model;
    private MyShape sampleShape;
    private MyShape shape;
    private Point2D firstPoint;
    private Point2D secondPoint;

    public ActionDraw(Model model) {
        this.model = model;
    }

    public void setSampleShape(MyShape sampleShape) {
        this.sampleShape = sampleShape;
    }

    public void setFirstPoint(Point2D firstPoint) {
        this.firstPoint = firstPoint;
    }

    public void setSecondPoint(Point2D secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Point2D getFirstPoint() {
        return firstPoint;
    }

    public Point2D getSecondPoint() {
        return secondPoint;
    }

    public void stretchShape(Point point){
        firstPoint = (Point2D) point;
        shape.setFrame(p);
    }
    public void createShape(Point point){
        secondPoint = (Point2D) point;
        shape = sampleShape.clone();
        model.createCurrentShape(shape);
    }
}
