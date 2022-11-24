package entity;

import Util.Position;

import grid.Grid;
import grid.Model;
import grid.InterfaceVisitorPaint;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fires implements Entities{
    int step = 0;
    Set<Position> fires_Position = new HashSet<>();
    Grid grid;
    int number_Entities;
    Model model;

    InterfaceVisitorPaint visitorPaint;
    public Fires(Grid grid, int number_Entities){
        this.model = model;
        this.grid = grid;
        this.number_Entities = number_Entities;
    }


    public List<Position> next_Position_Available(Position position) {
        List<Position> list = new ArrayList<>();
        if (position.row() > 0) list.add(new Position(position.row() - 1, position.col()));
        if (position.col() > 0) list.add(new Position(position.row(), position.col() - 1));
        if (position.row() < grid.getColCount() - 1) list.add(new Position(position.row() + 1, position.col()));
        if (position.col() < grid.getRowCount() - 1) list.add(new Position(position.row(), position.col() + 1));
        return list;
    }




    public void extinguish(Position position) {
        remove_Position_to_Fires_Position(position);
    }


    public void add_Position_to_Fires_Position(Position position){
        fires_Position.add(position);
    }

    public void remove_Position_to_Fires_Position(Position position){
        fires_Position.remove(position);
    }


    public Set<Position> get_Fires_Position() {
        return fires_Position;
    }

    public int get_Number_Fires() {
        return number_Entities;
    }



    @Override
    public void activation() {
        if (step % 2 == 0) {
            List<Position> positions = new ArrayList<>();
            for (Position position : get_Fires_Position()) {
                positions.addAll(next_Position_Available(position));
            }
            for (Position position : positions) {
                add_Position_to_Fires_Position(position);
            }
        }
        step++;
    }

    @Override
    public void initialisation() {
        for (int index = 0; index< get_Number_Fires() ; index++){
            add_Position_to_Fires_Position(Position.randomPosition(grid));
        }
    }


    @Override
    public void accept(InterfaceVisitorPaint visitor) {
        visitor.visitFires(this);
    }

}
