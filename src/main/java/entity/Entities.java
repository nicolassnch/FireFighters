package entity;

import Util.Position;
import grid.Grid;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Entities {

    Grid grid;
    Set<Position> entities_Position = new HashSet<>();
    int number_Entities;
    public Entities(Grid grid, int number_Entities){
        this.grid = grid;
        this.number_Entities = number_Entities;
    }

    protected Position randomPosition() {
        return new Position((int) (Math.random() * grid.getRowCount()), (int) (Math.random() * grid.getColCount()));
    }

    

    protected List<Position> next_Position_Available(Position position) {
        List<Position> list = new ArrayList<>();
        if (position.row() > 0) list.add(new Position(position.row() - 1, position.col()));
        if (position.col() > 0) list.add(new Position(position.row(), position.col() - 1));
        if (position.row() < grid.getColCount() - 1) list.add(new Position(position.row() + 1, position.col()));
        if (position.col() < grid.getRowCount() - 1) list.add(new Position(position.row(), position.col() + 1));
        return list;
    }
    
    void paintWhite(int row, int col,GraphicsContext graphicsContext){
        double height = get_Grid().getHeight();
        double width = get_Grid().getWidth();
        double rowCount = get_Grid().getRowCount();
        double colCount = get_Grid().getColCount();

        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
    }
    
    public void add_Position_to_Entities_Position(Position position){
        entities_Position.add(position);
    }

    public void remove_Position_to_Entities_Position(Position position){
        entities_Position.remove(position);
    }

    public void set_Entities_Position(Set<Position> entitys_Position) {
        this.entities_Position = entitys_Position;
    }

    public Set<Position> get_Entities_Position() {
        return entities_Position;
    }

    public int get_Number_Entities() {
        return number_Entities;
    }

    public Grid get_Grid() {
        return grid;
    }

   

    public abstract void activation();
    public abstract void initialisation();

    public abstract void paint_Entities(GraphicsContext graphicsContext , Position position);

    public abstract boolean isFire();
}
