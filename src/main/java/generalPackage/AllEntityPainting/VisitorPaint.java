package generalPackage.AllEntityPainting;

import fireFighters.EntittyManagerFireFighters.*;
import fireFighters.entityFireFighter.FireFighterEntity;
import fireFighters.gridFireFighters.GridFireFighters;
import fireFighters.groundFireFighters.*;
import generalPackage.entity.Entity;
import javafx.scene.paint.Color;

public class VisitorPaint implements InterfaceVisitorPaint {

    private GridFireFighters gridFireFighters;

    public VisitorPaint(GridFireFighters gridFireFighters) {
        this.gridFireFighters = gridFireFighters;
    }

    @Override
    public void visitFireFighters(WalkFireFighterManager walkFireFighterManager) {
        gridFireFighters.getGraphicsContext2D().setFill(Color.BLUE);
        double height = gridFireFighters.getHeight();
        double width = gridFireFighters.getWidth();
        double rowCount = gridFireFighters.getRowCount();
        double colCount = gridFireFighters.getColCount();
        for (FireFighterEntity fireFightersIndex : walkFireFighterManager.getFireFighters()) {
            int row = fireFightersIndex.getPosition().row();
            int col = fireFightersIndex.getPosition().col();
            gridFireFighters.getGraphicsContext2D().fillOval(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
        }

    }

    @Override
    public void visitFires(FiresManager fires) {
        gridFireFighters.getGraphicsContext2D().setFill(Color.RED);
        double height = gridFireFighters.getHeight();
        double width = gridFireFighters.getWidth();
        double rowCount = gridFireFighters.getRowCount();
        double colCount = gridFireFighters.getColCount();
        for (Entity firesIndex : fires.get_Fires()) {
            int row = firesIndex.getPosition().row();
            int col = firesIndex.getPosition().col();
            gridFireFighters.getGraphicsContext2D().fillRect(row * height / rowCount, col * width / colCount, height / rowCount, width / colCount);
        }
    }

    @Override
    public void visitMotorizedFireFighters(MotoeizedFireFighterManager motoeizedFireFighterManager) {
        gridFireFighters.getGraphicsContext2D().setFill(Color.CADETBLUE);
        double height = gridFireFighters.getHeight();
        double width = gridFireFighters.getWidth();
        double rowCount = gridFireFighters.getRowCount();
        double colCount = gridFireFighters.getColCount();
        for (Entity firesIndex : motoeizedFireFighterManager.getFireFighters()) {
            int row = firesIndex.getPosition().row();
            int col = firesIndex.getPosition().col();
            gridFireFighters.getGraphicsContext2D().fillOval(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
        }
    }

    @Override
    public void visitCloud(CloudManager cloudManager) {
        gridFireFighters.getGraphicsContext2D().setFill(Color.BLACK);
        double height = gridFireFighters.getHeight();
        double width = gridFireFighters.getWidth();
        double rowCount = gridFireFighters.getRowCount();
        double colCount = gridFireFighters.getColCount();
        for (Entity cloudIndex : cloudManager.getCloudList()) {
            int row = cloudIndex.getPosition().row();
            int col = cloudIndex.getPosition().col();
            gridFireFighters.getGraphicsContext2D().fillOval(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
        }
    }

    @Override
    public void visitRockery(Rockery rockery) {
        gridFireFighters.getGraphicsContext2D().setFill(Color.YELLOW);
        double height = gridFireFighters.getHeight();
        double width = gridFireFighters.getWidth();
        double rowCount = gridFireFighters.getRowCount();
        double colCount = gridFireFighters.getColCount();
        int row = rockery.getPosition().row();
        int col = rockery.getPosition().col();
        gridFireFighters.getGraphicsContext2D().fillRect(row * height / rowCount, col * width / colCount, height / rowCount, width / colCount);

    }

    @Override
    public void visitRoad(Road road) {
        gridFireFighters.getGraphicsContext2D().setFill(Color.LIGHTSLATEGREY);
        double height = gridFireFighters.getHeight();
        double width = gridFireFighters.getWidth();
        double rowCount = gridFireFighters.getRowCount();
        double colCount = gridFireFighters.getColCount();
        int row = road.getPosition().row();
        int col = road.getPosition().col();
        gridFireFighters.getGraphicsContext2D().fillRect(row * height / rowCount, col * width / colCount, height / rowCount, width / colCount);

    }

    @Override
    public void visitRoad(Montain montain) {
        gridFireFighters.getGraphicsContext2D().setFill(Color.DARKGREY);
        double height = gridFireFighters.getHeight();
        double width = gridFireFighters.getWidth();
        double rowCount = gridFireFighters.getRowCount();
        double colCount = gridFireFighters.getColCount();
        int row = montain.getPosition().row();
        int col = montain.getPosition().col();
        gridFireFighters.getGraphicsContext2D().fillRect(row * height / rowCount, col * width / colCount, height / rowCount, width / colCount);

    }


}
