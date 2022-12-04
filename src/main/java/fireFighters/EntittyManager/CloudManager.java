package fireFighters.EntittyManager;

import fireFighters.entity.CloudEntity;
import generalPackage.entity.Entity;
import generalPackage.entityManager.EntityManager;
import generalPackage.AllEntityPainting.InterfaceVisitorPaint;
import fireFighters.ground.VisitorGroundInterface;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class CloudManager extends EntityManager {

    private List<CloudEntity> cloudList = new ArrayList<>();
    private FiresManager fires;

    public CloudManager(int numberEntity, double rowCount, double colCount,FiresManager fires) {
        super(numberEntity, rowCount, colCount);
        this.fires = fires;
    }

    @Override
    public void activate() {
        for (CloudEntity cloudEntity:cloudList){
            List<Position> nextPossible = Position.next_Position_Available(cloudEntity.getPosition(),colCount,rowCount);
            int random =(int) Math.floor(Math.random()*nextPossible.size());
            Position newRandomPosition = nextPossible.get(random);
            cloudEntity.setPosition(newRandomPosition);
            fires.extinguish(fires.contain(newRandomPosition));
        }
    }

    @Override
    public void initialisation() {
        for (int index = 0; index< numberEntity ; index++){
            cloudList.add(new CloudEntity(Position.randomPosition(colCount,rowCount)));
        }
    }

    @Override
    public void acceptPaint(InterfaceVisitorPaint visitor) {
        visitor.visitCloud(this);
    }


    public List<CloudEntity> getCloudList() {
        return cloudList;
    }
}
