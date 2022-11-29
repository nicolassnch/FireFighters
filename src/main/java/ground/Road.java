package ground;

import Util.Position;
import grid.InterfaceVisitorPaint;

public class Road extends GroundAbstract{

    Position position;

    public Road(Position position) {
        super(position);

    }


    @Override
    public void accept(InterfaceVisitorPaint visitor) {
        visitor.visitRoad(this);
    }
}
