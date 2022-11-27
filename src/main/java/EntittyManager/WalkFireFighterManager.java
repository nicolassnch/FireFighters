package EntittyManager;

import Util.Position;
import grid.InterfaceVisitorPaint;

import java.util.*;

public class WalkFireFighterManager extends FireFightersManager{


    public WalkFireFighterManager(int numberEntity, double rowCount, double colCount, FiresManager fires) {
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
        return randomPosition;
    }

    @Override
    public void accept(InterfaceVisitorPaint visitor) {
        visitor.visitFireFighters(this);
    }


}
