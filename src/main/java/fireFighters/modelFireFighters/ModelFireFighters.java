package fireFighters.modelFireFighters;


import fireFighters.EntittyManagerFireFighters.*;
import fireFighters.gridFireFighters.GridFireFighters;
import fireFighters.groundFireFighters.*;
import fireFighters.groundManager.GroundManager;
import generalPackage.entityManager.EntityManager;
import generalPackage.model.InterfaceModel;

import java.util.List;
import java.util.*;


public class ModelFireFighters implements InterfaceModel {
  private GridFireFighters gridFireFighters;

  private double colCount;
  private double rowCount;

  private List<EntityManager> entityManagerList = new ArrayList<>();
  private List<VisitorGroundInterface> visitorGroundInterfaceList = new ArrayList<>();

  private CloudManager cloudManager;
  private FiresManager fires;
  private WalkFireFighterManager walkFireFighterManager;
  private MotoeizedFireFighterManager motoeizedFireFighterManager;

  private GroundManager groundManager;

  private RoadVisitor roadVisitor;
  private MontainVisitor montainVisitor;
  private RockeryVisitor rockeryVisitor;

  int fireNumber,walkFireFighterNumber,motoeizedFireFighterNumber,cloudNumber,rockeryNumber;


  public ModelFireFighters(GridFireFighters gridFireFighters, int fireNumber, int walkFireFighterNumber, int motoeizedFireFighterNumber, int cloudNumber, int rockeryNumber) {
    this.gridFireFighters = gridFireFighters;
    colCount = gridFireFighters.getColCount();
    rowCount = gridFireFighters.getRowCount();
    this.fireNumber = fireNumber;
    this.walkFireFighterNumber = walkFireFighterNumber;
    this.motoeizedFireFighterNumber = motoeizedFireFighterNumber;
    this.cloudNumber = cloudNumber;
    this.rockeryNumber = rockeryNumber;
  }


  public void initialisation() {
    initialiseGroundManager();
    initialiseGroundVisitor();
    initialiseEntityManager();
  }

  private void initialiseGroundManager(){
    this.groundManager = new GroundManager(rowCount,colCount,rockeryNumber);  }

  private void initialiseGroundVisitor(){
    this.roadVisitor = new RoadVisitor(groundManager,colCount,rowCount);
    this.montainVisitor = new MontainVisitor(groundManager,colCount,rowCount);
    this.rockeryVisitor = new RockeryVisitor(groundManager,colCount,rowCount);
    visitorGroundInterfaceList.add(roadVisitor);
    visitorGroundInterfaceList.add(montainVisitor);
    groundManager.initialize();
  }

  private void initialiseEntityManager(){
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


  public List<EntityManager> getEntityManagerList() {
    return entityManagerList;
  }

  public GroundManager getGroundManager() {
    return groundManager;
  }
}
