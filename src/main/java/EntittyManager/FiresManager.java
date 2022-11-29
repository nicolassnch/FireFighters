package EntittyManager;

import Util.Position;
import entity.Entity;
import entity.FireEntity;
import grid.InterfaceVisitorPaint;
import ground.VisitorGroundInterface;

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
                positions.addAll(acceptGround(visitorGroundInterfacesList,fireEntity));
            }
            for (Position position : positions) {
                fires.add(new FireEntity(position));
            }
        }
        step++;
    }

    @Override
    public void initialisation() {
        for (int index = 0; index <= numberEntity; index++) {
            fires.add(new FireEntity(Position.randomPosition(colCount, rowCount)));
        }
    }


    @Override
    public void accept(InterfaceVisitorPaint visitor) {
        visitor.visitFires(this);
    }

    @Override
    public List<Position> acceptGround(List<VisitorGroundInterface> visitorGroundInterfacesList,Entity entity) {
        int numberOfVisitor=visitorGroundInterfacesList.size();
        List<Position> next_Position_Available_not_final = new ArrayList<>();
        List<Position> next_Position_Available_Final= new ArrayList<>();
        HashMap<Position,Integer> number_Of_Occurence=new HashMap<>();
        for (VisitorGroundInterface visitorGround:visitorGroundInterfacesList){
            next_Position_Available_not_final.addAll(visitorGround.visitorFireEntity((FireEntity) entity));
        }
        for (Position position:next_Position_Available_not_final){
            if (number_Of_Occurence.containsKey(position)){
                number_Of_Occurence.put(position,number_Of_Occurence.get(position)+1);
                continue;
            }
            number_Of_Occurence.put(position,1);
        }
        for (Map.Entry m : number_Of_Occurence.entrySet()){
            if (m.getValue().equals(numberOfVisitor)){
                next_Position_Available_Final.add((Position) m.getKey());
            }
        }

        return next_Position_Available_Final;
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
