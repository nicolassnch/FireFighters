package util;

import java.util.ArrayList;
import java.util.List;

public record Position(int row, int col) {
    public static Position randomPosition(double colCount, double rowCount ) {
        return new Position((int) (Math.random() * rowCount), (int) (Math.random() * colCount));
    }
    public static List<Position> next_Position_Available(Position position ,double colCount, double rowCount ) {
        List<Position> list = new ArrayList<>();
        if (position.row() > 0) list.add(new Position(position.row() - 1, position.col()));
        if (position.col() > 0) list.add(new Position(position.row(), position.col() - 1));
        if (position.row() < colCount - 1) list.add(new Position(position.row() + 1, position.col()));
        if (position.col() < rowCount - 1) list.add(new Position(position.row(), position.col() + 1));
        return list;
    }

}

