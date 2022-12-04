package fireFighters.ground;

import fireFighters.groundManager.GroundManager;
import fireFighters.entity.FireEntity;
import fireFighters.entity.FireFighterEntity;



public class MontainVisitor implements VisitorGroundInterface{

    private GroundManager groundManager;
    private double colCount;
    private double rowCount;

    public MontainVisitor(GroundManager groundManager, double colCount, double rowCount) {
        this.groundManager = groundManager;
        this.colCount = colCount;
        this.rowCount = rowCount;
    }

    @Override
    public Boolean visitorFireFighterEntityPositionDisponnible(FireFighterEntity fireFighterEntity) {
        return !groundManager.getGround().contains(new Montain(fireFighterEntity.getPosition()));
    }

    @Override
    public Boolean visitorFireEntityPositionDisponnible(FireEntity fireEntity) {
        return !groundManager.getGround().contains(new Montain(fireEntity.getPosition()));
    }
}
