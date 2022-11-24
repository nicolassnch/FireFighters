package grid;

import Util.Position;
import entity.FireFighters;
import entity.Fires;
import javafx.scene.paint.Color;

public class VisitorPaint implements InterfaceVisitorPaint{

    Grid grid;

    public VisitorPaint(Grid grid) {
        this.grid =grid;
    }

    @Override
    public void visitFireFighters(FireFighters fireFighters) {
        grid.getGraphicsContext2D().setFill(Color.BLUE);
        double height = grid.getHeight();
        double width = grid.getWidth();
        double rowCount = grid.getRowCount();
        double colCount = grid.getColCount();
        for (Position fireFightersIndex : fireFighters.get_FireFighters_Position()) {
            int row = fireFightersIndex.row();
            int col = fireFightersIndex.col();
            grid.getGraphicsContext2D().fillOval(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
        }

    }

    @Override
    public void visitFires(Fires fires) {
        grid.getGraphicsContext2D().setFill(Color.RED);
        double height = grid.getHeight();
        double width = grid.getWidth();
        double rowCount = grid.getRowCount();
        double colCount = grid.getColCount();
        for (Position firesIndex : fires.get_Fires_Position()) {
            int row = firesIndex.row();
            int col = firesIndex.col();
            grid.getGraphicsContext2D().fillRect(row * height / rowCount, col * width / colCount, height / rowCount, width / colCount);
        }
    }
}
