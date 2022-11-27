package EntittyManager;

import grid.InterfaceVisitorPaint;
import grid.VisitorPaint;

public abstract class EntityManager {

    int numberEntity;
    double colCount;
    double rowCount;
    int step = 0;

    public EntityManager(int numberEntity,double rowCount,double colCount) {
        this.numberEntity = numberEntity;
        this.colCount = colCount;
        this.rowCount = rowCount;
    }

    public abstract void activate();
    public abstract void initialisation();
    public abstract void accept(InterfaceVisitorPaint visitor);
}
