package fireFighters.EntittyManager;

import fireFighters.ground.VisitorGroundInterface;
import generalPackage.entity.Entity;

import java.util.List;

public interface AcceptGround {
    public abstract Boolean acceptGround(List<VisitorGroundInterface> visitorGroundInterfacesList, Entity entity);
}
