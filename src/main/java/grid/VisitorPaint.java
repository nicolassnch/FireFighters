package grid;

import entittyManager.*;
import entity.CloudEntity;
import ground.Montain;
import ground.Road;
import ground.Rockery;
import util.Position;
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
    public void visitFireFighters(WalkFireFighterManager walkFireFighterManager) {
        grid.getGraphicsContext2D().setFill(Color.BLUE);
        double height = grid.getHeight();
        double width = grid.getWidth();
        double rowCount = grid.getRowCount();
        double colCount = grid.getColCount();
        for (FireFighterEntity fireFightersIndex : walkFireFighterManager.getFireFighters()) {
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

    @Override
    public void visitMotorizedFireFighters(MotoeizedFireFighterManager motoeizedFireFighterManager) {
        grid.getGraphicsContext2D().setFill(Color.CADETBLUE);
        double height = grid.getHeight();
        double width = grid.getWidth();
        double rowCount = grid.getRowCount();
        double colCount = grid.getColCount();
        for (Entity firesIndex : motoeizedFireFighterManager.getFireFighters()) {
            int row = firesIndex.getPosition().row();
            int col = firesIndex.getPosition().col();
            grid.getGraphicsContext2D().fillOval(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
        }
    }

    @Override
    public void visitCloud(CloudManager cloudManager) {
        grid.getGraphicsContext2D().setFill(Color.BLACK);
        double height = grid.getHeight();
        double width = grid.getWidth();
        double rowCount = grid.getRowCount();
        double colCount = grid.getColCount();
        for (Entity cloudIndex : cloudManager.getCloudList()) {
            int row = cloudIndex.getPosition().row();
            int col = cloudIndex.getPosition().col();
            grid.getGraphicsContext2D().fillOval(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
        }
    }

    @Override
    public void visitRockery(Rockery rockery) {
        grid.getGraphicsContext2D().setFill(Color.YELLOW);
        double height = grid.getHeight();
        double width = grid.getWidth();
        double rowCount = grid.getRowCount();
        double colCount = grid.getColCount();
        int row = rockery.getPosition().row();
        int col = rockery.getPosition().col();
        grid.getGraphicsContext2D().fillRect(row * height / rowCount, col * width / colCount, height / rowCount, width / colCount);

    }

    @Override
    public void visitRoad(Road road) {
        grid.getGraphicsContext2D().setFill(Color.LIGHTSLATEGREY);
        double height = grid.getHeight();
        double width = grid.getWidth();
        double rowCount = grid.getRowCount();
        double colCount = grid.getColCount();
        int row = road.getPosition().row();
        int col = road.getPosition().col();
        grid.getGraphicsContext2D().fillRect(row * height / rowCount, col * width / colCount, height / rowCount, width / colCount);

    }

    @Override
    public void visitRoad(Montain montain) {
        grid.getGraphicsContext2D().setFill(Color.DARKGREY);
        double height = grid.getHeight();
        double width = grid.getWidth();
        double rowCount = grid.getRowCount();
        double colCount = grid.getColCount();
        int row = montain.getPosition().row();
        int col = montain.getPosition().col();
        grid.getGraphicsContext2D().fillRect(row * height / rowCount, col * width / colCount, height / rowCount, width / colCount);

    }


}
