package Util;

import grid.Grid;

import java.util.ArrayList;
import java.util.List;

public record Position(int row, int col) {
    public static Position randomPosition(Grid grid) {
        return new Position((int) (Math.random() * grid.getRowCount()), (int) (Math.random() * grid.getColCount()));
    }


}

