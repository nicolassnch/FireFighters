package EntittyManager;

import ground.VisitorGroundInterface;
import Util.Position;
import entity.Entity;
import grid.InterfaceVisitorPaint;

import java.util.*;

public class WalkFireFighterManager extends FireFightersManager{


    public WalkFireFighterManager(int numberEntity, double rowCount, double colCount, FiresManager fires,List<VisitorGroundInterface> visitorGroundInterfaceList) {
        super(numberEntity, rowCount, colCount, fires,visitorGroundInterfaceList);
    }

    @Override
    protected Position activate_Firefighter(Position position) {
        return just_One_Step(position);
    }

    @Override
    public void accept(InterfaceVisitorPaint visitor) {
        visitor.visitFireFighters(this);
    }

    @Override
    public List<Position> acceptGround(List<VisitorGroundInterface> visitorGroundInterfacesList, Entity entity) {
        return null;
    }


}
