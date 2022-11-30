package ground;

import entity.FireEntity;
import entity.FireFighterEntity;
import groundManager.GroundManager;

public class RockeryVisitor implements VisitorGroundInterface{
    GroundManager groundManager;
    double colCount;
    double rowCount;

    public RockeryVisitor(GroundManager groundManager, double colCount, double rowCount) {
        this.groundManager = groundManager;
        this.colCount = colCount;
        this.rowCount = rowCount;
    }

    @Override
    public Boolean visitorFireFighterEntityPositionDisponnible(FireFighterEntity fireFighterEntity) {
        return groundManager.getGround().contains(new Rockery(fireFighterEntity.getPosition()));
    }

    @Override
    public Boolean visitorFireEntityPositionDisponnible(FireEntity fireEntity) {
        return groundManager.getGround().contains(new Rockery(fireEntity.getPosition()));
    }
}
