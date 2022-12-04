package fireFighters.EntittyManager;

import fireFighters.ground.RockeryVisitor;
import fireFighters.ground.VisitorGroundInterface;
import generalPackage.entityManager.EntityManager;
import util.Position;
import generalPackage.entity.Entity;
import fireFighters.entity.FireEntity;
import generalPackage.AllEntityPainting.InterfaceVisitorPaint;

import java.util.*;

public class FiresManager extends EntityManager implements AcceptGround{
    private Set<FireEntity> fires = new HashSet<>();
    private RockeryVisitor rockeryVisitor;




    public FiresManager(int numberEntity, double rowCount, double colCount,List<VisitorGroundInterface> visitorGroundInterfaceList,RockeryVisitor rockeryVisitor) {
        super(numberEntity, rowCount, colCount,visitorGroundInterfaceList);
        this.rockeryVisitor = rockeryVisitor;
    }


    public void extinguish(Entity fireEntity) {
        fires.remove(fireEntity);
    }


    @Override
    public void activate() {
        List<Position> positions = new ArrayList<>();
        Set<FireEntity> newFires = new HashSet<>();
        int moduloStep;
        for (FireEntity fireEntity : fires) {
            moduloStep=2;
            if (rockeryVisitor.visitorFireEntityPositionDisponnible(fireEntity)){                 //sorte de accept Mais seulement pour vérifier si la case actuelle est une rocaille.
                moduloStep = 4;
            }
            if (fireEntity.getInternalStep() % moduloStep == 0 ){
                positions.addAll(Position.next_Position_Available(fireEntity.getPosition(),colCount,rowCount)); //marche pas bien car normalement c'est le feu qui va arriver//
                for (Position position : positions) {                                                           // sur les rocaille qui mets 4 tour a ce répandre alors que  //
                    FireEntity newfireEntity = new FireEntity(position);                                        //la c'est un fois dessus que le feu mets 4 tour a ce rependre.//
                    if (acceptGround(visitorGroundInterfacesList,newfireEntity)) {
                        newFires.add(newfireEntity);
                    }
                }
            }
            fireEntity.incrementInternalStep();
        }
        fires.addAll(newFires);
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
    public void acceptPaint(InterfaceVisitorPaint visitor) {
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


    public Set<FireEntity> get_Fires() {
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
