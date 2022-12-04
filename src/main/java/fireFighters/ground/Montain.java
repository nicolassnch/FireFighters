package fireFighters.ground;

import generalPackage.ground.GroundAbstract;
import util.Position;
import generalPackage.AllEntityPainting.InterfaceVisitorPaint;


public class Montain extends GroundAbstract {


    public Montain(Position position) {
        super(position);

    }

    public Position getPosition() {
        return position;
    }



    @Override
    public void accept(InterfaceVisitorPaint visitor) {
        visitor.visitRoad(this);
    }


}
