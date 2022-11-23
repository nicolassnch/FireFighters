package grid;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class Grid extends Canvas{
    double width;
    double height;
    double colCount;
    double rowCount;
    Model model;


    public Grid(int width, int height, int colCount, int rowCount) {
        super(width,height);
        this.width = width;
        this.height = height;
        this.colCount = colCount;
        this.rowCount = rowCount;
        setFocusTraversable(true);
        setOnMousePressed(this::mousePressed);
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

    public void update(){
        model.activation();
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