package generalPackage.Grid;

import javafx.scene.canvas.Canvas;

import javafx.scene.input.*;
public abstract class AbstractGrid extends Canvas {
    protected double width;
    protected double height;
    protected double colCount;
    protected double rowCount;

    public AbstractGrid(int width, int height, int colCount, int rowCount) {
        super(width,height);
        this.width = width;
        this.height = height;
        this.colCount = colCount;
        this.rowCount = rowCount;
        setFocusTraversable(true);

    }

    public void repaint(){
        for(int col=0; col<colCount; col++)
            getGraphicsContext2D().strokeLine(4, col*width/colCount, height, col*width/colCount);
        for(int row=0; row<rowCount;row++)
            getGraphicsContext2D().strokeLine(row*height/rowCount,0,row*height/rowCount, width);
    }

    public double getColCount() {
        return colCount;
    }
    public double getRowCount() {
        return rowCount;
    }

    public abstract void paintEntitties();

    public abstract void paint();

    public abstract void mousePressed(MouseEvent mouseEvent);

    public abstract void restart(MouseEvent mouseEvent);
}
