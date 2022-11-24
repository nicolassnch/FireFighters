package entity;

import Util.Position;
import grid.Grid;
import grid.Model;
import grid.InterfaceVisitorPaint;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.*;

public class FireFighters implements Entities{


    List<Position> fireFighters_Position = new ArrayList<>();
    List<Position> new_Position;
    Grid grid;
    int number_Entities;
    Fires fires;


    public FireFighters(Grid grid, int number_Entities , Fires fires){
        this.fires=fires;
        this.grid = grid;
        this.number_Entities = number_Entities;
    }


    protected Position randomPosition() {
        return new Position((int) (Math.random() * grid.getRowCount()), (int) (Math.random() * grid.getColCount()));
    }

    public List<Position> next_Position_Available(Position position) {
        List<Position> list = new ArrayList<>();
        if (position.row() > 0) list.add(new Position(position.row() - 1, position.col()));
        if (position.col() > 0) list.add(new Position(position.row(), position.col() - 1));
        if (position.row() < grid.getColCount() - 1) list.add(new Position(position.row() + 1, position.col()));
        if (position.col() < grid.getRowCount() - 1) list.add(new Position(position.row(), position.col() + 1));
        return list;
    }


    private Position step_Toward_Fire(Position position) {
        Set<Position> seen = new HashSet<>();
        HashMap<Position, Position> firstMove = new HashMap<>();
        Queue<Position> toVisit = new LinkedList<>();
        toVisit.addAll(next_Position_Available(position));
        for (Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);
        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();
            if (fires.get_Fires_Position().contains(current))
                return firstMove.get(current);
            for (Position adjacent : next_Position_Available(current)) {
                if (seen.contains(adjacent)) continue;
                toVisit.add(adjacent);
                seen.add(adjacent);
                firstMove.put(adjacent, firstMove.get(current));
            }
        }
        return position;
    }

    private Position activate_Firefighter(Position position) {
        Position randomPosition = step_Toward_Fire(position);
        List<Position> nextFires = next_Position_Available(randomPosition).stream().filter(fires.get_Fires_Position()::contains).toList();
        fires.extinguish(randomPosition);
        for (Position fire : nextFires)
            fires.extinguish(fire);
        return randomPosition;
    }

    public void add_Position_to_FireFighters_Position(Position position){
        fireFighters_Position.add(position);
    }


    public void set_FireFighters_Position(List<Position> entitys_Position) {
        this.fireFighters_Position = entitys_Position;
    }

    public List<Position> get_FireFighters_Position() {
        return fireFighters_Position;
    }

    public int get_Number_FireFighters() {
        return number_Entities;
    }


    @Override
    public void activation() {
        new_Position = new ArrayList<>();
        for (Position ff : get_FireFighters_Position()) {
            Position newPosition = activate_Firefighter(ff);
            new_Position.add(newPosition);
        }
        set_FireFighters_Position(new_Position);
    }

    @Override
    public void initialisation() {
        for (int index = 0; index< get_Number_FireFighters() ; index++){
            add_Position_to_FireFighters_Position(randomPosition());
        }
    }


    @Override
    public void accept(InterfaceVisitorPaint visitor) {
        visitor.visitFireFighters(this);
    }

}
