package entittyManager;

import ground.VisitorGroundInterface;
import util.Position;
import entity.Entity;
import entity.FireEntity;
import entity.FireFighterEntity;
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



}
