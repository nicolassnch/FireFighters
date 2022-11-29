package ground;

import groundManager.GroundManager;
import Util.Position;
import entity.FireEntity;
import entity.FireFighterEntity;

import java.util.List;

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
    public List<Position> visitorFireFighterEntity(FireFighterEntity fireFighterEntity) {
        List<Position> nextPossiblePosition = Position.next_Position_Available(fireFighterEntity.getPosition(),colCount,rowCount);
        nextPossiblePosition.removeIf(nextPossible -> groundManager.getGround().contains(new Montain(new Position(fireFighterEntity.getPositionRow(), fireFighterEntity.getPositionRow() - 1))));
        nextPossiblePosition.removeIf(nextPossible -> groundManager.getGround().contains(new Montain(new Position(fireFighterEntity.getPositionRow(), fireFighterEntity.getPositionRow() + 1))));
        nextPossiblePosition.removeIf(nextPossible -> groundManager.getGround().contains(new Montain(new Position(fireFighterEntity.getPositionRow() - 1, fireFighterEntity.getPositionRow()))));
        nextPossiblePosition.removeIf(nextPossible -> groundManager.getGround().contains(new Montain(new Position(fireFighterEntity.getPositionRow() + 1, fireFighterEntity.getPositionRow()))));
        return nextPossiblePosition;
    }

    @Override
    public List<Position>  visitorFireEntity(FireEntity fireEntity) {
        List<Position> nextPossiblePosition = Position.next_Position_Available(fireEntity.getPosition(),colCount,rowCount);
        System.out.println(nextPossiblePosition);
        nextPossiblePosition.removeIf(nextPossible -> groundManager.getGround().contains(new Montain(new Position(fireEntity.getPositionRow(), fireEntity.getPositionRow() - 1))));
        nextPossiblePosition.removeIf(nextPossible -> groundManager.getGround().contains(new Montain(new Position(fireEntity.getPositionRow(), fireEntity.getPositionRow() + 1))));
        nextPossiblePosition.removeIf(nextPossible -> groundManager.getGround().contains(new Montain(new Position(fireEntity.getPositionRow() - 1, fireEntity.getPositionRow()))));
        nextPossiblePosition.removeIf(nextPossible -> groundManager.getGround().contains(new Montain(new Position(fireEntity.getPositionRow() + 1, fireEntity.getPositionRow()))));
        System.out.println(groundManager.getGround().toString());
        System.out.println(nextPossiblePosition+"\n\n");
        return nextPossiblePosition;
    }
}
