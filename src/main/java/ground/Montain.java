package ground;

import Util.Position;
import grid.InterfaceVisitorPaint;


public class Montain extends GroundAbstract {



    public Montain(Position position) {
        super(position);
    }


    @Override
    public void accept(InterfaceVisitorPaint visitor) {
        visitor.visitRoad(this);
    }


}
