package rockPaperScissor.entityManager;

import fireFighters.ground.VisitorGroundInterface;
import generalPackage.AllEntityPainting.InterfaceVisitorPaint;
import generalPackage.entity.Entity;
import generalPackage.entityManager.EntityManager;
import rockPaperScissor.entity.PaperEntity;
import rockPaperScissor.entity.ScissorEntity;
import util.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScissorManager extends EntityManager {


    Set<ScissorEntity> scissorSet = new HashSet<>();

    PaperManager paperManager;

    public ScissorManager(int numberEntity, double rowCount, double colCount) {
        super(numberEntity, rowCount, colCount);
    }

    public void setPaperManager(PaperManager paperManager) {
        this.paperManager = paperManager;
    }

    public void removeScissor(ScissorEntity scissorEntity){
        scissorSet.remove(scissorEntity);
    }

    public boolean contain(ScissorEntity scissorEntity){
        return scissorSet.contains(scissorEntity);
    }




    @Override
    public void activate() {
        Set<Position> positions = new HashSet<>();
        for (Entity paperEntity : scissorSet){
            positions.addAll(Position.next_Position_Available(paperEntity.getPosition(),colCount,rowCount));
        }
        for (Position position:positions){
            if (paperManager.contain(new PaperEntity(position))){
                paperManager.removePaper(new PaperEntity(position));
            }
            scissorSet.add(new ScissorEntity(position));
        }
    }

    @Override
    public void initialisation() {
        for (int i = 0 ; i< numberEntity;i++){
            scissorSet.add(new ScissorEntity(Position.randomPosition(colCount,rowCount)));
        }
    }

    @Override
    public void acceptPaint(InterfaceVisitorPaint visitor) {
        visitor.visitScissor(this);
    }


    public Set<ScissorEntity> getScissorSet() {
        return scissorSet;
    }
}
