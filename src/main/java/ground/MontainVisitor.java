package ground;

import groundManager.GroundManager;
import entity.FireEntity;
import entity.FireFighterEntity;



public class MontainVisitor implements VisitorGroundInterface{

    GroundManager groundManager;
    double colCount;
    double rowCount;

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
