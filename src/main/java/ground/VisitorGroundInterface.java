package ground;

import entittyManager.FiresManager;
import entittyManager.MotoeizedFireFighterManager;
import util.Position;
import entity.FireEntity;
import entity.FireFighterEntity;

import java.util.List;

public interface VisitorGroundInterface {
    Boolean visitorFireFighterEntityPositionDisponnible(FireFighterEntity fireFighterEntity);
    Boolean visitorFireEntityPositionDisponnible(FireEntity fireEntity);

}
