package entity;

import Util.Position;
import javafx.scene.canvas.GraphicsContext;

public interface Entities{
    void activation();
    void initialisation();
    void paint_Entities(GraphicsContext graphicsContext , Position position);
    boolean isFire();
}
