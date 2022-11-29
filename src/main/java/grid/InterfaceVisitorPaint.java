package grid;

import EntittyManager.FiresManager;
import EntittyManager.MotoeizedFireFighterManager;
import EntittyManager.WalkFireFighterManager;
import ground.Montain;
import ground.Road;

public interface InterfaceVisitorPaint {
    void visitFireFighters(WalkFireFighterManager walkFireFighterManager);
    void visitFires(FiresManager fires);
    void visitMotorizedFireFighters(MotoeizedFireFighterManager motoeizedFireFighterManager);
    void visitRoad(Road road);
    void visitRoad(Montain montain);

}
