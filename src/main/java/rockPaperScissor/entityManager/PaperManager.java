package rockPaperScissor.entityManager;

import fireFighters.groundFireFighters.VisitorGroundInterface;
import generalPackage.AllEntityPainting.InterfaceVisitorPaint;
import generalPackage.entity.Entity;
import generalPackage.entityManager.EntityManager;
import rockPaperScissor.entity.PaperEntity;
import rockPaperScissor.entity.RockEntity;
import util.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PaperManager extends EntityManager {
    Set<PaperEntity> papersSet = new HashSet<>();
    RockManager rockManager;

    public PaperManager(int numberEntity, double rowCount, double colCount) {
        super(numberEntity, rowCount, colCount);
    }

    public void setRockManager(RockManager rockManager){
        this.rockManager = rockManager;
    }

    public void removePaper(PaperEntity paperEntity){
        papersSet.remove(paperEntity);
    }

    public boolean contain(PaperEntity paperEntity){
        return papersSet.contains(paperEntity);
    }

    @Override
    public void activate() {
        Set<Position> positions = new HashSet<>();
        for (Entity paperEntity : papersSet){
            positions.addAll(Position.next_Position_Available(paperEntity.getPosition(),colCount,rowCount));
        }
        for (Position position:positions){
            if (rockManager.contain(new RockEntity(position))){
                rockManager.removeRock(new RockEntity(position));
            }
            papersSet.add(new PaperEntity(position));
        }
    }


    @Override
    public void initialisation() {
        for (int i = 0 ; i< numberEntity;i++){
            papersSet.add(new PaperEntity(Position.randomPosition(colCount,rowCount)));
        }
    }

    @Override
    public void acceptPaint(InterfaceVisitorPaint visitor) {
        visitor.visitPaper(this);
    }

    @Override
    public Boolean acceptGround(List<VisitorGroundInterface> visitorGroundInterfacesList, Entity entity) {
        return null;
    }

    public Set<PaperEntity> getPapersSet() {
        return papersSet;
    }
}
