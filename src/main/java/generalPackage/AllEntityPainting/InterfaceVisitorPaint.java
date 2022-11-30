package generalPackage.AllEntityPainting;


import fireFighters.EntittyManagerFireFighters.CloudManager;
import fireFighters.EntittyManagerFireFighters.FiresManager;
import fireFighters.EntittyManagerFireFighters.MotoeizedFireFighterManager;
import fireFighters.EntittyManagerFireFighters.WalkFireFighterManager;
import fireFighters.groundFireFighters.Montain;
import fireFighters.groundFireFighters.Road;
import fireFighters.groundFireFighters.Rockery;

public interface InterfaceVisitorPaint {
    void visitFireFighters(WalkFireFighterManager walkFireFighterManager);
    void visitFires(FiresManager fires);
    void visitMotorizedFireFighters(MotoeizedFireFighterManager motoeizedFireFighterManager);
    void visitRoad(Road road);
    void visitRoad(Montain montain);
    void visitCloud(CloudManager cloudManager);
    void visitRockery(Rockery rockery);

}
