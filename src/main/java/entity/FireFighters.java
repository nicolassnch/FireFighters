package entity;
import Util.Position;
import grid.Grid;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.*;

public class FireFighters extends Entities {

    Fires fires;

    Set<Position> new_Entities_Position;

    public FireFighters(Grid grid , int numberEntity , Fires fires){
        super(grid ,numberEntity);
        this.fires = fires;
    }



    private Position step_Toward_Fire(Position position) {
        Set<Position> seen = new HashSet<>();
        HashMap<Position, Position> firstMove = new HashMap<>();
        Queue<Position> toVisit = new LinkedList<>(next_Position_Available(position));
        for (Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);
        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();
            if (fires.get_Entities_Position().contains(current))
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
        List<Position> nextFires = next_Position_Available(randomPosition).stream().filter(fires.get_Entities_Position()::contains).toList();
        fires.extinguish(randomPosition);
        for (Position fire : nextFires)
            fires.extinguish(fire);
        return randomPosition;
    }



    @Override
    public void activation() {
        new_Entities_Position = new HashSet<>();
        for (Position ff : get_Entities_Position()) {
            Position newPosition = activate_Firefighter(ff);
            paintWhite(ff.row(), ff.col(), grid.getGraphicsContext2D());
            paint_Entities(grid.getGraphicsContext2D(), newPosition);
            new_Entities_Position.add(newPosition);
        }
        set_Entities_Position(new_Entities_Position);
    }

    @Override
    public void initialisation() {
        for (int index = 0; index< get_Number_Entities() ; index++){
            add_Position_to_Entities_Position(randomPosition());
        }
    }

    @Override
    public void paint_Entities(GraphicsContext graphicsContext, Position position) {
        graphicsContext.setFill(Color.BLUE);
            int row = position.row();
            int col = position.col();
            double height = get_Grid().getHeight();
            double width = get_Grid().getWidth();
            double rowCount = get_Grid().getRowCount();
            double colCount = get_Grid().getColCount();
            graphicsContext.fillOval(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
    }

    @Override
    public boolean isFire() {
        return false;
    }
}
