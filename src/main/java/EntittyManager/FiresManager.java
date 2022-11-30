package entittyManager;

import ground.VisitorGroundInterface;
import util.Position;
import entity.Entity;
import entity.FireEntity;
import grid.InterfaceVisitorPaint;

import java.util.*;

public class FiresManager extends EntityManager {
    Set<Entity> fires = new HashSet<>();




    public FiresManager(int numberEntity, double rowCount, double colCount,List<VisitorGroundInterface> visitorGroundInterfaceList) {
        super(numberEntity, rowCount, colCount,visitorGroundInterfaceList);
    }


    public void extinguish(Entity fireEntity) {
        fires.remove(fireEntity);
    }


    @Override
    public void activate() {


        if (step % 2 == 0) {
            List<Position> positions = new ArrayList<>();
            for (Entity fireEntity : fires) {
                positions.addAll(Position.next_Position_Available(fireEntity.getPosition(),colCount,rowCount));
            }
            for (Position position : positions) {
                FireEntity fireEntity = new FireEntity(position);
                if (acceptGround(visitorGroundInterfacesList,fireEntity)) {
                    fires.add(fireEntity);
                }
            }
        }
        step++;
    }

    @Override
    public void initialisation() {
        for (int index = 0; index < numberEntity; index++) {
            boolean isPosisionate = false;
            while (!isPosisionate){
                FireEntity newFireEntity = new FireEntity(Position.randomPosition(colCount, rowCount));
                if (acceptGround(visitorGroundInterfacesList,newFireEntity)) {
                    fires.add(newFireEntity);
                    isPosisionate = true;
                }
            }

        }
    }


    @Override
    public void accept(InterfaceVisitorPaint visitor) {
        visitor.visitFires(this);
    }

    @Override
    public Boolean acceptGround(List<VisitorGroundInterface> visitorGroundInterfacesList,Entity entity) {
        boolean isAceepted = true;
        for (VisitorGroundInterface visitorGround:visitorGroundInterfacesList){
            isAceepted = isAceepted && visitorGround.visitorFireEntityPositionDisponnible((FireEntity) entity);
        }
        return isAceepted;

    }


    public Set<Entity> get_Fires() {
        return fires;
    }

    public Entity contain(Position position) {
        for (Entity fire : fires) {
            if (fire.getPosition().equals(position)) {
                return fire;
            }
        }
        return null;
    }
}
