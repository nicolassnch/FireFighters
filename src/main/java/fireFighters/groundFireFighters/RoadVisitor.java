package fireFighters.groundFireFighters;

import fireFighters.groundManager.GroundManager;
import fireFighters.entityFireFighter.FireEntity;
import fireFighters.entityFireFighter.FireFighterEntity;


public class RoadVisitor implements VisitorGroundInterface{
    private GroundManager groundManager;
    private double colCount;
    private double rowCount;


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
