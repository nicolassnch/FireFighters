import fireFighters.gridFireFighters.*;
import generalPackage.Grid.AbstractGrid;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rockPaperScissor.grid.Grid;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class App extends Application {

    boolean isInPause = true;

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Button restart = new Button("Restart");
        Button switchPause = new Button("Pause");
        VBox buttons = new VBox();
        HBox total = new HBox();
        //GridFireFighters grid = new GridFireFighters(1000,1000,20,20);
        Grid grid = new Grid(1000,1000,20,20);
        root.getChildren().add(total);
        total.getChildren().add(buttons);
        total.getChildren().add(grid);
        buttons.getChildren().add(restart);
        buttons.getChildren().add(switchPause);
        restart.setOnMouseClicked(grid::restart);
        switchPause.setOnMouseClicked((value)->isInPause = !isInPause);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        grid.repaint();

        ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        threadPoolExecutor.scheduleAtFixedRate(() -> {
            if(!isInPause) {
                grid.getModel().activation();
                grid.paint();}
        }, 0, 50 , TimeUnit.MILLISECONDS);
    }
}

