package fireFighters.ground;

import fireFighters.entity.FireEntity;
import fireFighters.entity.FireFighterEntity;
import fireFighters.groundManager.GroundManager;

public class RockeryVisitor implements VisitorGroundInterface{
    private GroundManager groundManager;
    private double colCount;
    private double rowCount;

    public RockeryVisitor(GroundManager groundManager, double colCount, double rowCount) {
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
        return groundManager.getGround().contains(new Rockery(fireEntity.getPosition()));
    }
}
