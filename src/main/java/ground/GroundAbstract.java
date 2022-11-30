package ground;

import util.Position;
import grid.InterfaceVisitorPaint;

import java.util.Objects;

public abstract class GroundAbstract {
    Position position;

    public GroundAbstract(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public abstract void accept(InterfaceVisitorPaint visitor);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroundAbstract that = (GroundAbstract) o;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
