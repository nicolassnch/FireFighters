package EntittyManager;

import Util.Position;
import entity.FireFighterEntity;
import grid.InterfaceVisitorPaint;

import java.util.*;

public abstract class FireFightersManager extends EntityManager {


    List<FireFighterEntity> fireFighters = new ArrayList<>();


    FiresManager fires;

    public FireFightersManager(int numberEntity, double rowCount, double colCount, FiresManager fires){
        super(numberEntity,rowCount,colCount);
        this.fires = fires;
    }

    protected Position step_Toward_Fire(Position position){
        Queue<Position> toVisit = new LinkedList<>();
        Set<Position> seen = new HashSet<>();
        HashMap<Position,Position> firstMove = new HashMap<>();
        toVisit.addAll(Position.next_Position_Available(position,colCount,rowCount));
        for(Position initialMove : toVisit)
            firstMove.put(initialMove,initialMove);
        while(!toVisit.isEmpty()){
            Position current = toVisit.poll();
            if(fires.contain(current) != null)
                return firstMove.get(current);
            for(Position adjacent : Position.next_Position_Available(current,colCount,rowCount)){
                if(seen.contains(adjacent)) continue;
                toVisit.add(adjacent);
                seen.add(adjacent);
                firstMove.put(adjacent, firstMove.get(current));
            }
        }
        return position;
    }


    protected abstract Position activate_Firefighter(Position position);




    @Override
    public void activate() {
        for (FireFighterEntity ff : fireFighters) {
            Position newPosition = activate_Firefighter(ff.getPosition());
            ff.setPosition(newPosition);
        }
    }

    @Override
    public void initialisation() {
        for (int index = 0; index<= numberEntity ; index++){
            fireFighters.add(new FireFighterEntity(Position.randomPosition(colCount,rowCount)));
        }
    }


    @Override
    public abstract void accept(InterfaceVisitorPaint visitor);

    public List<FireFighterEntity> getFireFighters() {
        return fireFighters;
    }


}
