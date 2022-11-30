package grid;

import entittyManager.FiresManager;
import entittyManager.MotoeizedFireFighterManager;
import entittyManager.WalkFireFighterManager;
import ground.Montain;
import ground.Road;

public interface InterfaceVisitorPaint {
    void visitFireFighters(WalkFireFighterManager walkFireFighterManager);
    void visitFires(FiresManager fires);
    void visitMotorizedFireFighters(MotoeizedFireFighterManager motoeizedFireFighterManager);
    void visitRoad(Road road);
    void visitRoad(Montain montain);

}
