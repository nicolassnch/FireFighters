package entittyManager;

import ground.VisitorGroundInterface;
import util.Position;
import entity.Entity;
import grid.InterfaceVisitorPaint;
import grid.VisitorPaint;

import java.util.List;

public abstract class EntityManager {

    int numberEntity;
    double colCount;
    double rowCount;
    List<VisitorGroundInterface> visitorGroundInterfacesList;
    int step = 0;

    public EntityManager(int numberEntity,double rowCount,double colCount,List<VisitorGroundInterface> visitorGroundInterfacesList ) {
        this.visitorGroundInterfacesList = visitorGroundInterfacesList;
        this.numberEntity = numberEntity;
        this.colCount = colCount;
        this.rowCount = rowCount;
    }

    public abstract void activate();
    public abstract void initialisation();
    public abstract void accept(InterfaceVisitorPaint visitor);
    public abstract Boolean acceptGround(List<VisitorGroundInterface> visitorGroundInterfacesList, Entity entity);

}
