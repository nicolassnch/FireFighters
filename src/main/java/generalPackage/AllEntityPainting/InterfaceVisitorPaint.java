package generalPackage.AllEntityPainting;


import fireFighters.EntittyManager.CloudManager;
import fireFighters.EntittyManager.FiresManager;
import fireFighters.EntittyManager.MotoeizedFireFighterManager;
import fireFighters.EntittyManager.WalkFireFighterManager;
import fireFighters.ground.Montain;
import fireFighters.ground.Road;
import fireFighters.ground.Rockery;
import rockPaperScissor.entityManager.PaperManager;
import rockPaperScissor.entityManager.RockManager;
import rockPaperScissor.entityManager.ScissorManager;

public interface InterfaceVisitorPaint {
    void visitFireFighters(WalkFireFighterManager walkFireFighterManager);
    void visitFires(FiresManager fires);
    void visitMotorizedFireFighters(MotoeizedFireFighterManager motoeizedFireFighterManager);
    void visitRoad(Road road);
    void visitRoad(Montain montain);
    void visitCloud(CloudManager cloudManager);
    void visitRockery(Rockery rockery);

    void visitPaper(PaperManager paperManager);
    void visitRock(RockManager rockManager);
    void visitScissor(ScissorManager scissorManager);

}
