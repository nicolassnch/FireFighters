package EntittyManager;

import ground.VisitorGroundInterface;
import Util.Position;
import entity.FireFighterEntity;
import grid.InterfaceVisitorPaint;

import java.util.*;

public abstract class FireFightersManager extends EntityManager {


    List<FireFighterEntity> fireFighters = new ArrayList<>();


    FiresManager fires;

    public FireFightersManager(int numberEntity, double rowCount, double colCount, FiresManager fires,List<VisitorGroundInterface> visitorGroundInterfaceList){
        super(numberEntity,rowCount,colCount,visitorGroundInterfaceList);
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

    protected Position just_One_Step(Position position) {
        Position randomPosition = step_Toward_Fire(position);
        List<Position> nextFires = Position.next_Position_Available(randomPosition,colCount,rowCount);
        fires.extinguish(fires.contain(randomPosition));
        for (Position fire : nextFires){
            fires.extinguish(fires.contain(fire));
        }
        return randomPosition;
    }







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

    protected abstract Position activate_Firefighter(Position position);

}
