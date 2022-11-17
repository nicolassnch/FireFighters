package entity;

import Util.Position;
import grid.Grid;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fires implements Entities{

    Set<Position> fires_Position = new HashSet<>();

    Grid grid;
    int number_Entities;
    public Fires(Grid grid, int number_Entities){
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
        double height = grid.getHeight();
        double width = grid.getWidth();
        double rowCount = grid.getRowCount();
        double colCount = grid.getColCount();

        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
    }

    public void extinguish(Position position) {
        remove_Position_to_Fires_Position(position);
        paintWhite(position.row(), position.col(), grid.getGraphicsContext2D());
    }


    public void add_Position_to_Fires_Position(Position position){
        fires_Position.add(position);
    }

    public void remove_Position_to_Fires_Position(Position position){
        fires_Position.remove(position);
    }

    public void set_Fires_Position(Set<Position> entitys_Position) {
        this.fires_Position = entitys_Position;
    }

    public Set<Position> get_Fires_Position() {
        return fires_Position;
    }

    public int get_Number_Fires() {
        return number_Entities;
    }

    public Grid get_Grid() {
        return grid;
    }




    @Override
    public void activation() {
        List <Position> positions = new ArrayList<>();
        for (Position position : get_Fires_Position()){
            positions.addAll(next_Position_Available(position));
        }
        for (Position position:positions){
            paint_Entities(grid.getGraphicsContext2D(),position);
            add_Position_to_Fires_Position(position);
        }
    }

    @Override
    public void initialisation() {
        for (int index = 0; index< get_Number_Fires() ; index++){
            add_Position_to_Fires_Position(randomPosition());
        }
    }

    @Override
    public void paint_Entities(GraphicsContext graphicsContext, Position position) {
        graphicsContext.setFill(Color.RED);
        int row = position.row();
        int col = position.col();
        double height = get_Grid().getHeight();
        double width = get_Grid().getWidth();
        double rowCount = get_Grid().getRowCount();
        double colCount = get_Grid().getColCount();
        graphicsContext.fillRect(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
    }

    @Override
    public boolean isFire() {
        return true;
    }
}
