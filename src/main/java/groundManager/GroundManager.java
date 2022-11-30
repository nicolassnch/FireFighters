package groundManager;

import ground.GroundAbstract;
import ground.Montain;
import ground.Road;
import util.Position;

import java.util.HashSet;
import java.util.Set;

public class GroundManager {

    Set<GroundAbstract> ground ;
    double rowCount,colCount;
    public GroundManager(double rowCount,double colCount) {
        this.ground = new HashSet<>();
        this.colCount = colCount;
        this.rowCount = rowCount;
    }

    public void initialize(){
        courbeTracerForRoad();
        montainTracer();
    }

    private void courbeTracerForRoad() {
        double latitude = Math.random()*colCount;
        double verticalTest = Math.floor(Math.random()*2);
        boolean isVertical = verticalTest == 1;

        if (isVertical){
            for (int i = 5 ; i<=colCount-5;i++){
                ground.add(new Road(new Position((int)latitude,i)));
            }
        }
        else {
            for (int i = 5 ; i<=colCount-5;i++){
                ground.add(new Road(new Position(i,(int)latitude)));
            }
        }

    }

    private void montainTracer(){
        double y;
        double b = (Math.random())*2;
        for (int i=0 ; i <=20 ;i+=1){
            y = i*b;
            ground.add(new Montain(new Position((int) Math.floor(y), (int) Math.floor(i))));
        }
    }

    public Set<GroundAbstract> getGround() {
        return ground;
    }
}
