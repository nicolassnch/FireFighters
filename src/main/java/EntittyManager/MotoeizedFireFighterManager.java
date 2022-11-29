package EntittyManager;

import Util.Position;
import entity.Entity;
import grid.InterfaceVisitorPaint;
import ground.VisitorGroundInterface;

import java.util.List;

public class MotoeizedFireFighterManager extends FireFightersManager {


    public MotoeizedFireFighterManager(int numberEntity, double rowCount, double colCount, FiresManager fires,List<VisitorGroundInterface> visitorGroundInterfaceList) {
        super(numberEntity, rowCount, colCount, fires,visitorGroundInterfaceList);
    }

    @Override
    protected Position activate_Firefighter(Position position) {
        return just_One_Step(just_One_Step(position));
    }


    @Override
    public void accept(InterfaceVisitorPaint visitor) {
        visitor.visitMotorizedFireFighters(this);
    }

    @Override
    public List<Position> acceptGround(List<VisitorGroundInterface> visitorGroundInterfacesList, Entity entity) {
        return null;
    }
}
