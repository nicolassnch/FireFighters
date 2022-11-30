package grid;

import entittyManager.*;
import ground.MontainVisitor;
import ground.RoadVisitor;
import ground.RockeryVisitor;
import ground.VisitorGroundInterface;
import groundManager.GroundManager;

import java.util.List;
import java.util.*;


public class Model {
  Grid grid;
  double colCount;
  double rowCount;

  List<EntityManager> entityManagerList = new ArrayList<>();
  List<VisitorGroundInterface> visitorGroundInterfaceList = new ArrayList<>();


  CloudManager cloudManager;
  FiresManager fires;
  WalkFireFighterManager walkFireFighterManager;
  MotoeizedFireFighterManager motoeizedFireFighterManager;
  GroundManager groundManager;
  RoadVisitor roadVisitor;
  MontainVisitor montainVisitor;
  RockeryVisitor rockeryVisitor;


  public Model(Grid grid) {
    this.grid = grid;
    colCount = grid.colCount;
    rowCount = grid.rowCount;
  }


  public void initialisation(int fireNumber, int walkFireFighterNumber,int motoeizedFireFighterNumber,int cloudNumber,int rockeryNumber) {
    this.groundManager = new GroundManager(rowCount,colCount,rockeryNumber);

    this.roadVisitor = new RoadVisitor(groundManager,colCount,rowCount);
    this.montainVisitor = new MontainVisitor(groundManager,colCount,rowCount);
    this.rockeryVisitor = new RockeryVisitor(groundManager,colCount,rowCount);
    visitorGroundInterfaceList.add(roadVisitor);
    visitorGroundInterfaceList.add(montainVisitor);

    groundManager.initialize();
    entityManagerList.clear();
    this.fires =new FiresManager(fireNumber,rowCount,colCount,visitorGroundInterfaceList,rockeryVisitor);
    this.cloudManager = new CloudManager(cloudNumber,rowCount,colCount,fires);
    this.walkFireFighterManager=new WalkFireFighterManager(walkFireFighterNumber,rowCount,colCount,fires,visitorGroundInterfaceList);
    this.motoeizedFireFighterManager=new MotoeizedFireFighterManager(motoeizedFireFighterNumber,rowCount,colCount,fires,visitorGroundInterfaceList);
    entityManagerList.add(fires);
    entityManagerList.add(walkFireFighterManager);
    entityManagerList.add(motoeizedFireFighterManager);
    entityManagerList.add(cloudManager);
    for (EntityManager entity: entityManagerList){
      entity.initialisation();
    }


  }


  public void activation() {
    for (EntityManager entity : entityManagerList){
      entity.activate();
    }
  }
}
