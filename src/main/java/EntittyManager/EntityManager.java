package entittyManager;

import ground.VisitorGroundInterface;
import entity.Entity;
import grid.InterfaceVisitorPaint;

import java.util.List;

public abstract class EntityManager {

    int numberEntity;
    double colCount;
    double rowCount;
    List<VisitorGroundInterface> visitorGroundInterfacesList;

    public EntityManager(int numberEntity,double rowCount,double colCount,List<VisitorGroundInterface> visitorGroundInterfacesList ) {
        this.visitorGroundInterfacesList = visitorGroundInterfacesList;
        this.numberEntity = numberEntity;
        this.colCount = colCount;
        this.rowCount = rowCount;
    }

    public EntityManager(int numberEntity,double rowCount,double colCount ) {
        this.numberEntity = numberEntity;
        this.colCount = colCount;
        this.rowCount = rowCount;
    }

    public abstract void activate();
    public abstract void initialisation();
    public abstract void acceptPaint(InterfaceVisitorPaint visitor);
    public abstract Boolean acceptGround(List<VisitorGroundInterface> visitorGroundInterfacesList, Entity entity);

}
