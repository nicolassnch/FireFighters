package entity;

import Util.Position;
import grid.InterfaceVisitorPaint;
import javafx.scene.canvas.GraphicsContext;

public interface Entities{
    void activation();
    void initialisation();
    void accept(InterfaceVisitorPaint visitor);
}
