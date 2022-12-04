package fireFighters.grid;

import fireFighters.model.ModelFireFighters;
import generalPackage.AllEntityPainting.VisitorPaint;
import generalPackage.Grid.AbstractGrid;
import generalPackage.entityManager.EntityManager;
import generalPackage.ground.GroundAbstract;
import javafx.scene.input.MouseEvent;

public class GridFireFighters extends AbstractGrid {
    ModelFireFighters model;
    VisitorPaint visitorPaint;

    public GridFireFighters(int width, int height, int colCount, int rowCount) {
        super(width,height,colCount,rowCount);
        setOnMousePressed(this::mousePressed);
        this.visitorPaint = new VisitorPaint(this);
        model = new ModelFireFighters(this,5,2,2,3,1);
        model.initialisation();

    }

    public void restart(MouseEvent mouseEvent){
        model = new ModelFireFighters(this,5,2,2,3,1);
        model.initialisation();
        getGraphicsContext2D().clearRect(0,0,width, height);
        repaint();
    }

    public void mousePressed(MouseEvent mouseEvent) {
        model.activation();
        paint();
    }



    public void paintEntitties(){
        for (GroundAbstract groundInterface:model.getGroundManager().getGround()){
        groundInterface.accept(visitorPaint);
        }
        for (EntityManager entityManager :model.getEntityManagerList()){
            entityManager.acceptPaint(visitorPaint);
        }

    }

    public void paint(){
        getGraphicsContext2D().clearRect(0,0,width,height);
        paintEntitties();
        repaint();
    }

    public ModelFireFighters getModel() {
        return model;
    }
}