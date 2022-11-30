package ground;

import groundManager.GroundManager;
import util.Position;
import grid.InterfaceVisitorPaint;

import java.util.Objects;


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
