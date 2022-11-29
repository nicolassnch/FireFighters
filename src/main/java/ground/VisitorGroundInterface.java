package ground;

import Util.Position;
import entity.FireEntity;
import entity.FireFighterEntity;

import java.util.List;

public interface VisitorGroundInterface {
    List<Position>  visitorFireFighterEntity(FireFighterEntity fireFighterEntity);
    List<Position> visitorFireEntity(FireEntity fireEntity);
}
