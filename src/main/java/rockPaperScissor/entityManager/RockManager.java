package rockPaperScissor.entityManager;

import fireFighters.ground.VisitorGroundInterface;
import generalPackage.AllEntityPainting.InterfaceVisitorPaint;
import generalPackage.entity.Entity;
import generalPackage.entityManager.EntityManager;
import rockPaperScissor.entity.RockEntity;
import rockPaperScissor.entity.ScissorEntity;
import util.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RockManager extends EntityManager {

    Set<RockEntity> rockSet = new HashSet<>();

    ScissorManager scissorManager;

    public RockManager(int numberEntity, double rowCount, double colCount) {
        super(numberEntity, rowCount, colCount);
    }

    public void setScissorManager(ScissorManager scissorManager) {
        this.scissorManager = scissorManager;
    }

    public void removeRock(RockEntity rockEntity){
        rockSet.remove(rockEntity);
    }

    public boolean contain(RockEntity rockEntity){
        return rockSet.contains(rockEntity);
    }




    @Override
    public void activate() {
        Set<Position> positions = new HashSet<>();
        for (Entity paperEntity : rockSet){
            positions.addAll(Position.next_Position_Available(paperEntity.getPosition(),colCount,rowCount));
        }
        for (Position position:positions){
            if (scissorManager.contain(new ScissorEntity(position))){
                scissorManager.removeScissor(new ScissorEntity(position));
            }
            rockSet.add(new RockEntity(position));
        }
    }


    @Override
    public void initialisation() {
        for (int i = 0 ; i< numberEntity;i++){
            rockSet.add(new RockEntity(Position.randomPosition(colCount,rowCount)));
        }
    }

    @Override
    public void acceptPaint(InterfaceVisitorPaint visitor) {
        visitor.visitRock(this);
    }

    @Override
    public Boolean acceptGround(List<VisitorGroundInterface> visitorGroundInterfacesList, Entity entity) {
        return null;
    }

    public Set<RockEntity> getRockSet() {
        return rockSet;
    }
}
