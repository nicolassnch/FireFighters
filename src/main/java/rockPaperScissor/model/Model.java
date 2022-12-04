package rockPaperScissor.model;

import generalPackage.entityManager.EntityManager;
import generalPackage.model.InterfaceModel;
import rockPaperScissor.entityManager.PaperManager;
import rockPaperScissor.entityManager.RockManager;
import rockPaperScissor.entityManager.ScissorManager;
import rockPaperScissor.grid.Grid;

import java.util.ArrayList;
import java.util.List;

public class Model implements InterfaceModel {

    private Grid grid;
    private double colCount;
    private double rowCount;

    List<EntityManager> entityManagerList = new ArrayList<>();

    PaperManager paperManager;
    RockManager rockManager;
    ScissorManager scissorManager;

    int paperNumber, rockNumber , scissorNumber;

    public Model(Grid grid, int paperNumber, int rockNumber, int scissorNumber) {
        this.grid = grid;
        this.colCount = grid.getColCount();
        this.rowCount = grid.getRowCount();
        this.paperNumber = paperNumber;
        this.rockNumber = rockNumber;
        this.scissorNumber = scissorNumber;
    }

    @Override
    public void initialisation() {
        this.paperManager = new PaperManager(paperNumber,rowCount,colCount);
        this.rockManager = new RockManager(rockNumber,rowCount,colCount);
        this.scissorManager = new ScissorManager(scissorNumber,rowCount,colCount);
        paperManager.setRockManager(rockManager);
        rockManager.setScissorManager(scissorManager);
        scissorManager.setPaperManager(paperManager);

        entityManagerList.add(paperManager);
        entityManagerList.add(rockManager);
        entityManagerList.add(scissorManager);

        for (EntityManager entityManager:entityManagerList){
            entityManager.initialisation();
        }

    }

    @Override
    public void activation() {
        for (EntityManager entity : entityManagerList){
            entity.activate();
        }
    }

    public List<EntityManager> getEntityManagerList() {
        return entityManagerList;
    }
}
