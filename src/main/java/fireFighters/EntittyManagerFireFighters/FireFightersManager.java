package fireFighters.EntittyManagerFireFighters;

import fireFighters.groundFireFighters.VisitorGroundInterface;
import generalPackage.entityManager.EntityManager;
import util.Position;
import generalPackage.entity.Entity;
import fireFighters.entityFireFighter.FireFighterEntity;

import java.util.*;

public abstract class FireFightersManager extends EntityManager {


    private List<FireFighterEntity> fireFighters = new ArrayList<>();


    private FiresManager fires;

    public FireFightersManager(int numberEntity, double rowCount, double colCount, FiresManager fires,List<VisitorGroundInterface> visitorGroundInterfaceList){
        super(numberEntity,rowCount,colCount,visitorGroundInterfaceList);
        this.fires = fires;
    }

    protected Position step_Toward_Fire(Position position){
        Set<Position> seen = new HashSet<>();
        HashMap<Position,Position> firstMove = new HashMap<>();
        Queue<Position> toVisit = new LinkedList<>(nextPossibleFromFireFighter(position));
        for(Position initialMove : toVisit)
            firstMove.put(initialMove,initialMove);
        while(!toVisit.isEmpty()){
            Position current = toVisit.poll();
            if(fires.contain(current) != null)
                return firstMove.get(current);
            for(Position adjacent :nextPossibleFromFireFighter(current)){
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

    protected List<Position> nextPossibleFromFireFighter(Position position){
        List<Position> realPossible = new ArrayList<>();
        List<Position> allNextPossible = new ArrayList<>(Position.next_Position_Available(position,colCount, rowCount));
        for (Position next:allNextPossible){
            FireFighterEntity fireFighterEntityTestPosition = new FireFighterEntity(next);
            if (acceptGround(visitorGroundInterfacesList,fireFighterEntityTestPosition)){
                realPossible.add(next);
            }
        }
        return realPossible;
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
        for (int index = 0; index< numberEntity ; index++){
            fireFighters.add(new FireFighterEntity(Position.randomPosition(colCount,rowCount)));
        }
    }

    @Override
    public Boolean acceptGround(List<VisitorGroundInterface> visitorGroundInterfacesList, Entity entity) {
        boolean isAceepted = true;
        for (VisitorGroundInterface visitorGround:visitorGroundInterfacesList){
            isAceepted = isAceepted && visitorGround.visitorFireFighterEntityPositionDisponnible((FireFighterEntity) entity);
        }
        return isAceepted;

    }

    public List<FireFighterEntity> getFireFighters() {
        return fireFighters;
    }

    protected abstract Position activate_Firefighter(Position position);

}
