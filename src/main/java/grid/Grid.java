package grid;

import entity.Entities;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Grid extends Canvas{
    double width;
    double height;
    double colCount;
    double rowCount;
    Model model;
    VisitorPaint visitorPaint;

    public Grid(int width, int height, int colCount, int rowCount) {
        super(width,height);
        this.width = width;
        this.height = height;
        this.colCount = colCount;
        this.rowCount = rowCount;
        setFocusTraversable(true);
        setOnMousePressed(this::mousePressed);
        this.visitorPaint = new VisitorPaint(this);
        model = new Model(this);
        model.initialisation(3,10);

    }

    public void restart(MouseEvent mouseEvent){
        model = new Model(this);
        model.initialisation(3,10);
        getGraphicsContext2D().clearRect(0,0,width, height);
        repaint();
    }
    private void mousePressed(MouseEvent mouseEvent) {
        model.activation();
        repaint();
    }

    public void repaint(){
        for(int col=0; col<colCount; col++)
            getGraphicsContext2D().strokeLine(0, col*width/colCount, height, col*width/colCount);
        for(int row=0; row<rowCount;row++)
            getGraphicsContext2D().strokeLine(row*height/rowCount,0,row*height/rowCount, width);
    }


    public void paintEntitties(){
        for (Entities entities:model.entities){
            entities.accept(visitorPaint);
        }
    }

    public void paint(){
        getGraphicsContext2D().clearRect(0,0,width,height);
        paintEntitties();
        repaint();
    }



    public Model getModel() {
        return model;
    }
    public double getColCount() {
        return colCount;
    }
    public double getRowCount() {
        return rowCount;
    }
}