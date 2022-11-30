package ground;

import groundManager.GroundManager;
import entity.FireEntity;
import entity.FireFighterEntity;


public class RoadVisitor implements VisitorGroundInterface{
    GroundManager groundManager;
    double colCount;
    double rowCount;


    public RoadVisitor(GroundManager groundManager, double colCount, double rowCount) {
        this.groundManager = groundManager;
        this.colCount = colCount;
        this.rowCount = rowCount;
    }


    @Override
    public Boolean visitorFireFighterEntityPositionDisponnible(FireFighterEntity fireFighterEntity) {
        return true;
    }

    @Override
    public Boolean visitorFireEntityPositionDisponnible(FireEntity fireEntity) {
        return !groundManager.getGround().contains(new Road(fireEntity.getPosition()));
    }
}
