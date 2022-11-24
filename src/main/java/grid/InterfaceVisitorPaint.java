package grid;

import entity.FireFighters;
import entity.Fires;

public interface InterfaceVisitorPaint {
    void visitFireFighters(FireFighters fireFighters);
    void visitFires(Fires fires);

}
