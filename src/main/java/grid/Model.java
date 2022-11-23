package grid;

import entity.*;

import java.util.List;
import java.util.*;


public class Model {
  Grid grid;
  double colCount;
  double rowCount;

  int step = 0;

  List<Entities> entities = new ArrayList<>();

  Fires fires;
  FireFighters fireFighters;

  public Model(Grid grid) {
    this.grid = grid;
    colCount = grid.colCount;
    rowCount = grid.rowCount;
  }


  public void initialisation(int fireNumber, int fireFighterNumber) {
    entities.clear();
    this.fires =new Fires(grid,fireNumber,this);
    this.fireFighters=new FireFighters(grid , fireFighterNumber,this);
    entities.add(fires);
    entities.add(fireFighters);

    for (Entities entity: entities){
      entity.initialisation();
    }
  }




  public void activation() {
    for (Entities entity : entities){
      if (entity.isFire() && step % 2 != 0) {
        continue;
      }
      entity.activation();
    }
    step++;

  }


  public Fires getFires() {
    return fires;
  }
}