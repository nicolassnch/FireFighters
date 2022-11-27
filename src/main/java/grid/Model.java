package grid;

import EntittyManager.EntityManager;
import EntittyManager.FireFightersManager;
import EntittyManager.FiresManager;

import java.util.List;
import java.util.*;


public class Model {
  Grid grid;
  double colCount;
  double rowCount;

  List<EntityManager> entityManagerList = new ArrayList<>();

  FiresManager fires;
  FireFightersManager fireFighters;

  public Model(Grid grid) {
    this.grid = grid;
    colCount = grid.colCount;
    rowCount = grid.rowCount;
  }


  public void initialisation(int fireNumber, int fireFighterNumber) {
    entityManagerList.clear();
    this.fires =new FiresManager(fireNumber,rowCount,colCount);
    this.fireFighters=new FireFightersManager(fireFighterNumber,rowCount,colCount,fires);
    entityManagerList.add(fires);
    entityManagerList.add(fireFighters);

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
