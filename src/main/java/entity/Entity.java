package entity;

import util.Position;

import java.util.Objects;

public abstract class Entity {

    Position position;

    public Entity(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getPositionCol() {
        return position.col();
    }

    public int getPositionRow() {
        return position.row();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;
        Entity entity = (Entity) o;
        return Objects.equals(position, entity.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
