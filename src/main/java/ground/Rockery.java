package ground;

import grid.InterfaceVisitorPaint;
import util.Position;

public class Rockery extends GroundAbstract{
    public Rockery(Position position) {
        super(position);
    }

    @Override
    public void accept(InterfaceVisitorPaint visitor) {
        visitor.visitRockery(this);
    }
}
