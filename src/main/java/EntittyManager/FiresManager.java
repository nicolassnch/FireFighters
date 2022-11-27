package EntittyManager;

import Util.Position;

import entity.Entity;
import entity.FireEntity;
import grid.InterfaceVisitorPaint;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FiresManager extends EntityManager {
    Set<Entity> fires = new HashSet<>();


    InterfaceVisitorPaint visitorPaint;
    public FiresManager(int numberEntity, double rowCount, double colCount){
        super(numberEntity,rowCount,colCount);
    }




    public void extinguish(Entity fireEntity) {
        fires.remove(fireEntity);
    }




    @Override
    public void activate() {
        System.out.println(fires.size());
        if (step % 2 == 0) {
            List<Position> positions = new ArrayList<>();
            for (Entity fireEntity : fires) {
                positions.addAll(Position.next_Position_Available(fireEntity.getPosition(),colCount,rowCount));
            }
            for (Position position : positions) {
                fires.add(new FireEntity(position));
            }
        }
        step++;
    }

    @Override
    public void initialisation() {
        for (int index = 0; index<= numberEntity ; index++){
            fires.add(new FireEntity(Position.randomPosition(colCount,rowCount)));
        }
    }


    @Override
    public void accept(InterfaceVisitorPaint visitor) {
        visitor.visitFires(this);
    }


    public Set<Entity> get_Fires(){return fires;}

    public Entity contain(Position position){
        for (Entity fire:fires){
            if (fire.getPosition().equals(position) ){
                return fire;
            }
        }
        return null;
    }
}
