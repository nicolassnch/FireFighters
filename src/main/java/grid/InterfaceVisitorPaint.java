package grid;

import EntittyManager.FireFightersManager;
import EntittyManager.FiresManager;
import EntittyManager.MotoeizedFireFighterManager;
import EntittyManager.WalkFireFighterManager;

public interface InterfaceVisitorPaint {
    void visitFireFighters(WalkFireFighterManager walkFireFighterManager);
    void visitFires(FiresManager fires);
    void visitMotorizedFireFighters(MotoeizedFireFighterManager motoeizedFireFighterManager);

}
