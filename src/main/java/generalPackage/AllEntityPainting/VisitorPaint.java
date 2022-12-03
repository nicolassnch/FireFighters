package generalPackage.AllEntityPainting;

import fireFighters.EntittyManagerFireFighters.*;
import fireFighters.entityFireFighter.FireFighterEntity;
import fireFighters.groundFireFighters.*;
import generalPackage.Grid.AbstractGrid;
import generalPackage.entity.Entity;
import javafx.scene.paint.Color;
import rockPaperScissor.entity.PaperEntity;
import rockPaperScissor.entity.RockEntity;
import rockPaperScissor.entity.ScissorEntity;
import rockPaperScissor.entityManager.PaperManager;
import rockPaperScissor.entityManager.RockManager;
import rockPaperScissor.entityManager.ScissorManager;

public class VisitorPaint implements InterfaceVisitorPaint {

    private AbstractGrid abstractGrid;
    public VisitorPaint(AbstractGrid abstractGrid) {
        this.abstractGrid = abstractGrid;
    }

    @Override
    public void visitFireFighters(WalkFireFighterManager walkFireFighterManager) {
        abstractGrid.getGraphicsContext2D().setFill(Color.BLUE);
        double height = abstractGrid.getHeight();
        double width = abstractGrid.getWidth();
        double rowCount = abstractGrid.getRowCount();
        double colCount = abstractGrid.getColCount();
        for (FireFighterEntity fireFightersIndex : walkFireFighterManager.getFireFighters()) {
            int row = fireFightersIndex.getPosition().row();
            int col = fireFightersIndex.getPosition().col();
            abstractGrid.getGraphicsContext2D().fillOval(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
        }

    }

    @Override
    public void visitFires(FiresManager fires) {
        abstractGrid.getGraphicsContext2D().setFill(Color.RED);
        double height = abstractGrid.getHeight();
        double width = abstractGrid.getWidth();
        double rowCount = abstractGrid.getRowCount();
        double colCount = abstractGrid.getColCount();
        for (Entity firesIndex : fires.get_Fires()) {
            int row = firesIndex.getPosition().row();
            int col = firesIndex.getPosition().col();
            abstractGrid.getGraphicsContext2D().fillRect(row * height / rowCount, col * width / colCount, height / rowCount, width / colCount);
        }
    }

    @Override
    public void visitMotorizedFireFighters(MotoeizedFireFighterManager motoeizedFireFighterManager) {
        abstractGrid.getGraphicsContext2D().setFill(Color.CADETBLUE);
        double height = abstractGrid.getHeight();
        double width = abstractGrid.getWidth();
        double rowCount = abstractGrid.getRowCount();
        double colCount = abstractGrid.getColCount();
        for (Entity firesIndex : motoeizedFireFighterManager.getFireFighters()) {
            int row = firesIndex.getPosition().row();
            int col = firesIndex.getPosition().col();
            abstractGrid.getGraphicsContext2D().fillOval(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
        }
    }

    @Override
    public void visitCloud(CloudManager cloudManager) {
        abstractGrid.getGraphicsContext2D().setFill(Color.BLACK);
        double height = abstractGrid.getHeight();
        double width = abstractGrid.getWidth();
        double rowCount = abstractGrid.getRowCount();
        double colCount = abstractGrid.getColCount();
        for (Entity cloudIndex : cloudManager.getCloudList()) {
            int row = cloudIndex.getPosition().row();
            int col = cloudIndex.getPosition().col();
            abstractGrid.getGraphicsContext2D().fillOval(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
        }
    }

    @Override
    public void visitRockery(Rockery rockery) {
        abstractGrid.getGraphicsContext2D().setFill(Color.YELLOW);
        double height = abstractGrid.getHeight();
        double width = abstractGrid.getWidth();
        double rowCount = abstractGrid.getRowCount();
        double colCount = abstractGrid.getColCount();
        int row = rockery.getPosition().row();
        int col = rockery.getPosition().col();
        abstractGrid.getGraphicsContext2D().fillRect(row * height / rowCount, col * width / colCount, height / rowCount, width / colCount);

    }



    @Override
    public void visitRoad(Road road) {
        abstractGrid.getGraphicsContext2D().setFill(Color.LIGHTSLATEGREY);
        double height = abstractGrid.getHeight();
        double width = abstractGrid.getWidth();
        double rowCount = abstractGrid.getRowCount();
        double colCount = abstractGrid.getColCount();
        int row = road.getPosition().row();
        int col = road.getPosition().col();
        abstractGrid.getGraphicsContext2D().fillRect(row * height / rowCount, col * width / colCount, height / rowCount, width / colCount);

    }

    @Override
    public void visitRoad(Montain montain) {
        abstractGrid.getGraphicsContext2D().setFill(Color.DARKGREY);
        double height = abstractGrid.getHeight();
        double width = abstractGrid.getWidth();
        double rowCount = abstractGrid.getRowCount();
        double colCount = abstractGrid.getColCount();
        int row = montain.getPosition().row();
        int col = montain.getPosition().col();
        abstractGrid.getGraphicsContext2D().fillRect(row * height / rowCount, col * width / colCount, height / rowCount, width / colCount);

    }


    @Override
    public void visitPaper(PaperManager paperManager) {
        abstractGrid.getGraphicsContext2D().setFill(Color.YELLOW);
        double height = abstractGrid.getHeight();
        double width = abstractGrid.getWidth();
        double rowCount = abstractGrid.getRowCount();
        double colCount = abstractGrid.getColCount();
        for (PaperEntity paperEntity : paperManager.getPapersSet()) {
            int row = paperEntity.getPosition().row();
            int col = paperEntity.getPosition().col();
            abstractGrid.getGraphicsContext2D().fillOval(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
        }
    }

    @Override
    public void visitRock(RockManager rockManager) {
        abstractGrid.getGraphicsContext2D().setFill(Color.DARKGRAY);
        double height = abstractGrid.getHeight();
        double width = abstractGrid.getWidth();
        double rowCount = abstractGrid.getRowCount();
        double colCount = abstractGrid.getColCount();
        for (RockEntity rockEntity : rockManager.getRockSet()) {
            int row = rockEntity.getPosition().row();
            int col = rockEntity.getPosition().col();
            abstractGrid.getGraphicsContext2D().fillOval(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
        }
    }

    @Override
    public void visitScissor(ScissorManager scissorManager) {
        abstractGrid.getGraphicsContext2D().setFill(Color.DEEPPINK);
        double height = abstractGrid.getHeight();
        double width = abstractGrid.getWidth();
        double rowCount = abstractGrid.getRowCount();
        double colCount = abstractGrid.getColCount();
        for (ScissorEntity scissorEntity : scissorManager.getScissorSet()) {
            int row = scissorEntity.getPosition().row();
            int col = scissorEntity.getPosition().col();
            abstractGrid.getGraphicsContext2D().fillOval(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
        }
    }
}
