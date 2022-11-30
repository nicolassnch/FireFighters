package fireFighters.EntittyManagerFireFighters;

import fireFighters.groundFireFighters.VisitorGroundInterface;
import util.Position;
import generalPackage.AllEntityPainting.InterfaceVisitorPaint;

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
    public void acceptPaint(InterfaceVisitorPaint visitor) {
        visitor.visitFireFighters(this);
    }
}
