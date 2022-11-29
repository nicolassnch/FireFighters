package ground;

import groundManager.GroundManager;
import Util.Position;
import entity.FireEntity;
import entity.FireFighterEntity;

import java.util.List;

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
    public List<Position> visitorFireFighterEntity(FireFighterEntity fireFighterEntity) {
        return Position.next_Position_Available(fireFighterEntity.getPosition(),colCount,rowCount);
    }

    @Override
    public List<Position>  visitorFireEntity(FireEntity fireEntity) {
        List<Position> nextPossiblePosition = Position.next_Position_Available(fireEntity.getPosition(),colCount,rowCount);
        nextPossiblePosition.removeIf(nextPossible -> groundManager.getGround().contains(new Road(new Position(fireEntity.getPositionRow(), fireEntity.getPositionRow() - 1))));
        nextPossiblePosition.removeIf(nextPossible -> groundManager.getGround().contains(new Road(new Position(fireEntity.getPositionRow(), fireEntity.getPositionRow() + 1))));
        nextPossiblePosition.removeIf(nextPossible -> groundManager.getGround().contains(new Road(new Position(fireEntity.getPositionRow()-1, fireEntity.getPositionRow()))));
        nextPossiblePosition.removeIf(nextPossible -> groundManager.getGround().contains(new Road(new Position(fireEntity.getPositionRow()+1, fireEntity.getPositionRow()))));
        return nextPossiblePosition;
    }
}
