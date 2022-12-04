package rockPaperScissor.grid;

import fireFighters.modelFireFighters.ModelFireFighters;
import generalPackage.AllEntityPainting.VisitorPaint;
import generalPackage.Grid.AbstractGrid;
import generalPackage.entityManager.EntityManager;
import javafx.scene.input.MouseEvent;
import rockPaperScissor.model.Model;

public class Grid extends AbstractGrid {

    VisitorPaint visitorPaint;

    Model model;

    public Grid(int width, int height, int colCount, int rowCount) {
        super(width,height,colCount,rowCount);
        setOnMousePressed(this::mousePressed);
        this.visitorPaint = new VisitorPaint(this);
        model = new Model(this,3,3,3);
        model.initialisation();
    }

    @Override
    public void paintEntitties() {
        for (EntityManager entityManager :model.getEntityManagerList()){
            entityManager.acceptPaint(visitorPaint);
        }
    }

    @Override
    public void paint() {
        getGraphicsContext2D().clearRect(0,0,width,height);
        paintEntitties();
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        model.activation();
        paint();
    }

    @Override
    public void restart(MouseEvent mouseEvent) {
        model = new Model(this,3,3,3);
        model.initialisation();
        getGraphicsContext2D().clearRect(0,0,width, height);
        repaint();
    }

    public Model getModel() {
        return model;
    }
}
