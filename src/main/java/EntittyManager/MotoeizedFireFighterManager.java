package EntittyManager;

import Util.Position;
import entity.FireFighterEntity;
import grid.InterfaceVisitorPaint;

import java.util.*;

public class MotoeizedFireFighterManager extends FireFightersManager {


    public MotoeizedFireFighterManager(int numberEntity, double rowCount, double colCount, FiresManager fires) {
        super(numberEntity, rowCount, colCount, fires);
    }

    @Override
    protected Position activate_Firefighter(Position position) {
        Position randomPosition = step_Toward_Fire(position);
        List<Position> nextFires = Position.next_Position_Available(randomPosition,colCount,rowCount);
        fires.extinguish(fires.contain(randomPosition));
        for (Position fire : nextFires){
            fires.extinguish(fires.contain(fire));
        }
        randomPosition = step_Toward_Fire(randomPosition);
        nextFires = Position.next_Position_Available(randomPosition,colCount,rowCount);
        fires.extinguish(fires.contain(randomPosition));
        for (Position fire : nextFires){
            fires.extinguish(fires.contain(fire));
        }
        return randomPosition;
    }

    @Override
    public void accept(InterfaceVisitorPaint visitor) {
        visitor.visitMotorizedFireFighters(this);
    }
}
