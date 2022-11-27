package grid;

import Util.Position;
import EntittyManager.FireFightersManager;
import EntittyManager.FiresManager;
import entity.Entity;
import entity.FireEntity;
import entity.FireFighterEntity;
import javafx.scene.paint.Color;

public class VisitorPaint implements InterfaceVisitorPaint{

    Grid grid;

    public VisitorPaint(Grid grid) {
        this.grid =grid;
    }

    @Override
    public void visitFireFighters(FireFightersManager fireFighters) {
        grid.getGraphicsContext2D().setFill(Color.BLUE);
        double height = grid.getHeight();
        double width = grid.getWidth();
        double rowCount = grid.getRowCount();
        double colCount = grid.getColCount();
        for (FireFighterEntity fireFightersIndex : fireFighters.getFireFighters()) {
            int row = fireFightersIndex.getPosition().row();
            int col = fireFightersIndex.getPosition().col();
            grid.getGraphicsContext2D().fillOval(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
        }

    }

    @Override
    public void visitFires(FiresManager fires) {
        grid.getGraphicsContext2D().setFill(Color.RED);
        double height = grid.getHeight();
        double width = grid.getWidth();
        double rowCount = grid.getRowCount();
        double colCount = grid.getColCount();
        for (Entity firesIndex : fires.get_Fires()) {
            int row = firesIndex.getPosition().row();
            int col = firesIndex.getPosition().col();
            grid.getGraphicsContext2D().fillRect(row * height / rowCount, col * width / colCount, height / rowCount, width / colCount);
        }
    }
}
