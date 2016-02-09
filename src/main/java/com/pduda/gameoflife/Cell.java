package com.pduda.gameoflife;

import com.pduda.myjava.MyBoolean;
import com.pduda.myjava.MyInteger;
import com.pduda.myjava.MyObject;

public class Cell extends MyObject {
    private final MyInteger x;
    private final MyInteger y;

    public Cell(int x, int y) {
        this.x = new MyInteger(x);
        this.y = new MyInteger(y);
    }

    public MyBoolean isNeighbourWith(Cell potentialNeighbour) {
        return this.myEquals(potentialNeighbour).negate()
                .and(this.x.distanceTo(potentialNeighbour.x).isLessOrEqualTo(new MyInteger(1)))
                .and(this.y.distanceTo(potentialNeighbour.y).isLessOrEqualTo(new MyInteger(1)));
    }

    @Override
    public MyBoolean myEquals(MyObject object) {
        Cell that = (Cell) object;
        return x.myEquals(that.x)
                .and(y.myEquals(that.y));
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
