package grid;

import EntittyManager.*;

import java.util.List;
import java.util.*;


public class Model {
  Grid grid;
  double colCount;
  double rowCount;

  List<EntityManager> entityManagerList = new ArrayList<>();

  FiresManager fires;
  WalkFireFighterManager walkFireFighterManager;
  MotoeizedFireFighterManager motoeizedFireFighterManager;

  public Model(Grid grid) {
    this.grid = grid;
    colCount = grid.colCount;
    rowCount = grid.rowCount;
  }


  public void initialisation(int fireNumber, int walkFireFighterNumber,int motoeizedFireFighterNumber) {
    entityManagerList.clear();
    this.fires =new FiresManager(fireNumber,rowCount,colCount);
    this.walkFireFighterManager=new WalkFireFighterManager(walkFireFighterNumber,rowCount,colCount,fires);
    this.motoeizedFireFighterManager=new MotoeizedFireFighterManager(motoeizedFireFighterNumber,rowCount,colCount,fires);
    entityManagerList.add(fires);
    entityManagerList.add(walkFireFighterManager);
    entityManagerList.add(motoeizedFireFighterManager);

    for (EntityManager entity: entityManagerList){
      entity.initialisation();
    }
  }




  public void activation() {
    for (EntityManager entity : entityManagerList){
      entity.activate();
    }
  }


  public FiresManager getFires() {
    return fires;
  }
}
