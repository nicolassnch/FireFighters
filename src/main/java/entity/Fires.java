package entity;

import Util.Position;
import grid.Grid;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Fires extends Entities {


    public Fires(Grid grid , int numberEntity){
        super(grid ,numberEntity);
    }


    public void extinguish(Position position) {
        remove_Position_to_Entities_Position(position);
        paintWhite(position.row(), position.col(), grid.getGraphicsContext2D());
    }

    @Override
    public void activation() {
        List <Position> positions = new ArrayList<>();
        for (Position position : get_Entities_Position()){
            positions.addAll(next_Position_Available(position));
        }
        for (Position position:positions){
            paint_Entities(grid.getGraphicsContext2D(),position);
            add_Position_to_Entities_Position(position);
        }
    }


    @Override
    public void initialisation() {
        for (int index = 0; index< get_Number_Entities() ; index++){
            add_Position_to_Entities_Position(randomPosition());
        }
    }

    @Override
    public void paint_Entities(GraphicsContext graphicsContext , Position position) {
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
