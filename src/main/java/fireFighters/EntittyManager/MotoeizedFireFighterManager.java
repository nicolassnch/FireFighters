package fireFighters.EntittyManager;

import fireFighters.ground.VisitorGroundInterface;
import util.Position;
import generalPackage.AllEntityPainting.InterfaceVisitorPaint;

import java.util.*;

public class MotoeizedFireFighterManager extends FireFightersManager implements AcceptGround{


    public MotoeizedFireFighterManager(int numberEntity, double rowCount, double colCount, FiresManager fires,List<VisitorGroundInterface> visitorGroundInterfaceList) {
        super(numberEntity, rowCount, colCount, fires,visitorGroundInterfaceList);
    }

    @Override
    protected Position activate_Firefighter(Position position) {
        return just_One_Step(just_One_Step(position));
    }


    @Override
    public void acceptPaint(InterfaceVisitorPaint visitor) {
        visitor.visitMotorizedFireFighters(this);
    }

}
