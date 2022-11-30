package ground;

import util.Position;
import grid.InterfaceVisitorPaint;

public class Road extends GroundAbstract{


    public Road(Position position) {
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
