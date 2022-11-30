package groundManager;

import ground.GroundAbstract;
import ground.Montain;
import ground.Road;
import ground.Rockery;
import util.Position;

import java.util.HashSet;
import java.util.Set;

public class GroundManager {

    Set<GroundAbstract> ground ;
    double rowCount,colCount;
    int rockeryNumber;
    public GroundManager(double rowCount,double colCount,int rockeryNumber) {
        this.ground = new HashSet<>();
        this.colCount = colCount;
        this.rowCount = rowCount;
        this.rockeryNumber = rockeryNumber;
    }

    public void initialize(){
        courbeTracerForRoad();
        montainTracer();
        rockeryTracer();
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
        for (int i=0 ; i <=20 ;i++){
            y = i*b;
            ground.add(new Montain(new Position((int) Math.floor(y), (int) Math.floor(i))));
        }
    }

    private void rockeryTracer(){
        for (int i = 0 ; i<rockeryNumber;i++){
            Rockery newRockery = new Rockery(Position.randomPosition(colCount,rowCount));
            ground.add(newRockery);
            for (Position position:Position.next_Position_Available(newRockery.getPosition(),colCount,rowCount)){
                ground.add(new Rockery(position));
            }
        }

        for (int i = 0 ; i < colCount;i++){
            ground.add(new Rockery(new Position(10,i)));
        }

    }

    public Set<GroundAbstract> getGround() {
        return ground;
    }
}
