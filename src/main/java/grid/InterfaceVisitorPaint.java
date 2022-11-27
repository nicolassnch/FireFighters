package grid;

import EntittyManager.FireFightersManager;
import EntittyManager.FiresManager;

public interface InterfaceVisitorPaint {
    void visitFireFighters(FireFightersManager fireFighters);
    void visitFires(FiresManager fires);

}
