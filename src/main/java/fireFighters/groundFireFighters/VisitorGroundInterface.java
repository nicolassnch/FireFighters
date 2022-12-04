package fireFighters.groundFireFighters;

import fireFighters.entityFireFighter.FireEntity;
import fireFighters.entityFireFighter.FireFighterEntity;

public interface VisitorGroundInterface {
    Boolean visitorFireFighterEntityPositionDisponnible(FireFighterEntity fireFighterEntity);
    Boolean visitorFireEntityPositionDisponnible(FireEntity fireEntity);

}
