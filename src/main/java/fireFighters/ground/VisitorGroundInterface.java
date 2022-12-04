package fireFighters.ground;

import fireFighters.entity.FireEntity;
import fireFighters.entity.FireFighterEntity;

public interface VisitorGroundInterface {
    Boolean visitorFireFighterEntityPositionDisponnible(FireFighterEntity fireFighterEntity);
    Boolean visitorFireEntityPositionDisponnible(FireEntity fireEntity);

}
