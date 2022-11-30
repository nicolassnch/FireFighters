package grid;

import entittyManager.CloudManager;
import entittyManager.FiresManager;
import entittyManager.MotoeizedFireFighterManager;
import entittyManager.WalkFireFighterManager;
import entity.CloudEntity;
import ground.Montain;
import ground.Road;
import ground.Rockery;

public interface InterfaceVisitorPaint {
    void visitFireFighters(WalkFireFighterManager walkFireFighterManager);
    void visitFires(FiresManager fires);
    void visitMotorizedFireFighters(MotoeizedFireFighterManager motoeizedFireFighterManager);
    void visitRoad(Road road);
    void visitRoad(Montain montain);
    void visitCloud(CloudManager cloudManager);
    void visitRockery(Rockery rockery);

}
